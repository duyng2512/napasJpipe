package com.openwaygroup.pipe.napasoutgoing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import napas.md5.checkMD5;

import com.openwaygroup.application.pipe.ISourceCallback;
import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.pipe.file.FileInfoParameters;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;

public class Mapper extends com.openwaygroup.pipe.napasoutgoing.autogen.Mapper {
	protected SimpleDateFormat dateFormat;
	protected Timestamp currDate = new Timestamp(System.currentTimeMillis());
	protected long dataCount;
	protected BigDecimal multiplier;
	protected DecimalFormat decimalFormat;
	protected final int emptyZero=0;
	protected final int emptySpace=1;
	protected String DIRECTION,unEncryptedWord,BANK_PASSWORD,NAPAS_SERVICE;
	protected String sProcessDate="";
	protected Timestamp dISS_MIN_DATE;
	protected Timestamp dISS_MAX_DATE;
	protected Timestamp dACQ_MIN_DATE;
	protected Timestamp dACQ_MAX_DATE;
	
  /**
   * This method will be called at the beginning of the pipe's execution, 
   * before any data is retrieved by source. Add your opening code here.
   */
	protected void open() throws Exception {
		dateFormat = new SimpleDateFormat("ddMMyy");
		decimalFormat = new DecimalFormat("000000000000");
		dataCount = 0;
		multiplier = new BigDecimal(100);
		
		BANK_PASSWORD = Context.getMandatoryProperty(pipe.getContext(), "BANK_PASSWORD");
		DIRECTION = Context.getMandatoryProperty(pipe.getContext(), "DIRECTION");
		
		// Get the Process Date of reconciliation
		sProcessDate = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_PROCESS_DATE");
		sProcessDate = sProcessDate.replaceAll("'","").substring(0,10);
		processMessage("sProcessDates 2 = " + sProcessDate);
		
		NAPAS_SERVICE = Context.getMandatoryProperty(pipe.getContext(), "SERVICE");
		
		createHeaderFile();
		disputeRecord.select(new SQLGetOrder());
	}
	
	/**
	* This method will be called for each record (table row, record in flat file, xml element) retrieved 
	* by the pipe's source. Add your code to handle incoming data here.
	*/
	protected void execute() throws Exception {
	}
	public class SQLGetOrder implements ISourceCallback{
		
		public void processRow() throws Exception {
			if(!disputeRecord.dataNotFound())
			{
				try
				{
					String sTemp = "";
					outWardFile.setCurrentRecordType("fileDataRecord");
					outWardFile.getFileDataRecord().setMessageTypeIdentifierCode(disputeRecord.getMessagetypeidentifiercode());
					outWardFile.getFileDataRecord().setCardNumber(formatLeftPaddingSpace(checkNullValues(disputeRecord.getCardNumber(),19,emptySpace), 19));
					outWardFile.getFileDataRecord().setProcessingCode(checkNullValues(disputeRecord.getProcessingcode(),6,emptyZero));
					outWardFile.getFileDataRecord().setNapasSvcCode(formatLeftPaddingSpace(checkNullValues(disputeRecord.getNapassvccode(),10,emptySpace), 10));
					outWardFile.getFileDataRecord().setTransactionChannelCode(formatLeftPaddingSpace(checkNullValues(disputeRecord.getTransactionchannelcode(),2,emptySpace), 2));
					outWardFile.getFileDataRecord().setTransactionAmount(formatLeftPaddingZero(disputeRecord.getTransamount() + "00",12));
					outWardFile.getFileDataRecord().setRealTransactionAmount(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getRealtransactionamount()) + "00",12,emptySpace), 12));
					outWardFile.getFileDataRecord().setTransactionCurrencyCode(formatLeftPaddingZero(checkNullValues(disputeRecord.getTransactioncurrencycode(),3,emptyZero),3));
					outWardFile.getFileDataRecord().setSettlementAmount(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getSettlementamount()) + "00",12,emptyZero), 12));
					outWardFile.getFileDataRecord().setSettlementCurrencyCode(formatLeftPaddingZero(checkNullValues(disputeRecord.getSettlementcurrencycode(),3,emptyZero),3));
					outWardFile.getFileDataRecord().setFxRate(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getFxrate()),8,emptyZero),8));
					outWardFile.getFileDataRecord().setCardholderAmount(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getCardholderamount()) + "00",12,emptyZero),12));
					outWardFile.getFileDataRecord().setRealCardholerAmount(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getRealcardholderamount()) + "00",12,emptyZero),12));
					outWardFile.getFileDataRecord().setCardholerCurrencyCode(formatLeftPaddingZero(checkNullValues(disputeRecord.getCardholercurrencycode(),3,emptyZero),3));
					outWardFile.getFileDataRecord().setCardholderFxRate(formatLeftPaddingZero(checkNullValues(String.valueOf(disputeRecord.getCardholderfxrate()),8,emptyZero),8));
					outWardFile.getFileDataRecord().setSystemTraceNumber(formatLeftPaddingZero(checkNullValues(disputeRecord.getSystemtracenumber(),6,emptyZero),6));
					outWardFile.getFileDataRecord().setLocalTransactionTime(checkNullValues(disputeRecord.getLocaltransactiontime(),6,emptyZero));
					outWardFile.getFileDataRecord().setLocalTransactionDate(checkNullValues(disputeRecord.getLocaltransactiondate(),4,emptyZero));
					outWardFile.getFileDataRecord().setSettlementDate(checkNullValues(disputeRecord.getSettlementdate(),4,emptyZero));
					outWardFile.getFileDataRecord().setTerminalType(checkNullValues(disputeRecord.getSiccode(),4,emptySpace));
					outWardFile.getFileDataRecord().setServiceCode(formatLeftPaddingZero(checkNullValues(disputeRecord.getServicecode(),3,emptySpace),3));
					outWardFile.getFileDataRecord().setServiceConditionCode(formatLeftPaddingZero(checkNullValues(disputeRecord.getServiceconditioncode(),2,emptySpace),2));
					outWardFile.getFileDataRecord().setCardAcceptorTerminalIdentification(checkNullValues(disputeRecord.getTerminalidentification(),8,emptySpace));
					outWardFile.getFileDataRecord().setAcquiringInstitutionCode(formatLeftPaddingSpace(checkNullValues(disputeRecord.getAcquiringinstitutioncode(),8,emptyZero), 8));
					outWardFile.getFileDataRecord().setIssuerMemberId(formatLeftPaddingSpace(checkNullValues(disputeRecord.getIssuerbankcode(),8,emptySpace), 8));
					outWardFile.getFileDataRecord().setMerchantIdentificationCode(formatLeftPaddingSpace(checkNullValues(disputeRecord.getMerchantidentificationcode(),15,emptySpace), 15));
					outWardFile.getFileDataRecord().setBeneficiaryIdentify(formatLeftPaddingSpace(checkNullValues(disputeRecord.getBeneficiaryidentify(),8,emptySpace), 8));
					outWardFile.getFileDataRecord().setFromAccount(formatLeftPaddingSpace(checkNullValues(disputeRecord.getFromaccount(),28,emptySpace),28));
					outWardFile.getFileDataRecord().setToAccount(formatLeftPaddingSpace(checkNullValues(disputeRecord.getToaccount(),28,emptySpace),28));
					outWardFile.getFileDataRecord().setRrn(formatLeftPaddingZero(checkNullValues(disputeRecord.getRetrievalreferencenumber(),12,emptySpace),12));
					outWardFile.getFileDataRecord().setAuthorizationNumber(checkNullValues(disputeRecord.getAuthorizationnumber(),6,emptyZero));
					outWardFile.getFileDataRecord().setTransactionReferenceNumber(formatLeftPaddingSpace(checkNullValues(disputeRecord.getTransactionreferencenumber(),16,emptySpace),16));
					outWardFile.getFileDataRecord().setResponseCode(checkNullValues(disputeRecord.getTransactionstatus(), 4, emptySpace));

					sTemp = formatLeftPaddingSpace(checkNullValues("",100,emptySpace),100);
					outWardFile.getFileDataRecord().setRsv1(sTemp);
					outWardFile.getFileDataRecord().setRsv2(sTemp);
					outWardFile.getFileDataRecord().setRsv3(sTemp);
					
					calCheckSumValue();
					//outWardFile.getFileDataRecord().setChecksumRecordValue(ConvertMD5(unEncryptedWord,BANK_PASSWORD));
					outWardFile.getFileDataRecord().setChecksumRecordValue(MD5_NAPAS(unEncryptedWord));
					
					outWardFile.update();
					dataCount++;
				}
				catch (NullPointerException e){
					processMessage("disputeRecord is null. Stop");
				}
			}
		}
	}
	
	/**
	 * This method will be called at the end of the pipe's execution.
	 * Add your closing code here.
	 */
	protected void close() throws Exception {
		outWardFile.setCurrentRecordType("fileTrailerRecord");
		
		outWardFile.getFileTrailerRecord().setNumberOfRecordsInTheFile(String.format("%09d", dataCount));
		
		outWardFile.getFileTrailerRecord().setGenerator(formatLeftPaddingSpace(Context.getMandatoryProperty(pipe.getContext(), "CURRENT_USER"),20 ));
		
		dateFormat.applyPattern("HHmmss");
		outWardFile.getFileTrailerRecord().setFileGenerationTime(dateFormat.format(Calendar.getInstance().getTime()));
		
		dateFormat.applyPattern("ddMMyyyy");
		outWardFile.getFileTrailerRecord().setFileGenerationDate(dateFormat.format(Calendar.getInstance().getTime()));
		
		calCheckSumTrailer();
		//outWardFile.getFileTrailerRecord().setChecksumFileValue(ConvertMD5(unEncryptedWord,BANK_PASSWORD));
		outWardFile.getFileTrailerRecord().setChecksumFileValue(MD5_NAPAS(unEncryptedWord));
		
		outWardFile.update();
		processMessage("Outward file for Smartlink generated:"+outWardFile.getFileParameters().getFileDirectory()+"/"+outWardFile.getFileParameters().getFileName());
		outWardFile.close();
	}
	
	

	protected void createHeaderFile() throws Exception
	{
		/*Determining FileName*/
		String tempFileName="";
		dateFormat.applyPattern("MMddyy");
		String sMemberBankCode = Context.getMandatoryProperty(pipe.getContext(), "MEMBER_BANK_CODE");
		tempFileName = tempFileName + dateFormat.format(Calendar.getInstance().getTime()); 
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + DIRECTION;
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + Context.getMandatoryProperty(pipe.getContext(), "ABBREVIATION_BANK_NAME");
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + sMemberBankCode;
		
		FileInfoParameters fileInfoParameters = FileInfoParameters.get(outWardFile.getFileParameters());
		//The Parameters are used to filter the file group by using file names
		fileInfoParameters.setParameters(tempFileName);
		
		
		fileSequence.setPARMS(tempFileName);
		fileSequence.execute();
		long fileNumber = fileSequence.getNextSeq();
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + fileNumber;
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + "SL";
		tempFileName = tempFileName + "_";
		tempFileName = tempFileName + NAPAS_SERVICE + ".dat";
		//tempFileName = tempFileName +".dat";
		outWardFile.getFileParameters().setFileName(tempFileName);
		processMessage("FileSequence:"+ fileNumber );
		processMessage("FileName: "+tempFileName);
		 
		outWardFile.setCurrentRecordType("fileHeaderRecord");
		//Not Yet
		outWardFile.getFileHeaderRecord().setBin(formatLeftPaddingSpace(sMemberBankCode,8));
		
		getTransLastDate.execute();
		String transLastDate = getTransLastDate.getMaxDate();
		outWardFile.getFileHeaderRecord().setTransactionDate(checkNullValues(transLastDate, 8, emptyZero));
		
		outWardFile.update();
	}

	protected String checkNullValues(String word,int length,int defaultValue){
		if(word == null && defaultValue == emptySpace)
			return String.format("%"+length+"s", "");
		else if(word == null && defaultValue == emptyZero)
			return String.format("%0"+length+"d", 0);
		return word;
	}

	protected String formatLeftPaddingZero(String word, int count){
		if(count - word.length() > 0)
			return String.format("%0"+ (count - word.length() )+"d%s",0, word);
		else
			return word;
	}

	protected String formatLeftPaddingSpace(String word,int count){
		return String.format("%"+count+"s", word);
	}

	protected String ConvertMD5(String input,String Key) 
	{
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

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (java.security.NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
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
	
	public String MD5_NAPAS(String input){
		try {
			checkMD5 s = new checkMD5();			
			return s.getCS(input, BANK_PASSWORD);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void calCheckSumValue() throws FileSkipException{
		unEncryptedWord = "";
		outWardFile.getFileDataRecord().setDataRecord("DR");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getDataRecord();
		outWardFile.getFileDataRecord().setMtiDef("[MTI]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getMtiDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getMessageTypeIdentifierCode();
		outWardFile.getFileDataRecord().setF2("[F2]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF2();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCardNumber();
		outWardFile.getFileDataRecord().setF3("[F3]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF3();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getProcessingCode();
		outWardFile.getFileDataRecord().setSvcDef("[SVC]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getSvcDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getNapasSvcCode();
		outWardFile.getFileDataRecord().setTccDef("[TCC]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTccDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTransactionChannelCode();
		outWardFile.getFileDataRecord().setF4("[F4]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF4();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTransactionAmount();
		outWardFile.getFileDataRecord().setRta("[RTA]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRta();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRealTransactionAmount();
		outWardFile.getFileDataRecord().setF49("[F49]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF49();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTransactionCurrencyCode();
		outWardFile.getFileDataRecord().setF5("[F5]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF5();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getSettlementAmount();
		outWardFile.getFileDataRecord().setF50("[F50]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF50();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getSettlementCurrencyCode();
		outWardFile.getFileDataRecord().setF9("[F9]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF9();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getFxRate();
		outWardFile.getFileDataRecord().setF6("[F6]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF6();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCardholderAmount();
		outWardFile.getFileDataRecord().setRca("[RCA]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRca();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRealCardholerAmount();
		outWardFile.getFileDataRecord().setF51("[F51]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF51();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCardholerCurrencyCode();
		outWardFile.getFileDataRecord().setF10("[F10]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF10();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCardholderFxRate();
		outWardFile.getFileDataRecord().setF11("[F11]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF11();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getSystemTraceNumber();
		outWardFile.getFileDataRecord().setF12("[F12]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF12();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getLocalTransactionTime();
		outWardFile.getFileDataRecord().setF13("[F13]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF13();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getLocalTransactionDate();
		outWardFile.getFileDataRecord().setF15("[F15]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF15();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getSettlementDate();
		outWardFile.getFileDataRecord().setF18("[F18]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF18();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTerminalType();
		outWardFile.getFileDataRecord().setF22("[F22]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF22();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getServiceCode();
		outWardFile.getFileDataRecord().setF25("[F25]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF25();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getServiceConditionCode();
		outWardFile.getFileDataRecord().setF41("[F41]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF41();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCardAcceptorTerminalIdentification();
		outWardFile.getFileDataRecord().setAcq("[ACQ]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getAcq();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getAcquiringInstitutionCode();
		outWardFile.getFileDataRecord().setIss("[ISS]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getIss();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getIssuerMemberId();
		outWardFile.getFileDataRecord().setMid("[MID]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getMid();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getMerchantIdentificationCode();
		outWardFile.getFileDataRecord().setBnb("[BNB]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getBnb();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getBeneficiaryIdentify();
		outWardFile.getFileDataRecord().setF102("[F102]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF102();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getFromAccount();
		outWardFile.getFileDataRecord().setF103("[F103]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF103();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getToAccount();
		outWardFile.getFileDataRecord().setF37("[F37]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF37();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRrn();
		outWardFile.getFileDataRecord().setF38("[F38]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getF38();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getAuthorizationNumber();
		outWardFile.getFileDataRecord().setTrn("[TRN]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTrn();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getTransactionReferenceNumber();
		outWardFile.getFileDataRecord().setRrc("[RRC]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRrc();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getResponseCode();
		outWardFile.getFileDataRecord().setRsv1Def("[RSV1]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv1Def();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv1();
		outWardFile.getFileDataRecord().setRsv2Def("[RSV2]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv2Def();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv2();
		outWardFile.getFileDataRecord().setRsv3Def("[RSV3]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv3Def();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getRsv3();
		outWardFile.getFileDataRecord().setCsr("[CSR]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileDataRecord().getCsr();
  	}
	
	protected void calCheckSumTrailer() throws FileSkipException{
		unEncryptedWord = "";
		
		outWardFile.getFileTrailerRecord().setTrailerRecord("TR");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getTrailerRecord();
		
		outWardFile.getFileTrailerRecord().setNotDef("[NOT]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getNotDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getNumberOfRecordsInTheFile();
		
		outWardFile.getFileTrailerRecord().setGeneratorDef("[CRE]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getGeneratorDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getGenerator();
		
		outWardFile.getFileTrailerRecord().setGenerateTimeDef("[TIME]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getGenerateTimeDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getFileGenerationTime();
		
		outWardFile.getFileTrailerRecord().setGenerateDateDef("[DATE]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getGenerateDateDef();
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getFileGenerationDate();
		
		outWardFile.getFileTrailerRecord().setCsfDef("[CSF]");
		unEncryptedWord = unEncryptedWord+outWardFile.getFileTrailerRecord().getCsfDef();
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
		msg = "[NapasOutward]:"+msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters(
					"NapasOutward", msg, boxType));
		}
	}
	
	protected void skipFile(String errText) throws FileSkipException
	{
		processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
}