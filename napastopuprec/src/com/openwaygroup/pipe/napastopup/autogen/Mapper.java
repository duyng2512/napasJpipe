
package com.openwaygroup.pipe.napastopup.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napastopup.autogen.Source source;

  protected com.openwaygroup.pipe.napastopup.autogen.NewService newService;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napastopup.autogen.Source)getMandatoryService("source").getBuffer();
	newService = (com.openwaygroup.pipe.napastopup.autogen.NewService)getMandatoryService("newService").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napastopup.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public com.openwaygroup.pipe.napastopup.autogen.NewService getNewService() throws Exception {
    if (!getMandatoryService("newService").isOpened()) {
      getMandatoryService("newService").open();
    }
  
    return newService;
  }
  
  public static final String getSignature() {
    return "952397196";
  }
}
	