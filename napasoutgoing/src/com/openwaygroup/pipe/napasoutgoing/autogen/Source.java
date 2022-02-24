
package com.openwaygroup.pipe.napasoutgoing.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class Source extends SelectSourceVectorBuffer
{

    private static final VectorFieldMetaData dummyMetaData = new VectorFieldMetaData("dummy", OUT);
    private   java.lang.String dummy;
    
    public java.lang.String getDummy() {
      return dummy;
    }
    
      public void setDummy(java.lang.String dummy) {
        this.dummy = dummy;
      }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(Source.class, new VectorFieldMetaData[] {
         dummyMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    dummy =  getString(dummyMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
  }
}
