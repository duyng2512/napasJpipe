
package com.openwaygroup.pipe.napasincomingfindebit.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napasincomingfindebit.autogen.Source source;

  protected com.openwaygroup.pipe.napasincomingfindebit.autogen.DocFileXml docFileXml;

  protected com.openwaygroup.pipe.napasincomingfindebit.autogen.FileSequence fileSequence;

  protected com.openwaygroup.pipe.napasincomingfindebit.autogen.IncomingFinDebit incomingFinDebit;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napasincomingfindebit.autogen.Source)getMandatoryService("source").getBuffer();
	docFileXml = (com.openwaygroup.pipe.napasincomingfindebit.autogen.DocFileXml)getMandatoryService("docFileXml").getBuffer();
	fileSequence = (com.openwaygroup.pipe.napasincomingfindebit.autogen.FileSequence)getMandatoryService("fileSequence").getBuffer();
	incomingFinDebit = (com.openwaygroup.pipe.napasincomingfindebit.autogen.IncomingFinDebit)getMandatoryService("incomingFinDebit").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napasincomingfindebit.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napasincomingfindebit.autogen.DocFileXml getDocFileXml() throws Exception {
    if (!getMandatoryService("docFileXml").isOpened()) {
      getMandatoryService("docFileXml").open();
    }
  
    return docFileXml;
  }
  
  public com.openwaygroup.pipe.napasincomingfindebit.autogen.FileSequence getFileSequence() throws Exception {
    if (!getMandatoryService("fileSequence").isOpened()) {
      getMandatoryService("fileSequence").open();
    }
  
    return fileSequence;
  }
  
  public com.openwaygroup.pipe.napasincomingfindebit.autogen.IncomingFinDebit getIncomingFinDebit() throws Exception {
    if (!getMandatoryService("incomingFinDebit").isOpened()) {
      getMandatoryService("incomingFinDebit").open();
    }
  
    return incomingFinDebit;
  }
  
  public static final String getSignature() {
    return "1435403898";
  }
}
	