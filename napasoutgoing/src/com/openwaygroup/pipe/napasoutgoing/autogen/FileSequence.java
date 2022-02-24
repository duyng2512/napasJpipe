
package com.openwaygroup.pipe.napasoutgoing.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class FileSequence extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData PARMSMetaData = new VectorFieldMetaData("PARMS", IN);
    private   java.lang.String PARMS;
    
    public java.lang.String getPARMS() {
      return PARMS;
    }
    
      public void setPARMS(java.lang.String PARMS) {
        this.PARMS = PARMS;
      }
    
    private static final VectorFieldMetaData nextSeqMetaData = new VectorFieldMetaData("nextSeq", OUT);
    private   java.lang.Long nextSeq;
    
    public java.lang.Long getNextSeq() {
      return nextSeq;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(FileSequence.class, new VectorFieldMetaData[] {
         PARMSMetaData,
           nextSeqMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    nextSeq =  getLong(nextSeqMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
        set(PARMSMetaData, PARMS);
      
  }
}
