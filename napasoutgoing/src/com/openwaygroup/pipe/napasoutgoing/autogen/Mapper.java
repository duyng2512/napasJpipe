
package com.openwaygroup.pipe.napasoutgoing.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napasoutgoing.autogen.Source source;

  protected com.openwaygroup.pipe.napasoutgoing.autogen.OutWardFile outWardFile;

  protected com.openwaygroup.pipe.napasoutgoing.autogen.FileSequence fileSequence;

  protected com.openwaygroup.pipe.napasoutgoing.autogen.DisputeRecord disputeRecord;

  protected com.openwaygroup.pipe.napasoutgoing.autogen.GetTransLastDate getTransLastDate;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napasoutgoing.autogen.Source)getMandatoryService("source").getBuffer();
	outWardFile = (com.openwaygroup.pipe.napasoutgoing.autogen.OutWardFile)getMandatoryService("outWardFile").getBuffer();
	fileSequence = (com.openwaygroup.pipe.napasoutgoing.autogen.FileSequence)getMandatoryService("fileSequence").getBuffer();
	disputeRecord = (com.openwaygroup.pipe.napasoutgoing.autogen.DisputeRecord)getMandatoryService("disputeRecord").getBuffer();
	getTransLastDate = (com.openwaygroup.pipe.napasoutgoing.autogen.GetTransLastDate)getMandatoryService("getTransLastDate").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napasoutgoing.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napasoutgoing.autogen.OutWardFile getOutWardFile() throws Exception {
    if (!getMandatoryService("outWardFile").isOpened()) {
      getMandatoryService("outWardFile").open();
    }
  
    return outWardFile;
  }
  
  public com.openwaygroup.pipe.napasoutgoing.autogen.FileSequence getFileSequence() throws Exception {
    if (!getMandatoryService("fileSequence").isOpened()) {
      getMandatoryService("fileSequence").open();
    }
  
    return fileSequence;
  }
  
  public com.openwaygroup.pipe.napasoutgoing.autogen.DisputeRecord getDisputeRecord() throws Exception {
    if (!getMandatoryService("disputeRecord").isOpened()) {
      getMandatoryService("disputeRecord").open();
    }
  
    return disputeRecord;
  }
  
  public com.openwaygroup.pipe.napasoutgoing.autogen.GetTransLastDate getGetTransLastDate() throws Exception {
    if (!getMandatoryService("getTransLastDate").isOpened()) {
      getMandatoryService("getTransLastDate").open();
    }
  
    return getTransLastDate;
  }
  
  public static final String getSignature() {
    return "3426076571";
  }
}
	