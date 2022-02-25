package com.openwaygroup.pipe.napastopup;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.openwaygroup.application.pipe.impl.stream.FileSkipException;
import com.openwaygroup.application.pipe.impl.stream.IWrappedInputStream;
import com.openwaygroup.application.process.registry.PRLogRecord;
import com.openwaygroup.application.server.ui.ShowDialogParameters;
import com.openwaygroup.context.Context;
import com.openwaygroup.owsysdb.process.registry.processlog.ProcessLogRecord;
import com.openwaygroup.xmlmanager.metadata.EntitiesRegistry_Sy.Calendar;

public class Mapper extends com.openwaygroup.pipe.napastopup.autogen.Mapper {

	

	/**
	 * This method will be called at the beginning of the pipe's execution,
	 * before any data is retrieved by source. Add your opening code here.
	 */
	protected void open() throws Exception {
	}

	/**
	 * This method will be called for each record (table row, record in flat
	 * file, xml element) retrieved by the pipe's source. Add your code to
	 * handle incoming data here.
	 */
	protected void execute() throws Exception {
	}

	/**
	 * This method will be called at the end of the pipe's execution. Add your
	 * closing code here.
	 */
	protected void close() throws Exception {
	}

	
}