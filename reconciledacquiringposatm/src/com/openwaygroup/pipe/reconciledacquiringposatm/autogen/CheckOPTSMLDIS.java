
package com.openwaygroup.pipe.reconciledacquiringposatm.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class CheckOPTSMLDIS extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData PROCESS_DATEMetaData = new VectorFieldMetaData("PROCESS_DATE", IN);
    private   java.lang.String PROCESS_DATE;
    
    public java.lang.String getPROCESS_DATE() {
      return PROCESS_DATE;
    }
    
      public void setPROCESS_DATE(java.lang.String PROCESS_DATE) {
        this.PROCESS_DATE = PROCESS_DATE;
      }
    
    private static final VectorFieldMetaData DIRECTIONMetaData = new VectorFieldMetaData("DIRECTION", IN);
    private   java.lang.String DIRECTION;
    
    public java.lang.String getDIRECTION() {
      return DIRECTION;
    }
    
      public void setDIRECTION(java.lang.String DIRECTION) {
        this.DIRECTION = DIRECTION;
      }
    
    private static final VectorFieldMetaData SERVICEMetaData = new VectorFieldMetaData("SERVICE", IN);
    private   java.lang.String SERVICE;
    
    public java.lang.String getSERVICE() {
      return SERVICE;
    }
    
      public void setSERVICE(java.lang.String SERVICE) {
        this.SERVICE = SERVICE;
      }
    
    private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);
    private   java.lang.Long id;
    
    public java.lang.Long getId() {
      return id;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(CheckOPTSMLDIS.class, new VectorFieldMetaData[] {
         PROCESS_DATEMetaData,
           DIRECTIONMetaData,
           SERVICEMetaData,
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
      
        set(DIRECTIONMetaData, DIRECTION);
      
        set(SERVICEMetaData, SERVICE);
      
  }
}
