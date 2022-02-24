package com.openwaygroup.pipe.napasimportecom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import com.openwaygroup.owsysdb.pipe.file.FileInfoParameters;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;
public class Mapper extends com.openwaygroup.pipe.napasimportecom.autogen.Mapper {
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
	protected String OUR_MEMBER_ID,SMARTLINK_CHANNEL_CODE,DIRECTION,unEncryptedWord,CHECK_CHECKSUM,BankPassword;
	protected ArrayList<String[]> MessageCodeMapping;
	protected String sProcessDate = "";
	protected String sFileDate = "";
	protected String sFileSource = "";
	protected String sFileTarget = "";
	protected String sFileName = "";
	protected Long count;
	
	//protected String BankPassword;
	//Array Sequence: Smartlink Transaction Name;MTID;SIC;ProcessingCode;Way4 Transaction Name;Message Code
	
 
  protected void open() throws Exception {
	  /* Getting Pipe Parameters
	   * Initializing variables
	   * */
	  count = 0l;
	  dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  decimalFormat =  new DecimalFormat("#.##");
	  validMessageCode=false;
	  MessageCodeMapping = new ArrayList<String[]>();
	  OUR_MEMBER_ID = Context.getMandatoryProperty(pipe.getContext(), "OUR_MEMBER_ID");
	  SMARTLINK_CHANNEL_CODE = Context.getMandatoryProperty(pipe.getContext(), "SMARTLINK_CHANNEL_CODE");
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
		if (source.isFormatError()){
			//Skip file if format error
			skipFile("File " + source.getFileName() + " skipped because format error." + source.getErrorFieldName()+"||"+ source.getErrorFieldValue() +"||"+ source.getErrorFieldName() );
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
				processMessage("Validation for " + source.getFileName()+ " is completed");
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
}