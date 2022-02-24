
package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.spi.base.vector.*;
import com.openwaygroup.application.pipe.impl.jdbc.TableServiceBuffer;

public class UpdateOPTSMLDOC extends TableServiceBuffer
    
 {

  private static final VectorFieldMetaData amndStateMetaData = new VectorFieldMetaData("amndState", OUT);

  private static final VectorFieldMetaData amndOfficerMetaData = new VectorFieldMetaData("amndOfficer", OUT);

  private static final VectorFieldMetaData amndDateMetaData = new VectorFieldMetaData("amndDate", OUT);

  private static final VectorFieldMetaData amndPrevMetaData = new VectorFieldMetaData("amndPrev", OUT);

  private static final VectorFieldMetaData idMetaData = new VectorFieldMetaData("id", OUT);

  private static final VectorFieldMetaData docOrigIdMetaData = new VectorFieldMetaData("docOrigId", OUT);

  private static final VectorFieldMetaData docPrevIdMetaData = new VectorFieldMetaData("docPrevId", OUT);

  private static final VectorFieldMetaData docSummIdMetaData = new VectorFieldMetaData("docSummId", OUT);

  private static final VectorFieldMetaData numberOfSubSMetaData = new VectorFieldMetaData("numberOfSubS", OUT);

  private static final VectorFieldMetaData numberInChainMetaData = new VectorFieldMetaData("numberInChain", OUT);

  private static final VectorFieldMetaData actionMetaData = new VectorFieldMetaData("action", OUT);

  private static final VectorFieldMetaData messageCategoryMetaData = new VectorFieldMetaData("messageCategory", OUT);

  private static final VectorFieldMetaData sourceRegNumMetaData = new VectorFieldMetaData("sourceRegNum", OUT);

  private static final VectorFieldMetaData acqRefNumberMetaData = new VectorFieldMetaData("acqRefNumber", OUT);

  private static final VectorFieldMetaData retRefNumberMetaData = new VectorFieldMetaData("retRefNumber", OUT);

  private static final VectorFieldMetaData issRefNumberMetaData = new VectorFieldMetaData("issRefNumber", OUT);

  private static final VectorFieldMetaData psRefNumberMetaData = new VectorFieldMetaData("psRefNumber", OUT);

  private static final VectorFieldMetaData nwRefDateMetaData = new VectorFieldMetaData("nwRefDate", OUT);

  private static final VectorFieldMetaData authCodeMetaData = new VectorFieldMetaData("authCode", OUT);

  private static final VectorFieldMetaData isAuthorizationMetaData = new VectorFieldMetaData("isAuthorization", OUT);

  private static final VectorFieldMetaData requestCategoryMetaData = new VectorFieldMetaData("requestCategory", OUT);

  private static final VectorFieldMetaData serviceClassMetaData = new VectorFieldMetaData("serviceClass", OUT);

  private static final VectorFieldMetaData sourceCodeMetaData = new VectorFieldMetaData("sourceCode", OUT);

  private static final VectorFieldMetaData sourceFeeCodeMetaData = new VectorFieldMetaData("sourceFeeCode", OUT);

  private static final VectorFieldMetaData targetCodeMetaData = new VectorFieldMetaData("targetCode", OUT);

  private static final VectorFieldMetaData targetFeeCodeMetaData = new VectorFieldMetaData("targetFeeCode", OUT);

  private static final VectorFieldMetaData transTypeMetaData = new VectorFieldMetaData("transType", OUT);

  private static final VectorFieldMetaData sourceChannelMetaData = new VectorFieldMetaData("sourceChannel", OUT);

  private static final VectorFieldMetaData sCatMetaData = new VectorFieldMetaData("sCat", OUT);

  private static final VectorFieldMetaData sourceIdtSchemeMetaData = new VectorFieldMetaData("sourceIdtScheme", OUT);

  private static final VectorFieldMetaData sourceMemberIdMetaData = new VectorFieldMetaData("sourceMemberId", OUT);

  private static final VectorFieldMetaData recMemberIdMetaData = new VectorFieldMetaData("recMemberId", OUT);

  private static final VectorFieldMetaData sourceNumberMetaData = new VectorFieldMetaData("sourceNumber", OUT);

  private static final VectorFieldMetaData sourceSpcMetaData = new VectorFieldMetaData("sourceSpc", OUT);

  private static final VectorFieldMetaData sourceAccTypeMetaData = new VectorFieldMetaData("sourceAccType", OUT);

  private static final VectorFieldMetaData sourceContractMetaData = new VectorFieldMetaData("sourceContract", OUT);

  private static final VectorFieldMetaData sourceServiceMetaData = new VectorFieldMetaData("sourceService", OUT);

  private static final VectorFieldMetaData targetChannelMetaData = new VectorFieldMetaData("targetChannel", OUT);

  private static final VectorFieldMetaData tCatMetaData = new VectorFieldMetaData("tCat", OUT);

  private static final VectorFieldMetaData targetIdtSchemeMetaData = new VectorFieldMetaData("targetIdtScheme", OUT);

  private static final VectorFieldMetaData targetMemberIdMetaData = new VectorFieldMetaData("targetMemberId", OUT);

  private static final VectorFieldMetaData sendMemberIdMetaData = new VectorFieldMetaData("sendMemberId", OUT);

  private static final VectorFieldMetaData sendingBinMetaData = new VectorFieldMetaData("sendingBin", OUT);

  private static final VectorFieldMetaData targetBinIdMetaData = new VectorFieldMetaData("targetBinId", OUT);

  private static final VectorFieldMetaData targetNumberMetaData = new VectorFieldMetaData("targetNumber", OUT);

  private static final VectorFieldMetaData targetSpcMetaData = new VectorFieldMetaData("targetSpc", OUT);

  private static final VectorFieldMetaData targetAccTypeMetaData = new VectorFieldMetaData("targetAccType", OUT);

  private static final VectorFieldMetaData targetContractMetaData = new VectorFieldMetaData("targetContract", OUT);

  private static final VectorFieldMetaData targetServiceMetaData = new VectorFieldMetaData("targetService", OUT);

  private static final VectorFieldMetaData cardExpireMetaData = new VectorFieldMetaData("cardExpire", OUT);

  private static final VectorFieldMetaData cardSeqvNumberMetaData = new VectorFieldMetaData("cardSeqvNumber", OUT);

  private static final VectorFieldMetaData merchantIdMetaData = new VectorFieldMetaData("merchantId", OUT);

  private static final VectorFieldMetaData sicCodeMetaData = new VectorFieldMetaData("sicCode", OUT);

  private static final VectorFieldMetaData transConditionMetaData = new VectorFieldMetaData("transCondition", OUT);

  private static final VectorFieldMetaData transCondAttrMetaData = new VectorFieldMetaData("transCondAttr", OUT);

  private static final VectorFieldMetaData secTransCondAttMetaData = new VectorFieldMetaData("secTransCondAtt", OUT);

  private static final VectorFieldMetaData reconsCurrMetaData = new VectorFieldMetaData("reconsCurr", OUT);

  private static final VectorFieldMetaData reconsAmountMetaData = new VectorFieldMetaData("reconsAmount", OUT);

  private static final VectorFieldMetaData settlCurrMetaData = new VectorFieldMetaData("settlCurr", OUT);

  private static final VectorFieldMetaData settlAmountMetaData = new VectorFieldMetaData("settlAmount", OUT);

  private static final VectorFieldMetaData sourceFeeCurrMetaData = new VectorFieldMetaData("sourceFeeCurr", OUT);

  private static final VectorFieldMetaData sourceFeeAmountMetaData = new VectorFieldMetaData("sourceFeeAmount", OUT);

  private static final VectorFieldMetaData targetFeeCurrMetaData = new VectorFieldMetaData("targetFeeCurr", OUT);

  private static final VectorFieldMetaData targetFeeAmountMetaData = new VectorFieldMetaData("targetFeeAmount", OUT);

  private static final VectorFieldMetaData transDateMetaData = new VectorFieldMetaData("transDate", OUT);

  private static final VectorFieldMetaData secTransDateMetaData = new VectorFieldMetaData("secTransDate", OUT);

  private static final VectorFieldMetaData transCountryMetaData = new VectorFieldMetaData("transCountry", OUT);

  private static final VectorFieldMetaData transStateMetaData = new VectorFieldMetaData("transState", OUT);

  private static final VectorFieldMetaData transCityMetaData = new VectorFieldMetaData("transCity", OUT);

  private static final VectorFieldMetaData transDetailsMetaData = new VectorFieldMetaData("transDetails", OUT);

  private static final VectorFieldMetaData transAmountMetaData = new VectorFieldMetaData("transAmount", OUT);

  private static final VectorFieldMetaData transCurrMetaData = new VectorFieldMetaData("transCurr", OUT);

  private static final VectorFieldMetaData binRecordMetaData = new VectorFieldMetaData("binRecord", OUT);

  private static final VectorFieldMetaData reasonCodeMetaData = new VectorFieldMetaData("reasonCode", OUT);

  private static final VectorFieldMetaData reasonDetailsMetaData = new VectorFieldMetaData("reasonDetails", OUT);

  private static final VectorFieldMetaData requirementMetaData = new VectorFieldMetaData("requirement", OUT);

  private static final VectorFieldMetaData postingDateMetaData = new VectorFieldMetaData("postingDate", OUT);

  private static final VectorFieldMetaData fxSettlDateMetaData = new VectorFieldMetaData("fxSettlDate", OUT);

  private static final VectorFieldMetaData postingStatusMetaData = new VectorFieldMetaData("postingStatus", OUT);

  private static final VectorFieldMetaData outwardStatusMetaData = new VectorFieldMetaData("outwardStatus", OUT);

  private static final VectorFieldMetaData returnCodeMetaData = new VectorFieldMetaData("returnCode", OUT);

  private static final VectorFieldMetaData addInfoMetaData = new VectorFieldMetaData("addInfo", OUT);

  private static final VectorFieldMetaData processingCodeMetaData = new VectorFieldMetaData("processingCode", OUT);

  private static final VectorFieldMetaData systemTraceNumberMetaData = new VectorFieldMetaData("systemTraceNumber", OUT);

  private static final VectorFieldMetaData statusMetaData = new VectorFieldMetaData("status", OUT);

  private static final VectorFieldMetaData rbsStatusMetaData = new VectorFieldMetaData("rbsStatus", OUT);

  private static final VectorFieldMetaData processDateMetaData = new VectorFieldMetaData("processDate", OUT);

  private static final VectorFieldMetaData fileTypeMetaData = new VectorFieldMetaData("fileType", OUT);

  private static final VectorFieldMetaData fileNameMetaData = new VectorFieldMetaData("fileName", OUT);

  private static final VectorFieldMetaData partitionKeyMetaData = new VectorFieldMetaData("partitionKey", OUT);

  private static final VectorFieldMetaData synchTagMetaData = new VectorFieldMetaData("synchTag", OUT);

  private static final VectorFieldMetaData forDisputeCodeMetaData = new VectorFieldMetaData("forDisputeCode", OUT);

  private static final VectorMetaData VECTOR_META_DATA =
      new VectorMetaData(UpdateOPTSMLDOC.class, new VectorFieldMetaData[] {
amndStateMetaData,amndOfficerMetaData,amndDateMetaData,amndPrevMetaData,idMetaData,docOrigIdMetaData,docPrevIdMetaData,docSummIdMetaData,numberOfSubSMetaData,numberInChainMetaData,actionMetaData,messageCategoryMetaData,sourceRegNumMetaData,acqRefNumberMetaData,retRefNumberMetaData,issRefNumberMetaData,psRefNumberMetaData,nwRefDateMetaData,authCodeMetaData,isAuthorizationMetaData,requestCategoryMetaData,serviceClassMetaData,sourceCodeMetaData,sourceFeeCodeMetaData,targetCodeMetaData,targetFeeCodeMetaData,transTypeMetaData,sourceChannelMetaData,sCatMetaData,sourceIdtSchemeMetaData,sourceMemberIdMetaData,recMemberIdMetaData,sourceNumberMetaData,sourceSpcMetaData,sourceAccTypeMetaData,sourceContractMetaData,sourceServiceMetaData,targetChannelMetaData,tCatMetaData,targetIdtSchemeMetaData,targetMemberIdMetaData,sendMemberIdMetaData,sendingBinMetaData,targetBinIdMetaData,targetNumberMetaData,targetSpcMetaData,targetAccTypeMetaData,targetContractMetaData,targetServiceMetaData,cardExpireMetaData,cardSeqvNumberMetaData,merchantIdMetaData,sicCodeMetaData,transConditionMetaData,transCondAttrMetaData,secTransCondAttMetaData,reconsCurrMetaData,reconsAmountMetaData,settlCurrMetaData,settlAmountMetaData,sourceFeeCurrMetaData,sourceFeeAmountMetaData,targetFeeCurrMetaData,targetFeeAmountMetaData,transDateMetaData,secTransDateMetaData,transCountryMetaData,transStateMetaData,transCityMetaData,transDetailsMetaData,transAmountMetaData,transCurrMetaData,binRecordMetaData,reasonCodeMetaData,reasonDetailsMetaData,requirementMetaData,postingDateMetaData,fxSettlDateMetaData,postingStatusMetaData,outwardStatusMetaData,returnCodeMetaData,addInfoMetaData,processingCodeMetaData,systemTraceNumberMetaData,statusMetaData,rbsStatusMetaData,processDateMetaData,fileTypeMetaData,fileNameMetaData,partitionKeyMetaData,synchTagMetaData,forDisputeCodeMetaData
      }
  );


  private   java.lang.String amndState;

  private   java.lang.Long amndOfficer;

  private   java.sql.Timestamp amndDate;

  private   java.lang.Long amndPrev;

  private   java.lang.Long id;

  private   java.lang.Long docOrigId;

  private   java.lang.Long docPrevId;

  private   java.lang.Long docSummId;

  private   java.lang.Long numberOfSubS;

  private   java.lang.Long numberInChain;

  private   java.lang.String action;

  private   java.lang.String messageCategory;

  private   java.lang.String sourceRegNum;

  private   java.lang.String acqRefNumber;

  private   java.lang.String retRefNumber;

  private   java.lang.String issRefNumber;

  private   java.lang.String psRefNumber;

  private   java.sql.Timestamp nwRefDate;

  private   java.lang.String authCode;

  private   java.lang.String isAuthorization;

  private   java.lang.String requestCategory;

  private   java.lang.String serviceClass;

  private   java.lang.String sourceCode;

  private   java.lang.String sourceFeeCode;

  private   java.lang.String targetCode;

  private   java.lang.String targetFeeCode;

  private   java.lang.Long transType;

  private   java.lang.String sourceChannel;

  private   java.lang.String sCat;

  private   java.lang.String sourceIdtScheme;

  private   java.lang.String sourceMemberId;

  private   java.lang.String recMemberId;

  private   java.lang.String sourceNumber;

  private   java.lang.String sourceSpc;

  private   java.lang.String sourceAccType;

  private   java.lang.Long sourceContract;

  private   java.lang.Long sourceService;

  private   java.lang.String targetChannel;

  private   java.lang.String tCat;

  private   java.lang.String targetIdtScheme;

  private   java.lang.String targetMemberId;

  private   java.lang.String sendMemberId;

  private   java.lang.String sendingBin;

  private   java.lang.Long targetBinId;

  private   java.lang.String targetNumber;

  private   java.lang.String targetSpc;

  private   java.lang.String targetAccType;

  private   java.lang.Long targetContract;

  private   java.lang.Long targetService;

  private   java.lang.String cardExpire;

  private   java.lang.String cardSeqvNumber;

  private   java.lang.String merchantId;

  private   java.lang.String sicCode;

  private   java.lang.String transCondition;

  private   java.lang.Long transCondAttr;

  private   java.lang.Long secTransCondAtt;

  private   java.lang.String reconsCurr;

  private   java.math.BigDecimal reconsAmount;

  private   java.lang.String settlCurr;

  private   java.math.BigDecimal settlAmount;

  private   java.lang.String sourceFeeCurr;

  private   java.math.BigDecimal sourceFeeAmount;

  private   java.lang.String targetFeeCurr;

  private   java.math.BigDecimal targetFeeAmount;

  private   java.sql.Timestamp transDate;

  private   java.sql.Timestamp secTransDate;

  private   java.lang.String transCountry;

  private   java.lang.String transState;

  private   java.lang.String transCity;

  private   java.lang.String transDetails;

  private   java.math.BigDecimal transAmount;

  private   java.lang.String transCurr;

  private   java.lang.Long binRecord;

  private   java.lang.String reasonCode;

  private   java.lang.String reasonDetails;

  private   java.lang.String requirement;

  private   java.sql.Timestamp postingDate;

  private   java.sql.Timestamp fxSettlDate;

  private   java.lang.String postingStatus;

  private   java.lang.String outwardStatus;

  private   java.lang.Long returnCode;

  private   java.lang.String addInfo;

  private   java.lang.String processingCode;

  private   java.lang.String systemTraceNumber;

  private   java.lang.String status;

  private   java.lang.String rbsStatus;

  private   java.lang.String processDate;

  private   java.lang.String fileType;

  private   java.lang.String fileName;

  private   java.lang.String partitionKey;

  private   java.lang.String synchTag;

  private   java.lang.Long forDisputeCode;


  protected VectorMetaData getFieldsMetaData() {
    return VECTOR_META_DATA;
  }

  protected void setParameters() throws Exception {

    set(amndStateMetaData, amndState);

    set(amndOfficerMetaData, amndOfficer);

    set(amndDateMetaData, amndDate);

    set(amndPrevMetaData, amndPrev);

    set(idMetaData, id);

    set(docOrigIdMetaData, docOrigId);

    set(docPrevIdMetaData, docPrevId);

    set(docSummIdMetaData, docSummId);

    set(numberOfSubSMetaData, numberOfSubS);

    set(numberInChainMetaData, numberInChain);

    set(actionMetaData, action);

    set(messageCategoryMetaData, messageCategory);

    set(sourceRegNumMetaData, sourceRegNum);

    set(acqRefNumberMetaData, acqRefNumber);

    set(retRefNumberMetaData, retRefNumber);

    set(issRefNumberMetaData, issRefNumber);

    set(psRefNumberMetaData, psRefNumber);

    set(nwRefDateMetaData, nwRefDate);

    set(authCodeMetaData, authCode);

    set(isAuthorizationMetaData, isAuthorization);

    set(requestCategoryMetaData, requestCategory);

    set(serviceClassMetaData, serviceClass);

    set(sourceCodeMetaData, sourceCode);

    set(sourceFeeCodeMetaData, sourceFeeCode);

    set(targetCodeMetaData, targetCode);

    set(targetFeeCodeMetaData, targetFeeCode);

    set(transTypeMetaData, transType);

    set(sourceChannelMetaData, sourceChannel);

    set(sCatMetaData, sCat);

    set(sourceIdtSchemeMetaData, sourceIdtScheme);

    set(sourceMemberIdMetaData, sourceMemberId);

    set(recMemberIdMetaData, recMemberId);

    set(sourceNumberMetaData, sourceNumber);

    set(sourceSpcMetaData, sourceSpc);

    set(sourceAccTypeMetaData, sourceAccType);

    set(sourceContractMetaData, sourceContract);

    set(sourceServiceMetaData, sourceService);

    set(targetChannelMetaData, targetChannel);

    set(tCatMetaData, tCat);

    set(targetIdtSchemeMetaData, targetIdtScheme);

    set(targetMemberIdMetaData, targetMemberId);

    set(sendMemberIdMetaData, sendMemberId);

    set(sendingBinMetaData, sendingBin);

    set(targetBinIdMetaData, targetBinId);

    set(targetNumberMetaData, targetNumber);

    set(targetSpcMetaData, targetSpc);

    set(targetAccTypeMetaData, targetAccType);

    set(targetContractMetaData, targetContract);

    set(targetServiceMetaData, targetService);

    set(cardExpireMetaData, cardExpire);

    set(cardSeqvNumberMetaData, cardSeqvNumber);

    set(merchantIdMetaData, merchantId);

    set(sicCodeMetaData, sicCode);

    set(transConditionMetaData, transCondition);

    set(transCondAttrMetaData, transCondAttr);

    set(secTransCondAttMetaData, secTransCondAtt);

    set(reconsCurrMetaData, reconsCurr);

    set(reconsAmountMetaData, reconsAmount);

    set(settlCurrMetaData, settlCurr);

    set(settlAmountMetaData, settlAmount);

    set(sourceFeeCurrMetaData, sourceFeeCurr);

    set(sourceFeeAmountMetaData, sourceFeeAmount);

    set(targetFeeCurrMetaData, targetFeeCurr);

    set(targetFeeAmountMetaData, targetFeeAmount);

    set(transDateMetaData, transDate);

    set(secTransDateMetaData, secTransDate);

    set(transCountryMetaData, transCountry);

    set(transStateMetaData, transState);

    set(transCityMetaData, transCity);

    set(transDetailsMetaData, transDetails);

    set(transAmountMetaData, transAmount);

    set(transCurrMetaData, transCurr);

    set(binRecordMetaData, binRecord);

    set(reasonCodeMetaData, reasonCode);

    set(reasonDetailsMetaData, reasonDetails);

    set(requirementMetaData, requirement);

    set(postingDateMetaData, postingDate);

    set(fxSettlDateMetaData, fxSettlDate);

    set(postingStatusMetaData, postingStatus);

    set(outwardStatusMetaData, outwardStatus);

    set(returnCodeMetaData, returnCode);

    set(addInfoMetaData, addInfo);

    set(processingCodeMetaData, processingCode);

    set(systemTraceNumberMetaData, systemTraceNumber);

    set(statusMetaData, status);

    set(rbsStatusMetaData, rbsStatus);

    set(processDateMetaData, processDate);

    set(fileTypeMetaData, fileType);

    set(fileNameMetaData, fileName);

    set(partitionKeyMetaData, partitionKey);

    set(synchTagMetaData, synchTag);

    set(forDisputeCodeMetaData, forDisputeCode);

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

  public java.lang.Long getAmndOfficer() {
    return amndOfficer;
  }

  public void setAmndOfficer(java.lang.Long amndOfficer) {
    
    this.amndOfficer = amndOfficer;
  }

  public java.sql.Timestamp getAmndDate() {
    return amndDate;
  }

  public void setAmndDate(java.sql.Timestamp amndDate) {
    
    this.amndDate = amndDate;
  }

  public java.lang.Long getAmndPrev() {
    return amndPrev;
  }

  public void setAmndPrev(java.lang.Long amndPrev) {
    
    this.amndPrev = amndPrev;
  }

  public java.lang.Long getId() {
    return id;
  }

  public void setId(java.lang.Long id) {
    
    this.id = id;
  }

  public java.lang.Long getDocOrigId() {
    return docOrigId;
  }

  public void setDocOrigId(java.lang.Long docOrigId) {
    
    this.docOrigId = docOrigId;
  }

  public java.lang.Long getDocPrevId() {
    return docPrevId;
  }

  public void setDocPrevId(java.lang.Long docPrevId) {
    
    this.docPrevId = docPrevId;
  }

  public java.lang.Long getDocSummId() {
    return docSummId;
  }

  public void setDocSummId(java.lang.Long docSummId) {
    
    this.docSummId = docSummId;
  }

  public java.lang.Long getNumberOfSubS() {
    return numberOfSubS;
  }

  public void setNumberOfSubS(java.lang.Long numberOfSubS) {
    
    this.numberOfSubS = numberOfSubS;
  }

  public java.lang.Long getNumberInChain() {
    return numberInChain;
  }

  public void setNumberInChain(java.lang.Long numberInChain) {
    
    this.numberInChain = numberInChain;
  }

  public java.lang.String getAction() {
    return action;
  }

  public void setAction(java.lang.String action) {
    
    if(action != null && action.length() > 1) {
      
      throw new RuntimeException("ACTION length exceeds 1 symbol(s): [" + action + "]");
      
    }
    
    this.action = action;
  }

  public java.lang.String getMessageCategory() {
    return messageCategory;
  }

  public void setMessageCategory(java.lang.String messageCategory) {
    
    if(messageCategory != null && messageCategory.length() > 1) {
      
      throw new RuntimeException("MESSAGE_CATEGORY length exceeds 1 symbol(s): [" + messageCategory + "]");
      
    }
    
    this.messageCategory = messageCategory;
  }

  public java.lang.String getSourceRegNum() {
    return sourceRegNum;
  }

  public void setSourceRegNum(java.lang.String sourceRegNum) {
    
    if(sourceRegNum != null && sourceRegNum.length() > 32) {
      
      throw new RuntimeException("SOURCE_REG_NUM length exceeds 32 symbol(s): [" + sourceRegNum + "]");
      
    }
    
    this.sourceRegNum = sourceRegNum;
  }

  public java.lang.String getAcqRefNumber() {
    return acqRefNumber;
  }

  public void setAcqRefNumber(java.lang.String acqRefNumber) {
    
    if(acqRefNumber != null && acqRefNumber.length() > 32) {
      
      throw new RuntimeException("ACQ_REF_NUMBER length exceeds 32 symbol(s): [" + acqRefNumber + "]");
      
    }
    
    this.acqRefNumber = acqRefNumber;
  }

  public java.lang.String getRetRefNumber() {
    return retRefNumber;
  }

  public void setRetRefNumber(java.lang.String retRefNumber) {
    
    if(retRefNumber != null && retRefNumber.length() > 12) {
      
      throw new RuntimeException("RET_REF_NUMBER length exceeds 12 symbol(s): [" + retRefNumber + "]");
      
    }
    
    this.retRefNumber = retRefNumber;
  }

  public java.lang.String getIssRefNumber() {
    return issRefNumber;
  }

  public void setIssRefNumber(java.lang.String issRefNumber) {
    
    if(issRefNumber != null && issRefNumber.length() > 32) {
      
      throw new RuntimeException("ISS_REF_NUMBER length exceeds 32 symbol(s): [" + issRefNumber + "]");
      
    }
    
    this.issRefNumber = issRefNumber;
  }

  public java.lang.String getPsRefNumber() {
    return psRefNumber;
  }

  public void setPsRefNumber(java.lang.String psRefNumber) {
    
    if(psRefNumber != null && psRefNumber.length() > 32) {
      
      throw new RuntimeException("PS_REF_NUMBER length exceeds 32 symbol(s): [" + psRefNumber + "]");
      
    }
    
    this.psRefNumber = psRefNumber;
  }

  public java.sql.Timestamp getNwRefDate() {
    return nwRefDate;
  }

  public void setNwRefDate(java.sql.Timestamp nwRefDate) {
    
    this.nwRefDate = nwRefDate;
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

  public java.lang.String getIsAuthorization() {
    return isAuthorization;
  }

  public void setIsAuthorization(java.lang.String isAuthorization) {
    
    if(isAuthorization != null && isAuthorization.length() > 1) {
      
      throw new RuntimeException("IS_AUTHORIZATION length exceeds 1 symbol(s): [" + isAuthorization + "]");
      
    }
    
    this.isAuthorization = isAuthorization;
  }

  public java.lang.String getRequestCategory() {
    return requestCategory;
  }

  public void setRequestCategory(java.lang.String requestCategory) {
    
    if(requestCategory != null && requestCategory.length() > 1) {
      
      throw new RuntimeException("REQUEST_CATEGORY length exceeds 1 symbol(s): [" + requestCategory + "]");
      
    }
    
    this.requestCategory = requestCategory;
  }

  public java.lang.String getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(java.lang.String serviceClass) {
    
    if(serviceClass != null && serviceClass.length() > 1) {
      
      throw new RuntimeException("SERVICE_CLASS length exceeds 1 symbol(s): [" + serviceClass + "]");
      
    }
    
    this.serviceClass = serviceClass;
  }

  public java.lang.String getSourceCode() {
    return sourceCode;
  }

  public void setSourceCode(java.lang.String sourceCode) {
    
    if(sourceCode != null && sourceCode.length() > 32) {
      
      throw new RuntimeException("SOURCE_CODE length exceeds 32 symbol(s): [" + sourceCode + "]");
      
    }
    
    this.sourceCode = sourceCode;
  }

  public java.lang.String getSourceFeeCode() {
    return sourceFeeCode;
  }

  public void setSourceFeeCode(java.lang.String sourceFeeCode) {
    
    if(sourceFeeCode != null && sourceFeeCode.length() > 32) {
      
      throw new RuntimeException("SOURCE_FEE_CODE length exceeds 32 symbol(s): [" + sourceFeeCode + "]");
      
    }
    
    this.sourceFeeCode = sourceFeeCode;
  }

  public java.lang.String getTargetCode() {
    return targetCode;
  }

  public void setTargetCode(java.lang.String targetCode) {
    
    if(targetCode != null && targetCode.length() > 32) {
      
      throw new RuntimeException("TARGET_CODE length exceeds 32 symbol(s): [" + targetCode + "]");
      
    }
    
    this.targetCode = targetCode;
  }

  public java.lang.String getTargetFeeCode() {
    return targetFeeCode;
  }

  public void setTargetFeeCode(java.lang.String targetFeeCode) {
    
    if(targetFeeCode != null && targetFeeCode.length() > 32) {
      
      throw new RuntimeException("TARGET_FEE_CODE length exceeds 32 symbol(s): [" + targetFeeCode + "]");
      
    }
    
    this.targetFeeCode = targetFeeCode;
  }

  public java.lang.Long getTransType() {
    return transType;
  }

  public void setTransType(java.lang.Long transType) {
    
    this.transType = transType;
  }

  public java.lang.String getSourceChannel() {
    return sourceChannel;
  }

  public void setSourceChannel(java.lang.String sourceChannel) {
    
    if(sourceChannel != null && sourceChannel.length() > 1) {
      
      throw new RuntimeException("SOURCE_CHANNEL length exceeds 1 symbol(s): [" + sourceChannel + "]");
      
    }
    
    this.sourceChannel = sourceChannel;
  }

  public java.lang.String getSCat() {
    return sCat;
  }

  public void setSCat(java.lang.String sCat) {
    
    if(sCat != null && sCat.length() > 1) {
      
      throw new RuntimeException("S_CAT length exceeds 1 symbol(s): [" + sCat + "]");
      
    }
    
    this.sCat = sCat;
  }

  public java.lang.String getSourceIdtScheme() {
    return sourceIdtScheme;
  }

  public void setSourceIdtScheme(java.lang.String sourceIdtScheme) {
    
    if(sourceIdtScheme != null && sourceIdtScheme.length() > 32) {
      
      throw new RuntimeException("SOURCE_IDT_SCHEME length exceeds 32 symbol(s): [" + sourceIdtScheme + "]");
      
    }
    
    this.sourceIdtScheme = sourceIdtScheme;
  }

  public java.lang.String getSourceMemberId() {
    return sourceMemberId;
  }

  public void setSourceMemberId(java.lang.String sourceMemberId) {
    
    if(sourceMemberId != null && sourceMemberId.length() > 32) {
      
      throw new RuntimeException("SOURCE_MEMBER_ID length exceeds 32 symbol(s): [" + sourceMemberId + "]");
      
    }
    
    this.sourceMemberId = sourceMemberId;
  }

  public java.lang.String getRecMemberId() {
    return recMemberId;
  }

  public void setRecMemberId(java.lang.String recMemberId) {
    
    if(recMemberId != null && recMemberId.length() > 32) {
      
      throw new RuntimeException("REC_MEMBER_ID length exceeds 32 symbol(s): [" + recMemberId + "]");
      
    }
    
    this.recMemberId = recMemberId;
  }

  public java.lang.String getSourceNumber() {
    return sourceNumber;
  }

  public void setSourceNumber(java.lang.String sourceNumber) {
    
    if(sourceNumber != null && sourceNumber.length() > 64) {
      
      throw new RuntimeException("SOURCE_NUMBER length exceeds 64 symbol(s): [" + sourceNumber + "]");
      
    }
    
    this.sourceNumber = sourceNumber;
  }

  public java.lang.String getSourceSpc() {
    return sourceSpc;
  }

  public void setSourceSpc(java.lang.String sourceSpc) {
    
    if(sourceSpc != null && sourceSpc.length() > 32) {
      
      throw new RuntimeException("SOURCE_SPC length exceeds 32 symbol(s): [" + sourceSpc + "]");
      
    }
    
    this.sourceSpc = sourceSpc;
  }

  public java.lang.String getSourceAccType() {
    return sourceAccType;
  }

  public void setSourceAccType(java.lang.String sourceAccType) {
    
    if(sourceAccType != null && sourceAccType.length() > 32) {
      
      throw new RuntimeException("SOURCE_ACC_TYPE length exceeds 32 symbol(s): [" + sourceAccType + "]");
      
    }
    
    this.sourceAccType = sourceAccType;
  }

  public java.lang.Long getSourceContract() {
    return sourceContract;
  }

  public void setSourceContract(java.lang.Long sourceContract) {
    
    this.sourceContract = sourceContract;
  }

  public java.lang.Long getSourceService() {
    return sourceService;
  }

  public void setSourceService(java.lang.Long sourceService) {
    
    this.sourceService = sourceService;
  }

  public java.lang.String getTargetChannel() {
    return targetChannel;
  }

  public void setTargetChannel(java.lang.String targetChannel) {
    
    if(targetChannel != null && targetChannel.length() > 1) {
      
      throw new RuntimeException("TARGET_CHANNEL length exceeds 1 symbol(s): [" + targetChannel + "]");
      
    }
    
    this.targetChannel = targetChannel;
  }

  public java.lang.String getTCat() {
    return tCat;
  }

  public void setTCat(java.lang.String tCat) {
    
    if(tCat != null && tCat.length() > 1) {
      
      throw new RuntimeException("T_CAT length exceeds 1 symbol(s): [" + tCat + "]");
      
    }
    
    this.tCat = tCat;
  }

  public java.lang.String getTargetIdtScheme() {
    return targetIdtScheme;
  }

  public void setTargetIdtScheme(java.lang.String targetIdtScheme) {
    
    if(targetIdtScheme != null && targetIdtScheme.length() > 32) {
      
      throw new RuntimeException("TARGET_IDT_SCHEME length exceeds 32 symbol(s): [" + targetIdtScheme + "]");
      
    }
    
    this.targetIdtScheme = targetIdtScheme;
  }

  public java.lang.String getTargetMemberId() {
    return targetMemberId;
  }

  public void setTargetMemberId(java.lang.String targetMemberId) {
    
    if(targetMemberId != null && targetMemberId.length() > 32) {
      
      throw new RuntimeException("TARGET_MEMBER_ID length exceeds 32 symbol(s): [" + targetMemberId + "]");
      
    }
    
    this.targetMemberId = targetMemberId;
  }

  public java.lang.String getSendMemberId() {
    return sendMemberId;
  }

  public void setSendMemberId(java.lang.String sendMemberId) {
    
    if(sendMemberId != null && sendMemberId.length() > 32) {
      
      throw new RuntimeException("SEND_MEMBER_ID length exceeds 32 symbol(s): [" + sendMemberId + "]");
      
    }
    
    this.sendMemberId = sendMemberId;
  }

  public java.lang.String getSendingBin() {
    return sendingBin;
  }

  public void setSendingBin(java.lang.String sendingBin) {
    
    if(sendingBin != null && sendingBin.length() > 32) {
      
      throw new RuntimeException("SENDING_BIN length exceeds 32 symbol(s): [" + sendingBin + "]");
      
    }
    
    this.sendingBin = sendingBin;
  }

  public java.lang.Long getTargetBinId() {
    return targetBinId;
  }

  public void setTargetBinId(java.lang.Long targetBinId) {
    
    this.targetBinId = targetBinId;
  }

  public java.lang.String getTargetNumber() {
    return targetNumber;
  }

  public void setTargetNumber(java.lang.String targetNumber) {
    
    if(targetNumber != null && targetNumber.length() > 64) {
      
      throw new RuntimeException("TARGET_NUMBER length exceeds 64 symbol(s): [" + targetNumber + "]");
      
    }
    
    this.targetNumber = targetNumber;
  }

  public java.lang.String getTargetSpc() {
    return targetSpc;
  }

  public void setTargetSpc(java.lang.String targetSpc) {
    
    if(targetSpc != null && targetSpc.length() > 32) {
      
      throw new RuntimeException("TARGET_SPC length exceeds 32 symbol(s): [" + targetSpc + "]");
      
    }
    
    this.targetSpc = targetSpc;
  }

  public java.lang.String getTargetAccType() {
    return targetAccType;
  }

  public void setTargetAccType(java.lang.String targetAccType) {
    
    if(targetAccType != null && targetAccType.length() > 32) {
      
      throw new RuntimeException("TARGET_ACC_TYPE length exceeds 32 symbol(s): [" + targetAccType + "]");
      
    }
    
    this.targetAccType = targetAccType;
  }

  public java.lang.Long getTargetContract() {
    return targetContract;
  }

  public void setTargetContract(java.lang.Long targetContract) {
    
    this.targetContract = targetContract;
  }

  public java.lang.Long getTargetService() {
    return targetService;
  }

  public void setTargetService(java.lang.Long targetService) {
    
    this.targetService = targetService;
  }

  public java.lang.String getCardExpire() {
    return cardExpire;
  }

  public void setCardExpire(java.lang.String cardExpire) {
    
    if(cardExpire != null && cardExpire.length() > 4) {
      
      throw new RuntimeException("CARD_EXPIRE length exceeds 4 symbol(s): [" + cardExpire + "]");
      
    }
    
    this.cardExpire = cardExpire;
  }

  public java.lang.String getCardSeqvNumber() {
    return cardSeqvNumber;
  }

  public void setCardSeqvNumber(java.lang.String cardSeqvNumber) {
    
    if(cardSeqvNumber != null && cardSeqvNumber.length() > 32) {
      
      throw new RuntimeException("CARD_SEQV_NUMBER length exceeds 32 symbol(s): [" + cardSeqvNumber + "]");
      
    }
    
    this.cardSeqvNumber = cardSeqvNumber;
  }

  public java.lang.String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(java.lang.String merchantId) {
    
    if(merchantId != null && merchantId.length() > 32) {
      
      throw new RuntimeException("MERCHANT_ID length exceeds 32 symbol(s): [" + merchantId + "]");
      
    }
    
    this.merchantId = merchantId;
  }

  public java.lang.String getSicCode() {
    return sicCode;
  }

  public void setSicCode(java.lang.String sicCode) {
    
    if(sicCode != null && sicCode.length() > 4) {
      
      throw new RuntimeException("SIC_CODE length exceeds 4 symbol(s): [" + sicCode + "]");
      
    }
    
    this.sicCode = sicCode;
  }

  public java.lang.String getTransCondition() {
    return transCondition;
  }

  public void setTransCondition(java.lang.String transCondition) {
    
    if(transCondition != null && transCondition.length() > 32) {
      
      throw new RuntimeException("TRANS_CONDITION length exceeds 32 symbol(s): [" + transCondition + "]");
      
    }
    
    this.transCondition = transCondition;
  }

  public java.lang.Long getTransCondAttr() {
    return transCondAttr;
  }

  public void setTransCondAttr(java.lang.Long transCondAttr) {
    
    this.transCondAttr = transCondAttr;
  }

  public java.lang.Long getSecTransCondAtt() {
    return secTransCondAtt;
  }

  public void setSecTransCondAtt(java.lang.Long secTransCondAtt) {
    
    this.secTransCondAtt = secTransCondAtt;
  }

  public java.lang.String getReconsCurr() {
    return reconsCurr;
  }

  public void setReconsCurr(java.lang.String reconsCurr) {
    
    if(reconsCurr != null && reconsCurr.length() > 3) {
      
      throw new RuntimeException("RECONS_CURR length exceeds 3 symbol(s): [" + reconsCurr + "]");
      
    }
    
    this.reconsCurr = reconsCurr;
  }

  public java.math.BigDecimal getReconsAmount() {
    return reconsAmount;
  }

  public void setReconsAmount(java.math.BigDecimal reconsAmount) {
    
    this.reconsAmount = reconsAmount;
  }

  public java.lang.String getSettlCurr() {
    return settlCurr;
  }

  public void setSettlCurr(java.lang.String settlCurr) {
    
    if(settlCurr != null && settlCurr.length() > 3) {
      
      throw new RuntimeException("SETTL_CURR length exceeds 3 symbol(s): [" + settlCurr + "]");
      
    }
    
    this.settlCurr = settlCurr;
  }

  public java.math.BigDecimal getSettlAmount() {
    return settlAmount;
  }

  public void setSettlAmount(java.math.BigDecimal settlAmount) {
    
    this.settlAmount = settlAmount;
  }

  public java.lang.String getSourceFeeCurr() {
    return sourceFeeCurr;
  }

  public void setSourceFeeCurr(java.lang.String sourceFeeCurr) {
    
    if(sourceFeeCurr != null && sourceFeeCurr.length() > 3) {
      
      throw new RuntimeException("SOURCE_FEE_CURR length exceeds 3 symbol(s): [" + sourceFeeCurr + "]");
      
    }
    
    this.sourceFeeCurr = sourceFeeCurr;
  }

  public java.math.BigDecimal getSourceFeeAmount() {
    return sourceFeeAmount;
  }

  public void setSourceFeeAmount(java.math.BigDecimal sourceFeeAmount) {
    
    this.sourceFeeAmount = sourceFeeAmount;
  }

  public java.lang.String getTargetFeeCurr() {
    return targetFeeCurr;
  }

  public void setTargetFeeCurr(java.lang.String targetFeeCurr) {
    
    if(targetFeeCurr != null && targetFeeCurr.length() > 3) {
      
      throw new RuntimeException("TARGET_FEE_CURR length exceeds 3 symbol(s): [" + targetFeeCurr + "]");
      
    }
    
    this.targetFeeCurr = targetFeeCurr;
  }

  public java.math.BigDecimal getTargetFeeAmount() {
    return targetFeeAmount;
  }

  public void setTargetFeeAmount(java.math.BigDecimal targetFeeAmount) {
    
    this.targetFeeAmount = targetFeeAmount;
  }

  public java.sql.Timestamp getTransDate() {
    return transDate;
  }

  public void setTransDate(java.sql.Timestamp transDate) {
    
    this.transDate = transDate;
  }

  public java.sql.Timestamp getSecTransDate() {
    return secTransDate;
  }

  public void setSecTransDate(java.sql.Timestamp secTransDate) {
    
    this.secTransDate = secTransDate;
  }

  public java.lang.String getTransCountry() {
    return transCountry;
  }

  public void setTransCountry(java.lang.String transCountry) {
    
    if(transCountry != null && transCountry.length() > 3) {
      
      throw new RuntimeException("TRANS_COUNTRY length exceeds 3 symbol(s): [" + transCountry + "]");
      
    }
    
    this.transCountry = transCountry;
  }

  public java.lang.String getTransState() {
    return transState;
  }

  public void setTransState(java.lang.String transState) {
    
    if(transState != null && transState.length() > 32) {
      
      throw new RuntimeException("TRANS_STATE length exceeds 32 symbol(s): [" + transState + "]");
      
    }
    
    this.transState = transState;
  }

  public java.lang.String getTransCity() {
    return transCity;
  }

  public void setTransCity(java.lang.String transCity) {
    
    if(transCity != null && transCity.length() > 32) {
      
      throw new RuntimeException("TRANS_CITY length exceeds 32 symbol(s): [" + transCity + "]");
      
    }
    
    this.transCity = transCity;
  }

  public java.lang.String getTransDetails() {
    return transDetails;
  }

  public void setTransDetails(java.lang.String transDetails) {
    
    if(transDetails != null && transDetails.length() > 255) {
      
      throw new RuntimeException("TRANS_DETAILS length exceeds 255 symbol(s): [" + transDetails + "]");
      
    }
    
    this.transDetails = transDetails;
  }

  public java.math.BigDecimal getTransAmount() {
    return transAmount;
  }

  public void setTransAmount(java.math.BigDecimal transAmount) {
    
    this.transAmount = transAmount;
  }

  public java.lang.String getTransCurr() {
    return transCurr;
  }

  public void setTransCurr(java.lang.String transCurr) {
    
    if(transCurr != null && transCurr.length() > 3) {
      
      throw new RuntimeException("TRANS_CURR length exceeds 3 symbol(s): [" + transCurr + "]");
      
    }
    
    this.transCurr = transCurr;
  }

  public java.lang.Long getBinRecord() {
    return binRecord;
  }

  public void setBinRecord(java.lang.Long binRecord) {
    
    this.binRecord = binRecord;
  }

  public java.lang.String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(java.lang.String reasonCode) {
    
    if(reasonCode != null && reasonCode.length() > 4) {
      
      throw new RuntimeException("REASON_CODE length exceeds 4 symbol(s): [" + reasonCode + "]");
      
    }
    
    this.reasonCode = reasonCode;
  }

  public java.lang.String getReasonDetails() {
    return reasonDetails;
  }

  public void setReasonDetails(java.lang.String reasonDetails) {
    
    if(reasonDetails != null && reasonDetails.length() > 255) {
      
      throw new RuntimeException("REASON_DETAILS length exceeds 255 symbol(s): [" + reasonDetails + "]");
      
    }
    
    this.reasonDetails = reasonDetails;
  }

  public java.lang.String getRequirement() {
    return requirement;
  }

  public void setRequirement(java.lang.String requirement) {
    
    if(requirement != null && requirement.length() > 4) {
      
      throw new RuntimeException("REQUIREMENT length exceeds 4 symbol(s): [" + requirement + "]");
      
    }
    
    this.requirement = requirement;
  }

  public java.sql.Timestamp getPostingDate() {
    return postingDate;
  }

  public void setPostingDate(java.sql.Timestamp postingDate) {
    
    this.postingDate = postingDate;
  }

  public java.sql.Timestamp getFxSettlDate() {
    return fxSettlDate;
  }

  public void setFxSettlDate(java.sql.Timestamp fxSettlDate) {
    
    this.fxSettlDate = fxSettlDate;
  }

  public java.lang.String getPostingStatus() {
    return postingStatus;
  }

  public void setPostingStatus(java.lang.String postingStatus) {
    
    if(postingStatus != null && postingStatus.length() > 1) {
      
      throw new RuntimeException("POSTING_STATUS length exceeds 1 symbol(s): [" + postingStatus + "]");
      
    }
    
    this.postingStatus = postingStatus;
  }

  public java.lang.String getOutwardStatus() {
    return outwardStatus;
  }

  public void setOutwardStatus(java.lang.String outwardStatus) {
    
    if(outwardStatus != null && outwardStatus.length() > 1) {
      
      throw new RuntimeException("OUTWARD_STATUS length exceeds 1 symbol(s): [" + outwardStatus + "]");
      
    }
    
    this.outwardStatus = outwardStatus;
  }

  public java.lang.Long getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(java.lang.Long returnCode) {
    
    this.returnCode = returnCode;
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

  public java.lang.String getProcessingCode() {
    return processingCode;
  }

  public void setProcessingCode(java.lang.String processingCode) {
    
    if(processingCode != null && processingCode.length() > 6) {
      
      throw new RuntimeException("PROCESSING_CODE length exceeds 6 symbol(s): [" + processingCode + "]");
      
    }
    
    this.processingCode = processingCode;
  }

  public java.lang.String getSystemTraceNumber() {
    return systemTraceNumber;
  }

  public void setSystemTraceNumber(java.lang.String systemTraceNumber) {
    
    if(systemTraceNumber != null && systemTraceNumber.length() > 6) {
      
      throw new RuntimeException("SYSTEM_TRACE_NUMBER length exceeds 6 symbol(s): [" + systemTraceNumber + "]");
      
    }
    
    this.systemTraceNumber = systemTraceNumber;
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

  public java.lang.String getRbsStatus() {
    return rbsStatus;
  }

  public void setRbsStatus(java.lang.String rbsStatus) {
    
    if(rbsStatus != null && rbsStatus.length() > 20) {
      
      throw new RuntimeException("RBS_STATUS length exceeds 20 symbol(s): [" + rbsStatus + "]");
      
    }
    
    this.rbsStatus = rbsStatus;
  }

  public java.lang.String getProcessDate() {
    return processDate;
  }

  public void setProcessDate(java.lang.String processDate) {
    
    if(processDate != null && processDate.length() > 12) {
      
      throw new RuntimeException("PROCESS_DATE length exceeds 12 symbol(s): [" + processDate + "]");
      
    }
    
    this.processDate = processDate;
  }

  public java.lang.String getFileType() {
    return fileType;
  }

  public void setFileType(java.lang.String fileType) {
    
    if(fileType != null && fileType.length() > 50) {
      
      throw new RuntimeException("FILE_TYPE length exceeds 50 symbol(s): [" + fileType + "]");
      
    }
    
    this.fileType = fileType;
  }

  public java.lang.String getFileName() {
    return fileName;
  }

  public void setFileName(java.lang.String fileName) {
    
    if(fileName != null && fileName.length() > 50) {
      
      throw new RuntimeException("FILE_NAME length exceeds 50 symbol(s): [" + fileName + "]");
      
    }
    
    this.fileName = fileName;
  }

  public java.lang.String getPartitionKey() {
    return partitionKey;
  }

  public void setPartitionKey(java.lang.String partitionKey) {
    
    if(partitionKey != null && partitionKey.length() > 32) {
      
      throw new RuntimeException("PARTITION_KEY length exceeds 32 symbol(s): [" + partitionKey + "]");
      
    }
    
    this.partitionKey = partitionKey;
  }

  public java.lang.String getSynchTag() {
    return synchTag;
  }

  public void setSynchTag(java.lang.String synchTag) {
    
    if(synchTag != null && synchTag.length() > 1) {
      
      throw new RuntimeException("SYNCH_TAG length exceeds 1 symbol(s): [" + synchTag + "]");
      
    }
    
    this.synchTag = synchTag;
  }

  public java.lang.Long getForDisputeCode() {
    return forDisputeCode;
  }

  public void setForDisputeCode(java.lang.Long forDisputeCode) {
    
    this.forDisputeCode = forDisputeCode;
  }

  public void reset() {

    this.amndState = null;

    this.amndOfficer = null;

    this.amndDate = null;

    this.amndPrev = null;

    this.id = null;

    this.docOrigId = null;

    this.docPrevId = null;

    this.docSummId = null;

    this.numberOfSubS = null;

    this.numberInChain = null;

    this.action = null;

    this.messageCategory = null;

    this.sourceRegNum = null;

    this.acqRefNumber = null;

    this.retRefNumber = null;

    this.issRefNumber = null;

    this.psRefNumber = null;

    this.nwRefDate = null;

    this.authCode = null;

    this.isAuthorization = null;

    this.requestCategory = null;

    this.serviceClass = null;

    this.sourceCode = null;

    this.sourceFeeCode = null;

    this.targetCode = null;

    this.targetFeeCode = null;

    this.transType = null;

    this.sourceChannel = null;

    this.sCat = null;

    this.sourceIdtScheme = null;

    this.sourceMemberId = null;

    this.recMemberId = null;

    this.sourceNumber = null;

    this.sourceSpc = null;

    this.sourceAccType = null;

    this.sourceContract = null;

    this.sourceService = null;

    this.targetChannel = null;

    this.tCat = null;

    this.targetIdtScheme = null;

    this.targetMemberId = null;

    this.sendMemberId = null;

    this.sendingBin = null;

    this.targetBinId = null;

    this.targetNumber = null;

    this.targetSpc = null;

    this.targetAccType = null;

    this.targetContract = null;

    this.targetService = null;

    this.cardExpire = null;

    this.cardSeqvNumber = null;

    this.merchantId = null;

    this.sicCode = null;

    this.transCondition = null;

    this.transCondAttr = null;

    this.secTransCondAtt = null;

    this.reconsCurr = null;

    this.reconsAmount = null;

    this.settlCurr = null;

    this.settlAmount = null;

    this.sourceFeeCurr = null;

    this.sourceFeeAmount = null;

    this.targetFeeCurr = null;

    this.targetFeeAmount = null;

    this.transDate = null;

    this.secTransDate = null;

    this.transCountry = null;

    this.transState = null;

    this.transCity = null;

    this.transDetails = null;

    this.transAmount = null;

    this.transCurr = null;

    this.binRecord = null;

    this.reasonCode = null;

    this.reasonDetails = null;

    this.requirement = null;

    this.postingDate = null;

    this.fxSettlDate = null;

    this.postingStatus = null;

    this.outwardStatus = null;

    this.returnCode = null;

    this.addInfo = null;

    this.processingCode = null;

    this.systemTraceNumber = null;

    this.status = null;

    this.rbsStatus = null;

    this.processDate = null;

    this.fileType = null;

    this.fileName = null;

    this.partitionKey = null;

    this.synchTag = null;

    this.forDisputeCode = null;

  }
}


