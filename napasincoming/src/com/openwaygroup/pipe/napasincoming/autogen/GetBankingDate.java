
package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class GetBankingDate extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData bankingDateMetaData = new VectorFieldMetaData("bankingDate", OUT);
    private   java.lang.String bankingDate;
    
    public java.lang.String getBankingDate() {
      return bankingDate;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(GetBankingDate.class, new VectorFieldMetaData[] {
         bankingDateMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    bankingDate =  getString(bankingDateMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
  }
}
