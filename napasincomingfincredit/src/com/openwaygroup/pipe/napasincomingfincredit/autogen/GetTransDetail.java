
package com.openwaygroup.pipe.napasincomingfincredit.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class GetTransDetail extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData smldoc_idMetaData = new VectorFieldMetaData("smldoc_id", IN);
    private   java.lang.String smldoc_id;
    
    public java.lang.String getSmldoc_id() {
      return smldoc_id;
    }
    
      public void setSmldoc_id(java.lang.String smldoc_id) {
        this.smldoc_id = smldoc_id;
      }
    
    private static final VectorFieldMetaData transDetailsMetaData = new VectorFieldMetaData("transDetails", OUT);
    private   java.lang.String transDetails;
    
    public java.lang.String getTransDetails() {
      return transDetails;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(GetTransDetail.class, new VectorFieldMetaData[] {
         smldoc_idMetaData,
           transDetailsMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    transDetails =  getString(transDetailsMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
        set(smldoc_idMetaData, smldoc_id);
      
  }
}
