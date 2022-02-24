
package com.openwaygroup.pipe.reconciledacquiringposatm.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.reconciledacquiringposatm.autogen.Source source;

  protected com.openwaygroup.pipe.reconciledacquiringposatm.autogen.AcqService acqService;

  protected com.openwaygroup.pipe.reconciledacquiringposatm.autogen.DisputeService disputeService;

  protected com.openwaygroup.pipe.reconciledacquiringposatm.autogen.CheckOPTSMLDIS checkOPTSMLDIS;

  protected com.openwaygroup.pipe.reconciledacquiringposatm.autogen.OnlineDoc onlineDoc;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.reconciledacquiringposatm.autogen.Source)getMandatoryService("source").getBuffer();
	acqService = (com.openwaygroup.pipe.reconciledacquiringposatm.autogen.AcqService)getMandatoryService("acqService").getBuffer();
	disputeService = (com.openwaygroup.pipe.reconciledacquiringposatm.autogen.DisputeService)getMandatoryService("disputeService").getBuffer();
	checkOPTSMLDIS = (com.openwaygroup.pipe.reconciledacquiringposatm.autogen.CheckOPTSMLDIS)getMandatoryService("checkOPTSMLDIS").getBuffer();
	onlineDoc = (com.openwaygroup.pipe.reconciledacquiringposatm.autogen.OnlineDoc)getMandatoryService("onlineDoc").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.reconciledacquiringposatm.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.reconciledacquiringposatm.autogen.AcqService getAcqService() throws Exception {
    if (!getMandatoryService("acqService").isOpened()) {
      getMandatoryService("acqService").open();
    }
  
    return acqService;
  }
  
  public com.openwaygroup.pipe.reconciledacquiringposatm.autogen.DisputeService getDisputeService() throws Exception {
    if (!getMandatoryService("disputeService").isOpened()) {
      getMandatoryService("disputeService").open();
    }
  
    return disputeService;
  }
  
  public com.openwaygroup.pipe.reconciledacquiringposatm.autogen.CheckOPTSMLDIS getCheckOPTSMLDIS() throws Exception {
    if (!getMandatoryService("checkOPTSMLDIS").isOpened()) {
      getMandatoryService("checkOPTSMLDIS").open();
    }
  
    return checkOPTSMLDIS;
  }
  
  public com.openwaygroup.pipe.reconciledacquiringposatm.autogen.OnlineDoc getOnlineDoc() throws Exception {
    if (!getMandatoryService("onlineDoc").isOpened()) {
      getMandatoryService("onlineDoc").open();
    }
  
    return onlineDoc;
  }
  
  public static final String getSignature() {
    return "575922788";
  }
}
	