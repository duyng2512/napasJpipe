
package com.openwaygroup.pipe.napastest.autogen;
import com.openwaygroup.application.pipe.impl.java_mapper.AbstractJavaMapper;

public abstract class Mapper extends AbstractJavaMapper {

  protected com.openwaygroup.pipe.napastest.autogen.Source source;
  

  protected Object getSourceCustomCalculationHandler() {return null;}
  public void resolve() throws Exception {
	source = (com.openwaygroup.pipe.napastest.autogen.Source)getMandatoryService("source").getBuffer();
	
    source.setCustomCalculationHandler(getSourceCustomCalculationHandler());
  }

  
  public com.openwaygroup.pipe.napastest.autogen.Source getSource() throws Exception {
    if (!getMandatoryService("source").isOpened()) {
      getMandatoryService("source").open();
    }
  
    return source;
  }
  
  public static final String getSignature() {
    return "1322301695";
  }
}
	