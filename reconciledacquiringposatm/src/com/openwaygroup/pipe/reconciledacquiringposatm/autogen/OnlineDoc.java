
package com.openwaygroup.pipe.reconciledacquiringposatm.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class OnlineDoc extends SelectTargetVectorBuffer
{

    private static final VectorFieldMetaData DOC_IDMetaData = new VectorFieldMetaData("DOC_ID", IN);
    private   java.lang.Long DOC_ID;
    
    public java.lang.Long getDOC_ID() {
      return DOC_ID;
    }
    
      public void setDOC_ID(java.lang.Long DOC_ID) {
        this.DOC_ID = DOC_ID;
      }
    
    private static final VectorFieldMetaData intKeyMetaData = new VectorFieldMetaData("intKey", OUT);
    private   java.lang.String intKey;
    
    public java.lang.String getIntKey() {
      return intKey;
    }
    
    private static final VectorFieldMetaData napassvccodeMetaData = new VectorFieldMetaData("napassvccode", OUT);
    private   java.lang.String napassvccode;
    
    public java.lang.String getNapassvccode() {
      return napassvccode;
    }
    
    private static final VectorFieldMetaData transactionchannelcodeMetaData = new VectorFieldMetaData("transactionchannelcode", OUT);
    private   java.lang.String transactionchannelcode;
    
    public java.lang.String getTransactionchannelcode() {
      return transactionchannelcode;
    }
    
    private static final VectorFieldMetaData fxrateMetaData = new VectorFieldMetaData("fxrate", OUT);
    private   java.lang.String fxrate;
    
    public java.lang.String getFxrate() {
      return fxrate;
    }
    
    private static final VectorFieldMetaData cardholderamountMetaData = new VectorFieldMetaData("cardholderamount", OUT);
    private   java.lang.String cardholderamount;
    
    public java.lang.String getCardholderamount() {
      return cardholderamount;
    }
    
    private static final VectorFieldMetaData cardholercurrencycodeMetaData = new VectorFieldMetaData("cardholercurrencycode", OUT);
    private   java.lang.String cardholercurrencycode;
    
    public java.lang.String getCardholercurrencycode() {
      return cardholercurrencycode;
    }
    
    private static final VectorFieldMetaData cardholderfxrateMetaData = new VectorFieldMetaData("cardholderfxrate", OUT);
    private   java.lang.String cardholderfxrate;
    
    public java.lang.String getCardholderfxrate() {
      return cardholderfxrate;
    }
    
    private static final VectorFieldMetaData servicecodeMetaData = new VectorFieldMetaData("servicecode", OUT);
    private   java.lang.String servicecode;
    
    public java.lang.String getServicecode() {
      return servicecode;
    }
    
    private static final VectorFieldMetaData serviceconditioncodeMetaData = new VectorFieldMetaData("serviceconditioncode", OUT);
    private   java.lang.String serviceconditioncode;
    
    public java.lang.String getServiceconditioncode() {
      return serviceconditioncode;
    }
    
    private static final VectorFieldMetaData merchantidentificationcodeMetaData = new VectorFieldMetaData("merchantidentificationcode", OUT);
    private   java.lang.String merchantidentificationcode;
    
    public java.lang.String getMerchantidentificationcode() {
      return merchantidentificationcode;
    }
    
    private static final VectorFieldMetaData beneficiaryidentifyMetaData = new VectorFieldMetaData("beneficiaryidentify", OUT);
    private   java.lang.String beneficiaryidentify;
    
    public java.lang.String getBeneficiaryidentify() {
      return beneficiaryidentify;
    }
    
    private static final VectorFieldMetaData transactionreferencenumberMetaData = new VectorFieldMetaData("transactionreferencenumber", OUT);
    private   java.lang.String transactionreferencenumber;
    
    public java.lang.String getTransactionreferencenumber() {
      return transactionreferencenumber;
    }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(OnlineDoc.class, new VectorFieldMetaData[] {
         DOC_IDMetaData,
           intKeyMetaData,
         napassvccodeMetaData,
         transactionchannelcodeMetaData,
         fxrateMetaData,
         cardholderamountMetaData,
         cardholercurrencycodeMetaData,
         cardholderfxrateMetaData,
         servicecodeMetaData,
         serviceconditioncodeMetaData,
         merchantidentificationcodeMetaData,
         beneficiaryidentifyMetaData,
         transactionreferencenumberMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    intKey =  getString(intKeyMetaData);
            napassvccode =  getString(napassvccodeMetaData);
            transactionchannelcode =  getString(transactionchannelcodeMetaData);
            fxrate =  getString(fxrateMetaData);
            cardholderamount =  getString(cardholderamountMetaData);
            cardholercurrencycode =  getString(cardholercurrencycodeMetaData);
            cardholderfxrate =  getString(cardholderfxrateMetaData);
            servicecode =  getString(servicecodeMetaData);
            serviceconditioncode =  getString(serviceconditioncodeMetaData);
            merchantidentificationcode =  getString(merchantidentificationcodeMetaData);
            beneficiaryidentify =  getString(beneficiaryidentifyMetaData);
            transactionreferencenumber =  getString(transactionreferencenumberMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
        set(DOC_IDMetaData, DOC_ID);
      
  }
}
