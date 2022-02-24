
package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class GetTransID extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData TRANS_CODEMetaData = new VectorFieldMetaData("TRANS_CODE", IN);
    private   java.lang.String TRANS_CODE;
    
    public java.lang.String getTRANS_CODE() {
      return TRANS_CODE;
    }
    
      public void setTRANS_CODE(java.lang.String TRANS_CODE) {
        this.TRANS_CODE = TRANS_CODE;
      }
    
    private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);
    private   java.lang.Long id;
    
    public java.lang.Long getId() {
      return id;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(GetTransID.class, new VectorFieldMetaData[] {
         TRANS_CODEMetaData,
           idMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    id =  getLong(idMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
        set(TRANS_CODEMetaData, TRANS_CODE);
      
  }
}
