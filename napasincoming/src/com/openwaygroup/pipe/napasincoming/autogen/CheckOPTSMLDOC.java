
package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class CheckOPTSMLDOC extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData PROCESS_DATEMetaData = new VectorFieldMetaData("PROCESS_DATE", IN);
    private   java.lang.String PROCESS_DATE;
    
    public java.lang.String getPROCESS_DATE() {
      return PROCESS_DATE;
    }
    
      public void setPROCESS_DATE(java.lang.String PROCESS_DATE) {
        this.PROCESS_DATE = PROCESS_DATE;
      }
    
    private static final VectorFieldMetaData FILE_NAMEMetaData = new VectorFieldMetaData("FILE_NAME", IN);
    private   java.lang.String FILE_NAME;
    
    public java.lang.String getFILE_NAME() {
      return FILE_NAME;
    }
    
      public void setFILE_NAME(java.lang.String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
      }
    
    private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);
    private   java.lang.Long id;
    
    public java.lang.Long getId() {
      return id;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(CheckOPTSMLDOC.class, new VectorFieldMetaData[] {
         PROCESS_DATEMetaData,
           FILE_NAMEMetaData,
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
    
        set(PROCESS_DATEMetaData, PROCESS_DATE);
      
        set(FILE_NAMEMetaData, FILE_NAME);
      
  }
}
