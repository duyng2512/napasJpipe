package com.openwaygroup.pipe.napasincoming.autogen;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileSourceBuffer;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileSourceBufferRecord;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldString;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldNumber;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldDatetime;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldLong;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldBool;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferFieldBytes;
import com.openwaygroup.application.pipe.impl.filer.source.FlatFileBufferField;
import com.openwaygroup.application.pipe.impl.filer.source.IConditionCalculation;
import com.openwaygroup.application.pipe.util.DataConverter;
import java.math.BigDecimal;
import java.sql.Timestamp;


public class Source extends FlatFileSourceBuffer {

  FlatFileBufferFieldDatetime FileGeneratingDate;
  FlatFileBufferFieldString FileTarget;
  FlatFileBufferFieldString BankName;
  FlatFileBufferFieldString MemberBankCode;
  FlatFileBufferFieldString OrderNumber;
  FlatFileBufferFieldString FileType;
  FlatFileBufferFieldString FileService;
  FlatFileBufferFieldString HeaderRecord;
  FlatFileBufferFieldString Receiver;
  FlatFileBufferFieldString BIN;
  FlatFileBufferFieldString Date;
  FlatFileBufferFieldDatetime TransactionDate;
  FlatFileBufferFieldString DataRecord;
  FlatFileBufferFieldString MtiDef;
  FlatFileBufferFieldString MessageTypeIdentifierCode;
  FlatFileBufferFieldString F2;
  FlatFileBufferFieldString CardNumber;
  FlatFileBufferFieldString F3;
  FlatFileBufferFieldString ProcessingCode;
  FlatFileBufferFieldString SvcDef;
  FlatFileBufferFieldString NapasSvcCode;
  FlatFileBufferFieldString TccDef;
  FlatFileBufferFieldString TransactionChannelCode;
  FlatFileBufferFieldString F4;
  FlatFileBufferFieldString TransactionAmount;
  FlatFileBufferFieldString Rta;
  FlatFileBufferFieldString RealTransactionAmount;
  FlatFileBufferFieldString F49;
  FlatFileBufferFieldString TransactionCurrencyCode;
  FlatFileBufferFieldString F5;
  FlatFileBufferFieldString SettlementAmount;
  FlatFileBufferFieldString F50;
  FlatFileBufferFieldString SettlementCurrencyCode;
  FlatFileBufferFieldString F9;
  FlatFileBufferFieldString FxRate;
  FlatFileBufferFieldString F6;
  FlatFileBufferFieldString CardholderAmount;
  FlatFileBufferFieldString Rca;
  FlatFileBufferFieldString RealCardholerAmount;
  FlatFileBufferFieldString F51;
  FlatFileBufferFieldString CardholerCurrencyCode;
  FlatFileBufferFieldString F10;
  FlatFileBufferFieldString CardholderFxRate;
  FlatFileBufferFieldString F11;
  FlatFileBufferFieldString SystemTraceNumber;
  FlatFileBufferFieldString F12;
  FlatFileBufferFieldString LocalTransactionTime;
  FlatFileBufferFieldString F13;
  FlatFileBufferFieldString LocalTransactionDate;
  FlatFileBufferFieldString F15;
  FlatFileBufferFieldString SettlementDate;
  FlatFileBufferFieldString F18;
  FlatFileBufferFieldString TerminalType;
  FlatFileBufferFieldString F22;
  FlatFileBufferFieldString ServiceCode;
  FlatFileBufferFieldString F25;
  FlatFileBufferFieldString ServiceConditionCode;
  FlatFileBufferFieldString F41;
  FlatFileBufferFieldString CardAcceptorTerminalIdentification;
  FlatFileBufferFieldString Acq;
  FlatFileBufferFieldString AcquiringInstitutionCode;
  FlatFileBufferFieldString Iss;
  FlatFileBufferFieldString IssuerMemberId;
  FlatFileBufferFieldString Mid;
  FlatFileBufferFieldString MerchantIdentificationCode;
  FlatFileBufferFieldString Bnb;
  FlatFileBufferFieldString BeneficiaryIdentify;
  FlatFileBufferFieldString F102;
  FlatFileBufferFieldString FromAccount;
  FlatFileBufferFieldString F103;
  FlatFileBufferFieldString ToAccount;
  FlatFileBufferFieldString Svfissnp;
  FlatFileBufferFieldString SvFeeIssNapas;
  FlatFileBufferFieldString Irfissacq;
  FlatFileBufferFieldString IrFeeIssAcq;
  FlatFileBufferFieldString Irfissbnb;
  FlatFileBufferFieldString IrFeeIssBnb;
  FlatFileBufferFieldString Svfacqnp;
  FlatFileBufferFieldString SvFeeAcqNapas;
  FlatFileBufferFieldString Irfacqiss;
  FlatFileBufferFieldString IrFeeAcqIss;
  FlatFileBufferFieldString Irfacqbnb;
  FlatFileBufferFieldString IrFeeAcqBnb;
  FlatFileBufferFieldString Svfbnbnp;
  FlatFileBufferFieldString SvFeeBnbNapas;
  FlatFileBufferFieldString Irfbnbiss;
  FlatFileBufferFieldString IrFeeBnbIss;
  FlatFileBufferFieldString Irfbnbacq;
  FlatFileBufferFieldString IrFeeBnbAcq;
  FlatFileBufferFieldString F37;
  FlatFileBufferFieldString Rrn;
  FlatFileBufferFieldString F38;
  FlatFileBufferFieldString AuthorizationNumber;
  FlatFileBufferFieldString Trn;
  FlatFileBufferFieldString TransactionReferenceNumber;
  FlatFileBufferFieldString Rrc;
  FlatFileBufferFieldString ResponseCode;
  FlatFileBufferFieldString Rsv1Def;
  FlatFileBufferFieldString Rsv1;
  FlatFileBufferFieldString Rsv2Def;
  FlatFileBufferFieldString Rsv2;
  FlatFileBufferFieldString Rsv3Def;
  FlatFileBufferFieldString Rsv3;
  FlatFileBufferFieldString Csr;
  FlatFileBufferFieldString ChecksumRecordValue;
  FlatFileBufferFieldString TrailerRecord;
  FlatFileBufferFieldString Not;
  FlatFileBufferFieldString NumberofRecordsinTheFile;
  FlatFileBufferFieldString Cre;
  FlatFileBufferFieldString Generator;
  FlatFileBufferFieldString Time;
  FlatFileBufferFieldString FileGenerationTime;
  FlatFileBufferFieldString FileGenerationDate;
  FlatFileBufferFieldString Csf;
  FlatFileBufferFieldString ChecksumFileValue;

  public Timestamp getFileGeneratingDate() {return FileGeneratingDate.getValue();}
  public String getFileTarget() {return FileTarget.getValue();}
  public String getBankName() {return BankName.getValue();}
  public String getMemberBankCode() {return MemberBankCode.getValue();}
  public String getOrderNumber() {return OrderNumber.getValue();}
  public String getFileType() {return FileType.getValue();}
  public String getFileService() {return FileService.getValue();}
  public String getHeaderRecord() {return HeaderRecord.getValue();}
  public String getReceiver() {return Receiver.getValue();}
  public String getBin() {return BIN.getValue();}
  public String getDate() {return Date.getValue();}
  public Timestamp getTransactionDate() {return TransactionDate.getValue();}
  public String getDataRecord() {return DataRecord.getValue();}
  public String getMtiDef() {return MtiDef.getValue();}
  public String getMessageTypeIdentifierCode() {return MessageTypeIdentifierCode.getValue();}
  public String getF2() {return F2.getValue();}
  public String getCardNumber() {return CardNumber.getValue();}
  public String getF3() {return F3.getValue();}
  public String getProcessingCode() {return ProcessingCode.getValue();}
  public String getSvcDef() {return SvcDef.getValue();}
  public String getNapasSvcCode() {return NapasSvcCode.getValue();}
  public String getTccDef() {return TccDef.getValue();}
  public String getTransactionChannelCode() {return TransactionChannelCode.getValue();}
  public String getF4() {return F4.getValue();}
  public String getTransactionAmount() {return TransactionAmount.getValue();}
  public String getRta() {return Rta.getValue();}
  public String getRealTransactionAmount() {return RealTransactionAmount.getValue();}
  public String getF49() {return F49.getValue();}
  public String getTransactionCurrencyCode() {return TransactionCurrencyCode.getValue();}
  public String getF5() {return F5.getValue();}
  public String getSettlementAmount() {return SettlementAmount.getValue();}
  public String getF50() {return F50.getValue();}
  public String getSettlementCurrencyCode() {return SettlementCurrencyCode.getValue();}
  public String getF9() {return F9.getValue();}
  public String getFxRate() {return FxRate.getValue();}
  public String getF6() {return F6.getValue();}
  public String getCardholderAmount() {return CardholderAmount.getValue();}
  public String getRca() {return Rca.getValue();}
  public String getRealCardholerAmount() {return RealCardholerAmount.getValue();}
  public String getF51() {return F51.getValue();}
  public String getCardholerCurrencyCode() {return CardholerCurrencyCode.getValue();}
  public String getF10() {return F10.getValue();}
  public String getCardholderFxRate() {return CardholderFxRate.getValue();}
  public String getF11() {return F11.getValue();}
  public String getSystemTraceNumber() {return SystemTraceNumber.getValue();}
  public String getF12() {return F12.getValue();}
  public String getLocalTransactionTime() {return LocalTransactionTime.getValue();}
  public String getF13() {return F13.getValue();}
  public String getLocalTransactionDate() {return LocalTransactionDate.getValue();}
  public String getF15() {return F15.getValue();}
  public String getSettlementDate() {return SettlementDate.getValue();}
  public String getF18() {return F18.getValue();}
  public String getTerminalType() {return TerminalType.getValue();}
  public String getF22() {return F22.getValue();}
  public String getServiceCode() {return ServiceCode.getValue();}
  public String getF25() {return F25.getValue();}
  public String getServiceConditionCode() {return ServiceConditionCode.getValue();}
  public String getF41() {return F41.getValue();}
  public String getCardAcceptorTerminalIdentification() {return CardAcceptorTerminalIdentification.getValue();}
  public String getAcq() {return Acq.getValue();}
  public String getAcquiringInstitutionCode() {return AcquiringInstitutionCode.getValue();}
  public String getIss() {return Iss.getValue();}
  public String getIssuerMemberId() {return IssuerMemberId.getValue();}
  public String getMid() {return Mid.getValue();}
  public String getMerchantIdentificationCode() {return MerchantIdentificationCode.getValue();}
  public String getBnb() {return Bnb.getValue();}
  public String getBeneficiaryIdentify() {return BeneficiaryIdentify.getValue();}
  public String getF102() {return F102.getValue();}
  public String getFromAccount() {return FromAccount.getValue();}
  public String getF103() {return F103.getValue();}
  public String getToAccount() {return ToAccount.getValue();}
  public String getSvfissnp() {return Svfissnp.getValue();}
  public String getSvFeeIssNapas() {return SvFeeIssNapas.getValue();}
  public String getIrfissacq() {return Irfissacq.getValue();}
  public String getIrFeeIssAcq() {return IrFeeIssAcq.getValue();}
  public String getIrfissbnb() {return Irfissbnb.getValue();}
  public String getIrFeeIssBnb() {return IrFeeIssBnb.getValue();}
  public String getSvfacqnp() {return Svfacqnp.getValue();}
  public String getSvFeeAcqNapas() {return SvFeeAcqNapas.getValue();}
  public String getIrfacqiss() {return Irfacqiss.getValue();}
  public String getIrFeeAcqIss() {return IrFeeAcqIss.getValue();}
  public String getIrfacqbnb() {return Irfacqbnb.getValue();}
  public String getIrFeeAcqBnb() {return IrFeeAcqBnb.getValue();}
  public String getSvfbnbnp() {return Svfbnbnp.getValue();}
  public String getSvFeeBnbNapas() {return SvFeeBnbNapas.getValue();}
  public String getIrfbnbiss() {return Irfbnbiss.getValue();}
  public String getIrFeeBnbIss() {return IrFeeBnbIss.getValue();}
  public String getIrfbnbacq() {return Irfbnbacq.getValue();}
  public String getIrFeeBnbAcq() {return IrFeeBnbAcq.getValue();}
  public String getF37() {return F37.getValue();}
  public String getRrn() {return Rrn.getValue();}
  public String getF38() {return F38.getValue();}
  public String getAuthorizationNumber() {return AuthorizationNumber.getValue();}
  public String getTrn() {return Trn.getValue();}
  public String getTransactionReferenceNumber() {return TransactionReferenceNumber.getValue();}
  public String getRrc() {return Rrc.getValue();}
  public String getResponseCode() {return ResponseCode.getValue();}
  public String getRsv1Def() {return Rsv1Def.getValue();}
  public String getRsv1() {return Rsv1.getValue();}
  public String getRsv2Def() {return Rsv2Def.getValue();}
  public String getRsv2() {return Rsv2.getValue();}
  public String getRsv3Def() {return Rsv3Def.getValue();}
  public String getRsv3() {return Rsv3.getValue();}
  public String getCsr() {return Csr.getValue();}
  public String getChecksumRecordValue() {return ChecksumRecordValue.getValue();}
  public String getTrailerRecord() {return TrailerRecord.getValue();}
  public String getNot() {return Not.getValue();}
  public String getNumberofRecordsinTheFile() {return NumberofRecordsinTheFile.getValue();}
  public String getCre() {return Cre.getValue();}
  public String getGenerator() {return Generator.getValue();}
  public String getTime() {return Time.getValue();}
  public String getFileGenerationTime() {return FileGenerationTime.getValue();}
  public String getFileGenerationDate() {return FileGenerationDate.getValue();}
  public String getCsf() {return Csf.getValue();}
  public String getChecksumFileValue() {return ChecksumFileValue.getValue();}

  public void setFileGeneratingDate(Timestamp val) {FileGeneratingDate.setValue(val);}
  public void setFileTarget(String val) {FileTarget.setValue(val);}
  public void setBankName(String val) {BankName.setValue(val);}
  public void setMemberBankCode(String val) {MemberBankCode.setValue(val);}
  public void setOrderNumber(String val) {OrderNumber.setValue(val);}
  public void setFileType(String val) {FileType.setValue(val);}
  public void setFileService(String val) {FileService.setValue(val);}
  public void setHeaderRecord(String val) {HeaderRecord.setValue(val);}
  public void setReceiver(String val) {Receiver.setValue(val);}
  public void setBin(String val) {BIN.setValue(val);}
  public void setDate(String val) {Date.setValue(val);}
  public void setTransactionDate(Timestamp val) {TransactionDate.setValue(val);}
  public void setDataRecord(String val) {DataRecord.setValue(val);}
  public void setMtiDef(String val) {MtiDef.setValue(val);}
  public void setMessageTypeIdentifierCode(String val) {MessageTypeIdentifierCode.setValue(val);}
  public void setF2(String val) {F2.setValue(val);}
  public void setCardNumber(String val) {CardNumber.setValue(val);}
  public void setF3(String val) {F3.setValue(val);}
  public void setProcessingCode(String val) {ProcessingCode.setValue(val);}
  public void setSvcDef(String val) {SvcDef.setValue(val);}
  public void setNapasSvcCode(String val) {NapasSvcCode.setValue(val);}
  public void setTccDef(String val) {TccDef.setValue(val);}
  public void setTransactionChannelCode(String val) {TransactionChannelCode.setValue(val);}
  public void setF4(String val) {F4.setValue(val);}
  public void setTransactionAmount(String val) {TransactionAmount.setValue(val);}
  public void setRta(String val) {Rta.setValue(val);}
  public void setRealTransactionAmount(String val) {RealTransactionAmount.setValue(val);}
  public void setF49(String val) {F49.setValue(val);}
  public void setTransactionCurrencyCode(String val) {TransactionCurrencyCode.setValue(val);}
  public void setF5(String val) {F5.setValue(val);}
  public void setSettlementAmount(String val) {SettlementAmount.setValue(val);}
  public void setF50(String val) {F50.setValue(val);}
  public void setSettlementCurrencyCode(String val) {SettlementCurrencyCode.setValue(val);}
  public void setF9(String val) {F9.setValue(val);}
  public void setFxRate(String val) {FxRate.setValue(val);}
  public void setF6(String val) {F6.setValue(val);}
  public void setCardholderAmount(String val) {CardholderAmount.setValue(val);}
  public void setRca(String val) {Rca.setValue(val);}
  public void setRealCardholerAmount(String val) {RealCardholerAmount.setValue(val);}
  public void setF51(String val) {F51.setValue(val);}
  public void setCardholerCurrencyCode(String val) {CardholerCurrencyCode.setValue(val);}
  public void setF10(String val) {F10.setValue(val);}
  public void setCardholderFxRate(String val) {CardholderFxRate.setValue(val);}
  public void setF11(String val) {F11.setValue(val);}
  public void setSystemTraceNumber(String val) {SystemTraceNumber.setValue(val);}
  public void setF12(String val) {F12.setValue(val);}
  public void setLocalTransactionTime(String val) {LocalTransactionTime.setValue(val);}
  public void setF13(String val) {F13.setValue(val);}
  public void setLocalTransactionDate(String val) {LocalTransactionDate.setValue(val);}
  public void setF15(String val) {F15.setValue(val);}
  public void setSettlementDate(String val) {SettlementDate.setValue(val);}
  public void setF18(String val) {F18.setValue(val);}
  public void setTerminalType(String val) {TerminalType.setValue(val);}
  public void setF22(String val) {F22.setValue(val);}
  public void setServiceCode(String val) {ServiceCode.setValue(val);}
  public void setF25(String val) {F25.setValue(val);}
  public void setServiceConditionCode(String val) {ServiceConditionCode.setValue(val);}
  public void setF41(String val) {F41.setValue(val);}
  public void setCardAcceptorTerminalIdentification(String val) {CardAcceptorTerminalIdentification.setValue(val);}
  public void setAcq(String val) {Acq.setValue(val);}
  public void setAcquiringInstitutionCode(String val) {AcquiringInstitutionCode.setValue(val);}
  public void setIss(String val) {Iss.setValue(val);}
  public void setIssuerMemberId(String val) {IssuerMemberId.setValue(val);}
  public void setMid(String val) {Mid.setValue(val);}
  public void setMerchantIdentificationCode(String val) {MerchantIdentificationCode.setValue(val);}
  public void setBnb(String val) {Bnb.setValue(val);}
  public void setBeneficiaryIdentify(String val) {BeneficiaryIdentify.setValue(val);}
  public void setF102(String val) {F102.setValue(val);}
  public void setFromAccount(String val) {FromAccount.setValue(val);}
  public void setF103(String val) {F103.setValue(val);}
  public void setToAccount(String val) {ToAccount.setValue(val);}
  public void setSvfissnp(String val) {Svfissnp.setValue(val);}
  public void setSvFeeIssNapas(String val) {SvFeeIssNapas.setValue(val);}
  public void setIrfissacq(String val) {Irfissacq.setValue(val);}
  public void setIrFeeIssAcq(String val) {IrFeeIssAcq.setValue(val);}
  public void setIrfissbnb(String val) {Irfissbnb.setValue(val);}
  public void setIrFeeIssBnb(String val) {IrFeeIssBnb.setValue(val);}
  public void setSvfacqnp(String val) {Svfacqnp.setValue(val);}
  public void setSvFeeAcqNapas(String val) {SvFeeAcqNapas.setValue(val);}
  public void setIrfacqiss(String val) {Irfacqiss.setValue(val);}
  public void setIrFeeAcqIss(String val) {IrFeeAcqIss.setValue(val);}
  public void setIrfacqbnb(String val) {Irfacqbnb.setValue(val);}
  public void setIrFeeAcqBnb(String val) {IrFeeAcqBnb.setValue(val);}
  public void setSvfbnbnp(String val) {Svfbnbnp.setValue(val);}
  public void setSvFeeBnbNapas(String val) {SvFeeBnbNapas.setValue(val);}
  public void setIrfbnbiss(String val) {Irfbnbiss.setValue(val);}
  public void setIrFeeBnbIss(String val) {IrFeeBnbIss.setValue(val);}
  public void setIrfbnbacq(String val) {Irfbnbacq.setValue(val);}
  public void setIrFeeBnbAcq(String val) {IrFeeBnbAcq.setValue(val);}
  public void setF37(String val) {F37.setValue(val);}
  public void setRrn(String val) {Rrn.setValue(val);}
  public void setF38(String val) {F38.setValue(val);}
  public void setAuthorizationNumber(String val) {AuthorizationNumber.setValue(val);}
  public void setTrn(String val) {Trn.setValue(val);}
  public void setTransactionReferenceNumber(String val) {TransactionReferenceNumber.setValue(val);}
  public void setRrc(String val) {Rrc.setValue(val);}
  public void setResponseCode(String val) {ResponseCode.setValue(val);}
  public void setRsv1Def(String val) {Rsv1Def.setValue(val);}
  public void setRsv1(String val) {Rsv1.setValue(val);}
  public void setRsv2Def(String val) {Rsv2Def.setValue(val);}
  public void setRsv2(String val) {Rsv2.setValue(val);}
  public void setRsv3Def(String val) {Rsv3Def.setValue(val);}
  public void setRsv3(String val) {Rsv3.setValue(val);}
  public void setCsr(String val) {Csr.setValue(val);}
  public void setChecksumRecordValue(String val) {ChecksumRecordValue.setValue(val);}
  public void setTrailerRecord(String val) {TrailerRecord.setValue(val);}
  public void setNot(String val) {Not.setValue(val);}
  public void setNumberofRecordsinTheFile(String val) {NumberofRecordsinTheFile.setValue(val);}
  public void setCre(String val) {Cre.setValue(val);}
  public void setGenerator(String val) {Generator.setValue(val);}
  public void setTime(String val) {Time.setValue(val);}
  public void setFileGenerationTime(String val) {FileGenerationTime.setValue(val);}
  public void setFileGenerationDate(String val) {FileGenerationDate.setValue(val);}
  public void setCsf(String val) {Csf.setValue(val);}
  public void setChecksumFileValue(String val) {ChecksumFileValue.setValue(val);}

  public class FileNameRecord extends FlatFileSourceBufferRecord {
    public Timestamp getFileGeneratingDate() {return FileGeneratingDate.getValue();}
    public void setFileGeneratingDate(Timestamp val) {FileGeneratingDate.setValue(val);}
    public String getFileTarget() {return FileTarget.getValue();}
    public void setFileTarget(String val) {FileTarget.setValue(val);}
    public String getBankName() {return BankName.getValue();}
    public void setBankName(String val) {BankName.setValue(val);}
    public String getMemberBankCode() {return MemberBankCode.getValue();}
    public void setMemberBankCode(String val) {MemberBankCode.setValue(val);}
    public String getOrderNumber() {return OrderNumber.getValue();}
    public void setOrderNumber(String val) {OrderNumber.setValue(val);}
    public String getFileType() {return FileType.getValue();}
    public void setFileType(String val) {FileType.setValue(val);}
    public String getFileService() {return FileService.getValue();}
    public void setFileService(String val) {FileService.setValue(val);}
  }
  public class FileHeaderRecord extends FlatFileSourceBufferRecord {
    public String getHeaderRecord() {return HeaderRecord.getValue();}
    public void setHeaderRecord(String val) {HeaderRecord.setValue(val);}
    public String getReceiver() {return Receiver.getValue();}
    public void setReceiver(String val) {Receiver.setValue(val);}
    public String getBin() {return BIN.getValue();}
    public void setBin(String val) {BIN.setValue(val);}
    public String getDate() {return Date.getValue();}
    public void setDate(String val) {Date.setValue(val);}
    public Timestamp getTransactionDate() {return TransactionDate.getValue();}
    public void setTransactionDate(Timestamp val) {TransactionDate.setValue(val);}
  }
  public class FileDataRecord extends FlatFileSourceBufferRecord {
    public String getDataRecord() {return DataRecord.getValue();}
    public void setDataRecord(String val) {DataRecord.setValue(val);}
    public String getMtiDef() {return MtiDef.getValue();}
    public void setMtiDef(String val) {MtiDef.setValue(val);}
    public String getMessageTypeIdentifierCode() {return MessageTypeIdentifierCode.getValue();}
    public void setMessageTypeIdentifierCode(String val) {MessageTypeIdentifierCode.setValue(val);}
    public String getF2() {return F2.getValue();}
    public void setF2(String val) {F2.setValue(val);}
    public String getCardNumber() {return CardNumber.getValue();}
    public void setCardNumber(String val) {CardNumber.setValue(val);}
    public String getF3() {return F3.getValue();}
    public void setF3(String val) {F3.setValue(val);}
    public String getProcessingCode() {return ProcessingCode.getValue();}
    public void setProcessingCode(String val) {ProcessingCode.setValue(val);}
    public String getSvcDef() {return SvcDef.getValue();}
    public void setSvcDef(String val) {SvcDef.setValue(val);}
    public String getNapasSvcCode() {return NapasSvcCode.getValue();}
    public void setNapasSvcCode(String val) {NapasSvcCode.setValue(val);}
    public String getTccDef() {return TccDef.getValue();}
    public void setTccDef(String val) {TccDef.setValue(val);}
    public String getTransactionChannelCode() {return TransactionChannelCode.getValue();}
    public void setTransactionChannelCode(String val) {TransactionChannelCode.setValue(val);}
    public String getF4() {return F4.getValue();}
    public void setF4(String val) {F4.setValue(val);}
    public String getTransactionAmount() {return TransactionAmount.getValue();}
    public void setTransactionAmount(String val) {TransactionAmount.setValue(val);}
    public String getRta() {return Rta.getValue();}
    public void setRta(String val) {Rta.setValue(val);}
    public String getRealTransactionAmount() {return RealTransactionAmount.getValue();}
    public void setRealTransactionAmount(String val) {RealTransactionAmount.setValue(val);}
    public String getF49() {return F49.getValue();}
    public void setF49(String val) {F49.setValue(val);}
    public String getTransactionCurrencyCode() {return TransactionCurrencyCode.getValue();}
    public void setTransactionCurrencyCode(String val) {TransactionCurrencyCode.setValue(val);}
    public String getF5() {return F5.getValue();}
    public void setF5(String val) {F5.setValue(val);}
    public String getSettlementAmount() {return SettlementAmount.getValue();}
    public void setSettlementAmount(String val) {SettlementAmount.setValue(val);}
    public String getF50() {return F50.getValue();}
    public void setF50(String val) {F50.setValue(val);}
    public String getSettlementCurrencyCode() {return SettlementCurrencyCode.getValue();}
    public void setSettlementCurrencyCode(String val) {SettlementCurrencyCode.setValue(val);}
    public String getF9() {return F9.getValue();}
    public void setF9(String val) {F9.setValue(val);}
    public String getFxRate() {return FxRate.getValue();}
    public void setFxRate(String val) {FxRate.setValue(val);}
    public String getF6() {return F6.getValue();}
    public void setF6(String val) {F6.setValue(val);}
    public String getCardholderAmount() {return CardholderAmount.getValue();}
    public void setCardholderAmount(String val) {CardholderAmount.setValue(val);}
    public String getRca() {return Rca.getValue();}
    public void setRca(String val) {Rca.setValue(val);}
    public String getRealCardholerAmount() {return RealCardholerAmount.getValue();}
    public void setRealCardholerAmount(String val) {RealCardholerAmount.setValue(val);}
    public String getF51() {return F51.getValue();}
    public void setF51(String val) {F51.setValue(val);}
    public String getCardholerCurrencyCode() {return CardholerCurrencyCode.getValue();}
    public void setCardholerCurrencyCode(String val) {CardholerCurrencyCode.setValue(val);}
    public String getF10() {return F10.getValue();}
    public void setF10(String val) {F10.setValue(val);}
    public String getCardholderFxRate() {return CardholderFxRate.getValue();}
    public void setCardholderFxRate(String val) {CardholderFxRate.setValue(val);}
    public String getF11() {return F11.getValue();}
    public void setF11(String val) {F11.setValue(val);}
    public String getSystemTraceNumber() {return SystemTraceNumber.getValue();}
    public void setSystemTraceNumber(String val) {SystemTraceNumber.setValue(val);}
    public String getF12() {return F12.getValue();}
    public void setF12(String val) {F12.setValue(val);}
    public String getLocalTransactionTime() {return LocalTransactionTime.getValue();}
    public void setLocalTransactionTime(String val) {LocalTransactionTime.setValue(val);}
    public String getF13() {return F13.getValue();}
    public void setF13(String val) {F13.setValue(val);}
    public String getLocalTransactionDate() {return LocalTransactionDate.getValue();}
    public void setLocalTransactionDate(String val) {LocalTransactionDate.setValue(val);}
    public String getF15() {return F15.getValue();}
    public void setF15(String val) {F15.setValue(val);}
    public String getSettlementDate() {return SettlementDate.getValue();}
    public void setSettlementDate(String val) {SettlementDate.setValue(val);}
    public String getF18() {return F18.getValue();}
    public void setF18(String val) {F18.setValue(val);}
    public String getTerminalType() {return TerminalType.getValue();}
    public void setTerminalType(String val) {TerminalType.setValue(val);}
    public String getF22() {return F22.getValue();}
    public void setF22(String val) {F22.setValue(val);}
    public String getServiceCode() {return ServiceCode.getValue();}
    public void setServiceCode(String val) {ServiceCode.setValue(val);}
    public String getF25() {return F25.getValue();}
    public void setF25(String val) {F25.setValue(val);}
    public String getServiceConditionCode() {return ServiceConditionCode.getValue();}
    public void setServiceConditionCode(String val) {ServiceConditionCode.setValue(val);}
    public String getF41() {return F41.getValue();}
    public void setF41(String val) {F41.setValue(val);}
    public String getCardAcceptorTerminalIdentification() {return CardAcceptorTerminalIdentification.getValue();}
    public void setCardAcceptorTerminalIdentification(String val) {CardAcceptorTerminalIdentification.setValue(val);}
    public String getAcq() {return Acq.getValue();}
    public void setAcq(String val) {Acq.setValue(val);}
    public String getAcquiringInstitutionCode() {return AcquiringInstitutionCode.getValue();}
    public void setAcquiringInstitutionCode(String val) {AcquiringInstitutionCode.setValue(val);}
    public String getIss() {return Iss.getValue();}
    public void setIss(String val) {Iss.setValue(val);}
    public String getIssuerMemberId() {return IssuerMemberId.getValue();}
    public void setIssuerMemberId(String val) {IssuerMemberId.setValue(val);}
    public String getMid() {return Mid.getValue();}
    public void setMid(String val) {Mid.setValue(val);}
    public String getMerchantIdentificationCode() {return MerchantIdentificationCode.getValue();}
    public void setMerchantIdentificationCode(String val) {MerchantIdentificationCode.setValue(val);}
    public String getBnb() {return Bnb.getValue();}
    public void setBnb(String val) {Bnb.setValue(val);}
    public String getBeneficiaryIdentify() {return BeneficiaryIdentify.getValue();}
    public void setBeneficiaryIdentify(String val) {BeneficiaryIdentify.setValue(val);}
    public String getF102() {return F102.getValue();}
    public void setF102(String val) {F102.setValue(val);}
    public String getFromAccount() {return FromAccount.getValue();}
    public void setFromAccount(String val) {FromAccount.setValue(val);}
    public String getF103() {return F103.getValue();}
    public void setF103(String val) {F103.setValue(val);}
    public String getToAccount() {return ToAccount.getValue();}
    public void setToAccount(String val) {ToAccount.setValue(val);}
    public String getSvfissnp() {return Svfissnp.getValue();}
    public void setSvfissnp(String val) {Svfissnp.setValue(val);}
    public String getSvFeeIssNapas() {return SvFeeIssNapas.getValue();}
    public void setSvFeeIssNapas(String val) {SvFeeIssNapas.setValue(val);}
    public String getIrfissacq() {return Irfissacq.getValue();}
    public void setIrfissacq(String val) {Irfissacq.setValue(val);}
    public String getIrFeeIssAcq() {return IrFeeIssAcq.getValue();}
    public void setIrFeeIssAcq(String val) {IrFeeIssAcq.setValue(val);}
    public String getIrfissbnb() {return Irfissbnb.getValue();}
    public void setIrfissbnb(String val) {Irfissbnb.setValue(val);}
    public String getIrFeeIssBnb() {return IrFeeIssBnb.getValue();}
    public void setIrFeeIssBnb(String val) {IrFeeIssBnb.setValue(val);}
    public String getSvfacqnp() {return Svfacqnp.getValue();}
    public void setSvfacqnp(String val) {Svfacqnp.setValue(val);}
    public String getSvFeeAcqNapas() {return SvFeeAcqNapas.getValue();}
    public void setSvFeeAcqNapas(String val) {SvFeeAcqNapas.setValue(val);}
    public String getIrfacqiss() {return Irfacqiss.getValue();}
    public void setIrfacqiss(String val) {Irfacqiss.setValue(val);}
    public String getIrFeeAcqIss() {return IrFeeAcqIss.getValue();}
    public void setIrFeeAcqIss(String val) {IrFeeAcqIss.setValue(val);}
    public String getIrfacqbnb() {return Irfacqbnb.getValue();}
    public void setIrfacqbnb(String val) {Irfacqbnb.setValue(val);}
    public String getIrFeeAcqBnb() {return IrFeeAcqBnb.getValue();}
    public void setIrFeeAcqBnb(String val) {IrFeeAcqBnb.setValue(val);}
    public String getSvfbnbnp() {return Svfbnbnp.getValue();}
    public void setSvfbnbnp(String val) {Svfbnbnp.setValue(val);}
    public String getSvFeeBnbNapas() {return SvFeeBnbNapas.getValue();}
    public void setSvFeeBnbNapas(String val) {SvFeeBnbNapas.setValue(val);}
    public String getIrfbnbiss() {return Irfbnbiss.getValue();}
    public void setIrfbnbiss(String val) {Irfbnbiss.setValue(val);}
    public String getIrFeeBnbIss() {return IrFeeBnbIss.getValue();}
    public void setIrFeeBnbIss(String val) {IrFeeBnbIss.setValue(val);}
    public String getIrfbnbacq() {return Irfbnbacq.getValue();}
    public void setIrfbnbacq(String val) {Irfbnbacq.setValue(val);}
    public String getIrFeeBnbAcq() {return IrFeeBnbAcq.getValue();}
    public void setIrFeeBnbAcq(String val) {IrFeeBnbAcq.setValue(val);}
    public String getF37() {return F37.getValue();}
    public void setF37(String val) {F37.setValue(val);}
    public String getRrn() {return Rrn.getValue();}
    public void setRrn(String val) {Rrn.setValue(val);}
    public String getF38() {return F38.getValue();}
    public void setF38(String val) {F38.setValue(val);}
    public String getAuthorizationNumber() {return AuthorizationNumber.getValue();}
    public void setAuthorizationNumber(String val) {AuthorizationNumber.setValue(val);}
    public String getTrn() {return Trn.getValue();}
    public void setTrn(String val) {Trn.setValue(val);}
    public String getTransactionReferenceNumber() {return TransactionReferenceNumber.getValue();}
    public void setTransactionReferenceNumber(String val) {TransactionReferenceNumber.setValue(val);}
    public String getRrc() {return Rrc.getValue();}
    public void setRrc(String val) {Rrc.setValue(val);}
    public String getResponseCode() {return ResponseCode.getValue();}
    public void setResponseCode(String val) {ResponseCode.setValue(val);}
    public String getRsv1Def() {return Rsv1Def.getValue();}
    public void setRsv1Def(String val) {Rsv1Def.setValue(val);}
    public String getRsv1() {return Rsv1.getValue();}
    public void setRsv1(String val) {Rsv1.setValue(val);}
    public String getRsv2Def() {return Rsv2Def.getValue();}
    public void setRsv2Def(String val) {Rsv2Def.setValue(val);}
    public String getRsv2() {return Rsv2.getValue();}
    public void setRsv2(String val) {Rsv2.setValue(val);}
    public String getRsv3Def() {return Rsv3Def.getValue();}
    public void setRsv3Def(String val) {Rsv3Def.setValue(val);}
    public String getRsv3() {return Rsv3.getValue();}
    public void setRsv3(String val) {Rsv3.setValue(val);}
    public String getCsr() {return Csr.getValue();}
    public void setCsr(String val) {Csr.setValue(val);}
    public String getChecksumRecordValue() {return ChecksumRecordValue.getValue();}
    public void setChecksumRecordValue(String val) {ChecksumRecordValue.setValue(val);}
  }
  public class FileTrailerRecord extends FlatFileSourceBufferRecord {
    public String getTrailerRecord() {return TrailerRecord.getValue();}
    public void setTrailerRecord(String val) {TrailerRecord.setValue(val);}
    public String getNot() {return Not.getValue();}
    public void setNot(String val) {Not.setValue(val);}
    public String getNumberofRecordsinTheFile() {return NumberofRecordsinTheFile.getValue();}
    public void setNumberofRecordsinTheFile(String val) {NumberofRecordsinTheFile.setValue(val);}
    public String getCre() {return Cre.getValue();}
    public void setCre(String val) {Cre.setValue(val);}
    public String getGenerator() {return Generator.getValue();}
    public void setGenerator(String val) {Generator.setValue(val);}
    public String getTime() {return Time.getValue();}
    public void setTime(String val) {Time.setValue(val);}
    public String getFileGenerationTime() {return FileGenerationTime.getValue();}
    public void setFileGenerationTime(String val) {FileGenerationTime.setValue(val);}
    public String getDate() {return Date.getValue();}
    public void setDate(String val) {Date.setValue(val);}
    public String getFileGenerationDate() {return FileGenerationDate.getValue();}
    public void setFileGenerationDate(String val) {FileGenerationDate.setValue(val);}
    public String getCsf() {return Csf.getValue();}
    public void setCsf(String val) {Csf.setValue(val);}
    public String getChecksumFileValue() {return ChecksumFileValue.getValue();}
    public void setChecksumFileValue(String val) {ChecksumFileValue.setValue(val);}
  }


  public FileNameRecord getFileNameRecord() {return (FileNameRecord)records[0];}
  public FileHeaderRecord getFileHeaderRecord() {return (FileHeaderRecord)records[1];}
  public FileDataRecord getFileDataRecord() {return (FileDataRecord)records[2];}
  public FileTrailerRecord getFileTrailerRecord() {return (FileTrailerRecord)records[3];}

  public Source() {
    records = new FlatFileSourceBufferRecord[4];
    records[0] = new FileNameRecord();
    records[0].setName("FileNameRecord");
    records[1] = new FileHeaderRecord();
    records[1].setName("FileHeaderRecord");
    records[2] = new FileDataRecord();
    records[2].setName("FileDataRecord");
    records[3] = new FileTrailerRecord();
    records[3].setName("FileTrailerRecord");
    nOfRecords = 4;

    FileGeneratingDate = new FlatFileBufferFieldDatetime("FileGeneratingDate");
    FileTarget = new FlatFileBufferFieldString("FileTarget");
    BankName = new FlatFileBufferFieldString("BankName");
    MemberBankCode = new FlatFileBufferFieldString("MemberBankCode");
    OrderNumber = new FlatFileBufferFieldString("OrderNumber");
    FileType = new FlatFileBufferFieldString("FileType");
    FileService = new FlatFileBufferFieldString("FileService");
    HeaderRecord = new FlatFileBufferFieldString("HeaderRecord");
    Receiver = new FlatFileBufferFieldString("Receiver");
    BIN = new FlatFileBufferFieldString("BIN");
    Date = new FlatFileBufferFieldString("Date");
    TransactionDate = new FlatFileBufferFieldDatetime("TransactionDate");
    DataRecord = new FlatFileBufferFieldString("DataRecord");
    MtiDef = new FlatFileBufferFieldString("MtiDef");
    MessageTypeIdentifierCode = new FlatFileBufferFieldString("MessageTypeIdentifierCode");
    F2 = new FlatFileBufferFieldString("F2");
    CardNumber = new FlatFileBufferFieldString("CardNumber");
    F3 = new FlatFileBufferFieldString("F3");
    ProcessingCode = new FlatFileBufferFieldString("ProcessingCode");
    SvcDef = new FlatFileBufferFieldString("SvcDef");
    NapasSvcCode = new FlatFileBufferFieldString("NapasSvcCode");
    TccDef = new FlatFileBufferFieldString("TccDef");
    TransactionChannelCode = new FlatFileBufferFieldString("TransactionChannelCode");
    F4 = new FlatFileBufferFieldString("F4");
    TransactionAmount = new FlatFileBufferFieldString("TransactionAmount");
    Rta = new FlatFileBufferFieldString("Rta");
    RealTransactionAmount = new FlatFileBufferFieldString("RealTransactionAmount");
    F49 = new FlatFileBufferFieldString("F49");
    TransactionCurrencyCode = new FlatFileBufferFieldString("TransactionCurrencyCode");
    F5 = new FlatFileBufferFieldString("F5");
    SettlementAmount = new FlatFileBufferFieldString("SettlementAmount");
    F50 = new FlatFileBufferFieldString("F50");
    SettlementCurrencyCode = new FlatFileBufferFieldString("SettlementCurrencyCode");
    F9 = new FlatFileBufferFieldString("F9");
    FxRate = new FlatFileBufferFieldString("FxRate");
    F6 = new FlatFileBufferFieldString("F6");
    CardholderAmount = new FlatFileBufferFieldString("CardholderAmount");
    Rca = new FlatFileBufferFieldString("Rca");
    RealCardholerAmount = new FlatFileBufferFieldString("RealCardholerAmount");
    F51 = new FlatFileBufferFieldString("F51");
    CardholerCurrencyCode = new FlatFileBufferFieldString("CardholerCurrencyCode");
    F10 = new FlatFileBufferFieldString("F10");
    CardholderFxRate = new FlatFileBufferFieldString("CardholderFxRate");
    F11 = new FlatFileBufferFieldString("F11");
    SystemTraceNumber = new FlatFileBufferFieldString("SystemTraceNumber");
    F12 = new FlatFileBufferFieldString("F12");
    LocalTransactionTime = new FlatFileBufferFieldString("LocalTransactionTime");
    F13 = new FlatFileBufferFieldString("F13");
    LocalTransactionDate = new FlatFileBufferFieldString("LocalTransactionDate");
    F15 = new FlatFileBufferFieldString("F15");
    SettlementDate = new FlatFileBufferFieldString("SettlementDate");
    F18 = new FlatFileBufferFieldString("F18");
    TerminalType = new FlatFileBufferFieldString("TerminalType");
    F22 = new FlatFileBufferFieldString("F22");
    ServiceCode = new FlatFileBufferFieldString("ServiceCode");
    F25 = new FlatFileBufferFieldString("F25");
    ServiceConditionCode = new FlatFileBufferFieldString("ServiceConditionCode");
    F41 = new FlatFileBufferFieldString("F41");
    CardAcceptorTerminalIdentification = new FlatFileBufferFieldString("CardAcceptorTerminalIdentification");
    Acq = new FlatFileBufferFieldString("Acq");
    AcquiringInstitutionCode = new FlatFileBufferFieldString("AcquiringInstitutionCode");
    Iss = new FlatFileBufferFieldString("Iss");
    IssuerMemberId = new FlatFileBufferFieldString("IssuerMemberId");
    Mid = new FlatFileBufferFieldString("Mid");
    MerchantIdentificationCode = new FlatFileBufferFieldString("MerchantIdentificationCode");
    Bnb = new FlatFileBufferFieldString("Bnb");
    BeneficiaryIdentify = new FlatFileBufferFieldString("BeneficiaryIdentify");
    F102 = new FlatFileBufferFieldString("F102");
    FromAccount = new FlatFileBufferFieldString("FromAccount");
    F103 = new FlatFileBufferFieldString("F103");
    ToAccount = new FlatFileBufferFieldString("ToAccount");
    Svfissnp = new FlatFileBufferFieldString("Svfissnp");
    SvFeeIssNapas = new FlatFileBufferFieldString("SvFeeIssNapas");
    Irfissacq = new FlatFileBufferFieldString("Irfissacq");
    IrFeeIssAcq = new FlatFileBufferFieldString("IrFeeIssAcq");
    Irfissbnb = new FlatFileBufferFieldString("Irfissbnb");
    IrFeeIssBnb = new FlatFileBufferFieldString("IrFeeIssBnb");
    Svfacqnp = new FlatFileBufferFieldString("Svfacqnp");
    SvFeeAcqNapas = new FlatFileBufferFieldString("SvFeeAcqNapas");
    Irfacqiss = new FlatFileBufferFieldString("Irfacqiss");
    IrFeeAcqIss = new FlatFileBufferFieldString("IrFeeAcqIss");
    Irfacqbnb = new FlatFileBufferFieldString("Irfacqbnb");
    IrFeeAcqBnb = new FlatFileBufferFieldString("IrFeeAcqBnb");
    Svfbnbnp = new FlatFileBufferFieldString("Svfbnbnp");
    SvFeeBnbNapas = new FlatFileBufferFieldString("SvFeeBnbNapas");
    Irfbnbiss = new FlatFileBufferFieldString("Irfbnbiss");
    IrFeeBnbIss = new FlatFileBufferFieldString("IrFeeBnbIss");
    Irfbnbacq = new FlatFileBufferFieldString("Irfbnbacq");
    IrFeeBnbAcq = new FlatFileBufferFieldString("IrFeeBnbAcq");
    F37 = new FlatFileBufferFieldString("F37");
    Rrn = new FlatFileBufferFieldString("Rrn");
    F38 = new FlatFileBufferFieldString("F38");
    AuthorizationNumber = new FlatFileBufferFieldString("AuthorizationNumber");
    Trn = new FlatFileBufferFieldString("Trn");
    TransactionReferenceNumber = new FlatFileBufferFieldString("TransactionReferenceNumber");
    Rrc = new FlatFileBufferFieldString("Rrc");
    ResponseCode = new FlatFileBufferFieldString("ResponseCode");
    Rsv1Def = new FlatFileBufferFieldString("Rsv1Def");
    Rsv1 = new FlatFileBufferFieldString("Rsv1");
    Rsv2Def = new FlatFileBufferFieldString("Rsv2Def");
    Rsv2 = new FlatFileBufferFieldString("Rsv2");
    Rsv3Def = new FlatFileBufferFieldString("Rsv3Def");
    Rsv3 = new FlatFileBufferFieldString("Rsv3");
    Csr = new FlatFileBufferFieldString("Csr");
    ChecksumRecordValue = new FlatFileBufferFieldString("ChecksumRecordValue");
    TrailerRecord = new FlatFileBufferFieldString("TrailerRecord");
    Not = new FlatFileBufferFieldString("Not");
    NumberofRecordsinTheFile = new FlatFileBufferFieldString("NumberofRecordsinTheFile");
    Cre = new FlatFileBufferFieldString("Cre");
    Generator = new FlatFileBufferFieldString("Generator");
    Time = new FlatFileBufferFieldString("Time");
    FileGenerationTime = new FlatFileBufferFieldString("FileGenerationTime");
    FileGenerationDate = new FlatFileBufferFieldString("FileGenerationDate");
    Csf = new FlatFileBufferFieldString("Csf");
    ChecksumFileValue = new FlatFileBufferFieldString("ChecksumFileValue");

  initStandardVariables();
    records[0].fields = new FlatFileBufferField.RecordAdapter[7];
    records[0].fields[0] = new FlatFileBufferField.RecordAdapter(FileGeneratingDate,null,null);
    records[0].fields[1] = new FlatFileBufferField.RecordAdapter(FileTarget,null,null);
    records[0].fields[2] = new FlatFileBufferField.RecordAdapter(BankName,null,null);
    records[0].fields[3] = new FlatFileBufferField.RecordAdapter(MemberBankCode,null,null);
    records[0].fields[4] = new FlatFileBufferField.RecordAdapter(OrderNumber,null,null);
    records[0].fields[5] = new FlatFileBufferField.RecordAdapter(FileType,null,null);
    records[0].fields[6] = new FlatFileBufferField.RecordAdapter(FileService,new IConditionCalculation(){public boolean compute(){return getFileService() != null && (getFileNameRecord().getFileService().split("\\.")[0].equals("SWC") || getFileNameRecord().getFileService().split("\\.")[0].equals("PC") || getFileNameRecord().getFileService().split("\\.")[0].equals("UPI") || getFileNameRecord().getFileService().split("\\.")[0].equals("ECOM"));}},null);
    records[0].nOfFields = 7;
    records[0].setSimple(true);
    records[1].fields = new FlatFileBufferField.RecordAdapter[5];
    records[1].fields[0] = new FlatFileBufferField.RecordAdapter(HeaderRecord,new IConditionCalculation(){public boolean compute(){return getHeaderRecord().equals("HR");}},null);
    records[1].fields[1] = new FlatFileBufferField.RecordAdapter(Receiver,new IConditionCalculation(){public boolean compute(){return getReceiver().equals("[REV]");}},null);
    records[1].fields[2] = new FlatFileBufferField.RecordAdapter(BIN,null,null);
    records[1].fields[3] = new FlatFileBufferField.RecordAdapter(Date,new IConditionCalculation(){public boolean compute(){return getDate().equals("[DATE]");}},null);
    records[1].fields[4] = new FlatFileBufferField.RecordAdapter(TransactionDate,null,null);
    records[1].nOfFields = 5;
    records[1].setSimple(true);
    records[2].fields = new FlatFileBufferField.RecordAdapter[93];
    records[2].fields[0] = new FlatFileBufferField.RecordAdapter(DataRecord,new IConditionCalculation(){public boolean compute(){return getDataRecord().equals("DR");}},null);
    records[2].fields[1] = new FlatFileBufferField.RecordAdapter(MtiDef,new IConditionCalculation(){public boolean compute(){return getMtiDef().equals("[MTI]");}},null);
    records[2].fields[2] = new FlatFileBufferField.RecordAdapter(MessageTypeIdentifierCode,null,null);
    records[2].fields[3] = new FlatFileBufferField.RecordAdapter(F2,new IConditionCalculation(){public boolean compute(){return getF2().equals("[F2]");}},null);
    records[2].fields[4] = new FlatFileBufferField.RecordAdapter(CardNumber,null,null);
    records[2].fields[5] = new FlatFileBufferField.RecordAdapter(F3,new IConditionCalculation(){public boolean compute(){return getF3().equals("[F3]");}},null);
    records[2].fields[6] = new FlatFileBufferField.RecordAdapter(ProcessingCode,null,null);
    records[2].fields[7] = new FlatFileBufferField.RecordAdapter(SvcDef,new IConditionCalculation(){public boolean compute(){return getSvcDef().equals("[SVC]");}},null);
    records[2].fields[8] = new FlatFileBufferField.RecordAdapter(NapasSvcCode,null,null);
    records[2].fields[9] = new FlatFileBufferField.RecordAdapter(TccDef,new IConditionCalculation(){public boolean compute(){return getTccDef().equals("[TCC]");}},null);
    records[2].fields[10] = new FlatFileBufferField.RecordAdapter(TransactionChannelCode,null,null);
    records[2].fields[11] = new FlatFileBufferField.RecordAdapter(F4,new IConditionCalculation(){public boolean compute(){return getF4().equals("[F4]");}},null);
    records[2].fields[12] = new FlatFileBufferField.RecordAdapter(TransactionAmount,null,null);
    records[2].fields[13] = new FlatFileBufferField.RecordAdapter(Rta,new IConditionCalculation(){public boolean compute(){return getRta().equals("[RTA]");}},null);
    records[2].fields[14] = new FlatFileBufferField.RecordAdapter(RealTransactionAmount,null,null);
    records[2].fields[15] = new FlatFileBufferField.RecordAdapter(F49,new IConditionCalculation(){public boolean compute(){return getF49().equals("[F49]");}},null);
    records[2].fields[16] = new FlatFileBufferField.RecordAdapter(TransactionCurrencyCode,null,null);
    records[2].fields[17] = new FlatFileBufferField.RecordAdapter(F5,new IConditionCalculation(){public boolean compute(){return getF5().equals("[F5]");}},null);
    records[2].fields[18] = new FlatFileBufferField.RecordAdapter(SettlementAmount,null,null);
    records[2].fields[19] = new FlatFileBufferField.RecordAdapter(F50,new IConditionCalculation(){public boolean compute(){return getF50().equals("[F50]");}},null);
    records[2].fields[20] = new FlatFileBufferField.RecordAdapter(SettlementCurrencyCode,null,null);
    records[2].fields[21] = new FlatFileBufferField.RecordAdapter(F9,new IConditionCalculation(){public boolean compute(){return getF9().equals("[F9]");}},null);
    records[2].fields[22] = new FlatFileBufferField.RecordAdapter(FxRate,null,null);
    records[2].fields[23] = new FlatFileBufferField.RecordAdapter(F6,new IConditionCalculation(){public boolean compute(){return getF6().equals("[F6]");}},null);
    records[2].fields[24] = new FlatFileBufferField.RecordAdapter(CardholderAmount,null,null);
    records[2].fields[25] = new FlatFileBufferField.RecordAdapter(Rca,new IConditionCalculation(){public boolean compute(){return getRca().equals("[RCA]");}},null);
    records[2].fields[26] = new FlatFileBufferField.RecordAdapter(RealCardholerAmount,null,null);
    records[2].fields[27] = new FlatFileBufferField.RecordAdapter(F51,new IConditionCalculation(){public boolean compute(){return getF51().equals("[F51]");}},null);
    records[2].fields[28] = new FlatFileBufferField.RecordAdapter(CardholerCurrencyCode,null,null);
    records[2].fields[29] = new FlatFileBufferField.RecordAdapter(F10,new IConditionCalculation(){public boolean compute(){return getF10().equals("[F10]");}},null);
    records[2].fields[30] = new FlatFileBufferField.RecordAdapter(CardholderFxRate,null,null);
    records[2].fields[31] = new FlatFileBufferField.RecordAdapter(F11,new IConditionCalculation(){public boolean compute(){return getF11().equals("[F11]");}},null);
    records[2].fields[32] = new FlatFileBufferField.RecordAdapter(SystemTraceNumber,null,null);
    records[2].fields[33] = new FlatFileBufferField.RecordAdapter(F12,new IConditionCalculation(){public boolean compute(){return getF12().equals("[F12]");}},null);
    records[2].fields[34] = new FlatFileBufferField.RecordAdapter(LocalTransactionTime,null,null);
    records[2].fields[35] = new FlatFileBufferField.RecordAdapter(F13,new IConditionCalculation(){public boolean compute(){return getF13().equals("[F13]");}},null);
    records[2].fields[36] = new FlatFileBufferField.RecordAdapter(LocalTransactionDate,null,null);
    records[2].fields[37] = new FlatFileBufferField.RecordAdapter(F15,new IConditionCalculation(){public boolean compute(){return getF15().equals("[F15]");}},null);
    records[2].fields[38] = new FlatFileBufferField.RecordAdapter(SettlementDate,null,null);
    records[2].fields[39] = new FlatFileBufferField.RecordAdapter(F18,new IConditionCalculation(){public boolean compute(){return getF18().equals("[F18]");}},null);
    records[2].fields[40] = new FlatFileBufferField.RecordAdapter(TerminalType,null,null);
    records[2].fields[41] = new FlatFileBufferField.RecordAdapter(F22,new IConditionCalculation(){public boolean compute(){return getF22().equals("[F22]");}},null);
    records[2].fields[42] = new FlatFileBufferField.RecordAdapter(ServiceCode,null,null);
    records[2].fields[43] = new FlatFileBufferField.RecordAdapter(F25,new IConditionCalculation(){public boolean compute(){return getF25().equals("[F25]");}},null);
    records[2].fields[44] = new FlatFileBufferField.RecordAdapter(ServiceConditionCode,null,null);
    records[2].fields[45] = new FlatFileBufferField.RecordAdapter(F41,new IConditionCalculation(){public boolean compute(){return getF41().equals("[F41]");}},null);
    records[2].fields[46] = new FlatFileBufferField.RecordAdapter(CardAcceptorTerminalIdentification,null,null);
    records[2].fields[47] = new FlatFileBufferField.RecordAdapter(Acq,new IConditionCalculation(){public boolean compute(){return getAcq().equals("[ACQ]");}},null);
    records[2].fields[48] = new FlatFileBufferField.RecordAdapter(AcquiringInstitutionCode,null,null);
    records[2].fields[49] = new FlatFileBufferField.RecordAdapter(Iss,new IConditionCalculation(){public boolean compute(){return getIss().equals("[ISS]");}},null);
    records[2].fields[50] = new FlatFileBufferField.RecordAdapter(IssuerMemberId,null,null);
    records[2].fields[51] = new FlatFileBufferField.RecordAdapter(Mid,new IConditionCalculation(){public boolean compute(){return getMid().equals("[MID]");}},null);
    records[2].fields[52] = new FlatFileBufferField.RecordAdapter(MerchantIdentificationCode,null,null);
    records[2].fields[53] = new FlatFileBufferField.RecordAdapter(Bnb,new IConditionCalculation(){public boolean compute(){return getBnb().equals("[BNB]");}},null);
    records[2].fields[54] = new FlatFileBufferField.RecordAdapter(BeneficiaryIdentify,null,null);
    records[2].fields[55] = new FlatFileBufferField.RecordAdapter(F102,new IConditionCalculation(){public boolean compute(){return getF102().equals("[F102]");}},null);
    records[2].fields[56] = new FlatFileBufferField.RecordAdapter(FromAccount,null,null);
    records[2].fields[57] = new FlatFileBufferField.RecordAdapter(F103,new IConditionCalculation(){public boolean compute(){return getF103().equals("[F103]");}},null);
    records[2].fields[58] = new FlatFileBufferField.RecordAdapter(ToAccount,null,null);
    records[2].fields[59] = new FlatFileBufferField.RecordAdapter(Svfissnp,new IConditionCalculation(){public boolean compute(){return getSvfissnp().equals("[SVFISSNP]");}},null);
    records[2].fields[60] = new FlatFileBufferField.RecordAdapter(SvFeeIssNapas,null,null);
    records[2].fields[61] = new FlatFileBufferField.RecordAdapter(Irfissacq,new IConditionCalculation(){public boolean compute(){return getIrfissacq().equals("[IRFISSACQ]");}},null);
    records[2].fields[62] = new FlatFileBufferField.RecordAdapter(IrFeeIssAcq,null,null);
    records[2].fields[63] = new FlatFileBufferField.RecordAdapter(Irfissbnb,new IConditionCalculation(){public boolean compute(){return getIrfissbnb().equals("[IRFISSBNB]");}},null);
    records[2].fields[64] = new FlatFileBufferField.RecordAdapter(IrFeeIssBnb,null,null);
    records[2].fields[65] = new FlatFileBufferField.RecordAdapter(Svfacqnp,new IConditionCalculation(){public boolean compute(){return getSvfacqnp().equals("[SVFACQNP]");}},null);
    records[2].fields[66] = new FlatFileBufferField.RecordAdapter(SvFeeAcqNapas,null,null);
    records[2].fields[67] = new FlatFileBufferField.RecordAdapter(Irfacqiss,new IConditionCalculation(){public boolean compute(){return getIrfacqiss().equals("[IRFACQISS]");}},null);
    records[2].fields[68] = new FlatFileBufferField.RecordAdapter(IrFeeAcqIss,null,null);
    records[2].fields[69] = new FlatFileBufferField.RecordAdapter(Irfacqbnb,new IConditionCalculation(){public boolean compute(){return getIrfacqbnb().equals("[IRFACQBNB]");}},null);
    records[2].fields[70] = new FlatFileBufferField.RecordAdapter(IrFeeAcqBnb,null,null);
    records[2].fields[71] = new FlatFileBufferField.RecordAdapter(Svfbnbnp,new IConditionCalculation(){public boolean compute(){return getSvfbnbnp().equals("[SVFBNBNP]");}},null);
    records[2].fields[72] = new FlatFileBufferField.RecordAdapter(SvFeeBnbNapas,null,null);
    records[2].fields[73] = new FlatFileBufferField.RecordAdapter(Irfbnbiss,new IConditionCalculation(){public boolean compute(){return getIrfbnbiss().equals("[IRFBNBISS]");}},null);
    records[2].fields[74] = new FlatFileBufferField.RecordAdapter(IrFeeBnbIss,null,null);
    records[2].fields[75] = new FlatFileBufferField.RecordAdapter(Irfbnbacq,new IConditionCalculation(){public boolean compute(){return getIrfbnbacq().equals("[IRFBNBACQ]");}},null);
    records[2].fields[76] = new FlatFileBufferField.RecordAdapter(IrFeeBnbAcq,null,null);
    records[2].fields[77] = new FlatFileBufferField.RecordAdapter(F37,new IConditionCalculation(){public boolean compute(){return getF37().equals("[F37]");}},null);
    records[2].fields[78] = new FlatFileBufferField.RecordAdapter(Rrn,null,null);
    records[2].fields[79] = new FlatFileBufferField.RecordAdapter(F38,new IConditionCalculation(){public boolean compute(){return getF38().equals("[F38]");}},null);
    records[2].fields[80] = new FlatFileBufferField.RecordAdapter(AuthorizationNumber,null,null);
    records[2].fields[81] = new FlatFileBufferField.RecordAdapter(Trn,new IConditionCalculation(){public boolean compute(){return getTrn().equals("[TRN]");}},null);
    records[2].fields[82] = new FlatFileBufferField.RecordAdapter(TransactionReferenceNumber,null,null);
    records[2].fields[83] = new FlatFileBufferField.RecordAdapter(Rrc,new IConditionCalculation(){public boolean compute(){return getRrc().equals("[RRC]");}},null);
    records[2].fields[84] = new FlatFileBufferField.RecordAdapter(ResponseCode,null,null);
    records[2].fields[85] = new FlatFileBufferField.RecordAdapter(Rsv1Def,new IConditionCalculation(){public boolean compute(){return getRsv1Def().equals("[RSV1]");}},null);
    records[2].fields[86] = new FlatFileBufferField.RecordAdapter(Rsv1,null,null);
    records[2].fields[87] = new FlatFileBufferField.RecordAdapter(Rsv2Def,new IConditionCalculation(){public boolean compute(){return getRsv2Def().equals("[RSV2]");}},null);
    records[2].fields[88] = new FlatFileBufferField.RecordAdapter(Rsv2,null,null);
    records[2].fields[89] = new FlatFileBufferField.RecordAdapter(Rsv3Def,new IConditionCalculation(){public boolean compute(){return getRsv3Def().equals("[RSV3]");}},null);
    records[2].fields[90] = new FlatFileBufferField.RecordAdapter(Rsv3,null,null);
    records[2].fields[91] = new FlatFileBufferField.RecordAdapter(Csr,new IConditionCalculation(){public boolean compute(){return getCsr().equals("[CSR]");}},null);
    records[2].fields[92] = new FlatFileBufferField.RecordAdapter(ChecksumRecordValue,null,null);
    records[2].nOfFields = 93;
    records[2].setSimple(true);
    records[3].fields = new FlatFileBufferField.RecordAdapter[11];
    records[3].fields[0] = new FlatFileBufferField.RecordAdapter(TrailerRecord,new IConditionCalculation(){public boolean compute(){return getTrailerRecord().equals("TR");}},null);
    records[3].fields[1] = new FlatFileBufferField.RecordAdapter(Not,new IConditionCalculation(){public boolean compute(){return getNot().equals("[NOT]");}},null);
    records[3].fields[2] = new FlatFileBufferField.RecordAdapter(NumberofRecordsinTheFile,null,null);
    records[3].fields[3] = new FlatFileBufferField.RecordAdapter(Cre,new IConditionCalculation(){public boolean compute(){return getCre().equals("[CRE]");}},null);
    records[3].fields[4] = new FlatFileBufferField.RecordAdapter(Generator,null,null);
    records[3].fields[5] = new FlatFileBufferField.RecordAdapter(Time,new IConditionCalculation(){public boolean compute(){return getTime().equals("[TIME]");}},null);
    records[3].fields[6] = new FlatFileBufferField.RecordAdapter(FileGenerationTime,null,null);
    records[3].fields[7] = new FlatFileBufferField.RecordAdapter(Date,new IConditionCalculation(){public boolean compute(){return getDate().equals("[DATE]");}},null);
    records[3].fields[8] = new FlatFileBufferField.RecordAdapter(FileGenerationDate,null,null);
    records[3].fields[9] = new FlatFileBufferField.RecordAdapter(Csf,new IConditionCalculation(){public boolean compute(){return getCsf().equals("[CSF]");}},null);
    records[3].fields[10] = new FlatFileBufferField.RecordAdapter(ChecksumFileValue,null,null);
    records[3].nOfFields = 11;
    records[3].setSimple(true);
  }

  protected String getVersion() {return "2.1";}
}