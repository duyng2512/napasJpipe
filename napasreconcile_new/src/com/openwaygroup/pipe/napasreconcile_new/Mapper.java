package com.openwaygroup.pipe.napasreconcile_new;

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

public class Mapper extends com.openwaygroup.pipe.napasreconcile_new.autogen.Mapper {
	protected Timestamp currDate = new Timestamp(System.currentTimeMillis());	
	protected BigDecimal multiplier;
	protected DecimalFormat decimalFormat;
	protected final int emptyZero=0;
	protected final int emptySpace=1;
	protected String DIRECTION,unEncryptedWord,BANK_PASSWORD,SERVICE;
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
		decimalFormat = new DecimalFormat("000000000000");
		multiplier = new BigDecimal(100);
		
		BANK_PASSWORD = Context.getMandatoryProperty(pipe.getContext(), "BANK_PASSWORD");
		DIRECTION = Context.getMandatoryProperty(pipe.getContext(), "DIRECTION");
		SERVICE = Context.getMandatoryProperty(pipe.getContext(), "SERVICE");
		if(SERVICE.equals("SWC") || SERVICE.equals("ECOM") || SERVICE.equals("UPI")){}
		else{skipFile("Error service config");}
		
		// Get the Process Date of reconciliation
		sProcessDate = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_PROCESS_DATE");
		sProcessDate = sProcessDate.substring(0,10);
		processMessage("sProcessDates = " + sProcessDate);
		
		checkOPTSMLDIS.setPROCESS_DATE(sProcessDate);
		checkOPTSMLDIS.setDIRECTION(DIRECTION);
		checkOPTSMLDIS.setSERVICE(SERVICE);
		checkOPTSMLDIS.execute();

		/*if (checkOPTSMLDIS.getId() > 0)
		{
			skipFile("Data in " + sProcessDate + " have already processed. Skip this file.");
		}*/
		
		if(DIRECTION.equals("ACQ")){
			try{
				System.out.println("ACQ reconcied");
				acqService.select(new SQLGetOrder());
			}catch(Exception ex)
			{
				ex.printStackTrace();
				skipFile("ACQ SWC Service is null. Stop: ");
			}
		}
		else if(DIRECTION.equals("ISS")){
			if(SERVICE.equals("SWC"))
			{
				issService.select(new SQLGetOrder());
			}
			else if(SERVICE.equals("ECOM"))
			{
				getMinDateEcom.execute();
				getMaxDateEcom.execute();
				dISS_MIN_DATE = getMinDateEcom.getMinDate();
				dISS_MAX_DATE = getMaxDateEcom.getMaxDate();
				processMessage("dISS_MIN_DATE = " + dISS_MIN_DATE);
				processMessage("dISS_MAX_DATE = " + dISS_MAX_DATE);
				issEcomService.setMIN_DATE(dISS_MIN_DATE);
				issEcomService.setMAX_DATE(dISS_MAX_DATE);
				issEcomService.select(new SQLGetOrder());
			}
		}
		else
		{
			skipFile("Wrong File Type!");
		}
	}

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
						skipFile("acqService is null. Stop");
					}
					
				}
			}else if(DIRECTION.equals("ISS"))
			{
				if(SERVICE.equals("SWC"))
				{
					if(!issService.dataNotFound())
					{
						try
						{
							processMessage("I'm in !issService.dataNotFound()");
							processMessage("----------------------------------");
	
							String responseCode = checkNullValues(issService.getTransactionstatus(), 4, emptySpace);
							long docId = 0;
							String add_info = "";
							if(responseCode.equals("0116"))
							{
								docId = issService.getId();
								getOnlineDoc(docId);
							}
							disputeService.setCardNumber(issService.getCardNumber());
							disputeService.setProcessingCode(checkNullValues(issService.getProcessingcode(),6,emptyZero));
							disputeService.setTransAmount(issService.getTransamount().toString());
							disputeService.setSystemTraceNumber(checkNullValues(issService.getSystemtracenumber(),6,emptyZero));
							disputeService.setTransTime(checkNullValues(issService.getLocaltransactiontime(),6,emptyZero));						
							disputeService.setTransDate(checkNullValues(issService.getLocaltransactiondate(),4,emptyZero));
							disputeService.setSettlDate(issService.getSettlementdate());
							disputeService.setTerminalType(checkNullValues(issService.getSiccode(),4,emptySpace));
							disputeService.setAcquiringMemberId(checkNullValues(issService.getAcquiringinstitutioncode(),8,emptyZero));
							disputeService.setAuthCode(checkNullValues(issService.getAuthorizationnumber(),6,emptyZero));
							disputeService.setTerminalId(checkNullValues(issService.getTerminalidentification(),8,emptySpace));
							disputeService.setTransCurr(checkNullValues(issService.getTransactioncurrencycode(),3,emptyZero));
							disputeService.setFromAccount(formatLeftPaddingZero(checkNullValues(issService.getFromaccount(),20,emptyZero),20));
							disputeService.setToAccount(formatLeftPaddingZero(checkNullValues(issService.getToaccount(),20,emptyZero),20));
							disputeService.setMessageCode(issService.getMessagetypeidentifiercode());
							disputeService.setReturnCode(checkNullValues(issService.getTransactionstatus(), 4, emptySpace));
							disputeService.setDirection("ISS");
							if (issService.getTransactionstatus().equalsIgnoreCase("0116") ) // Co o ACB khong co o SML
							{
								disputeService.setDocOid(null);
							}
							else // Co o SML khong co o ACB thi set theo ID o bang OPT_SMLDOC
							{
								disputeService.setDocOid(issService.getId());
							}
							
							if(issService.getAcquiringinstitutioncode().equals("970416")){
								disputeService.setStatus("HOLD");
							}
							else{
								disputeService.setStatus("TO BE SENT");
							}
							
							disputeService.setTransDate2(issService.getTransDate());
							disputeService.setNapasService(SERVICE);
							
							//Napas Service Code
							if(responseCode.equals("0116") && onlineDoc.getNapassvccode() != null)
							{
								add_info = add_info + "F62=" + onlineDoc.getNapassvccode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !((issService.getNapassvccode() == null) ? "" : issService.getNapassvccode()).equals(""))
							{
								add_info = add_info + "F62=" + issService.getNapassvccode().trim() + ";";
							}
							
							//Transaction Channel Code
							if(responseCode.equals("0116") && onlineDoc.getTransactionchannelcode() != null)
							{
								add_info = add_info + "F60=" + onlineDoc.getTransactionchannelcode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !((issService.getTransactionchannelcode() == null) ? "" : issService.getTransactionchannelcode()).equals(""))
							{
								add_info = add_info + "F60=" + issService.getTransactionchannelcode().trim() + ";";
							}
							
			
							//add_info = add_info + "RTA=" + issService.getRealtransactionamount().toString() + ";";
							// fixed add_info = add_info + "RTA=" + issService.getRealtransactionamount().toString() + ";";
							if(responseCode.equals("0116") && issService.getRealtransactionamount()!= null)
							{
								add_info = add_info + "RTA=" + issService.getRealtransactionamount().toString() + ";";
							}
							else if(responseCode.equals("0117") && issService.getRealtransactionamount()!= null)
							{
								add_info = add_info + "RTA=000000000000;";
							}
						    //Settlement Amount
						    add_info = add_info + "F5=" + issService.getSettlementamount().toString() + ";";
						    
						    //Settlement Currency Code
						    add_info = add_info + "F50=" + issService.getSettlementcurrencycode().toString() + ";";
							
						    //FX Rate
							if(responseCode.equals("0116") && onlineDoc.getFxrate() != null)
							{
								add_info = add_info + "F9=" + onlineDoc.getFxrate().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getFxrate().equals(""))
							{
								add_info = add_info + "F9=" + issService.getFxrate().toString() + ";";
							}
							
							//Card Holder Amount
							if(responseCode.equals("0116") && onlineDoc.getCardholderamount() != null)
							{
								add_info = add_info + "F6=" + onlineDoc.getCardholderamount().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getCardholderamount().equals(""))
							{
								add_info = add_info + "F6=" + issService.getCardholderamount().toString() + ";";
							}
							
							//Real Card Holder Amount
							//add_info = add_info + "RCA=" + issService.getRealcardholderamount().toString() + ";";
		
							if((responseCode.equals("0116")) && (issService.getRealcardholderamount().toString()!=null))
							{
								add_info = add_info + "RCA=" + issService.getRealcardholderamount().toString() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getCardholderamount().equals(""))
							{
								add_info = add_info + "RCA=000000000000;";
							}
							//Card Holder Currency Code
							if(responseCode.equals("0116") && onlineDoc.getCardholercurrencycode() != null)
							{
								add_info = add_info + "F51=" + onlineDoc.getCardholercurrencycode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getCardholercurrencycode().equals(""))
							{
								add_info = add_info + "F51=" + issService.getCardholercurrencycode().toString() + ";";
							}
							
							//Card Holder FX Rate
							if(responseCode.equals("0116") && onlineDoc.getCardholderfxrate() != null)
							{
								add_info = add_info + "F10=" + onlineDoc.getCardholderfxrate().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getCardholderfxrate().equals(""))
							{
								add_info = add_info + "F10=" + issService.getCardholderfxrate().toString() + ";";
							}
							
							//Service Code
							if(responseCode.equals("0116") && onlineDoc.getServicecode() != null)
							{
								add_info = add_info + "F22=" + onlineDoc.getServicecode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getServicecode().equals(""))
							{
								add_info = add_info + "F22=" + issService.getServicecode().toString() + ";";
							}
							
							//Service Condition Code
							if(responseCode.equals("0116") && onlineDoc.getServiceconditioncode() != null)
							{
								add_info = add_info + "F25=" + onlineDoc.getServiceconditioncode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getServiceconditioncode().equals(""))
							{
								add_info = add_info + "F25=" + issService.getServiceconditioncode().toString() + ";";
							}
							
							//Merchant Identification Code
							if(responseCode.equals("0116") && onlineDoc.getMerchantidentificationcode() != null)
							{
								add_info = add_info + "MID=" + onlineDoc.getMerchantidentificationcode().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getMerchantidentificationcode().equals(""))
							{
								add_info = add_info + "MID=" + issService.getMerchantidentificationcode().toString() + ";";
							}
							
							//Beneficiary Identify
							if(responseCode.equals("0116") && onlineDoc.getBeneficiaryidentify() != null)
							{
								add_info = add_info + "BNB=" + onlineDoc.getBeneficiaryidentify().trim() + ";";
							}
							else if(responseCode.equals("0117") && !issService.getBeneficiaryidentify().equals(""))
							{
								add_info = add_info + "BNB=" + issService.getBeneficiaryidentify().toString() + ";";
							}
							
							//Transaction Reference Number
							if(responseCode.equals("0116") && onlineDoc.getTransactionreferencenumber() != null)
							{
								add_info = add_info + "TRN=" + onlineDoc.getTransactionreferencenumber().substring(0,16).trim() + ";";
							}
							else if(responseCode.equals("0117") && !((issService.getTransactionreferencenumber() == null) ? "" : issService.getTransactionreferencenumber()).equals(""))
							{
								add_info = add_info + "TRN=" + issService.getTransactionreferencenumber().substring(0,16).toString() + ";";
							}
							
							//Retrieve Reference NUmber
							if(issService.getRetrievalreferencenumber() != null || !issService.getRetrievalreferencenumber().equals(""))																																	   
							{
								add_info = add_info + "RRN=" + issService.getRetrievalreferencenumber().toString() + ";";
							}
							
							
							disputeService.setAddInfo(add_info);
							
							disputeService.update();
						}
						catch (NullPointerException e){
							skipFile("issService is null. Stop");
						}
					}
				}
				else //ECOM
				{
					if(!issEcomService.dataNotFound())
					{
						try
						{
							processMessage("I'm in !issECOMService.dataNotFound()");
							processMessage("----------------------------------");
	
							String responseCodeEcom = checkNullValues(issService.getTransactionstatus(), 4, emptySpace);
							long docId = 0;
							String add_info = "";
							if(responseCodeEcom.equals("0116"))
							{
								docId = issEcomService.getId();
								getOnlineDoc(docId);
							}
							disputeService.setCardNumber(issEcomService.getCardNumber());
							disputeService.setProcessingCode(checkNullValues(issEcomService.getProcessingcode(),6,emptyZero));
							disputeService.setTransAmount(issEcomService.getTransamount().toString());
							disputeService.setSystemTraceNumber(checkNullValues(issEcomService.getSystemtracenumber(),6,emptyZero));
							disputeService.setTransTime(checkNullValues(issEcomService.getLocaltransactiontime(),6,emptyZero));						
							disputeService.setTransDate(checkNullValues(issEcomService.getLocaltransactiondate(),4,emptyZero));
							disputeService.setSettlDate(issEcomService.getSettlementdate());
							disputeService.setTerminalType(checkNullValues(issEcomService.getSiccode(),4,emptySpace));
							disputeService.setAcquiringMemberId(checkNullValues(issEcomService.getAcquiringinstitutioncode(),8,emptyZero));
							disputeService.setAuthCode(checkNullValues(issEcomService.getAuthorizationnumber(),6,emptyZero));
							disputeService.setTerminalId(checkNullValues(issEcomService.getTerminalidentification(),8,emptySpace));
							disputeService.setTransCurr(checkNullValues(issEcomService.getTransactioncurrencycode(),3,emptyZero));
							disputeService.setFromAccount(formatLeftPaddingZero(checkNullValues(issEcomService.getFromaccount(),20,emptyZero),20));
							disputeService.setToAccount(formatLeftPaddingZero(checkNullValues(issEcomService.getToaccount(),20,emptyZero),20));
							disputeService.setMessageCode(issEcomService.getMessagetypeidentifiercode());
							disputeService.setReturnCode(checkNullValues(issEcomService.getTransactionstatus(), 4, emptySpace));
							disputeService.setDirection("ISS");
							if (issEcomService.getTransactionstatus().equalsIgnoreCase("0116") ) // Co o ACB khong co o SML
							{
								disputeService.setDocOid(null);
							}
							else // Co o SML khong co o ACB thi set theo ID o bang OPT_SMLDOC
							{
								disputeService.setDocOid(issEcomService.getId());
							}
							
							if(issEcomService.getAcquiringinstitutioncode().equals("970416")){
								disputeService.setStatus("HOLD");
							}
							else{
								disputeService.setStatus("TO BE SENT");
							}
							
							disputeService.setTransDate2(issEcomService.getTransDate());
							disputeService.setNapasService(SERVICE);
							
							//Napas Service Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getNapassvccode() != null)
							{
								add_info = add_info + "F62=" + onlineDoc.getNapassvccode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !((issEcomService.getNapassvccode() == null) ? "" : issEcomService.getNapassvccode()).equals(""))
							{
								add_info = add_info + "F62=" + issEcomService.getNapassvccode().trim() + ";";
							}
							
							//Transaction Channel Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getTransactionchannelcode() != null)
							{
								add_info = add_info + "F60=" + onlineDoc.getTransactionchannelcode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !((issEcomService.getTransactionchannelcode() == null) ? "" : issEcomService.getTransactionchannelcode()).equals(""))
							{
								add_info = add_info + "F60=" + issEcomService.getTransactionchannelcode().trim() + ";";
							}
							
							//RTA
						     //add_info = add_info + "RTA=" + issEcomService.getRealtransactionamount().toString() + ";";
							// fixed add_info = add_info + "RTA=" + issEcomService.getRealtransactionamount().toString() + ";";
							if((responseCodeEcom.equals("0116")) && (issEcomService.getRealtransactionamount().toString()!=null))
							{
								add_info = add_info + "RTA=" + issEcomService.getRealtransactionamount().toString() + ";";
							}
							else if(responseCodeEcom.equals("0117"))
							{
								add_info = add_info + "RTA=000000000000;";
							}
						    //Settlement Amount
						    add_info = add_info + "F5=" + issEcomService.getSettlementamount().toString() + ";";
						    
						    //Settlement Currency Code
						    add_info = add_info + "F50=" + issEcomService.getSettlementcurrencycode().toString() + ";";
							
						    //FX Rate
							if(responseCodeEcom.equals("0116") && onlineDoc.getFxrate() != null)
							{
								add_info = add_info + "F9=" + onlineDoc.getFxrate().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getFxrate().equals(""))
							{
								add_info = add_info + "F9=" + issEcomService.getFxrate().toString() + ";";
							}
							
							//Card Holder Amount
							if(responseCodeEcom.equals("0116") && onlineDoc.getCardholderamount() != null)
							{
								add_info = add_info + "F6=" + onlineDoc.getCardholderamount().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getCardholderamount().equals(""))
							{
								add_info = add_info + "F6=" + issEcomService.getCardholderamount().toString() + ";";
							}
							
							//Real Card Holder Amount
							//add_info = add_info + "RCA=" + issEcomService.getRealcardholderamount().toString() + ";";
							if(responseCodeEcom.equals("0116") && issEcomService.getRealcardholderamount() != null)
							{
								add_info = add_info + "RCA=" + issEcomService.getRealcardholderamount().toString() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getRealcardholderamount().equals(""))
							{
								add_info = add_info + "RCA=000000000000;";
							}
							//Card Holder Currency Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getCardholercurrencycode() != null)
							{
								add_info = add_info + "F51=" + onlineDoc.getCardholercurrencycode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getCardholercurrencycode().equals(""))
							{
								add_info = add_info + "F51=" + issEcomService.getCardholercurrencycode().toString() + ";";
							}
							
							//Card Holder FX Rate
							if(responseCodeEcom.equals("0116") && onlineDoc.getCardholderfxrate() != null)
							{
								add_info = add_info + "F10=" + onlineDoc.getCardholderfxrate().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getCardholderfxrate().equals(""))
							{
								add_info = add_info + "F10=" + issEcomService.getCardholderfxrate().toString() + ";";
							}
							
							//Service Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getServicecode() != null)
							{
								add_info = add_info + "F22=" + onlineDoc.getServicecode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getServicecode().equals(""))
							{
								add_info = add_info + "F22=" + issEcomService.getServicecode().toString() + ";";
							}
							
							//Service Condition Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getServiceconditioncode() != null)
							{
								add_info = add_info + "F25=" + onlineDoc.getServiceconditioncode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getServiceconditioncode().equals(""))
							{
								add_info = add_info + "F25=" + issEcomService.getServiceconditioncode().toString() + ";";
							}
							
							//Merchant Identification Code
							if(responseCodeEcom.equals("0116") && onlineDoc.getMerchantidentificationcode() != null)
							{
								add_info = add_info + "MID=" + onlineDoc.getMerchantidentificationcode().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getMerchantidentificationcode().equals(""))
							{
								add_info = add_info + "MID=" + issEcomService.getMerchantidentificationcode().toString() + ";";
							}
							
							//Beneficiary Identify
							if(responseCodeEcom.equals("0116") && onlineDoc.getBeneficiaryidentify() != null)
							{
								add_info = add_info + "BNB=" + onlineDoc.getBeneficiaryidentify().trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !issEcomService.getBeneficiaryidentify().equals(""))
							{
								add_info = add_info + "BNB=" + issEcomService.getBeneficiaryidentify().toString() + ";";
							}
							
							//Transaction Reference Number
							if(responseCodeEcom.equals("0116") && onlineDoc.getTransactionreferencenumber() != null)
							{
								add_info = add_info + "TRN=" + onlineDoc.getTransactionreferencenumber().substring(0,16).trim() + ";";
							}
							else if(responseCodeEcom.equals("0117") && !((issEcomService.getTransactionreferencenumber() == null) ? "" : issEcomService.getTransactionreferencenumber()).equals(""))
							{
								add_info = add_info + "TRN=" + issEcomService.getTransactionreferencenumber().substring(0,16).toString() + ";";
							}
							
							//Retrieve Reference NUmber
							if(issEcomService.getRetrievalreferencenumber() != null || !issEcomService.getRetrievalreferencenumber().equals(""))																														   
							{
								add_info = add_info + "RRN=" + issEcomService.getRetrievalreferencenumber().toString() + ";";
							}
							
							disputeService.setAddInfo(add_info);

							disputeService.update();
						}
						catch (NullPointerException e){
							e.printStackTrace();
							skipFile("issEcomService is null. Stop: ");
						}
					}
				}
			}else
			{
				processMessage("Could not written Details Row");
				skipFile("Invalid File Type!");
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
		
		//processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		//throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
}