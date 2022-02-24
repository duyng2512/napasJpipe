
package com.openwaygroup.pipe.reconciledacquiringposatm.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.TableServiceBuffer;

public class DisputeService extends TableServiceBuffer
    
 {

  private static final VectorFieldMetaData amndStateMetaData = new VectorFieldMetaData("amndState", OUT);

  private static final VectorFieldMetaData amndDateMetaData = new VectorFieldMetaData("amndDate", OUT);

  private static final VectorFieldMetaData amndOfficerMetaData = new VectorFieldMetaData("amndOfficer", OUT);

  private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);

  private static final VectorFieldMetaData docOidMetaData = new VectorFieldMetaData("docOid", OUT);

  private static final VectorFieldMetaData cardNumberMetaData = new VectorFieldMetaData("cardNumber", OUT);

  private static final VectorFieldMetaData processingCodeMetaData = new VectorFieldMetaData("processingCode", OUT);

  private static final VectorFieldMetaData transAmountMetaData = new VectorFieldMetaData("transAmount", OUT);

  private static final VectorFieldMetaData systemTraceNumberMetaData = new VectorFieldMetaData("systemTraceNumber", OUT);

  private static final VectorFieldMetaData transTimeMetaData = new VectorFieldMetaData("transTime", OUT);

  private static final VectorFieldMetaData transDateMetaData = new VectorFieldMetaData("transDate", OUT);

  private static final VectorFieldMetaData settlDateMetaData = new VectorFieldMetaData("settlDate", OUT);

  private static final VectorFieldMetaData terminalTypeMetaData = new VectorFieldMetaData("terminalType", OUT);

  private static final VectorFieldMetaData acquiringMemberIdMetaData = new VectorFieldMetaData("acquiringMemberId", OUT);

  private static final VectorFieldMetaData authCodeMetaData = new VectorFieldMetaData("authCode", OUT);

  private static final VectorFieldMetaData terminalIdMetaData = new VectorFieldMetaData("terminalId", OUT);

  private static final VectorFieldMetaData transCurrMetaData = new VectorFieldMetaData("transCurr", OUT);

  private static final VectorFieldMetaData fromAccountMetaData = new VectorFieldMetaData("fromAccount", OUT);

  private static final VectorFieldMetaData toAccountMetaData = new VectorFieldMetaData("toAccount", OUT);

  private static final VectorFieldMetaData messageCodeMetaData = new VectorFieldMetaData("messageCode", OUT);

  private static final VectorFieldMetaData directionMetaData = new VectorFieldMetaData("direction", OUT);

  private static final VectorFieldMetaData returnCodeMetaData = new VectorFieldMetaData("returnCode", OUT);

  private static final VectorFieldMetaData processDateMetaData = new VectorFieldMetaData("processDate", OUT);

  private static final VectorFieldMetaData addInfoMetaData = new VectorFieldMetaData("addInfo", OUT);

  private static final VectorFieldMetaData checkSumValueMetaData = new VectorFieldMetaData("checkSumValue", OUT);

  private static final VectorFieldMetaData napasReturnCodeMetaData = new VectorFieldMetaData("napasReturnCode", OUT);

  private static final VectorFieldMetaData statusMetaData = new VectorFieldMetaData("status", OUT);

  private static final VectorFieldMetaData outwardDateMetaData = new VectorFieldMetaData("outwardDate", OUT);

  private static final VectorFieldMetaData transDate2MetaData = new VectorFieldMetaData("transDate2", OUT);

  private static final VectorFieldMetaData napasServiceMetaData = new VectorFieldMetaData("napasService", OUT);

  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(DisputeService.class, new VectorFieldMetaData[] {
amndStateMetaData,amndDateMetaData,amndOfficerMetaData,idMetaData,docOidMetaData,cardNumberMetaData,processingCodeMetaData,transAmountMetaData,systemTraceNumberMetaData,transTimeMetaData,transDateMetaData,settlDateMetaData,terminalTypeMetaData,acquiringMemberIdMetaData,authCodeMetaData,terminalIdMetaData,transCurrMetaData,fromAccountMetaData,toAccountMetaData,messageCodeMetaData,directionMetaData,returnCodeMetaData,processDateMetaData,addInfoMetaData,checkSumValueMetaData,napasReturnCodeMetaData,statusMetaData,outwardDateMetaData,transDate2MetaData,napasServiceMetaData
      }
  );


  private   java.lang.String amndState;

  private   java.sql.Timestamp amndDate;

  private   java.lang.Long amndOfficer;

  private   java.lang.Long id;

  private   java.lang.Long docOid;

  private   java.lang.String cardNumber;

  private   java.lang.String processingCode;

  private   java.lang.String transAmount;

  private   java.lang.String systemTraceNumber;

  private   java.lang.String transTime;

  private   java.lang.String transDate;

  private   java.lang.String settlDate;

  private   java.lang.String terminalType;

  private   java.lang.String acquiringMemberId;

  private   java.lang.String authCode;

  private   java.lang.String terminalId;

  private   java.lang.String transCurr;

  private   java.lang.String fromAccount;

  private   java.lang.String toAccount;

  private   java.lang.String messageCode;

  private   java.lang.String direction;

  private   java.lang.String returnCode;

  private   java.lang.String processDate;

  private   java.lang.String addInfo;

  private   java.lang.String checkSumValue;

  private   java.lang.Long napasReturnCode;

  private   java.lang.String status;

  private   java.lang.String outwardDate;

  private   java.sql.Timestamp transDate2;

  private   java.lang.String napasService;


  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void setParameters() throws Exception {

    set(amndStateMetaData, amndState);

    set(amndDateMetaData, amndDate);

    set(amndOfficerMetaData, amndOfficer);

    set(idMetaData, id);

    set(docOidMetaData, docOid);

    set(cardNumberMetaData, cardNumber);

    set(processingCodeMetaData, processingCode);

    set(transAmountMetaData, transAmount);

    set(systemTraceNumberMetaData, systemTraceNumber);

    set(transTimeMetaData, transTime);

    set(transDateMetaData, transDate);

    set(settlDateMetaData, settlDate);

    set(terminalTypeMetaData, terminalType);

    set(acquiringMemberIdMetaData, acquiringMemberId);

    set(authCodeMetaData, authCode);

    set(terminalIdMetaData, terminalId);

    set(transCurrMetaData, transCurr);

    set(fromAccountMetaData, fromAccount);

    set(toAccountMetaData, toAccount);

    set(messageCodeMetaData, messageCode);

    set(directionMetaData, direction);

    set(returnCodeMetaData, returnCode);

    set(processDateMetaData, processDate);

    set(addInfoMetaData, addInfo);

    set(checkSumValueMetaData, checkSumValue);

    set(napasReturnCodeMetaData, napasReturnCode);

    set(statusMetaData, status);

    set(outwardDateMetaData, outwardDate);

    set(transDate2MetaData, transDate2);

    set(napasServiceMetaData, napasService);

  }


  public java.lang.String getAmndState() {
    return amndState;
  }

  public void setAmndState(java.lang.String amndState) {
    
    if(amndState != null && amndState.length() > 1) {
      
      throw new RuntimeException("AMND_STATE length exceeds 1 symbol(s): [" + amndState + "]");
      
    }
    
    this.amndState = amndState;
  }

  public java.sql.Timestamp getAmndDate() {
    return amndDate;
  }

  public void setAmndDate(java.sql.Timestamp amndDate) {
    
    this.amndDate = amndDate;
  }

  public java.lang.Long getAmndOfficer() {
    return amndOfficer;
  }

  public void setAmndOfficer(java.lang.Long amndOfficer) {
    
    this.amndOfficer = amndOfficer;
  }

  public java.lang.Long getId() {
    return id;
  }

  public void setId(java.lang.Long id) {
    
    this.id = id;
  }

  public java.lang.Long getDocOid() {
    return docOid;
  }

  public void setDocOid(java.lang.Long docOid) {
    
    this.docOid = docOid;
  }

  public java.lang.String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(java.lang.String cardNumber) {
    
    if(cardNumber != null && cardNumber.length() > 64) {
      
      throw new RuntimeException("CARD_NUMBER length exceeds 64 symbol(s): [" + cardNumber + "]");
      
    }
    
    this.cardNumber = cardNumber;
  }

  public java.lang.String getProcessingCode() {
    return processingCode;
  }

  public void setProcessingCode(java.lang.String processingCode) {
    
    if(processingCode != null && processingCode.length() > 32) {
      
      throw new RuntimeException("PROCESSING_CODE length exceeds 32 symbol(s): [" + processingCode + "]");
      
    }
    
    this.processingCode = processingCode;
  }

  public java.lang.String getTransAmount() {
    return transAmount;
  }

  public void setTransAmount(java.lang.String transAmount) {
    
    if(transAmount != null && transAmount.length() > 32) {
      
      throw new RuntimeException("TRANS_AMOUNT length exceeds 32 symbol(s): [" + transAmount + "]");
      
    }
    
    this.transAmount = transAmount;
  }

  public java.lang.String getSystemTraceNumber() {
    return systemTraceNumber;
  }

  public void setSystemTraceNumber(java.lang.String systemTraceNumber) {
    
    if(systemTraceNumber != null && systemTraceNumber.length() > 32) {
      
      throw new RuntimeException("SYSTEM_TRACE_NUMBER length exceeds 32 symbol(s): [" + systemTraceNumber + "]");
      
    }
    
    this.systemTraceNumber = systemTraceNumber;
  }

  public java.lang.String getTransTime() {
    return transTime;
  }

  public void setTransTime(java.lang.String transTime) {
    
    if(transTime != null && transTime.length() > 32) {
      
      throw new RuntimeException("TRANS_TIME length exceeds 32 symbol(s): [" + transTime + "]");
      
    }
    
    this.transTime = transTime;
  }

  public java.lang.String getTransDate() {
    return transDate;
  }

  public void setTransDate(java.lang.String transDate) {
    
    if(transDate != null && transDate.length() > 32) {
      
      throw new RuntimeException("TRANS_DATE length exceeds 32 symbol(s): [" + transDate + "]");
      
    }
    
    this.transDate = transDate;
  }

  public java.lang.String getSettlDate() {
    return settlDate;
  }

  public void setSettlDate(java.lang.String settlDate) {
    
    if(settlDate != null && settlDate.length() > 32) {
      
      throw new RuntimeException("SETTL_DATE length exceeds 32 symbol(s): [" + settlDate + "]");
      
    }
    
    this.settlDate = settlDate;
  }

  public java.lang.String getTerminalType() {
    return terminalType;
  }

  public void setTerminalType(java.lang.String terminalType) {
    
    if(terminalType != null && terminalType.length() > 32) {
      
      throw new RuntimeException("TERMINAL_TYPE length exceeds 32 symbol(s): [" + terminalType + "]");
      
    }
    
    this.terminalType = terminalType;
  }

  public java.lang.String getAcquiringMemberId() {
    return acquiringMemberId;
  }

  public void setAcquiringMemberId(java.lang.String acquiringMemberId) {
    
    if(acquiringMemberId != null && acquiringMemberId.length() > 32) {
      
      throw new RuntimeException("ACQUIRING_MEMBER_ID length exceeds 32 symbol(s): [" + acquiringMemberId + "]");
      
    }
    
    this.acquiringMemberId = acquiringMemberId;
  }

  public java.lang.String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(java.lang.String authCode) {
    
    if(authCode != null && authCode.length() > 32) {
      
      throw new RuntimeException("AUTH_CODE length exceeds 32 symbol(s): [" + authCode + "]");
      
    }
    
    this.authCode = authCode;
  }

  public java.lang.String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(java.lang.String terminalId) {
    
    if(terminalId != null && terminalId.length() > 32) {
      
      throw new RuntimeException("TERMINAL_ID length exceeds 32 symbol(s): [" + terminalId + "]");
      
    }
    
    this.terminalId = terminalId;
  }

  public java.lang.String getTransCurr() {
    return transCurr;
  }

  public void setTransCurr(java.lang.String transCurr) {
    
    if(transCurr != null && transCurr.length() > 10) {
      
      throw new RuntimeException("TRANS_CURR length exceeds 10 symbol(s): [" + transCurr + "]");
      
    }
    
    this.transCurr = transCurr;
  }

  public java.lang.String getFromAccount() {
    return fromAccount;
  }

  public void setFromAccount(java.lang.String fromAccount) {
    
    if(fromAccount != null && fromAccount.length() > 64) {
      
      throw new RuntimeException("FROM_ACCOUNT length exceeds 64 symbol(s): [" + fromAccount + "]");
      
    }
    
    this.fromAccount = fromAccount;
  }

  public java.lang.String getToAccount() {
    return toAccount;
  }

  public void setToAccount(java.lang.String toAccount) {
    
    if(toAccount != null && toAccount.length() > 64) {
      
      throw new RuntimeException("TO_ACCOUNT length exceeds 64 symbol(s): [" + toAccount + "]");
      
    }
    
    this.toAccount = toAccount;
  }

  public java.lang.String getMessageCode() {
    return messageCode;
  }

  public void setMessageCode(java.lang.String messageCode) {
    
    if(messageCode != null && messageCode.length() > 6) {
      
      throw new RuntimeException("MESSAGE_CODE length exceeds 6 symbol(s): [" + messageCode + "]");
      
    }
    
    this.messageCode = messageCode;
  }

  public java.lang.String getDirection() {
    return direction;
  }

  public void setDirection(java.lang.String direction) {
    
    if(direction != null && direction.length() > 32) {
      
      throw new RuntimeException("DIRECTION length exceeds 32 symbol(s): [" + direction + "]");
      
    }
    
    this.direction = direction;
  }

  public java.lang.String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(java.lang.String returnCode) {
    
    if(returnCode != null && returnCode.length() > 6) {
      
      throw new RuntimeException("RETURN_CODE length exceeds 6 symbol(s): [" + returnCode + "]");
      
    }
    
    this.returnCode = returnCode;
  }

  public java.lang.String getProcessDate() {
    return processDate;
  }

  public void setProcessDate(java.lang.String processDate) {
    
    if(processDate != null && processDate.length() > 32) {
      
      throw new RuntimeException("PROCESS_DATE length exceeds 32 symbol(s): [" + processDate + "]");
      
    }
    
    this.processDate = processDate;
  }

  public java.lang.String getAddInfo() {
    return addInfo;
  }

  public void setAddInfo(java.lang.String addInfo) {
    
    if(addInfo != null && addInfo.length() > 3900) {
      
      throw new RuntimeException("ADD_INFO length exceeds 3900 symbol(s): [" + addInfo + "]");
      
    }
    
    this.addInfo = addInfo;
  }

  public java.lang.String getCheckSumValue() {
    return checkSumValue;
  }

  public void setCheckSumValue(java.lang.String checkSumValue) {
    
    if(checkSumValue != null && checkSumValue.length() > 64) {
      
      throw new RuntimeException("CHECK_SUM_VALUE length exceeds 64 symbol(s): [" + checkSumValue + "]");
      
    }
    
    this.checkSumValue = checkSumValue;
  }

  public java.lang.Long getNapasReturnCode() {
    return napasReturnCode;
  }

  public void setNapasReturnCode(java.lang.Long napasReturnCode) {
    
    this.napasReturnCode = napasReturnCode;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String status) {
    
    if(status != null && status.length() > 20) {
      
      throw new RuntimeException("STATUS length exceeds 20 symbol(s): [" + status + "]");
      
    }
    
    this.status = status;
  }

  public java.lang.String getOutwardDate() {
    return outwardDate;
  }

  public void setOutwardDate(java.lang.String outwardDate) {
    
    if(outwardDate != null && outwardDate.length() > 12) {
      
      throw new RuntimeException("OUTWARD_DATE length exceeds 12 symbol(s): [" + outwardDate + "]");
      
    }
    
    this.outwardDate = outwardDate;
  }

  public java.sql.Timestamp getTransDate2() {
    return transDate2;
  }

  public void setTransDate2(java.sql.Timestamp transDate2) {
    
    this.transDate2 = transDate2;
  }

  public java.lang.String getNapasService() {
    return napasService;
  }

  public void setNapasService(java.lang.String napasService) {
    
    if(napasService != null && napasService.length() > 32) {
      
      throw new RuntimeException("NAPAS_SERVICE length exceeds 32 symbol(s): [" + napasService + "]");
      
    }
    
    this.napasService = napasService;
  }

  public void reset() {

    this.amndState = null;

    this.amndDate = null;

    this.amndOfficer = null;

    this.id = null;

    this.docOid = null;

    this.cardNumber = null;

    this.processingCode = null;

    this.transAmount = null;

    this.systemTraceNumber = null;

    this.transTime = null;

    this.transDate = null;

    this.settlDate = null;

    this.terminalType = null;

    this.acquiringMemberId = null;

    this.authCode = null;

    this.terminalId = null;

    this.transCurr = null;

    this.fromAccount = null;

    this.toAccount = null;

    this.messageCode = null;

    this.direction = null;

    this.returnCode = null;

    this.processDate = null;

    this.addInfo = null;

    this.checkSumValue = null;

    this.napasReturnCode = null;

    this.status = null;

    this.outwardDate = null;

    this.transDate2 = null;

    this.napasService = null;

  }
}


