
package com.openwaygroup.pipe.reconciledacquiringposatm.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.*;

public class AcqService extends SelectSourceVectorBuffer
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
    
    private static final VectorFieldMetaData localtransactiontimeMetaData = new VectorFieldMetaData("localtransactiontime", OUT);
    private   java.lang.String localtransactiontime;
    
    public java.lang.String getLocaltransactiontime() {
      return localtransactiontime;
    }
    
      public void setLocaltransactiontime(java.lang.String localtransactiontime) {
        this.localtransactiontime = localtransactiontime;
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
    
    private static final VectorFieldMetaData messagetypeidentifiercodeMetaData = new VectorFieldMetaData("messagetypeidentifiercode", OUT);
    private   java.lang.String messagetypeidentifiercode;
    
    public java.lang.String getMessagetypeidentifiercode() {
      return messagetypeidentifiercode;
    }
    
      public void setMessagetypeidentifiercode(java.lang.String messagetypeidentifiercode) {
        this.messagetypeidentifiercode = messagetypeidentifiercode;
      }
    
    private static final VectorFieldMetaData transactionstatusMetaData = new VectorFieldMetaData("transactionstatus", OUT);
    private   java.lang.String transactionstatus;
    
    public java.lang.String getTransactionstatus() {
      return transactionstatus;
    }
    
      public void setTransactionstatus(java.lang.String transactionstatus) {
        this.transactionstatus = transactionstatus;
      }
    
    private static final VectorFieldMetaData transDateMetaData = new VectorFieldMetaData("transDate", OUT);
    private   java.sql.Timestamp transDate;
    
    public java.sql.Timestamp getTransDate() {
      return transDate;
    }
    
      public void setTransDate(java.sql.Timestamp transDate) {
        this.transDate = transDate;
      }
    
    private static final VectorFieldMetaData napassvccodeMetaData = new VectorFieldMetaData("napassvccode", OUT);
    private   java.lang.String napassvccode;
    
    public java.lang.String getNapassvccode() {
      return napassvccode;
    }
    
      public void setNapassvccode(java.lang.String napassvccode) {
        this.napassvccode = napassvccode;
      }
    
    private static final VectorFieldMetaData transactionchannelcodeMetaData = new VectorFieldMetaData("transactionchannelcode", OUT);
    private   java.lang.String transactionchannelcode;
    
    public java.lang.String getTransactionchannelcode() {
      return transactionchannelcode;
    }
    
      public void setTransactionchannelcode(java.lang.String transactionchannelcode) {
        this.transactionchannelcode = transactionchannelcode;
      }
    
    private static final VectorFieldMetaData realtransactionamountMetaData = new VectorFieldMetaData("realtransactionamount", OUT);
    private   java.lang.Long realtransactionamount;
    
    public java.lang.Long getRealtransactionamount() {
      return realtransactionamount;
    }
    
      public void setRealtransactionamount(java.lang.Long realtransactionamount) {
        this.realtransactionamount = realtransactionamount;
      }
    
    private static final VectorFieldMetaData settlementamountMetaData = new VectorFieldMetaData("settlementamount", OUT);
    private   java.math.BigDecimal settlementamount;
    
    public java.math.BigDecimal getSettlementamount() {
      return settlementamount;
    }
    
      public void setSettlementamount(java.math.BigDecimal settlementamount) {
        this.settlementamount = settlementamount;
      }
    
    private static final VectorFieldMetaData reconciledtransactionMetaData = new VectorFieldMetaData("reconciledtransaction", OUT);
    private   java.math.BigDecimal reconciledtransaction;
    
    public java.math.BigDecimal getReconciledtransaction() {
      return reconciledtransaction;
    }
    
      public void setReconciledtransaction(java.math.BigDecimal reconciledtransaction) {
        this.reconciledtransaction = reconciledtransaction;
      }
    
    private static final VectorFieldMetaData settlementcurrencycodeMetaData = new VectorFieldMetaData("settlementcurrencycode", OUT);
    private   java.lang.String settlementcurrencycode;
    
    public java.lang.String getSettlementcurrencycode() {
      return settlementcurrencycode;
    }
    
      public void setSettlementcurrencycode(java.lang.String settlementcurrencycode) {
        this.settlementcurrencycode = settlementcurrencycode;
      }
    
    private static final VectorFieldMetaData fxrateMetaData = new VectorFieldMetaData("fxrate", OUT);
    private   java.lang.Long fxrate;
    
    public java.lang.Long getFxrate() {
      return fxrate;
    }
    
      public void setFxrate(java.lang.Long fxrate) {
        this.fxrate = fxrate;
      }
    
    private static final VectorFieldMetaData cardholderamountMetaData = new VectorFieldMetaData("cardholderamount", OUT);
    private   java.lang.Long cardholderamount;
    
    public java.lang.Long getCardholderamount() {
      return cardholderamount;
    }
    
      public void setCardholderamount(java.lang.Long cardholderamount) {
        this.cardholderamount = cardholderamount;
      }
    
    private static final VectorFieldMetaData realcardholderamountMetaData = new VectorFieldMetaData("realcardholderamount", OUT);
    private   java.lang.Long realcardholderamount;
    
    public java.lang.Long getRealcardholderamount() {
      return realcardholderamount;
    }
    
      public void setRealcardholderamount(java.lang.Long realcardholderamount) {
        this.realcardholderamount = realcardholderamount;
      }
    
    private static final VectorFieldMetaData cardholercurrencycodeMetaData = new VectorFieldMetaData("cardholercurrencycode", OUT);
    private   java.lang.String cardholercurrencycode;
    
    public java.lang.String getCardholercurrencycode() {
      return cardholercurrencycode;
    }
    
      public void setCardholercurrencycode(java.lang.String cardholercurrencycode) {
        this.cardholercurrencycode = cardholercurrencycode;
      }
    
    private static final VectorFieldMetaData cardholderfxrateMetaData = new VectorFieldMetaData("cardholderfxrate", OUT);
    private   java.lang.Long cardholderfxrate;
    
    public java.lang.Long getCardholderfxrate() {
      return cardholderfxrate;
    }
    
      public void setCardholderfxrate(java.lang.Long cardholderfxrate) {
        this.cardholderfxrate = cardholderfxrate;
      }
    
    private static final VectorFieldMetaData servicecodeMetaData = new VectorFieldMetaData("servicecode", OUT);
    private   java.lang.String servicecode;
    
    public java.lang.String getServicecode() {
      return servicecode;
    }
    
      public void setServicecode(java.lang.String servicecode) {
        this.servicecode = servicecode;
      }
    
    private static final VectorFieldMetaData serviceconditioncodeMetaData = new VectorFieldMetaData("serviceconditioncode", OUT);
    private   java.lang.String serviceconditioncode;
    
    public java.lang.String getServiceconditioncode() {
      return serviceconditioncode;
    }
    
      public void setServiceconditioncode(java.lang.String serviceconditioncode) {
        this.serviceconditioncode = serviceconditioncode;
      }
    
    private static final VectorFieldMetaData merchantidentificationcodeMetaData = new VectorFieldMetaData("merchantidentificationcode", OUT);
    private   java.lang.String merchantidentificationcode;
    
    public java.lang.String getMerchantidentificationcode() {
      return merchantidentificationcode;
    }
    
      public void setMerchantidentificationcode(java.lang.String merchantidentificationcode) {
        this.merchantidentificationcode = merchantidentificationcode;
      }
    
    private static final VectorFieldMetaData beneficiaryidentifyMetaData = new VectorFieldMetaData("beneficiaryidentify", OUT);
    private   java.lang.String beneficiaryidentify;
    
    public java.lang.String getBeneficiaryidentify() {
      return beneficiaryidentify;
    }
    
      public void setBeneficiaryidentify(java.lang.String beneficiaryidentify) {
        this.beneficiaryidentify = beneficiaryidentify;
      }
    
    private static final VectorFieldMetaData transactionreferencenumberMetaData = new VectorFieldMetaData("transactionreferencenumber", OUT);
    private   java.lang.String transactionreferencenumber;
    
    public java.lang.String getTransactionreferencenumber() {
      return transactionreferencenumber;
    }
    
      public void setTransactionreferencenumber(java.lang.String transactionreferencenumber) {
        this.transactionreferencenumber = transactionreferencenumber;
      }
    
    private static final VectorFieldMetaData onlinelogflagMetaData = new VectorFieldMetaData("onlinelogflag", OUT);
    private   java.lang.String onlinelogflag;
    
    public java.lang.String getOnlinelogflag() {
      return onlinelogflag;
    }
    
      public void setOnlinelogflag(java.lang.String onlinelogflag) {
        this.onlinelogflag = onlinelogflag;
      }
    
    private static final VectorFieldMetaData statusMetaData = new VectorFieldMetaData("status", OUT);
    private   java.lang.String status;
    
    public java.lang.String getStatus() {
      return status;
    }
    
      public void setStatus(java.lang.String status) {
        this.status = status;
      }
    
  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(AcqService.class, new VectorFieldMetaData[] {
         idMetaData,
         cardNumberMetaData,
         processingcodeMetaData,
         transamountMetaData,
         systemtracenumberMetaData,
         localtransactiontimeMetaData,
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
         messagetypeidentifiercodeMetaData,
         transactionstatusMetaData,
         transDateMetaData,
         napassvccodeMetaData,
         transactionchannelcodeMetaData,
         realtransactionamountMetaData,
         settlementamountMetaData,
         reconciledtransactionMetaData,
         settlementcurrencycodeMetaData,
         fxrateMetaData,
         cardholderamountMetaData,
         realcardholderamountMetaData,
         cardholercurrencycodeMetaData,
         cardholderfxrateMetaData,
         servicecodeMetaData,
         serviceconditioncodeMetaData,
         merchantidentificationcodeMetaData,
         beneficiaryidentifyMetaData,
         transactionreferencenumberMetaData,
         onlinelogflagMetaData,
         statusMetaData,

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
            localtransactiontime =  getString(localtransactiontimeMetaData);
            localtransactiondate =  getString(localtransactiondateMetaData);
            settlementdate =  getString(settlementdateMetaData);
            siccode =  getString(siccodeMetaData);
            acquiringinstitutioncode =  getChar(acquiringinstitutioncodeMetaData);
            issuerbankcode =  getString(issuerbankcodeMetaData);
            authorizationnumber =  getString(authorizationnumberMetaData);
            retrievalreferencenumber =  getString(retrievalreferencenumberMetaData);
            terminalidentification =  getString(terminalidentificationMetaData);
            transactioncurrencycode =  getString(transactioncurrencycodeMetaData);
            fromaccount =  getString(fromaccountMetaData);
            toaccount =  getString(toaccountMetaData);
            messagetypeidentifiercode =  getChar(messagetypeidentifiercodeMetaData);
            transactionstatus =  getChar(transactionstatusMetaData);
            transDate =  getTimestamp(transDateMetaData);
            napassvccode =  getString(napassvccodeMetaData);
            transactionchannelcode =  getString(transactionchannelcodeMetaData);
            realtransactionamount =  getLong(realtransactionamountMetaData);
            settlementamount =  getBigDecimal(settlementamountMetaData);
            reconciledtransaction =  getBigDecimal(reconciledtransactionMetaData);
            settlementcurrencycode =  getString(settlementcurrencycodeMetaData);
            fxrate =  getLong(fxrateMetaData);
            cardholderamount =  getLong(cardholderamountMetaData);
            realcardholderamount =  getLong(realcardholderamountMetaData);
            cardholercurrencycode =  getString(cardholercurrencycodeMetaData);
            cardholderfxrate =  getLong(cardholderfxrateMetaData);
            servicecode =  getString(servicecodeMetaData);
            serviceconditioncode =  getString(serviceconditioncodeMetaData);
            merchantidentificationcode =  getString(merchantidentificationcodeMetaData);
            beneficiaryidentify =  getString(beneficiaryidentifyMetaData);
            transactionreferencenumber =  getString(transactionreferencenumberMetaData);
            onlinelogflag =  getChar(onlinelogflagMetaData);
            status =  getString(statusMetaData);
        
  }


  protected void setSelectParameters() throws Exception {
    
  }
}
