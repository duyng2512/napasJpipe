package com.openwaygroup.pipe.napasincomingfincredit;

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

public class Mapper extends com.openwaygroup.pipe.napasincomingfincredit.autogen.Mapper {
	protected SimpleDateFormat dateFormat;
	protected Timestamp currDate = new Timestamp(System.currentTimeMillis());
	protected long dataCount;
	protected DecimalFormat decimalFormat;
	protected String FILE_TYPE, NAPAS_CHANNEL_CODE,MEMBER_BANK_CODE,DESCRIPTION;
	protected ArrayList<String[]> MessageCodeMapping;
	protected String sProcessDate="";
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
		
		dataCount = 0;
		createXmlHeaderFile();
		incomingFinCredit.select(new SQLGetOrder());
	}

	public class SQLGetOrder implements ISourceCallback{
		public void processRow() throws Exception {
			if(!incomingFinCredit.dataNotFound()){
				try{
					docFileXml.addStartElement("Doc");
						docFileXml.addStartElement("TransType");
							docFileXml.addStartElement("TransCode");
							docFileXml.addElement("FinCategory",checkIS_AUTHORIZATION());
							docFileXml.addElement("RequestCategory",checkREQUEST_CATEGORY());
							docFileXml.addElement("ServiceClass","T");
							docFileXml.addElement("TransTypeCode",checkTransTypeCode());
							docFileXml.addFinishElement("TransCode");
						docFileXml.addFinishElement("TransType");
						
						docFileXml.addStartElement("DocRefSet");
							docFileXml.addStartElement("Parm");
								docFileXml.addElement("ParmCode","AuthCode");
								docFileXml.addElement("Value",incomingFinCredit.getAuthorizationnumber());
							docFileXml.addFinishElement("Parm");
						docFileXml.addFinishElement("DocRefSet");
						
						docFileXml.addElement("LocalDt", incomingFinCredit.getLocaltransactiondate());
						//Them trans details cua Auth
						String trans_detail = getTransDetail(incomingFinCredit.getId().toString());
						docFileXml.addElement("Description",DESCRIPTION + " " + trans_detail);
						
						docFileXml.addStartElement("SourceDtls");
							docFileXml.addElement("SIC",incomingFinCredit.getSiccode());
						docFileXml.addFinishElement("SourceDtls");
						
						docFileXml.addStartElement("Requestor");
							docFileXml.addElement("ContractNumber",incomingFinCredit.getCardNumber());
							docFileXml.addElement("MemberId",MEMBER_BANK_CODE);
							docFileXml.addStartElement("Product");
								docFileXml.addElement("Channel",NAPAS_CHANNEL_CODE);
							docFileXml.addFinishElement("Product");
						docFileXml.addFinishElement("Requestor");
						
						docFileXml.addStartElement("Source");
							docFileXml.addElement("ContractNumber",incomingFinCredit.getTerminalidentification());
							docFileXml.addElement("TransitId",incomingFinCredit.getAcquiringinstitutioncode());
							docFileXml.addStartElement("Product");
								docFileXml.addElement("Channel","O");
							docFileXml.addFinishElement("Product");
						docFileXml.addFinishElement("Source");
						
						docFileXml.addStartElement("Transaction");
							docFileXml.addStartElement("Currency");
								docFileXml.add(incomingFinCredit.getTransactioncurrencycode().equals("000") ? "704" : incomingFinCredit.getTransactioncurrencycode());
							docFileXml.addFinishElement("Currency");
							
							docFileXml.addElement("Amount",String.valueOf(incomingFinCredit.getTransamount()));
							
							docFileXml.addStartElement("Extra");
								docFileXml.addElement("Type","AddInfo");
								
								docFileXml.addStartElement("AddData");
								//logging Additional data
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","ProcessingCode");
										docFileXml.addElement("Value",incomingFinCredit.getProcessingcode());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","SystemTraceNumber");
										docFileXml.addElement("Value",incomingFinCredit.getSystemtracenumber());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","F15");
										docFileXml.addElement("Value",incomingFinCredit.getSettlementdate());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","AcquiringInstitutionCode");
										docFileXml.addElement("Value",incomingFinCredit.getAcquiringinstitutioncode());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","SMLRespCode");
										docFileXml.addElement("Value",incomingFinCredit.getReturnCode().toString());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","FromAccount");
										docFileXml.addElement("Value",incomingFinCredit.getFromaccount());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","ToAccount");
										docFileXml.addElement("Value",incomingFinCredit.getToaccount());
									docFileXml.addFinishElement("Parm");
									
									docFileXml.addStartElement("Parm");
										docFileXml.addElement("ParmCode","RBSStatus");
										docFileXml.addElement("Value","DEBIT");
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
							docFileXml.addElement("Currency",incomingFinCredit.getTransactioncurrencycode().equals("000") ? "704" : incomingFinCredit.getTransactioncurrencycode());
							docFileXml.addElement("Amount", String.valueOf(incomingFinCredit.getTransamount()));
						docFileXml.addFinishElement("Billing");
						
						docFileXml.addStartElement("Reconciliation");
							docFileXml.addElement("Currency",incomingFinCredit.getTransactioncurrencycode().equals("000") ? "704" : incomingFinCredit.getTransactioncurrencycode());
							docFileXml.addElement("Amount", String.valueOf(incomingFinCredit.getTransamount()));
						docFileXml.addFinishElement("Reconciliation");
						
						docFileXml.addStartElement("Status");
							docFileXml.addElement("RespClass",incomingFinCredit.getReturnCode() == 0 ? "Information" : "Error");
							docFileXml.addElement("RespCode",incomingFinCredit.getReturnCode().toString());
							docFileXml.addElement("RespText","....");
						docFileXml.addFinishElement("Status");
					
					docFileXml.addFinishElement("Doc");
					dataCount++;
				}
				catch (NullPointerException e){
					processMessage("incomingFinCredit is null. Stop");
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
		if(dataCount > 0){
			docFileXml.addFinishElement("DocList");
			docFileXml.addFinishElement("DocFile");
			docFileXml.update();
			docFileXml.close();
			processMessage("Export file success");
		}
		else
		{			
			docFileXml.addElement("Info","No Data found!");
			docFileXml.addFinishElement("DocList");
			docFileXml.addFinishElement("DocFile");
			docFileXml.update();
			docFileXml.close();
			skipFile("No transaction data !!!");
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
		docFileXml.getFileParameters().setFileName(strCurrentDate1 + "_" + "NAPAS_INCOMING_CREDIT" + "_" + fileNumber + ".xml");
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
			
			if(temp[2].equals(incomingFinCredit.getSiccode())){
				//this means ATM Transaction
				if(temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4)))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					// IS_AUTHORIZATION - Pos_7
					return temp[7];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+incomingFinCredit.getSystemtracenumber()+"[AUTHCODE]:"+incomingFinCredit.getAuthorizationnumber()+ "[ProcessingCode]:"+incomingFinCredit.getProcessingcode()+"[SIC]:"+incomingFinCredit.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	protected String checkREQUEST_CATEGORY(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(incomingFinCredit.getSiccode())){
				//this means ATM Transaction
				if((temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4)))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4)))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					//REQUEST_CATEGORY - Pos_8
					return temp[8];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+incomingFinCredit.getSystemtracenumber()+"[AUTHCODE]:"+incomingFinCredit.getAuthorizationnumber()+ "[ProcessingCode]:"+incomingFinCredit.getProcessingcode()+"[SIC]:"+incomingFinCredit.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	protected String checkTransTypeCode(){
		//If return code is 0000, read message code mapping
		for(String[] temp : MessageCodeMapping){
			
			if(temp[2].equals(incomingFinCredit.getSiccode())){
				//this means ATM Transaction
				if((temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4)))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}else{
				//SIC = Other than 6011
				 
				if((temp[3].replace("xx", incomingFinCredit.getProcessingcode().substring(2, 4)))
							.equals(incomingFinCredit.getProcessingcode()))
				{
					//processMessage("Message Code Found! : "+temp[5]);
					return temp[6];
				}
			}
		}
		try {
			skipFile("Transaction ID Not Found![STAN]:"+incomingFinCredit.getSystemtracenumber()+"[AUTHCODE]:"+incomingFinCredit.getAuthorizationnumber()+ "[ProcessingCode]:"+incomingFinCredit.getProcessingcode()+"[SIC]:"+incomingFinCredit.getSiccode());
		} catch (FileSkipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/* Log to Trace
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
		msg = "[Napas Incoming Fin Credit]:"+msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters(
					"Napas Incoming Fin Credit", msg, boxType));
		}
	}
	
	protected void skipFile(String errText) throws FileSkipException
	{
		processMessage(PRLogRecord.ERROR, errText, true, ShowDialogParameters.ERROR_MESSAGE, null);
		throw new FileSkipException(IWrappedInputStream.CLOSE_ACTION_REJECT);
	}
}