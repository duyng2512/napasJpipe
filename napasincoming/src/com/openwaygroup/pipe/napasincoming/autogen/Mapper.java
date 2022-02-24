
package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napasincoming.autogen.Source source;

  protected com.openwaygroup.pipe.napasincoming.autogen.CheckOPTSMLDOC checkOPTSMLDOC;

  protected com.openwaygroup.pipe.napasincoming.autogen.UpdateOPTSMLDOC updateOPTSMLDOC;

  protected com.openwaygroup.pipe.napasincoming.autogen.GetTransID getTransID;

  protected com.openwaygroup.pipe.napasincoming.autogen.GetBankingDate getBankingDate;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napasincoming.autogen.Source)getMandatoryService("source").getBuffer();
	checkOPTSMLDOC = (com.openwaygroup.pipe.napasincoming.autogen.CheckOPTSMLDOC)getMandatoryService("checkOPTSMLDOC").getBuffer();
	updateOPTSMLDOC = (com.openwaygroup.pipe.napasincoming.autogen.UpdateOPTSMLDOC)getMandatoryService("updateOPTSMLDOC").getBuffer();
	getTransID = (com.openwaygroup.pipe.napasincoming.autogen.GetTransID)getMandatoryService("getTransID").getBuffer();
	getBankingDate = (com.openwaygroup.pipe.napasincoming.autogen.GetBankingDate)getMandatoryService("getBankingDate").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napasincoming.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napasincoming.autogen.CheckOPTSMLDOC getCheckOPTSMLDOC() throws Exception {
    if (!getMandatoryService("checkOPTSMLDOC").isOpened()) {
      getMandatoryService("checkOPTSMLDOC").open();
    }
  
    return checkOPTSMLDOC;
  }
  
  public com.openwaygroup.pipe.napasincoming.autogen.UpdateOPTSMLDOC getUpdateOPTSMLDOC() throws Exception {
    if (!getMandatoryService("updateOPTSMLDOC").isOpened()) {
      getMandatoryService("updateOPTSMLDOC").open();
    }
  
    return updateOPTSMLDOC;
  }
  
  public com.openwaygroup.pipe.napasincoming.autogen.GetTransID getGetTransID() throws Exception {
    if (!getMandatoryService("getTransID").isOpened()) {
      getMandatoryService("getTransID").open();
    }
  
    return getTransID;
  }
  
  public com.openwaygroup.pipe.napasincoming.autogen.GetBankingDate getGetBankingDate() throws Exception {
    if (!getMandatoryService("getBankingDate").isOpened()) {
      getMandatoryService("getBankingDate").open();
    }
  
    return getBankingDate;
  }
  
  public static final String getSignature() {
    return "364624749";
  }
}
	