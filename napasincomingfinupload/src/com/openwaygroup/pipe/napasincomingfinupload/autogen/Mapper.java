
package com.openwaygroup.pipe.napasincomingfinupload.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napasincomingfinupload.autogen.Source source;

  protected com.openwaygroup.pipe.napasincomingfinupload.autogen.DocFileXml docFileXml;

  protected com.openwaygroup.pipe.napasincomingfinupload.autogen.FileSequence fileSequence;

  protected com.openwaygroup.pipe.napasincomingfinupload.autogen.IncomingFin incomingFin;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napasincomingfinupload.autogen.Source)getMandatoryService("source").getBuffer();
	docFileXml = (com.openwaygroup.pipe.napasincomingfinupload.autogen.DocFileXml)getMandatoryService("docFileXml").getBuffer();
	fileSequence = (com.openwaygroup.pipe.napasincomingfinupload.autogen.FileSequence)getMandatoryService("fileSequence").getBuffer();
	incomingFin = (com.openwaygroup.pipe.napasincomingfinupload.autogen.IncomingFin)getMandatoryService("incomingFin").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napasincomingfinupload.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napasincomingfinupload.autogen.DocFileXml getDocFileXml() throws Exception {
    if (!getMandatoryService("docFileXml").isOpened()) {
      getMandatoryService("docFileXml").open();
    }
  
    return docFileXml;
  }
  
  public com.openwaygroup.pipe.napasincomingfinupload.autogen.FileSequence getFileSequence() throws Exception {
    if (!getMandatoryService("fileSequence").isOpened()) {
      getMandatoryService("fileSequence").open();
    }
  
    return fileSequence;
  }
  
  public com.openwaygroup.pipe.napasincomingfinupload.autogen.IncomingFin getIncomingFin() throws Exception {
    if (!getMandatoryService("incomingFin").isOpened()) {
      getMandatoryService("incomingFin").open();
    }
  
    return incomingFin;
  }
  
  public static final String getSignature() {
    return "1542855701";
  }
}
	