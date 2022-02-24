package com.openwaygroup.pipe.napasackupload;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.openwaygroup.application.pipe.ISourceCallback;
import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;

public class Mapper extends com.openwaygroup.pipe.napasackupload.autogen.Mapper {
	protected SimpleDateFormat dateFormat;
	protected Timestamp currDate = new Timestamp(System.currentTimeMillis());
	protected long dataCount;
	protected DecimalFormat decimalFormat;
	protected String DIRECTION, NAPAS_CHANNEL_CODE,MEMBER_BANK_CODE,DESCRIPTION,FILE_TYPE;
	protected ArrayList<String[]> MessageCodeMapping;
	protected String sProcessDate="";
	protected String creditType=""; //2 type: CREDIT or REVERSE
	
	/**
	 * This method will be called at the beginning of the pipe's execution, 
	 * before any data is retrieved by source. Add your opening code here.
	 */
	protected void open() throws Exception {
		MessageCodeMapping = new ArrayList<String[]>();
			//Reading ProcessingCode Mapping with Way4 MessageCode
		readMessageCodeMapping();
		NAPAS_CHANNEL_CODE = Context.getMandatoryProperty(pipe.getContext(), "NAPAS_CHANNEL_CODE");
		MEMBER_BANK_CODE = Context.getMandatoryProperty(pipe.getContext(), "MEMBER_BANK_CODE");
		DESCRIPTION = Context.getMandatoryProperty(pipe.getContext(),"DESCRIPTION");
		DIRECTION = Context.getMandatoryProperty(pipe.getContext(),"DIRECTION");
		FILE_TYPE = Context.getMandatoryProperty(pipe.getContext(), "FILE_TYPE");
		dataCount = 0;
		createXmlHeaderFile();
		if(DIRECTION.equals("ISS"))
		{
			issTransaction.select(new SQLGetOrder());
		}
	}

	/**
	 * This method will be called for each record (table row, record in flat file, xml element) retrieved 
	 * by the pipe's source. Add your code to handle incoming data here.
	 */
	protected void execute() throws Exception {
	}

	public class SQLGetOrder implements ISourceCallback{
		public void processRow() throws Exception {
			if(!issTransaction.dataNotFound()){
				try{
					docFileXml.addStartElement("Doc");
						docFileXml.addStartElement("TransType");
							docFileXml.addStartElement("TransCode");
							if(issTransaction.getRbsStatus().equals("REVERSE")){
								//Check transaction type
								if(checkTransTypeCode().equals("A1"))
									docFileXml.addElement("MsgCode","cash_atm_rev");
								else if(checkTransTypeCode().equals("R1"))
									docFileXml.addElement("MsgCode","purchase_rev");
								/*else if(checkTransTypeCode().equals("BQ"))
									docFileXml.addElement("MsgCode","04200B");*/
							}
							else if(issTransaction.getRbsStatus().equals("PARTIAL REVERSE")){
								//Check transaction type
								if(checkTransTypeCode().equals("A1"))
									docFileXml.addElement("MsgCode","cash_atm_adj");
								else if(checkTransTypeCode().equals("R1"))
									docFileXml.addElement("MsgCode","purchase_adj");
							}
							else if(issTransaction.getRbsStatus().equals("CREDIT"))
							{
								docFileXml.addElement("FinCategory",checkIS_AUTHORIZATION());
								docFileXml.addElement("RequestCategory",checkREQUEST_CATEGORY());
								docFileXml.addElement("ServiceClass","T");
								docFileXml.addElement("TransTypeCode","K1");
							}
							else //DEBIT
							{
								docFileXml.addElement("FinCategory",checkIS_AUTHORIZATION());
								docFileXml.addElement("RequestCategory",checkREQUEST_CATEGORY());
								docFileXml.addElement("ServiceClass","T");
								docFileXml.addElement("TransTypeCode",checkTransTypeCode());
							}
							
							docFileXml.addFinishElement("TransCode");
						docFileXml.addFinishElement("TransType");
						
						docFileXml.addStartElement("DocRefSet");
							docFileXml.addStartElement("Parm");
								docFileXml.addElement("ParmCode","AuthCode");
								docFileXml.addElement("Value",issTransaction.getAuthorizationnumber());
							docFileXml.addFinishElement("Parm");
						docFileXml.addFinishElement("DocRefSet");
						
						docFileXml.addElement("LocalDt", issTransaction.getLocaltransactiondate());
						//Them trans details cua Auth
						String trans_detail = getTransDetail(issTransaction.getId().toString());
						docFileXml.addElement("Description",DESCRIPTION + " " + trans_detail);						
						
						docFileXml.addStartElement("SourceDtls");
							docFileXml.addElement("SIC",issTransaction.getSiccode());
						docFileXml.addFinishElement("SourceDtls");
						
						docFileXml.addStartElement("Requestor");
							docFileXml.addElement("ContractNumber",issTransaction.getCardNumber());
							docFileXml.addElement("MemberId",MEMBER_BANK_CODE);
						docFileXml.addFinishElement("Requestor");
						
						docFileXml.addStartElement("Source");
							docFileXml.addElement("ContractNumber",issTransaction.getTerminalidentification());
							docFileXml.addElement("TransitId",issTransaction.getAcquiringinstitutioncode());
						docFileXml.addFinishElement("Source");
						
						docFileXml.addStartElement("Transaction");
							docFileXml.addStartElement("Currency");
								docFileXml.add(issTransaction.getTransactioncurrencycode().equals("000") ? "704" : issTransaction.getTransactioncurrencycode());
							docFileXml.addFinishElement("Currency");
							
							docFileXml.addElement("Amount",String.valueOf(issTransaction.getTransamount()));
							
							docFileXml.addStartElement("Extra");
								docFileXml.addElement("Type","AddInfo");
								
								docFileXml.addStartElement("AddData");
								//logging Additional data
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","ProcessingCode");
										docFileXml.addElement("Value",issTransaction.getProcessingcode());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","SystemTraceNumber");
										docFileXml.addElement("Value",issTransaction.getSystemtracenumber());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","AcquiringInstitutionCode");
										docFileXml.addElement("Value",issTransaction.getAcquiringinstitutioncode());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","SMLRespCode");
										docFileXml.addElement("Value",issTransaction.getReturnCode().toString());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","FromAccount");
										docFileXml.addElement("Value",issTransaction.getFromaccount());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","ToAccount");
										docFileXml.addElement("Value",issTransaction.getToaccount());										
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","RBSStatus");
										docFileXml.addElement("Value",issTransaction.getRbsStatus());	
									docFileXml.addFinishElement("Parm");
									
									//For ISS File, only proccess record with Return Code 0000 and 0111. else than that, set the posting status = P (only logging the transaction)
									//Other than that, log the file only
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","IssStatus");
										docFileXml.addElement("Value","P");
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","FIN_LC_POS");
										docFileXml.addElement("Value","Y");
									docFileXml.addFinishElement("Parm");
								docFileXml.addFinishElement("AddData");
								
							docFileXml.addFinishElement("Extra");
						docFileXml.addFinishElement("Transaction");
						
						docFileXml.addStartElement("Billing");
							docFileXml.addElement("Currency",issTransaction.getTransactioncurrencycode().equals("000") ? "704" : issTransaction.getTransactioncurrencycode());
							docFileXml.addElement("Amount", String.valueOf(issTransaction.getTransamount()));
						docFileXml.addFinishElement("Billing");
						
						docFileXml.addStartElement("Reconciliation");
							docFileXml.addElement("Currency",issTransaction.getTransactioncurrencycode().equals("000") ? "704" : issTransaction.getTransactioncurrencycode());
							docFileXml.addElement("Amount", String.valueOf(issTransaction.getTransamount()));
						docFileXml.addFinishElement("Reconciliation");
						
						docFileXml.addStartElement("Status");
							docFileXml.addElement("RespClass","Information");
							docFileXml.addElement("RespCode","0");							
							docFileXml.addElement("RespText","....");
						docFileXml.addFinishElement("Status");
					
					docFileXml.addFinishElement("Doc");
					dataCount++;
				}
				catch (NullPointerException e){
					processMessage("issTransaction is null. Stop");
				}
			}
		}

		private String getTransDetail(String id) {
			// TODO Auto-generated method stub
			try
			{
				getTransDetail.setSmldoc_id(id);
				getTransDetail.execute();
				return (getTransDetail.getTransDetails() == null) ? "" : getTransDetail.getTransDetails();
			}	
			catch (Exception ex)
			{
				processMessage("getTransDetail could not get auth trans details: " + id);				
				ex.printStackTrace();
				return "";
			}
		}
	}

	/**
	 * This method will be called at the end of the pipe's execution.
	 * Add your closing code here.
	 */
	protected void close() throws Exception {
		if(dataCount > 0){
			docFileXml.addFinishElement("DocList");
			docFileXml.addFinishElement("DocFile");
			docFileXml.update();
			docFileXml.close();
		}
		else
		{			
			docFileXml.addElement("Info","No Data found!");
			docFileXml.addFinishElement("DocList");
			docFileXml.addFinishElement("DocFile");
			docFileXml.update();
			docFileXml.close();
			skipFile("No matching data !!!");
		}
	}

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

	private void createXmlHeaderFile() throws Exception{
		
		// TODO Auto-generated method stub
		SimpleDateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat currentDate1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
		Calendar now = Calendar.getInstance();
		String strCurrentDate1 = currentDate1.format(now.getTime()).toString();
			
		fileSequence.execute();
		long fileNumber = fileSequence.getNextSeq();		
		docFileXml.getFileParameters().setFileName(strCurrentDate1 + "_" + "NAPAS_ACK" + "_" + fileNumber + ".xml");
		docFileXml.addStartElement("DocFile xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		docFileXml.addStartElement("FileHeader");
		docFileXml.addElement("FileLabel","NAPASDOCUMENT");
		docFileXml.addElement("FormatVersion", "2.0");
		docFileXml.addElement("Sender","NAPASDOCUMENT");
		docFileXml.addElement("CreationDate", currentDate.format(now.getTime()));
		docFileXml.addElement("CreationTime", currentTime.format(now.getTime()));
		docFileXml.addElement("FileSeqNumber",Long.toString(fileNumber));
		docFileXml.addElement("Receiver",MEMBER_BANK_CODE);
		docFileXml.addFinishElement("FileHeader");
		docFileXml.addStartElement("DocList");
	}
	
	protected String checkIS_AUTHORIZATION(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(issTransaction.getSiccode())){
				//this means ATM Transaction
				if(temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4))
							.equals(issTransaction.getProcessingcode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4)))
							.equals(issTransaction.getProcessingcode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+issTransaction.getSystemtracenumber()+"[AUTHCODE]:"+issTransaction.getAuthorizationnumber()+ "[ProcessingCode]:"+issTransaction.getProcessingcode()+"[SIC]:"+issTransaction.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	protected String checkREQUEST_CATEGORY(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(issTransaction.getSiccode())){
				//this means ATM Transaction
				if((temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4)))
							.equals(issTransaction.getProcessingcode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4)))
							.equals(issTransaction.getProcessingcode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+issTransaction.getSystemtracenumber()+"[AUTHCODE]:"+issTransaction.getAuthorizationnumber()+ "[ProcessingCode]:"+issTransaction.getProcessingcode()+"[SIC]:"+issTransaction.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	protected String checkTransTypeCode(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(issTransaction.getSiccode())){
				//this means ATM Transaction
				if((temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4)))
							.equals(issTransaction.getProcessingcode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", issTransaction.getProcessingcode().substring(2, 4)))
							.equals(issTransaction.getProcessingcode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+issTransaction.getSystemtracenumber()+"[AUTHCODE]:"+issTransaction.getAuthorizationnumber()+ "[ProcessingCode]:"+issTransaction.getProcessingcode()+"[SIC]:"+issTransaction.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
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
		msg = "[NAPAS ACK EXPORT]:"+msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters(
					"NAPAS ACK EXPORT", msg, boxType));
		}
	}
	
	protected void skipFile(String errText) throws FileSkipException
	{
		processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
}