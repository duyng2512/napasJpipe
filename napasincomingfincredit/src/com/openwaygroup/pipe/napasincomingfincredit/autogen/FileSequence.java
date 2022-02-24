
package com.openwaygroup.pipe.napasincomingfincredit.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class FileSequence extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData nextSeqMetaData = new VectorFieldMetaData("nextSeq", OUT);
    private   java.lang.Long nextSeq;
    
    public java.lang.Long getNextSeq() {
      return nextSeq;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(FileSequence.class, new VectorFieldMetaData[] {
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
    
  }
}
