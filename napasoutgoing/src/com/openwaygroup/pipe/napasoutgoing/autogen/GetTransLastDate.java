
package com.openwaygroup.pipe.napasoutgoing.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class GetTransLastDate extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData maxDateMetaData = new VectorFieldMetaData("maxDate", OUT);
    private   java.lang.String maxDate;
    
    public java.lang.String getMaxDate() {
      return maxDate;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(GetTransLastDate.class, new VectorFieldMetaData[] {
         maxDateMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    maxDate =  getString(maxDateMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
  }
}
