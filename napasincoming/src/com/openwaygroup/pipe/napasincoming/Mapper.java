package com.openwaygroup.pipe.napasincoming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;

public class Mapper extends com.openwaygroup.pipe.napasincoming.autogen.Mapper {

	/**
	* This method will be called at the beginning of the pipe's execution, 
	* before any data is retrieved by source. Add your opening code here.
	*/
	protected SimpleDateFormat dateFormat;
	protected DecimalFormat decimalFormat;
	protected double totalSum,tempAmount;
	protected Calendar tempCalendar;
	protected int tempYear;
	protected boolean validMessageCode;
	protected String OUR_MEMBER_ID,NAPAS_CHANNEL_CODE,DIRECTION,unEncryptedWord,CHECK_CHECKSUM,BankPassword;
	protected ArrayList<String[]> MessageCodeMapping;
	protected String sProcessDate = "";
	protected String sFileDate = "";
	protected String sFileType = ""; //TC,SL,XL
	protected String sFileService = "";
	protected String sFileTarget = "";
	protected String sFileName = "";
	protected String RRN="";
	//protected String BankPassword;
	//Array Sequence: Smartlink Transaction Name;MTID;SIC;ProcessingCode;Way4 Transaction Name;Message Code

	protected void open() throws Exception {
		/* Getting Pipe Parameters
		 * Initializing variables
		 * */
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		decimalFormat =new DecimalFormat("#.##");
		validMessageCode=false;
		MessageCodeMapping = new ArrayList<String[]>();
		OUR_MEMBER_ID = Context.getMandatoryProperty(pipe.getContext(), "OUR_MEMBER_ID");
		NAPAS_CHANNEL_CODE = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_CHANNEL_CODE");
		DIRECTION = Context.getMandatoryProperty(pipe.getContext(), "DIRECTION");
		CHECK_CHECKSUM = Context.getMandatoryProperty(pipe.getContext(), "CHECK_CHECKSUM");
		BankPassword = Context.getMandatoryProperty(pipe.getContext(), "BANK_PASSWORD");

		//Reading ProcessingCode Mapping with Way4 MessageCode
		readMessageCodeMapping();
	}
	
	/**
	 * This method will be called for each record (table row, record in flat file, xml element) retrieved 
	 * by the pipe's source. Add your code to handle incoming data here.
	 */
	protected void execute() throws Exception {
		//I used pipe parameter for flat file source : Read File Twice
		//When reading for first time, it will compare count of data (by pipe) and count of data (by file trailer), Checking format error
		//Checking Checksum inside file trailer
		if(source.isFirstPassage()){
			if (source.isFormatError()) {
				//Skip file if format error
			skipFile("File " + source.getFileName() + " skipped because format error." + source.getErrorFieldName().trim()+"||"+ source.getErrorFieldValue().length() +"||"+ source.ERROR_TEST.toString());
			}
			if(source.getCurrentRecord() == source.getFileTrailerRecord()){
				if(source.getRecordCounter() != Integer.parseInt( source.getNumberofRecordsinTheFile())){
					skipFile("File " + source.getFileName() 
							+ " skipped because Record Count mismatch! Actual RecordCount:" + source.getRecordCounter() + " TrailerRecordCounter:"+source.getNumberofRecordsinTheFile() );
				}else if( !checkCheckSumFileTrailer() ){
					skipFile("File " + source.getFileName() 
							+ " skipped because FileTrailer Doesn't Match with Checksum! Record:\""+unEncryptedWord+"\".ValidChecksum:"+ConvertMD5(unEncryptedWord,BankPassword) );
				}
				else{
					processMessage("Validation for "+source.getFileName()+" is completed");
				}
			}
		}else
		{
			//When reading file for second time, start converting data
			convertData();
		}
	}

	/**
	 * This method will be called at the end of the pipe's execution.
	 * Add your closing code here.
	 */
	protected void close() throws Exception {
		processMessage("Converted "+source.getFileParameters().getFileName() + " completed.");
	}
	
	protected void convertData() throws Exception{
		if(source.getCurrentRecord() == source.getFileNameRecord())
		{
			getBankingDate.execute();
			sProcessDate = getBankingDate.getBankingDate();

			sFileDate = source.getFileNameRecord().getFileGeneratingDate().toString();
			sFileDate = sFileDate.substring(0,10);
			sFileTarget = source.getFileNameRecord().getFileTarget().trim();
			sFileType = source.getFileNameRecord().getFileType().trim();
			sFileService = source.getFileNameRecord().getFileService().trim().split("\\.")[0];
			sFileName = source.getFileName();

			checkOPTSMLDOC.setPROCESS_DATE(sProcessDate);
			checkOPTSMLDOC.setFILE_NAME(sFileName);
			checkOPTSMLDOC.execute();

			if ( checkOPTSMLDOC.getId() > 0)
			{
				skipFile("Data in " + sProcessDate + " have already processed. Skip this file.");
			}

		}
		else if(source.getCurrentRecord() == source.getFileDataRecord() && !checkMessageCode().equals("") && checkCheckSumValue())
		{
			// Mapping for Is Authorization
			if (checkTransTypeCode().equalsIgnoreCase("BQ") && DIRECTION.equals("ACQ"))
			{
				updateOPTSMLDOC.setIsAuthorization("P");
			}
			else
			{
				updateOPTSMLDOC.setIsAuthorization(checkIS_AUTHORIZATION());
			}
			
			// Mapping for Request Category
			updateOPTSMLDOC.setRequestCategory(checkREQUEST_CATEGORY());
			updateOPTSMLDOC.setServiceClass("T");

			// Get Trans ID
			processMessage("checkTransTypeCode()= " + checkTransTypeCode()+ " is completed");
			getTransID.setTRANS_CODE(checkTransTypeCode());
			getTransID.execute();
			updateOPTSMLDOC.setTransType(getTransID.getId());

			// Mapping for AuthCode
			updateOPTSMLDOC.setAuthCode(source.getFileDataRecord().getAuthorizationNumber());

			processMessage("source.getFileDataRecord().getLocalTransactionDate()= " + source.getFileDataRecord().getLocalTransactionDate());
			//processMessage("source.getFileDataRecord().getLocalTransactionTime()= " + source.getFileDataRecord().getLocalTransactionDate());

			// Mapping for Transaction DateTime
			String sTemp_Date = "";
			int iYear = Integer.valueOf(sFileDate.substring(0,4));
			int iTransYear = 0;
			int iMonthFile = Integer.valueOf(sFileDate.substring(5,7));
			int iMonth = Integer.valueOf(source.getFileDataRecord().getLocalTransactionDate().substring(0,2));
			if(iMonth == 12 && iMonthFile ==1)
		    {
				iTransYear = iYear - 1;
		    }
		    else
		    {
		    	iTransYear = iYear;
		    }
			
			int iDay = Integer.valueOf(source.getFileDataRecord().getLocalTransactionDate().substring(2,4));
			int iHH = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(0,2));
			int iMM = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(2,4));
			int iSS = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(4,6));
			
			sTemp_Date = iTransYear + "-" + ("00" + iMonth).substring(("" + iMonth).length()) + "-" +
            ("00" + iDay).substring(("" + iDay).length()) + " " + iHH + ":" + iMM + ":" + iSS;
			updateOPTSMLDOC.setTransDate(Timestamp.valueOf(sTemp_Date));

			int iSettleYear = 0;
			iMonthFile = Integer.valueOf(sFileDate.substring(5,7));
			iMonth = Integer.valueOf(source.getFileDataRecord().getSettlementDate().substring(0,2));
			if(iMonth == 12 && iMonthFile ==1)
			{
				iSettleYear = iYear - 1;
			}
			else
			{
			    iSettleYear = iYear;
			}
			iDay = Integer.valueOf(source.getFileDataRecord().getSettlementDate().substring(2,4));
			/*iHH = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(0,2));
			iMM = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(2,4));
			iSS = Integer.valueOf(source.getFileDataRecord().getLocalTransactionTime().substring(4,6));*/
			  
			sTemp_Date = iSettleYear + "-" + ("00" + iMonth).substring(("" + iMonth).length())  + "-" + 
			("00" + iDay).substring(("" + iDay).length()) + " 00:00:00";
			updateOPTSMLDOC.setPostingDate(Timestamp.valueOf(sTemp_Date));

			// Mapping for SIC
			updateOPTSMLDOC.setSicCode(source.getFileDataRecord().getTerminalType());

			// Mapping for Targetnumber
			updateOPTSMLDOC.setTargetNumber(source.getFileDataRecord().getCardNumber());

			// Mapping for Acquring Member
			updateOPTSMLDOC.setSourceMemberId(source.getFileDataRecord().getAcquiringInstitutionCode());

			//if this is is not ACB Member id, add smartlink channel code -> ACB is Issuer
			if( !source.getFileDataRecord().getAcquiringInstitutionCode().equals(OUR_MEMBER_ID)){
				updateOPTSMLDOC.setSourceChannel(NAPAS_CHANNEL_CODE);
			} else 
			{
				updateOPTSMLDOC.setSourceChannel(source.getFileDataRecord().getTerminalType().equals("6011") ? "A" : "P" );
			}

			// Mapping for source number
			updateOPTSMLDOC.setSourceNumber(source.getFileDataRecord().getCardAcceptorTerminalIdentification());
			
			// Mapping for target channel
			if(DIRECTION.equals("ISS")){
			//ACB is issuer
				updateOPTSMLDOC.setTargetMemberId(OUR_MEMBER_ID);
				updateOPTSMLDOC.setTargetChannel("O");
			} else {
				//ACB is acquirer
				updateOPTSMLDOC.setTargetMemberId(source.getFileDataRecord().getCardNumber().substring(0,6));
				updateOPTSMLDOC.setTargetChannel(NAPAS_CHANNEL_CODE);
			}

			// Mapping for Currency
			updateOPTSMLDOC.setTransCurr(source.getFileDataRecord().getTransactionCurrencyCode().equals("000") ? "704" : source.getFileDataRecord().getTransactionCurrencyCode());
			//updateOPTSMLDOC.setSettlCurr(source.getFileDataRecord().getTransactionCurrencyCode().equals("000") ? "704" : source.getFileDataRecord().getTransactionCurrencyCode());
			updateOPTSMLDOC.setReconsCurr(source.getFileDataRecord().getTransactionCurrencyCode().equals("000") ? "704" : source.getFileDataRecord().getTransactionCurrencyCode());

			// Mapping for Amount
			tempAmount = Double.parseDouble( source.getFileDataRecord().getTransactionAmount())/100;
			updateOPTSMLDOC.setTransAmount(BigDecimal.valueOf(tempAmount));
			//updateOPTSMLDOC.setSettlAmount(BigDecimal.valueOf(tempAmount));
			updateOPTSMLDOC.setReconsAmount(BigDecimal.valueOf(tempAmount));

			// Mapping for File Target
			updateOPTSMLDOC.setFileType("NAPAS " + sFileTarget + "-" + sFileType + "-" + sFileService.toUpperCase());			

			// Mapping for System trace number
			updateOPTSMLDOC.setSystemTraceNumber(source.getFileDataRecord().getSystemTraceNumber());
			
			// Mapping for processing code
			updateOPTSMLDOC.setProcessingCode(source.getFileDataRecord().getProcessingCode());
			
			// Mapping for process date
			updateOPTSMLDOC.setProcessDate(sProcessDate);

			// Mappring for file name
			updateOPTSMLDOC.setFileName(sFileName);

			// Mapping for Response Code
			updateOPTSMLDOC.setReturnCode(Long.valueOf(source.getFileDataRecord().getResponseCode()));

			// Mapping for Posting Status & Outwordstatus
			updateOPTSMLDOC.setPostingStatus("P");
			updateOPTSMLDOC.setOutwardStatus("N");

			// Mapping for Status
			updateOPTSMLDOC.setStatus("LOAD");
			
			// Mapping for Settlement amount
			tempAmount = Double.parseDouble( source.getFileDataRecord().getSettlementAmount())/100;
			updateOPTSMLDOC.setSettlAmount(BigDecimal.valueOf(tempAmount));
			
			// Mapping for Settlement currency
			updateOPTSMLDOC.setSettlCurr(source.getFileDataRecord().getSettlementCurrencyCode().equals("000") ? "704" : source.getFileDataRecord().getSettlementCurrencyCode());						
			
			// Mapping for Target Member ID
			updateOPTSMLDOC.setTargetMemberId(source.getFileDataRecord().getIssuerMemberId());
			
			// Mapping for Retrieval Reference Number RRN
			//RRN= source.getFileDataRecord().getRrn();
			//updateOPTSMLDOC.setRetRefNumber(RRN);
			//updateOPTSMLDOC.setRetRefNumber(padLeftZeros(source.getFileDataRecord().getRrn(),12,);
			if (!((source.getFileDataRecord().getRrn() == null) ? "" : source.getFileDataRecord().getRrn()).equalsIgnoreCase(""))
			{
				updateOPTSMLDOC.setRetRefNumber(padLeftZeros(source.getFileDataRecord().getRrn(),12));
			} else
			{
				String RRN ="0";
				updateOPTSMLDOC.setRetRefNumber(padLeftZeros(RRN,12));
			}

			// Mapping for Additional Data
			String sTemp="";

			if (!((source.getFileDataRecord().getNapasSvcCode() == null) ? "" : source.getFileDataRecord().getNapasSvcCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "SVC=" + source.getFileDataRecord().getNapasSvcCode() + ";";
			}

			if (!((source.getFileDataRecord().getTransactionChannelCode() == null) ? "" : source.getFileDataRecord().getTransactionChannelCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "TCC=" + source.getFileDataRecord().getTransactionChannelCode() + ";";
			}
			
			// Mapping for Real Transaction Amount
			tempAmount = Double.parseDouble( source.getFileDataRecord().getRealTransactionAmount())/100;
			sTemp = sTemp + "RTA=" + BigDecimal.valueOf(tempAmount) + ";";

			if (!((source.getFileDataRecord().getFromAccount() == null) ? "" : source.getFileDataRecord().getFromAccount()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "FromAccount=" + source.getFileDataRecord().getFromAccount() + ";";
			}

			if (!((source.getFileDataRecord().getToAccount() == null) ? "" : source.getFileDataRecord().getToAccount()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "ToAccount=" + source.getFileDataRecord().getToAccount() + ";";
			}

			if (!((source.getFileDataRecord().getFxRate() == null) ? "" : source.getFileDataRecord().getFxRate()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F9=" + source.getFileDataRecord().getFxRate() + ";";
			}

			if (!((source.getFileDataRecord().getCardholderAmount() == null) ? "" : source.getFileDataRecord().getCardholderAmount()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F6=" + source.getFileDataRecord().getCardholderAmount() + ";";
			}
			
			// Mapping for Real Card holder Amount
			tempAmount = Double.parseDouble( source.getFileDataRecord().getRealCardholerAmount())/100;
			sTemp = sTemp + "RCA=" + BigDecimal.valueOf(tempAmount) + ";";

			if (!((source.getFileDataRecord().getCardholerCurrencyCode() == null) ? "" : source.getFileDataRecord().getCardholerCurrencyCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F51=" + source.getFileDataRecord().getCardholerCurrencyCode() + ";";
			}

			if (!((source.getFileDataRecord().getCardholderFxRate() == null) ? "" : source.getFileDataRecord().getCardholderFxRate()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F10=" + source.getFileDataRecord().getCardholderFxRate() + ";";
			}

			if (!((source.getFileDataRecord().getServiceCode() == null) ? "" : source.getFileDataRecord().getServiceCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F22=" + source.getFileDataRecord().getServiceCode() + ";";
			}

			if (!((source.getFileDataRecord().getServiceConditionCode() == null) ? "" : source.getFileDataRecord().getServiceConditionCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "F25=" + source.getFileDataRecord().getServiceConditionCode() + ";";
			}

			if (!((source.getFileDataRecord().getMerchantIdentificationCode() == null) ? "" : source.getFileDataRecord().getMerchantIdentificationCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "MID=" + source.getFileDataRecord().getMerchantIdentificationCode() + ";";
			}

			if (!((source.getFileDataRecord().getBeneficiaryIdentify() == null) ? "" : source.getFileDataRecord().getBeneficiaryIdentify()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "BNB=" + source.getFileDataRecord().getBeneficiaryIdentify() + ";";
			}
		
			if (!((source.getFileDataRecord().getSvFeeIssNapas() == null) ? "" : source.getFileDataRecord().getSvFeeIssNapas()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "SVFISSNP=" + source.getFileDataRecord().getSvFeeIssNapas() + ";";
			}

			if (!((source.getFileDataRecord().getIrFeeIssAcq() == null) ? "" : source.getFileDataRecord().getIrFeeIssAcq()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFISSACQ=" + source.getFileDataRecord().getIrFeeIssAcq() + ";";
			}

			if (!((source.getFileDataRecord().getIrFeeIssBnb() == null) ? "" : source.getFileDataRecord().getIrFeeIssBnb()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFISSBNB=" + source.getFileDataRecord().getIrFeeIssBnb() + ";";
			}
		
			if (!((source.getFileDataRecord().getSvFeeAcqNapas() == null) ? "" : source.getFileDataRecord().getSvFeeAcqNapas()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "SVFACQNP=" + source.getFileDataRecord().getSvFeeAcqNapas() + ";";
			}

			if (!((source.getFileDataRecord().getIrFeeAcqIss() == null) ? "" : source.getFileDataRecord().getIrFeeAcqIss()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFACQISS=" + source.getFileDataRecord().getIrFeeAcqIss() + ";";
			}

			if (!((source.getFileDataRecord().getIrFeeAcqBnb() == null) ? "" : source.getFileDataRecord().getIrFeeAcqBnb()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFACQBNB=" + source.getFileDataRecord().getIrFeeAcqBnb() + ";";
			}

			if (!((source.getFileDataRecord().getSvFeeBnbNapas() == null) ? "" : source.getFileDataRecord().getSvFeeBnbNapas()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "SVFBNBNP=" + source.getFileDataRecord().getSvFeeBnbNapas() + ";";
			}
			
			if (!((source.getFileDataRecord().getIrFeeBnbIss() == null) ? "" : source.getFileDataRecord().getIrFeeBnbIss()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFBNBISS=" + source.getFileDataRecord().getIrFeeBnbIss() + ";";
			}
			
			if (!((source.getFileDataRecord().getIrFeeBnbAcq() == null) ? "" : source.getFileDataRecord().getIrFeeBnbAcq()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "IRFBNBACQ=" + source.getFileDataRecord().getIrFeeBnbAcq() + ";";
			}

			if (!((source.getFileDataRecord().getTransactionReferenceNumber() == null) ? "" : source.getFileDataRecord().getTransactionReferenceNumber()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "TRN=" + source.getFileDataRecord().getTransactionReferenceNumber() + ";";
			}

			if (!((source.getFileDataRecord().getResponseCode() == null) ? "" : source.getFileDataRecord().getResponseCode()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "RRC=" + source.getFileDataRecord().getResponseCode() + ";";
			}
			if (!((source.getFileDataRecord().getRsv1() == null) ? "" : source.getFileDataRecord().getRsv1()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "RSV1=" + source.getFileDataRecord().getRsv1() + ";";
			}
			
			if (!((source.getFileDataRecord().getRsv2() == null) ? "" : source.getFileDataRecord().getRsv2()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "RSV2=" + source.getFileDataRecord().getRsv2() + ";";
			}

			if (!((source.getFileDataRecord().getRsv3() == null) ? "" : source.getFileDataRecord().getRsv3()).equalsIgnoreCase(""))
			{
				sTemp = sTemp + "RSV3=" + source.getFileDataRecord().getRsv3() + ";";
			}

			updateOPTSMLDOC.setAddInfo(sTemp);
			sTemp = "";
			
			// Mapping for system field
			updateOPTSMLDOC.setNumberOfSubS(0l);
			updateOPTSMLDOC.setSourceFeeAmount(BigDecimal.valueOf(0));
			updateOPTSMLDOC.setTargetFeeAmount(BigDecimal.valueOf(0));
			updateOPTSMLDOC.setAmndState("A");
			updateOPTSMLDOC.setAmndDate(new Timestamp(System.currentTimeMillis()));

			// Update to DB
			updateOPTSMLDOC.update();

		}
		else if(source.getCurrentRecord() == source.getFileTrailerRecord())
		{
			processMessage("Reading Message Success");
		}
	}

	//read mapping for messagecode mapping from file
	protected void readMessageCodeMapping() throws FileSkipException{
		String line = "";
		BufferedReader br = null;
		try {
			InputStream is = getClass().getResourceAsStream("MessageCodeConfig.txt");
			InputStreamReader isr = new InputStreamReader(is);

			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				MessageCodeMapping.add(line.split(";"));
			}
			processMessage("ReadingMessageCodeConfig Success");
		} catch (FileNotFoundException e) {
			
			skipFile("ReadingMessageCodeConfig Failed"+e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			skipFile("ReadingMessageCodeConfig Failed"+e.getMessage());

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected boolean checkCheckSumValue() throws FileSkipException{ 
		//if Check_checksum parameter = Y, then check file Checksum
		//for file Record
		if(CHECK_CHECKSUM.equals("Y")){
			unEncryptedWord = "";
			unEncryptedWord = unEncryptedWord+source.getDataRecord();
			unEncryptedWord = unEncryptedWord+source.getMtiDef();
			unEncryptedWord = unEncryptedWord+source.getMessageTypeIdentifierCode();
			unEncryptedWord = unEncryptedWord+source.getF2();
			unEncryptedWord = unEncryptedWord+formatLeftPaddingSpace(source.getCardNumber(),19);
			unEncryptedWord = unEncryptedWord+source.getF3();
			unEncryptedWord = unEncryptedWord+source.getProcessingCode();
			unEncryptedWord = unEncryptedWord+source.getSvcDef();
			unEncryptedWord = unEncryptedWord+source.getNapasSvcCode();
			unEncryptedWord = unEncryptedWord+source.getTccDef();
			unEncryptedWord = unEncryptedWord+source.getTransactionChannelCode();
			unEncryptedWord = unEncryptedWord+source.getF4();
			unEncryptedWord = unEncryptedWord+source.getTransactionAmount();
			unEncryptedWord = unEncryptedWord+source.getRta();
			unEncryptedWord = unEncryptedWord+source.getRealTransactionAmount();
			unEncryptedWord = unEncryptedWord+source.getF49();
			unEncryptedWord = unEncryptedWord+source.getTransactionCurrencyCode();
			unEncryptedWord = unEncryptedWord+source.getF5();
			unEncryptedWord = unEncryptedWord+source.getSettlementAmount();
			unEncryptedWord = unEncryptedWord+source.getF50();
			unEncryptedWord = unEncryptedWord+source.getSettlementCurrencyCode();
			unEncryptedWord = unEncryptedWord+source.getF9();
			unEncryptedWord = unEncryptedWord+source.getFxRate();
			unEncryptedWord = unEncryptedWord+source.getF6();
			unEncryptedWord = unEncryptedWord+source.getCardholderAmount();
			unEncryptedWord = unEncryptedWord+source.getRca();
			unEncryptedWord = unEncryptedWord+source.getRealCardholerAmount();
			unEncryptedWord = unEncryptedWord+source.getF51();
			unEncryptedWord = unEncryptedWord+source.getCardholerCurrencyCode();
			unEncryptedWord = unEncryptedWord+source.getF10();
			unEncryptedWord = unEncryptedWord+source.getCardholderFxRate();
			unEncryptedWord = unEncryptedWord+source.getF11();
			unEncryptedWord = unEncryptedWord+source.getSystemTraceNumber();
			unEncryptedWord = unEncryptedWord+source.getF12();
			unEncryptedWord = unEncryptedWord+source.getLocalTransactionTime();
			unEncryptedWord = unEncryptedWord+source.getF13();
			unEncryptedWord = unEncryptedWord+source.getLocalTransactionDate();
			unEncryptedWord = unEncryptedWord+source.getF15();
			unEncryptedWord = unEncryptedWord+source.getSettlementDate();
			unEncryptedWord = unEncryptedWord+source.getF18();
			unEncryptedWord = unEncryptedWord+source.getTerminalType();
			unEncryptedWord = unEncryptedWord+source.getF22();
			unEncryptedWord = unEncryptedWord+source.getServiceCode();
			unEncryptedWord = unEncryptedWord+source.getF25();
			unEncryptedWord = unEncryptedWord+source.getServiceConditionCode();
			unEncryptedWord = unEncryptedWord+source.getF41();
			unEncryptedWord = unEncryptedWord+source.getCardAcceptorTerminalIdentification();
			unEncryptedWord = unEncryptedWord+source.getAcq();
			unEncryptedWord = unEncryptedWord+formatLeftPaddingSpace(source.getAcquiringInstitutionCode(),8);
			unEncryptedWord = unEncryptedWord+source.getIss();
			unEncryptedWord = unEncryptedWord+formatLeftPaddingSpace(source.getIssuerMemberId(),8);
			unEncryptedWord = unEncryptedWord+source.getMid();
			unEncryptedWord = unEncryptedWord+source.getMerchantIdentificationCode();
			unEncryptedWord = unEncryptedWord+source.getBnb();
			unEncryptedWord = unEncryptedWord+source.getBeneficiaryIdentify();
			unEncryptedWord = unEncryptedWord+source.getF102();
			unEncryptedWord = unEncryptedWord+source.getFromAccount();
			unEncryptedWord = unEncryptedWord+source.getF103();
			unEncryptedWord = unEncryptedWord+source.getToAccount();
			unEncryptedWord = unEncryptedWord+source.getSvfissnp();
			unEncryptedWord = unEncryptedWord+source.getSvFeeIssNapas();
			unEncryptedWord = unEncryptedWord+source.getIrfissacq();
			unEncryptedWord = unEncryptedWord+source.getIrFeeIssAcq();
			unEncryptedWord = unEncryptedWord+source.getIrfissbnb();
			unEncryptedWord = unEncryptedWord+source.getIrFeeIssBnb();
			unEncryptedWord = unEncryptedWord+source.getSvfacqnp();
			unEncryptedWord = unEncryptedWord+source.getSvFeeAcqNapas();
			unEncryptedWord = unEncryptedWord+source.getIrfacqiss();
			unEncryptedWord = unEncryptedWord+source.getIrFeeAcqIss();
			unEncryptedWord = unEncryptedWord+source.getIrfacqbnb();
			unEncryptedWord = unEncryptedWord+source.getIrFeeAcqBnb();
			unEncryptedWord = unEncryptedWord+source.getSvfbnbnp();
			unEncryptedWord = unEncryptedWord+source.getSvFeeBnbNapas();
			unEncryptedWord = unEncryptedWord+source.getIrfbnbiss();
			unEncryptedWord = unEncryptedWord+source.getIrFeeBnbIss();
			unEncryptedWord = unEncryptedWord+source.getIrfbnbacq();
			unEncryptedWord = unEncryptedWord+source.getIrFeeBnbAcq();
			unEncryptedWord = unEncryptedWord+source.getF37();
			unEncryptedWord = unEncryptedWord+source.getRrn();
			unEncryptedWord = unEncryptedWord+source.getF38();
			unEncryptedWord = unEncryptedWord+source.getAuthorizationNumber();
			unEncryptedWord = unEncryptedWord+source.getTrn();
			unEncryptedWord = unEncryptedWord+source.getTransactionReferenceNumber();
			unEncryptedWord = unEncryptedWord+source.getRrc();
			unEncryptedWord = unEncryptedWord+source.getResponseCode();
			unEncryptedWord = unEncryptedWord+source.getRsv1Def();
			unEncryptedWord = unEncryptedWord+source.getRsv1();
			unEncryptedWord = unEncryptedWord+source.getRsv2Def();
			unEncryptedWord = unEncryptedWord+source.getRsv2();
			unEncryptedWord = unEncryptedWord+source.getRsv3Def();
			unEncryptedWord = unEncryptedWord+source.getRsv3();
			unEncryptedWord = unEncryptedWord+source.getCsr();

			//processMessage("DEBUG: word: "+ unEncryptedWord + "| PrevFileId : "+ConvertMD5(unEncryptedWord,BankPassword));
			if(MD5(unEncryptedWord).equals(source.getChecksumRecordValue())){
				return true;
			}else{
				skipFile("File " + source.getFileName() 
							+ " skipped because Record Doesn't Match with Checksum! Record:\""+unEncryptedWord+"\".ValidChecksum:"+ConvertMD5(unEncryptedWord,BankPassword));
				return false;
			}
		}else{
			return true;
		}
	}

	protected boolean checkCheckSumFileTrailer() throws FileSkipException{
		//if Check_checksum parameter = Y, then check file Checksum
		//for File Trailer

		if(CHECK_CHECKSUM.equals("Y")){
			unEncryptedWord = "";
			unEncryptedWord = unEncryptedWord+ source.getTrailerRecord();
			unEncryptedWord = unEncryptedWord+ source.getNot();
			unEncryptedWord = unEncryptedWord+ source.getNumberofRecordsinTheFile();
			unEncryptedWord = unEncryptedWord+ source.getCre();
			unEncryptedWord = unEncryptedWord+ formatLeftPaddingSpace(source.getGenerator(),20);
			unEncryptedWord = unEncryptedWord+ source.getTime();
			unEncryptedWord = unEncryptedWord+ source.getFileGenerationTime();
			unEncryptedWord = unEncryptedWord+ source.getDate();
			unEncryptedWord = unEncryptedWord+ source.getFileGenerationDate();
			unEncryptedWord = unEncryptedWord+ source.getCsf();

			if(MD5(unEncryptedWord).equals(source.getChecksumFileValue()))
				return true;
			else
				return false;
		}else
			return true;
	}
	
	protected String formatLeftPaddingSpace(String word,int count){
		return String.format("%"+count+"s", word);
	}

	protected String formatRightPaddingSpace(String word,int count){
		return String.format("%-"+count+"s", word);
	}

	protected String checkMessageCode(){
		//if the return code is 0111 and DIRECTION = ISS, it means this is Credit transaction
		if(source.getFileDataRecord().getResponseCode().equals("0111") && !DIRECTION.equals("ACQ"))
		{
			return "022020020";
		}
		//If return code is 0000, read messagecode mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(source.getFileDataRecord().getTerminalType())){
				//this means ATM Transaction
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[5];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[5];
				}
			}
		}
		//Cac giao dich khong duoc ghi nhan o Way4 Doc thi ko duoc load vao 
		/*try {
			skipFile("Message Code Not Found![STAN]:"+source.getSystemTraceNumber()+"[AUTHCODE]:"+source.getAuthorizationNumber()+"[MTID]:"+source.getMessageTypeIdentifierCode() + "[ProcessingCode]:"+source.getProcessingCode()+"[SIC]:"+source.getTerminalType());			
		} catch (FileSkipException e) {		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "";
	}

	protected String checkTransTypeCode(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(source.getFileDataRecord().getTerminalType())){
				//this means ATM Transaction
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+source.getSystemTraceNumber()+"[AUTHCODE]:"+source.getAuthorizationNumber()+"[MTID]:"+source.getMessageTypeIdentifierCode() + "[ProcessingCode]:"+source.getProcessingCode()+"[SIC]:"+source.getTerminalType());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	protected String checkIS_AUTHORIZATION(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(source.getFileDataRecord().getTerminalType())){
				//this means ATM Transaction
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+source.getSystemTraceNumber()+"[AUTHCODE]:"+source.getAuthorizationNumber()+"[MTID]:"+source.getMessageTypeIdentifierCode() + "[ProcessingCode]:"+source.getProcessingCode()+"[SIC]:"+source.getTerminalType());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	protected String checkREQUEST_CATEGORY(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(source.getFileDataRecord().getTerminalType())){
				//this means ATM Transaction
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[1]+temp[3].replace("xx", source.getProcessingCode().substring(2, 4)))
							.equals(source.getMessageTypeIdentifierCode()+source.getProcessingCode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+source.getSystemTraceNumber()+"[AUTHCODE]:"+source.getAuthorizationNumber()+"[MTID]:"+source.getMessageTypeIdentifierCode() + "[ProcessingCode]:"+source.getProcessingCode()+"[SIC]:"+source.getTerminalType());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	protected String ConvertMD5(String input,String Key) 
	{
		//Checksum Creation by smartlink algorithm
		String temp="";
		String strMa = MD5(input);
		String MaBM = "5" + Key + "5";
		String regex = "[0-9]+";
		String strKQ = strMa;
		if(MaBM.matches(regex))
		{
			for(int i=0; i < MaBM.length()-1 ; i++)
			{
				int from = Integer.parseInt(MaBM.charAt(i)+""); 
				int to = Integer.parseInt(MaBM.charAt(i+1)+"");
				to = 20 - to+from;
				temp = temp +strMa.substring(from, to);
			}
			strKQ = MD5(temp);
		}
		return strKQ;
	}

	public String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			 }
			return sb.toString();
		} 
		catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	/**
	 * Log to Trace
	 * 
	 * @param msg
	 * @throws Exception
	 */
	protected void processMessage(String msg) {
		processMessage(PRLogRecord.TRACE, msg);
	}
	/**
	 * Logger w/o MsgBox
	 * 
	 * @param type
	 * @param msg
	 * @throws Exception
	 */
	protected void processMessage(String type, String msg) {
		processMessage(type, msg, false, 0, null);
	}
	/**
	 * Logger
	 * 
	 * @param type
	 * @param msg
	 * @param isMsgBox
	 * @param boxType
	 * @param docId
	 * @throws Exception
	 */
	protected void processMessage(String type, String msg, boolean isMsgBox,
			int boxType, Long docId) {
		msg = "[NapasImport]:"+msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters(
					"NapasImport", msg, boxType));
		}
	}
	
	protected void skipFile(String errText) throws FileSkipException
	{
		processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
	public String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);
	 
	    return sb.toString();
	}
}