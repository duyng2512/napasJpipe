
package com.openwaygroup.pipe.napasincomingfinupload.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class IncomingFin extends SelectSourceVectorBuffer
{

    private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);
    private   java.lang.Long id;
    
    public java.lang.Long getId() {
      return id;
    }
    
      public void setId(java.lang.Long id) {
        this.id = id;
      }
    
    private static final VectorFieldMetaData cardNumberMetaData = new VectorFieldMetaData("cardNumber", OUT);
    private   java.lang.String cardNumber;
    
    public java.lang.String getCardNumber() {
      return cardNumber;
    }
    
      public void setCardNumber(java.lang.String cardNumber) {
        this.cardNumber = cardNumber;
      }
    
    private static final VectorFieldMetaData processingcodeMetaData = new VectorFieldMetaData("processingcode", OUT);
    private   java.lang.String processingcode;
    
    public java.lang.String getProcessingcode() {
      return processingcode;
    }
    
      public void setProcessingcode(java.lang.String processingcode) {
        this.processingcode = processingcode;
      }
    
    private static final VectorFieldMetaData transamountMetaData = new VectorFieldMetaData("transamount", OUT);
    private   java.math.BigDecimal transamount;
    
    public java.math.BigDecimal getTransamount() {
      return transamount;
    }
    
      public void setTransamount(java.math.BigDecimal transamount) {
        this.transamount = transamount;
      }
    
    private static final VectorFieldMetaData systemtracenumberMetaData = new VectorFieldMetaData("systemtracenumber", OUT);
    private   java.lang.String systemtracenumber;
    
    public java.lang.String getSystemtracenumber() {
      return systemtracenumber;
    }
    
      public void setSystemtracenumber(java.lang.String systemtracenumber) {
        this.systemtracenumber = systemtracenumber;
      }
    
    private static final VectorFieldMetaData localtransactiondateMetaData = new VectorFieldMetaData("localtransactiondate", OUT);
    private   java.lang.String localtransactiondate;
    
    public java.lang.String getLocaltransactiondate() {
      return localtransactiondate;
    }
    
      public void setLocaltransactiondate(java.lang.String localtransactiondate) {
        this.localtransactiondate = localtransactiondate;
      }
    
    private static final VectorFieldMetaData settlementdateMetaData = new VectorFieldMetaData("settlementdate", OUT);
    private   java.lang.String settlementdate;
    
    public java.lang.String getSettlementdate() {
      return settlementdate;
    }
    
      public void setSettlementdate(java.lang.String settlementdate) {
        this.settlementdate = settlementdate;
      }
    
    private static final VectorFieldMetaData siccodeMetaData = new VectorFieldMetaData("siccode", OUT);
    private   java.lang.String siccode;
    
    public java.lang.String getSiccode() {
      return siccode;
    }
    
      public void setSiccode(java.lang.String siccode) {
        this.siccode = siccode;
      }
    
    private static final VectorFieldMetaData acquiringinstitutioncodeMetaData = new VectorFieldMetaData("acquiringinstitutioncode", OUT);
    private   java.lang.String acquiringinstitutioncode;
    
    public java.lang.String getAcquiringinstitutioncode() {
      return acquiringinstitutioncode;
    }
    
      public void setAcquiringinstitutioncode(java.lang.String acquiringinstitutioncode) {
        this.acquiringinstitutioncode = acquiringinstitutioncode;
      }
    
    private static final VectorFieldMetaData issuerbankcodeMetaData = new VectorFieldMetaData("issuerbankcode", OUT);
    private   java.lang.String issuerbankcode;
    
    public java.lang.String getIssuerbankcode() {
      return issuerbankcode;
    }
    
      public void setIssuerbankcode(java.lang.String issuerbankcode) {
        this.issuerbankcode = issuerbankcode;
      }
    
    private static final VectorFieldMetaData authorizationnumberMetaData = new VectorFieldMetaData("authorizationnumber", OUT);
    private   java.lang.String authorizationnumber;
    
    public java.lang.String getAuthorizationnumber() {
      return authorizationnumber;
    }
    
      public void setAuthorizationnumber(java.lang.String authorizationnumber) {
        this.authorizationnumber = authorizationnumber;
      }
    
    private static final VectorFieldMetaData retrievalreferencenumberMetaData = new VectorFieldMetaData("retrievalreferencenumber", OUT);
    private   java.lang.String retrievalreferencenumber;
    
    public java.lang.String getRetrievalreferencenumber() {
      return retrievalreferencenumber;
    }
    
      public void setRetrievalreferencenumber(java.lang.String retrievalreferencenumber) {
        this.retrievalreferencenumber = retrievalreferencenumber;
      }
    
    private static final VectorFieldMetaData terminalidentificationMetaData = new VectorFieldMetaData("terminalidentification", OUT);
    private   java.lang.String terminalidentification;
    
    public java.lang.String getTerminalidentification() {
      return terminalidentification;
    }
    
      public void setTerminalidentification(java.lang.String terminalidentification) {
        this.terminalidentification = terminalidentification;
      }
    
    private static final VectorFieldMetaData transactioncurrencycodeMetaData = new VectorFieldMetaData("transactioncurrencycode", OUT);
    private   java.lang.String transactioncurrencycode;
    
    public java.lang.String getTransactioncurrencycode() {
      return transactioncurrencycode;
    }
    
      public void setTransactioncurrencycode(java.lang.String transactioncurrencycode) {
        this.transactioncurrencycode = transactioncurrencycode;
      }
    
    private static final VectorFieldMetaData fromaccountMetaData = new VectorFieldMetaData("fromaccount", OUT);
    private   java.lang.String fromaccount;
    
    public java.lang.String getFromaccount() {
      return fromaccount;
    }
    
      public void setFromaccount(java.lang.String fromaccount) {
        this.fromaccount = fromaccount;
      }
    
    private static final VectorFieldMetaData toaccountMetaData = new VectorFieldMetaData("toaccount", OUT);
    private   java.lang.String toaccount;
    
    public java.lang.String getToaccount() {
      return toaccount;
    }
    
      public void setToaccount(java.lang.String toaccount) {
        this.toaccount = toaccount;
      }
    
    private static final VectorFieldMetaData returnCodeMetaData = new VectorFieldMetaData("returnCode", OUT);
    private   java.lang.Long returnCode;
    
    public java.lang.Long getReturnCode() {
      return returnCode;
    }
    
      public void setReturnCode(java.lang.Long returnCode) {
        this.returnCode = returnCode;
      }
    
    private static final VectorFieldMetaData transDateMetaData = new VectorFieldMetaData("transDate", OUT);
    private   java.sql.Timestamp transDate;
    
    public java.sql.Timestamp getTransDate() {
      return transDate;
    }
    
      public void setTransDate(java.sql.Timestamp transDate) {
        this.transDate = transDate;
      }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(IncomingFin.class, new VectorFieldMetaData[] {
         idMetaData,
         cardNumberMetaData,
         processingcodeMetaData,
         transamountMetaData,
         systemtracenumberMetaData,
         localtransactiondateMetaData,
         settlementdateMetaData,
         siccodeMetaData,
         acquiringinstitutioncodeMetaData,
         issuerbankcodeMetaData,
         authorizationnumberMetaData,
         retrievalreferencenumberMetaData,
         terminalidentificationMetaData,
         transactioncurrencycodeMetaData,
         fromaccountMetaData,
         toaccountMetaData,
         returnCodeMetaData,
         transDateMetaData,

      }
  );

  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void retrieveBuffer() throws Exception {
    id =  getLong(idMetaData);
            cardNumber =  getString(cardNumberMetaData);
            processingcode =  getString(processingcodeMetaData);
            transamount =  getBigDecimal(transamountMetaData);
            systemtracenumber =  getString(systemtracenumberMetaData);
            localtransactiondate =  getString(localtransactiondateMetaData);
            settlementdate =  getString(settlementdateMetaData);
            siccode =  getString(siccodeMetaData);
            acquiringinstitutioncode =  getString(acquiringinstitutioncodeMetaData);
            issuerbankcode =  getString(issuerbankcodeMetaData);
            authorizationnumber =  getString(authorizationnumberMetaData);
            retrievalreferencenumber =  getString(retrievalreferencenumberMetaData);
            terminalidentification =  getString(terminalidentificationMetaData);
            transactioncurrencycode =  getString(transactioncurrencycodeMetaData);
            fromaccount =  getString(fromaccountMetaData);
            toaccount =  getString(toaccountMetaData);
            returnCode =  getLong(returnCodeMetaData);
            transDate =  getTimestamp(transDateMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
  }
}
