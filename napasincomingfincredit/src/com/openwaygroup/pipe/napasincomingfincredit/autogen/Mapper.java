
package com.openwaygroup.pipe.napasincomingfincredit.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napasincomingfincredit.autogen.Source source;

  protected com.openwaygroup.pipe.napasincomingfincredit.autogen.DocFileXml docFileXml;

  protected com.openwaygroup.pipe.napasincomingfincredit.autogen.FileSequence fileSequence;

  protected com.openwaygroup.pipe.napasincomingfincredit.autogen.IncomingFinCredit incomingFinCredit;

  protected com.openwaygroup.pipe.napasincomingfincredit.autogen.GetTransDetail getTransDetail;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napasincomingfincredit.autogen.Source)getMandatoryService("source").getBuffer();
	docFileXml = (com.openwaygroup.pipe.napasincomingfincredit.autogen.DocFileXml)getMandatoryService("docFileXml").getBuffer();
	fileSequence = (com.openwaygroup.pipe.napasincomingfincredit.autogen.FileSequence)getMandatoryService("fileSequence").getBuffer();
	incomingFinCredit = (com.openwaygroup.pipe.napasincomingfincredit.autogen.IncomingFinCredit)getMandatoryService("incomingFinCredit").getBuffer();
	getTransDetail = (com.openwaygroup.pipe.napasincomingfincredit.autogen.GetTransDetail)getMandatoryService("getTransDetail").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napasincomingfincredit.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napasincomingfincredit.autogen.DocFileXml getDocFileXml() throws Exception {
    if (!getMandatoryService("docFileXml").isOpened()) {
      getMandatoryService("docFileXml").open();
    }
  
    return docFileXml;
  }
  
  public com.openwaygroup.pipe.napasincomingfincredit.autogen.FileSequence getFileSequence() throws Exception {
    if (!getMandatoryService("fileSequence").isOpened()) {
      getMandatoryService("fileSequence").open();
    }
  
    return fileSequence;
  }
  
  public com.openwaygroup.pipe.napasincomingfincredit.autogen.IncomingFinCredit getIncomingFinCredit() throws Exception {
    if (!getMandatoryService("incomingFinCredit").isOpened()) {
      getMandatoryService("incomingFinCredit").open();
    }
  
    return incomingFinCredit;
  }
  
  public com.openwaygroup.pipe.napasincomingfincredit.autogen.GetTransDetail getGetTransDetail() throws Exception {
    if (!getMandatoryService("getTransDetail").isOpened()) {
      getMandatoryService("getTransDetail").open();
    }
  
    return getTransDetail;
  }
  
  public static final String getSignature() {
    return "1820299395";
  }
}
	