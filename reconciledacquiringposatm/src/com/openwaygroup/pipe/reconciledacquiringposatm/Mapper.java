package com.openwaygroup.pipe.reconciledacquiringposatm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.lang.Math;
import com.openwaygroup.application.pipe.ISourceCallback;
import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;

import com.openwaygroup.application.pipe.ISourceCallback;
import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;
import com.openwaygroup.pipe.reconciledacquiringposatm.Mapper.SQLGetOrder;

public class Mapper extends com.openwaygroup.pipe.reconciledacquiringposatm.autogen.Mapper {
	protected Timestamp currDate = new Timestamp(System.currentTimeMillis());	
	protected BigDecimal multiplier;
	protected DecimalFormat decimalFormat;
	protected final int emptyZero=0;
	protected final int emptySpace=1;
	protected String unEncryptedWord;
	protected String SERVICE;
	protected String DIRECTION;
	protected String sProcessDate;
	protected String FILE_TYPE="NAPAS ACQ-TC-SWC";
	protected String BANK_PASSWORD="970416";
	protected String NAPAS_CHANNEL_CODE="b";
	protected String ABBREVIATION_BANK_NAME;
	protected String CURRENT_USER;
  /**
   * This method will be called at the beginning of the pipe's execution, 
   * before any data is retrieved by source. Add your opening code here.
   */
  protected void open() throws Exception {
		decimalFormat = new DecimalFormat("000000000000");
		multiplier = new BigDecimal(100);
		//BANK_PASSWORD = Context.getMandatoryProperty(pipe.getContext(), "BANK_PASSWORD");
		BANK_PASSWORD="970416";
		DIRECTION =  Context.getMandatoryProperty(pipe.getContext(), "DIRECTION");
		//FILE_TYPE =  Context.getMandatoryProperty(pipe.getContext(), "FILE_TYPE");
		FILE_TYPE="NAPAS ACQ-TC-SWC";
		SERVICE = Context.getMandatoryProperty(pipe.getContext(), "SERVICE");
		//NAPAS_CHANNEL_CODE = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_CHANNEL_CODE");
		NAPAS_CHANNEL_CODE="b";
		sProcessDate = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_PROCESS_DATE");
		sProcessDate = sProcessDate.substring(0,10);
		
		//if(SERVICE.equals("SWC") || SERVICE.equals("ECOM") || SERVICE.equals("UPI")){}
		//else{skipFile("Error service config");}
		// Get the Process Date of reconciliation
		
		
		checkOPTSMLDIS.setPROCESS_DATE(sProcessDate);
		checkOPTSMLDIS.setDIRECTION(DIRECTION);
		checkOPTSMLDIS.setSERVICE(SERVICE);
		checkOPTSMLDIS.execute();

		/*if (checkOPTSMLDIS.getId() > 0)
		{
			skipFile("Data in " + sProcessDate + " have already processed. Skip this file.");
		}*/
		
		if(DIRECTION.equals("ACQ")){
			acqService.select(new SQLGetOrder());
		}
		else
		{
			processMessage("sProcessDates = " + sProcessDate);
			processMessage("BANK_PASSWORD = " + BANK_PASSWORD);
			processMessage("DIRECTION = " + DIRECTION);
			processMessage("NAPAS_CHANNEL_CODE = " + NAPAS_CHANNEL_CODE);
			processMessage("FILE_TYPE = " + FILE_TYPE);
			processMessage("SERVICE = " + SERVICE);
			skipFile("Wrong File Type!");
		}
	}

  /**
   * This method will be called for each record (table row, record in flat file, xml element) retrieved 
   * by the pipe's source. Add your code to handle incoming data here.
   */
  public class SQLGetOrder implements ISourceCallback{
		
		public void processRow() throws Exception {
			// TODO Auto-generated method stub

			// Assign value to some fields
			disputeService.setAmndOfficer(1l);
			disputeService.setAmndState("A");
			disputeService.setProcessDate(sProcessDate);
			disputeService.setAmndDate(currDate);

			if(DIRECTION.equals("ACQ"))
			{
				if(!acqService.dataNotFound())
				{
					try
					{
						processMessage("I'm in !acqService.dataNotFound()");
						processMessage("----------------------------------");
						
						String onlineDocFlag = checkNullValues(acqService.getOnlinelogflag(), 4, emptySpace);
						long docId = 0;
						String add_info = "";
						if(onlineDocFlag.equals("Y"))
						{
							docId = acqService.getId();
							getOnlineDoc(docId);
						}
						
						disputeService.setCardNumber(acqService.getCardNumber());
						disputeService.setProcessingCode(checkNullValues(acqService.getProcessingcode(),6,0));
						disputeService.setTransAmount(acqService.getTransamount().toString());
						disputeService.setSystemTraceNumber(acqService.getSystemtracenumber());
						disputeService.setTransTime(checkNullValues(acqService.getLocaltransactiontime(),6,emptyZero));
						disputeService.setTransDate(checkNullValues(acqService.getLocaltransactiondate(),4,emptyZero));
						disputeService.setSettlDate(acqService.getSettlementdate());
						disputeService.setTerminalType(acqService.getSiccode());
						disputeService.setAcquiringMemberId(checkNullValues(acqService.getAcquiringinstitutioncode(),8,emptyZero));
						disputeService.setTerminalId(checkNullValues(acqService.getTerminalidentification(),8,emptySpace));
						disputeService.setAuthCode(checkNullValues(acqService.getAuthorizationnumber(),6,emptyZero));
						disputeService.setTransCurr(checkNullValues(acqService.getTransactioncurrencycode(),3,emptyZero));
						disputeService.setFromAccount(formatLeftPaddingZero(checkNullValues(acqService.getFromaccount(),20,emptyZero),20));
						disputeService.setToAccount(formatLeftPaddingZero(checkNullValues(acqService.getToaccount(),20,emptyZero),20));
						disputeService.setMessageCode(acqService.getMessagetypeidentifiercode());
						disputeService.setReturnCode(checkNullValues(acqService.getTransactionstatus(), 4, emptySpace));
						disputeService.setDirection("ACQ");
						
						if (acqService.getTransactionstatus().equalsIgnoreCase("0115") && onlineDocFlag.equals("N")) // Co o ACB khong co o SML
						{
							disputeService.setDocOid(acqService.getId());
						}
						else // Co o SML khong co o ACB thi set theo ID o bang OPT_SMLDOC
						{
							disputeService.setDocOid(null);
						}
						
						//processMessage("I'm here: 19");
						String status = acqService.getStatus();
						if(status.equals("HOLD"))
						{
							disputeService.setStatus("HOLD");
						}
						else if (acqService.getCardNumber().substring(0, 8).equals("97041116"))
						{
							disputeService.setStatus("HOLD");
						}
						else if(status.equals("TO BE SENT"))
						{
							disputeService.setStatus("TO BE SENT");
						}
						else
						{
							disputeService.setStatus("TO BE SENT");
						}
						disputeService.setTransDate2(acqService.getTransDate());
						disputeService.setNapasService(SERVICE);
						//Napas Service Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getNapassvccode() != null)
						{
							add_info = add_info + "F62=" + onlineDoc.getNapassvccode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !((acqService.getNapassvccode() == null) ? "" : acqService.getNapassvccode()).equals(""))
						{
							add_info = add_info + "F62=" + acqService.getNapassvccode().trim() + ";";
						}

						//Transaction Channel Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getTransactionchannelcode() != null)
						{
							add_info = add_info + "F60=" + onlineDoc.getTransactionchannelcode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !((acqService.getTransactionchannelcode() == null) ? "" : acqService.getTransactionchannelcode()).equals(""))
						{
							add_info = add_info + "F60=" + acqService.getTransactionchannelcode().trim() + ";";
						}

		   
						//add_info = add_info + "RTA=" + acqService.getRealtransactionamount().toString() + ";";
						// fix for RTA 115 add_info = add_info + "RTA=" + acqService.getRealtransactionamount().toString() + ";";
						if (acqService.getTransactionstatus().equalsIgnoreCase("0115") && acqService.getRealtransactionamount()!= null) 
						{
							add_info = add_info + "RTA=000000000000;";
						}
						else if (acqService.getTransactionstatus().equalsIgnoreCase("0114") && acqService.getRealtransactionamount()!= null)
						{	// return value Adjustment doc
							double rtavalue=0;
							rtavalue = (acqService.getRealcardholderamount().doubleValue() - acqService.getReconciledtransaction().doubleValue());
							add_info =add_info + "RTA=" + rtavalue + ";";
						}
						//Settlement Amount
						add_info = add_info + "F5=" + acqService.getSettlementamount().toString() + ";";

						//Settlement Currency Code
						add_info = add_info + "F50=" + acqService.getSettlementcurrencycode().toString() + ";";

						//FX Rate
						if(onlineDocFlag.equals("Y") && onlineDoc.getFxrate() != null)
						{
							add_info = add_info + "F9=" + onlineDoc.getFxrate().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getFxrate().equals(""))
						{
							add_info = add_info + "F9=" + acqService.getFxrate().toString() + ";";
						}

						//Card Holder Amount
						if(onlineDocFlag.equals("Y") && onlineDoc.getCardholderamount() != null)
						{
							add_info = add_info + "F6=" + onlineDoc.getCardholderamount().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getCardholderamount().equals(""))
						{
							add_info = add_info + "F6=" + acqService.getCardholderamount().toString() + ";";
						}

						//Real Card Holder Amount
						//add_info = add_info + "RCA=" + acqService.getRealcardholderamount().toString() + ";";
						if ((acqService.getTransactionstatus().equalsIgnoreCase("0115"))&& (acqService.getCardholderamount().toString()!=null)) // Co o ACB khong co o SML
						{
							add_info = add_info + "RCA=000000000000;";
						}
						else if (acqService.getTransactionstatus().equalsIgnoreCase("0114") && acqService.getSettlementamount()!= null)
						{	// return value Adjustment doc
							double rcavalue=0;
							rcavalue = (acqService.getRealtransactionamount().doubleValue()-acqService.getReconciledtransaction().doubleValue());
							add_info =add_info + "RCA=" + rcavalue + ";";
						}
	  
						//Card Holder Currency Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getCardholercurrencycode() != null)
						{
							add_info = add_info + "F51=" + onlineDoc.getCardholercurrencycode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getCardholercurrencycode().equals(""))
						{
							add_info = add_info + "F51=" + acqService.getCardholercurrencycode().toString() + ";";
						}

						//Card Holder FX Rate
						if(onlineDocFlag.equals("Y") && onlineDoc.getCardholderfxrate() != null)
						{
							add_info = add_info + "F10=" + onlineDoc.getCardholderfxrate().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getCardholderfxrate().equals(""))
						{
							add_info = add_info + "F10=" + acqService.getCardholderfxrate().toString() + ";";
						}

						//Service Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getServicecode() != null)
						{
							add_info = add_info + "F22=" + onlineDoc.getServicecode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getServicecode().equals(""))
						{
							add_info = add_info + "F22=" + acqService.getServicecode().toString() + ";";
						}

						//Service Condition Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getServiceconditioncode() != null)
						{
							add_info = add_info + "F25=" + onlineDoc.getServiceconditioncode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getServiceconditioncode().equals(""))
						{
							add_info = add_info + "F25=" + acqService.getServiceconditioncode().toString() + ";";
						}

						//Merchant Identification Code
						if(onlineDocFlag.equals("Y") && onlineDoc.getMerchantidentificationcode() != null)
						{
							add_info = add_info + "MID=" + onlineDoc.getMerchantidentificationcode().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getMerchantidentificationcode().equals(""))
						{
							add_info = add_info + "MID=" + acqService.getMerchantidentificationcode().toString() + ";";
						}

						//Beneficiary Identify
						if(onlineDocFlag.equals("Y") && onlineDoc.getBeneficiaryidentify() != null)
						{
							add_info = add_info + "BNB=" + onlineDoc.getBeneficiaryidentify().trim() + ";";
						}
						else if(onlineDocFlag.equals("N") && !acqService.getBeneficiaryidentify().equals(""))
						{
							add_info = add_info + "BNB=" + acqService.getBeneficiaryidentify().toString() + ";";
						}

						//Transaction Reference Number
						if(onlineDocFlag.equals("Y") && onlineDoc.getTransactionreferencenumber() != null)
						{
							add_info = add_info + "TRN=" + onlineDoc.getTransactionreferencenumber().substring(0,16).toString() + ";";
						}
						else if(onlineDocFlag.equals("N") && !((acqService.getTransactionreferencenumber() == null) ? "" : acqService.getTransactionreferencenumber()).equals(""))
						{
							add_info = add_info + "TRN=" + acqService.getTransactionreferencenumber().toString() + ";";
						}

						//Retrieve Reference NUmber
						add_info = add_info + "RRN=" + acqService.getRetrievalreferencenumber().toString() + ";";

						disputeService.setAddInfo(add_info);
						disputeService.update();
					}
					catch (NullPointerException e){
						processMessage("Could not written Details Row");
					}
				}else
				{
					processMessage("sProcessDates = " + sProcessDate);
					processMessage("BANK_PASSWORD = " + BANK_PASSWORD);
					processMessage("DIRECTION = " + DIRECTION);
					processMessage("NAPAS_CHANNEL_CODE = " + NAPAS_CHANNEL_CODE);
					processMessage("FILE_TYPE = " + FILE_TYPE);
					processMessage("SERVICE = " + SERVICE);
				}
			}
		}
  }
		private void getOnlineDoc(long docId) throws Exception {
		// TODO Auto-generated method stub
		try{
			onlineDoc.setDOC_ID(docId);
			onlineDoc.execute();
		} catch (Exception e) {
			skipFile("Doc has no online log: " + docId);
		}
	}
	
	protected String checkNullValues(String word,int length,int defaultValue){
		if(word == null && defaultValue == emptySpace)
			return String.format("%"+length+"s", "");
		else if(word == null && defaultValue == emptyZero)
			return String.format("%0"+length+"d",0);
		return word;
	}
	
	protected String formatLeftPaddingZero(String word, int count){
		  if(count - word.length() > 0)
			  return String.format("%0"+ (count - word.length() )+"d%s",0, word);
		  else
			  return word;
	}

	/**
	 * This method will be called for each record (table row, record in flat file, xml element) retrieved 
	 * by the pipe's source. Add your code to handle incoming data here.
	 */
	protected void execute() throws Exception {
	}

	/**
	 * This method will be called at the end of the pipe's execution.
	 * Add your closing code here.
	 */
	protected void close() throws Exception {
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
		msg = "[Napas Reconilation]:"+msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters(
					"Napas Reconilation", msg, boxType));
		}
	}

	protected void skipFile(String errText) throws FileSkipException
	{
		processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
}