package com.openwaygroup.pipe.napastest;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.openwaygroup.application.pipe.impl.filer.source.FlatFileSourceBuffer;
import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;

public class Mapper extends com.openwaygroup.pipe.napastest.autogen.Mapper {

	protected SimpleDateFormat dateFormat;
	protected DecimalFormat decimalFormat;
	protected double totalSum, tempAmount;
	protected Calendar tempCalendar;
	protected int tempYear;
	protected boolean validMessageCode;
	protected String OUR_MEMBER_ID, NAPAS_CHANNEL_CODE, DIRECTION,
			unEncryptedWord, CHECK_CHECKSUM, BankPassword;
	protected ArrayList<String[]> MessageCodeMapping;
	protected String sProcessDate = "";
	protected String sFileDate = "";
	protected String sFileType = ""; // TC,SL,XL
	protected String sFileService = "";
	protected String sFileTarget = "";
	protected String sFileName = "";
	protected String RRN = "";

	private PRLogRecord record = new PRLogRecord();
	
	/**
	 * This method will be called at the beginning of the pipe's execution,
	 * before any data is retrieved by source. Add your opening code here.
	 */
	protected void open() throws Exception {

		record.setMessageText("Starting [OPEN] com.openwaygroup.pipe.napastest "
							+ new Date().toString());
		pipe.log(record);

		/*
		 * Getting Pipe Parameters Initializing variables
		 */
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		decimalFormat = new DecimalFormat("#.##");
		validMessageCode = false;
		MessageCodeMapping = new ArrayList<String[]>();
		OUR_MEMBER_ID = Context.getMandatoryProperty(pipe.getContext(),
				"OUR_MEMBER_ID");
		NAPAS_CHANNEL_CODE = Context.getMandatoryProperty(pipe.getContext(),
				"NAPAS_CHANNEL_CODE");
		DIRECTION = Context
				.getMandatoryProperty(pipe.getContext(), "DIRECTION");
		CHECK_CHECKSUM = Context.getMandatoryProperty(pipe.getContext(),
				"CHECK_CHECKSUM");
		BankPassword = Context.getMandatoryProperty(pipe.getContext(),
				"BANK_PASSWORD");

		record.setMessageText("OUR_MEMBER_ID [" + OUR_MEMBER_ID + "]");
		pipe.log(record);
	}

	/**
	 * This method will be called for each record (table row, record in flat
	 * file, xml element) retrieved by the pipe's source. Add your code to
	 * handle incoming data here.
	 */
	protected void execute() throws Exception {
		record.setMessageText("Starting [EXECUTE] com.openwaygroup.pipe.napastest "
				+ new Date().toString());
		pipe.log(record);
		if (source.isFirstPassage()) {
			if (source.isFormatError()) {
				String errStr;
				try {
					errStr = String.format("File [%s] skipped | err [%d] | field length [%d] [%d]" , 
							source.getFileName(), 
							source.getErrorFieldName().trim(), 
							source.getErrorFieldValue().length(), 
							FlatFileSourceBuffer.ERROR_TEST.toString());
				} catch(NullPointerException ex) {
					errStr = String.format("File [%s] skipped | err [%s]" , 
											source.getFileName(), 
											source.getErrorFieldName().trim());
				}
				skipFile(errStr);
			}
		}
	}

	/**
	 * This method will be called at the end of the pipe's execution. Add your
	 * closing code here.
	 */
	protected void close() throws Exception {
	}

	
	/**
	 * 
	 * LOGGING UTILS
	 * 
	 */
	
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
		msg = "[NapasImport]:" + msg;
		ProcessLogRecord logRecord = new ProcessLogRecord(type, msg, docId);

		try {
			pipe.log(logRecord);
		} catch (Exception e) {
			pipe.cancel();
		}

		if (isMsgBox) {
			pipe.showMessageDialog(new ShowDialogParameters("NapasImport", msg,
					boxType));
		}
	}

	protected void skipFile(String errText) throws FileSkipException {
		processMessage(PRLogRecord.ERROR, errText, true,
				ShowDialogParameters.ERROR_MESSAGE, null);
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