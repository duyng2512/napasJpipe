package com.openwaygroup.pipe.napasoutgoing.autogen;

import java.nio.ByteBuffer;
import com.openwaygroup.application.pipe.spi.base.vector.VectorMetaData;
import com.openwaygroup.application.pipe.impl.filer.target.FlatFileTargetBuffer;
import com.openwaygroup.application.pipe.impl.filer.target.VectorRecordFieldMetaData;
import com.openwaygroup.application.pipe.impl.filer.target.VectorRecordMetaData;
import com.openwaygroup.application.pipe.spi.base.vector.VectorBuffer;

public class OutWardFile extends FlatFileTargetBuffer {
    public static interface RECORD_TYPES {
        public static final String FILEDATARECORD = "fileDataRecord";
        public static final String FILEHEADERRECORD = "fileHeaderRecord";
        public static final String FILETRAILERRECORD = "fileTrailerRecord";
    }
    private VectorRecordMetaData fileDataRecordVectorMetaData = new VectorRecordMetaData(OutWardFile.class,
        new VectorRecordFieldMetaData[] {
            new VectorRecordFieldMetaData("fileDataRecord","DataRecord", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","MtiDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","MessageTypeIdentifierCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F2", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","CardNumber", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F3", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ProcessingCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","SvcDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","NapasSvcCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TccDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TransactionChannelCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F4", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TransactionAmount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rta", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","RealTransactionAmount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F49", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TransactionCurrencyCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F5", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","SettlementAmount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F50", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","SettlementCurrencyCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F9", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","FxRate", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F6", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","CardholderAmount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rca", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","RealCardholerAmount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F51", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","CardholerCurrencyCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F10", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","CardholderFxRate", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F11", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","SystemTraceNumber", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F12", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","LocalTransactionTime", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F13", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","LocalTransactionDate", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F15", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","SettlementDate", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F18", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TerminalType", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F22", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ServiceCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F25", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ServiceConditionCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F41", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","CardAcceptorTerminalIdentification", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Acq", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","AcquiringInstitutionCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Iss", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","IssuerMemberId", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Mid", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","MerchantIdentificationCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Bnb", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","BeneficiaryIdentify", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F102", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","FromAccount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F103", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ToAccount", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F37", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rrn", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","F38", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","AuthorizationNumber", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Trn", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","TransactionReferenceNumber", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rrc", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ResponseCode", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv1Def", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv1", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv2Def", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv2", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv3Def", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Rsv3", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","Csr", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileDataRecord","ChecksumRecordValue", VectorBuffer.IN)
        });

    private VectorRecordMetaData fileHeaderRecordVectorMetaData = new VectorRecordMetaData(OutWardFile.class,
        new VectorRecordFieldMetaData[] {
            new VectorRecordFieldMetaData("fileHeaderRecord","headerRecord", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileHeaderRecord","binDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileHeaderRecord","bin", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileHeaderRecord","dateDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileHeaderRecord","transactionDate", VectorBuffer.IN)
        });

    private VectorRecordMetaData fileTrailerRecordVectorMetaData = new VectorRecordMetaData(OutWardFile.class,
        new VectorRecordFieldMetaData[] {
            new VectorRecordFieldMetaData("fileTrailerRecord","trailerRecord", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","notDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","numberOfRecordsInTheFile", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","generatorDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","generator", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","generateTimeDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","fileGenerationTime", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","generateDateDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","fileGenerationDate", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","csfDef", VectorBuffer.IN),
            new VectorRecordFieldMetaData("fileTrailerRecord","checksumFileValue", VectorBuffer.IN)
        });

    protected VectorMetaData getFieldsMetaData(String recordType) {
        if("fileDataRecord".equals(recordType))
            return fileDataRecordVectorMetaData;
        if("fileHeaderRecord".equals(recordType))
            return fileHeaderRecordVectorMetaData;
        if("fileTrailerRecord".equals(recordType))
            return fileTrailerRecordVectorMetaData;
        return null;
    }
    private java.lang.String Mid = null;
    private java.lang.String RealTransactionAmount = null;
    private java.lang.String TccDef = null;
    private java.lang.String CardAcceptorTerminalIdentification = null;
    private java.lang.String AcquiringInstitutionCode = null;
    private java.lang.String Rsv2 = null;
    private java.lang.String Rsv1 = null;
    private java.lang.String Rta = null;
    private java.lang.String Rsv3 = null;
    private java.lang.String Trn = null;
    private java.lang.String MtiDef = null;
    private java.lang.String AuthorizationNumber = null;
    private java.lang.String TransactionChannelCode = null;
    private java.lang.String generateTimeDef = null;
    private java.lang.String F49 = null;
    private java.lang.String ServiceCode = null;
    private java.lang.String F41 = null;
    private java.lang.String dateDef = null;
    private java.lang.String fileGenerationDate = null;
    private java.lang.String CardholderAmount = null;
    private java.lang.String F11 = null;
    private java.lang.String F103 = null;
    private java.lang.String F12 = null;
    private java.lang.String F102 = null;
    private java.lang.String RealCardholerAmount = null;
    private java.lang.String F10 = null;
    private java.lang.String numberOfRecordsInTheFile = null;
    private java.lang.String notDef = null;
    private java.lang.String ChecksumRecordValue = null;
    private java.lang.String checksumFileValue = null;
    private java.lang.String ProcessingCode = null;
    private java.lang.String Rca = null;
    private java.lang.String TransactionCurrencyCode = null;
    private java.lang.String TransactionReferenceNumber = null;
    private java.lang.String F9 = null;
    private java.lang.String F6 = null;
    private java.lang.String F18 = null;
    private java.lang.String F15 = null;
    private java.lang.String transactionDate = null;
    private java.lang.String F13 = null;
    private java.lang.String SvcDef = null;
    private java.lang.String binDef = null;
    private java.lang.String Rrc = null;
    private java.lang.String F5 = null;
    private java.lang.String F4 = null;
    private java.lang.String F3 = null;
    private java.lang.String F2 = null;
    private java.lang.String DataRecord = null;
    private java.lang.String NapasSvcCode = null;
    private java.lang.String CardholerCurrencyCode = null;
    private java.lang.String generatorDef = null;
    private java.lang.String Bnb = null;
    private java.lang.String IssuerMemberId = null;
    private java.lang.String bin = null;
    private java.lang.String Iss = null;
    private java.lang.String F50 = null;
    private java.lang.String Rrn = null;
    private java.lang.String F51 = null;
    private java.lang.String MerchantIdentificationCode = null;
    private java.lang.String ToAccount = null;
    private java.lang.String CardholderFxRate = null;
    private java.lang.String Rsv2Def = null;
    private java.lang.String Rsv3Def = null;
    private java.lang.String FxRate = null;
    private java.lang.String LocalTransactionDate = null;
    private java.lang.String TransactionAmount = null;
    private java.lang.String F25 = null;
    private java.lang.String headerRecord = null;
    private java.lang.String generator = null;
    private java.lang.String csfDef = null;
    private java.lang.String LocalTransactionTime = null;
    private java.lang.String F22 = null;
    private java.lang.String CardNumber = null;
    private java.lang.String SettlementCurrencyCode = null;
    private java.lang.String fileGenerationTime = null;
    private java.lang.String generateDateDef = null;
    private java.lang.String MessageTypeIdentifierCode = null;
    private java.lang.String ResponseCode = null;
    private java.lang.String BeneficiaryIdentify = null;
    private java.lang.String SettlementAmount = null;
    private java.lang.String SettlementDate = null;
    private java.lang.String F38 = null;
    private java.lang.String FromAccount = null;
    private java.lang.String ServiceConditionCode = null;
    private java.lang.String Rsv1Def = null;
    private java.lang.String F37 = null;
    private java.lang.String TerminalType = null;
    private java.lang.String Acq = null;
    private java.lang.String SystemTraceNumber = null;
    private java.lang.String trailerRecord = null;
    private java.lang.String Csr = null;
    private FileDataRecord fileDataRecord = new FileDataRecord();
    public FileDataRecord getFileDataRecord() {
        return fileDataRecord;
    }
    private FileHeaderRecord fileHeaderRecord = new FileHeaderRecord();
    public FileHeaderRecord getFileHeaderRecord() {
        return fileHeaderRecord;
    }
    private FileTrailerRecord fileTrailerRecord = new FileTrailerRecord();
    public FileTrailerRecord getFileTrailerRecord() {
        return fileTrailerRecord;
    }
    public void setAllFields() throws Exception {
        if("fileDataRecord".equals(currentRecordType))
            fileDataRecord.update();
        if("fileHeaderRecord".equals(currentRecordType))
            fileHeaderRecord.update();
        if("fileTrailerRecord".equals(currentRecordType))
            fileTrailerRecord.update();
    }
    public class FileDataRecord {
        public void setDataRecord(java.lang.String p_DataRecord) {
           DataRecord = p_DataRecord;
        }
        public java.lang.String getDataRecord() {
          return DataRecord;
        }
        public void setMtiDef(java.lang.String p_MtiDef) {
           MtiDef = p_MtiDef;
        }
        public java.lang.String getMtiDef() {
          return MtiDef;
        }
        public void setMessageTypeIdentifierCode(java.lang.String p_MessageTypeIdentifierCode) {
           MessageTypeIdentifierCode = p_MessageTypeIdentifierCode;
        }
        public java.lang.String getMessageTypeIdentifierCode() {
          return MessageTypeIdentifierCode;
        }
        public void setF2(java.lang.String p_F2) {
           F2 = p_F2;
        }
        public java.lang.String getF2() {
          return F2;
        }
        public void setCardNumber(java.lang.String p_CardNumber) {
           CardNumber = p_CardNumber;
        }
        public java.lang.String getCardNumber() {
          return CardNumber;
        }
        public void setF3(java.lang.String p_F3) {
           F3 = p_F3;
        }
        public java.lang.String getF3() {
          return F3;
        }
        public void setProcessingCode(java.lang.String p_ProcessingCode) {
           ProcessingCode = p_ProcessingCode;
        }
        public java.lang.String getProcessingCode() {
          return ProcessingCode;
        }
        public void setSvcDef(java.lang.String p_SvcDef) {
           SvcDef = p_SvcDef;
        }
        public java.lang.String getSvcDef() {
          return SvcDef;
        }
        public void setNapasSvcCode(java.lang.String p_NapasSvcCode) {
           NapasSvcCode = p_NapasSvcCode;
        }
        public java.lang.String getNapasSvcCode() {
          return NapasSvcCode;
        }
        public void setTccDef(java.lang.String p_TccDef) {
           TccDef = p_TccDef;
        }
        public java.lang.String getTccDef() {
          return TccDef;
        }
        public void setTransactionChannelCode(java.lang.String p_TransactionChannelCode) {
           TransactionChannelCode = p_TransactionChannelCode;
        }
        public java.lang.String getTransactionChannelCode() {
          return TransactionChannelCode;
        }
        public void setF4(java.lang.String p_F4) {
           F4 = p_F4;
        }
        public java.lang.String getF4() {
          return F4;
        }
        public void setTransactionAmount(java.lang.String p_TransactionAmount) {
           TransactionAmount = p_TransactionAmount;
        }
        public java.lang.String getTransactionAmount() {
          return TransactionAmount;
        }
        public void setRta(java.lang.String p_Rta) {
           Rta = p_Rta;
        }
        public java.lang.String getRta() {
          return Rta;
        }
        public void setRealTransactionAmount(java.lang.String p_RealTransactionAmount) {
           RealTransactionAmount = p_RealTransactionAmount;
        }
        public java.lang.String getRealTransactionAmount() {
          return RealTransactionAmount;
        }
        public void setF49(java.lang.String p_F49) {
           F49 = p_F49;
        }
        public java.lang.String getF49() {
          return F49;
        }
        public void setTransactionCurrencyCode(java.lang.String p_TransactionCurrencyCode) {
           TransactionCurrencyCode = p_TransactionCurrencyCode;
        }
        public java.lang.String getTransactionCurrencyCode() {
          return TransactionCurrencyCode;
        }
        public void setF5(java.lang.String p_F5) {
           F5 = p_F5;
        }
        public java.lang.String getF5() {
          return F5;
        }
        public void setSettlementAmount(java.lang.String p_SettlementAmount) {
           SettlementAmount = p_SettlementAmount;
        }
        public java.lang.String getSettlementAmount() {
          return SettlementAmount;
        }
        public void setF50(java.lang.String p_F50) {
           F50 = p_F50;
        }
        public java.lang.String getF50() {
          return F50;
        }
        public void setSettlementCurrencyCode(java.lang.String p_SettlementCurrencyCode) {
           SettlementCurrencyCode = p_SettlementCurrencyCode;
        }
        public java.lang.String getSettlementCurrencyCode() {
          return SettlementCurrencyCode;
        }
        public void setF9(java.lang.String p_F9) {
           F9 = p_F9;
        }
        public java.lang.String getF9() {
          return F9;
        }
        public void setFxRate(java.lang.String p_FxRate) {
           FxRate = p_FxRate;
        }
        public java.lang.String getFxRate() {
          return FxRate;
        }
        public void setF6(java.lang.String p_F6) {
           F6 = p_F6;
        }
        public java.lang.String getF6() {
          return F6;
        }
        public void setCardholderAmount(java.lang.String p_CardholderAmount) {
           CardholderAmount = p_CardholderAmount;
        }
        public java.lang.String getCardholderAmount() {
          return CardholderAmount;
        }
        public void setRca(java.lang.String p_Rca) {
           Rca = p_Rca;
        }
        public java.lang.String getRca() {
          return Rca;
        }
        public void setRealCardholerAmount(java.lang.String p_RealCardholerAmount) {
           RealCardholerAmount = p_RealCardholerAmount;
        }
        public java.lang.String getRealCardholerAmount() {
          return RealCardholerAmount;
        }
        public void setF51(java.lang.String p_F51) {
           F51 = p_F51;
        }
        public java.lang.String getF51() {
          return F51;
        }
        public void setCardholerCurrencyCode(java.lang.String p_CardholerCurrencyCode) {
           CardholerCurrencyCode = p_CardholerCurrencyCode;
        }
        public java.lang.String getCardholerCurrencyCode() {
          return CardholerCurrencyCode;
        }
        public void setF10(java.lang.String p_F10) {
           F10 = p_F10;
        }
        public java.lang.String getF10() {
          return F10;
        }
        public void setCardholderFxRate(java.lang.String p_CardholderFxRate) {
           CardholderFxRate = p_CardholderFxRate;
        }
        public java.lang.String getCardholderFxRate() {
          return CardholderFxRate;
        }
        public void setF11(java.lang.String p_F11) {
           F11 = p_F11;
        }
        public java.lang.String getF11() {
          return F11;
        }
        public void setSystemTraceNumber(java.lang.String p_SystemTraceNumber) {
           SystemTraceNumber = p_SystemTraceNumber;
        }
        public java.lang.String getSystemTraceNumber() {
          return SystemTraceNumber;
        }
        public void setF12(java.lang.String p_F12) {
           F12 = p_F12;
        }
        public java.lang.String getF12() {
          return F12;
        }
        public void setLocalTransactionTime(java.lang.String p_LocalTransactionTime) {
           LocalTransactionTime = p_LocalTransactionTime;
        }
        public java.lang.String getLocalTransactionTime() {
          return LocalTransactionTime;
        }
        public void setF13(java.lang.String p_F13) {
           F13 = p_F13;
        }
        public java.lang.String getF13() {
          return F13;
        }
        public void setLocalTransactionDate(java.lang.String p_LocalTransactionDate) {
           LocalTransactionDate = p_LocalTransactionDate;
        }
        public java.lang.String getLocalTransactionDate() {
          return LocalTransactionDate;
        }
        public void setF15(java.lang.String p_F15) {
           F15 = p_F15;
        }
        public java.lang.String getF15() {
          return F15;
        }
        public void setSettlementDate(java.lang.String p_SettlementDate) {
           SettlementDate = p_SettlementDate;
        }
        public java.lang.String getSettlementDate() {
          return SettlementDate;
        }
        public void setF18(java.lang.String p_F18) {
           F18 = p_F18;
        }
        public java.lang.String getF18() {
          return F18;
        }
        public void setTerminalType(java.lang.String p_TerminalType) {
           TerminalType = p_TerminalType;
        }
        public java.lang.String getTerminalType() {
          return TerminalType;
        }
        public void setF22(java.lang.String p_F22) {
           F22 = p_F22;
        }
        public java.lang.String getF22() {
          return F22;
        }
        public void setServiceCode(java.lang.String p_ServiceCode) {
           ServiceCode = p_ServiceCode;
        }
        public java.lang.String getServiceCode() {
          return ServiceCode;
        }
        public void setF25(java.lang.String p_F25) {
           F25 = p_F25;
        }
        public java.lang.String getF25() {
          return F25;
        }
        public void setServiceConditionCode(java.lang.String p_ServiceConditionCode) {
           ServiceConditionCode = p_ServiceConditionCode;
        }
        public java.lang.String getServiceConditionCode() {
          return ServiceConditionCode;
        }
        public void setF41(java.lang.String p_F41) {
           F41 = p_F41;
        }
        public java.lang.String getF41() {
          return F41;
        }
        public void setCardAcceptorTerminalIdentification(java.lang.String p_CardAcceptorTerminalIdentification) {
           CardAcceptorTerminalIdentification = p_CardAcceptorTerminalIdentification;
        }
        public java.lang.String getCardAcceptorTerminalIdentification() {
          return CardAcceptorTerminalIdentification;
        }
        public void setAcq(java.lang.String p_Acq) {
           Acq = p_Acq;
        }
        public java.lang.String getAcq() {
          return Acq;
        }
        public void setAcquiringInstitutionCode(java.lang.String p_AcquiringInstitutionCode) {
           AcquiringInstitutionCode = p_AcquiringInstitutionCode;
        }
        public java.lang.String getAcquiringInstitutionCode() {
          return AcquiringInstitutionCode;
        }
        public void setIss(java.lang.String p_Iss) {
           Iss = p_Iss;
        }
        public java.lang.String getIss() {
          return Iss;
        }
        public void setIssuerMemberId(java.lang.String p_IssuerMemberId) {
           IssuerMemberId = p_IssuerMemberId;
        }
        public java.lang.String getIssuerMemberId() {
          return IssuerMemberId;
        }
        public void setMid(java.lang.String p_Mid) {
           Mid = p_Mid;
        }
        public java.lang.String getMid() {
          return Mid;
        }
        public void setMerchantIdentificationCode(java.lang.String p_MerchantIdentificationCode) {
           MerchantIdentificationCode = p_MerchantIdentificationCode;
        }
        public java.lang.String getMerchantIdentificationCode() {
          return MerchantIdentificationCode;
        }
        public void setBnb(java.lang.String p_Bnb) {
           Bnb = p_Bnb;
        }
        public java.lang.String getBnb() {
          return Bnb;
        }
        public void setBeneficiaryIdentify(java.lang.String p_BeneficiaryIdentify) {
           BeneficiaryIdentify = p_BeneficiaryIdentify;
        }
        public java.lang.String getBeneficiaryIdentify() {
          return BeneficiaryIdentify;
        }
        public void setF102(java.lang.String p_F102) {
           F102 = p_F102;
        }
        public java.lang.String getF102() {
          return F102;
        }
        public void setFromAccount(java.lang.String p_FromAccount) {
           FromAccount = p_FromAccount;
        }
        public java.lang.String getFromAccount() {
          return FromAccount;
        }
        public void setF103(java.lang.String p_F103) {
           F103 = p_F103;
        }
        public java.lang.String getF103() {
          return F103;
        }
        public void setToAccount(java.lang.String p_ToAccount) {
           ToAccount = p_ToAccount;
        }
        public java.lang.String getToAccount() {
          return ToAccount;
        }
        public void setF37(java.lang.String p_F37) {
           F37 = p_F37;
        }
        public java.lang.String getF37() {
          return F37;
        }
        public void setRrn(java.lang.String p_Rrn) {
           Rrn = p_Rrn;
        }
        public java.lang.String getRrn() {
          return Rrn;
        }
        public void setF38(java.lang.String p_F38) {
           F38 = p_F38;
        }
        public java.lang.String getF38() {
          return F38;
        }
        public void setAuthorizationNumber(java.lang.String p_AuthorizationNumber) {
           AuthorizationNumber = p_AuthorizationNumber;
        }
        public java.lang.String getAuthorizationNumber() {
          return AuthorizationNumber;
        }
        public void setTrn(java.lang.String p_Trn) {
           Trn = p_Trn;
        }
        public java.lang.String getTrn() {
          return Trn;
        }
        public void setTransactionReferenceNumber(java.lang.String p_TransactionReferenceNumber) {
           TransactionReferenceNumber = p_TransactionReferenceNumber;
        }
        public java.lang.String getTransactionReferenceNumber() {
          return TransactionReferenceNumber;
        }
        public void setRrc(java.lang.String p_Rrc) {
           Rrc = p_Rrc;
        }
        public java.lang.String getRrc() {
          return Rrc;
        }
        public void setResponseCode(java.lang.String p_ResponseCode) {
           ResponseCode = p_ResponseCode;
        }
        public java.lang.String getResponseCode() {
          return ResponseCode;
        }
        public void setRsv1Def(java.lang.String p_Rsv1Def) {
           Rsv1Def = p_Rsv1Def;
        }
        public java.lang.String getRsv1Def() {
          return Rsv1Def;
        }
        public void setRsv1(java.lang.String p_Rsv1) {
           Rsv1 = p_Rsv1;
        }
        public java.lang.String getRsv1() {
          return Rsv1;
        }
        public void setRsv2Def(java.lang.String p_Rsv2Def) {
           Rsv2Def = p_Rsv2Def;
        }
        public java.lang.String getRsv2Def() {
          return Rsv2Def;
        }
        public void setRsv2(java.lang.String p_Rsv2) {
           Rsv2 = p_Rsv2;
        }
        public java.lang.String getRsv2() {
          return Rsv2;
        }
        public void setRsv3Def(java.lang.String p_Rsv3Def) {
           Rsv3Def = p_Rsv3Def;
        }
        public java.lang.String getRsv3Def() {
          return Rsv3Def;
        }
        public void setRsv3(java.lang.String p_Rsv3) {
           Rsv3 = p_Rsv3;
        }
        public java.lang.String getRsv3() {
          return Rsv3;
        }
        public void setCsr(java.lang.String p_Csr) {
           Csr = p_Csr;
        }
        public java.lang.String getCsr() {
          return Csr;
        }
        public void setChecksumRecordValue(java.lang.String p_ChecksumRecordValue) {
           ChecksumRecordValue = p_ChecksumRecordValue;
        }
        public java.lang.String getChecksumRecordValue() {
          return ChecksumRecordValue;
        }
        public void evaluate() {
            if(DataRecord == null)
                DataRecord="DR";
            if(MtiDef == null)
                MtiDef="[MTI]";
            if(F2 == null)
                F2="[F2]";
            if(F3 == null)
                F3="[F3]";
            if(SvcDef == null)
                SvcDef="[SVC]";
            if(TccDef == null)
                TccDef="[TCC]";
            if(F4 == null)
                F4="[F4]";
            if(Rta == null)
                Rta="[RTA]";
            if(F49 == null)
                F49="[F49]";
            if(F5 == null)
                F5="[F5]";
            if(F50 == null)
                F50="[F50]";
            if(F9 == null)
                F9="[F9]";
            if(F6 == null)
                F6="[F6]";
            if(Rca == null)
                Rca="[RCA]";
            if(F51 == null)
                F51="[F51]";
            if(F10 == null)
                F10="[F10]";
            if(F11 == null)
                F11="[F11]";
            if(F12 == null)
                F12="[F12]";
            if(F13 == null)
                F13="[F13]";
            if(F15 == null)
                F15="[F15]";
            if(F18 == null)
                F18="[F18]";
            if(F22 == null)
                F22="[F22]";
            if(F25 == null)
                F25="[F25]";
            if(F41 == null)
                F41="[F41]";
            if(Acq == null)
                Acq="[ACQ]";
            if(Iss == null)
                Iss="[ISS]";
            if(Mid == null)
                Mid="[MID]";
            if(Bnb == null)
                Bnb="[BNB]";
            if(F102 == null)
                F102="[F102]";
            if(F103 == null)
                F103="[F103]";
            if(F37 == null)
                F37="[F37]";
            if(F38 == null)
                F38="[F38]";
            if(Trn == null)
                Trn="[TRN]";
            if(Rrc == null)
                Rrc="[RRC]";
            if(Rsv1Def == null)
                Rsv1Def="[RSV1]";
            if(Rsv2Def == null)
                Rsv2Def="[RSV2]";
            if(Rsv3Def == null)
                Rsv3Def="[RSV3]";
            if(Csr == null)
                Csr="[CSR]";
        }
        public void update() throws Exception {
            evaluate();
            if(null==DataRecord && !false){
                 throw new Exception("DataRecord is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("DataRecord"), DataRecord);
            if(null==MtiDef && !false){
                 throw new Exception("MtiDef is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("MtiDef"), MtiDef);
            if(null==MessageTypeIdentifierCode && !false){
                 throw new Exception("MessageTypeIdentifierCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("MessageTypeIdentifierCode"), MessageTypeIdentifierCode);
            if(null==F2 && !false){
                 throw new Exception("F2 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F2"), F2);
            if(null==CardNumber && !false){
                 throw new Exception("CardNumber is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("CardNumber"), CardNumber);
            if(null==F3 && !false){
                 throw new Exception("F3 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F3"), F3);
            if(null==ProcessingCode && !false){
                 throw new Exception("ProcessingCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ProcessingCode"), ProcessingCode);
            if(null==SvcDef && !false){
                 throw new Exception("SvcDef is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("SvcDef"), SvcDef);
            if(null==NapasSvcCode && !false){
                 throw new Exception("NapasSvcCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("NapasSvcCode"), NapasSvcCode);
            if(null==TccDef && !false){
                 throw new Exception("TccDef is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TccDef"), TccDef);
            if(null==TransactionChannelCode && !false){
                 throw new Exception("TransactionChannelCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TransactionChannelCode"), TransactionChannelCode);
            if(null==F4 && !false){
                 throw new Exception("F4 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F4"), F4);
            if(null==TransactionAmount && !false){
                 throw new Exception("TransactionAmount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TransactionAmount"), TransactionAmount);
            if(null==Rta && !false){
                 throw new Exception("Rta is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rta"), Rta);
            if(null==RealTransactionAmount && !false){
                 throw new Exception("RealTransactionAmount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("RealTransactionAmount"), RealTransactionAmount);
            if(null==F49 && !false){
                 throw new Exception("F49 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F49"), F49);
            if(null==TransactionCurrencyCode && !false){
                 throw new Exception("TransactionCurrencyCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TransactionCurrencyCode"), TransactionCurrencyCode);
            if(null==F5 && !false){
                 throw new Exception("F5 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F5"), F5);
            if(null==SettlementAmount && !false){
                 throw new Exception("SettlementAmount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("SettlementAmount"), SettlementAmount);
            if(null==F50 && !false){
                 throw new Exception("F50 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F50"), F50);
            if(null==SettlementCurrencyCode && !false){
                 throw new Exception("SettlementCurrencyCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("SettlementCurrencyCode"), SettlementCurrencyCode);
            if(null==F9 && !false){
                 throw new Exception("F9 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F9"), F9);
            if(null==FxRate && !false){
                 throw new Exception("FxRate is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("FxRate"), FxRate);
            if(null==F6 && !false){
                 throw new Exception("F6 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F6"), F6);
            if(null==CardholderAmount && !false){
                 throw new Exception("CardholderAmount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("CardholderAmount"), CardholderAmount);
            if(null==Rca && !false){
                 throw new Exception("Rca is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rca"), Rca);
            if(null==RealCardholerAmount && !false){
                 throw new Exception("RealCardholerAmount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("RealCardholerAmount"), RealCardholerAmount);
            if(null==F51 && !false){
                 throw new Exception("F51 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F51"), F51);
            if(null==CardholerCurrencyCode && !false){
                 throw new Exception("CardholerCurrencyCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("CardholerCurrencyCode"), CardholerCurrencyCode);
            if(null==F10 && !false){
                 throw new Exception("F10 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F10"), F10);
            if(null==CardholderFxRate && !false){
                 throw new Exception("CardholderFxRate is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("CardholderFxRate"), CardholderFxRate);
            if(null==F11 && !false){
                 throw new Exception("F11 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F11"), F11);
            if(null==SystemTraceNumber && !false){
                 throw new Exception("SystemTraceNumber is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("SystemTraceNumber"), SystemTraceNumber);
            if(null==F12 && !false){
                 throw new Exception("F12 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F12"), F12);
            if(null==LocalTransactionTime && !false){
                 throw new Exception("LocalTransactionTime is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("LocalTransactionTime"), LocalTransactionTime);
            if(null==F13 && !false){
                 throw new Exception("F13 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F13"), F13);
            if(null==LocalTransactionDate && !false){
                 throw new Exception("LocalTransactionDate is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("LocalTransactionDate"), LocalTransactionDate);
            if(null==F15 && !false){
                 throw new Exception("F15 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F15"), F15);
            if(null==SettlementDate && !false){
                 throw new Exception("SettlementDate is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("SettlementDate"), SettlementDate);
            if(null==F18 && !false){
                 throw new Exception("F18 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F18"), F18);
            if(null==TerminalType && !false){
                 throw new Exception("TerminalType is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TerminalType"), TerminalType);
            if(null==F22 && !false){
                 throw new Exception("F22 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F22"), F22);
            if(null==ServiceCode && !false){
                 throw new Exception("ServiceCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ServiceCode"), ServiceCode);
            if(null==F25 && !false){
                 throw new Exception("F25 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F25"), F25);
            if(null==ServiceConditionCode && !false){
                 throw new Exception("ServiceConditionCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ServiceConditionCode"), ServiceConditionCode);
            if(null==F41 && !false){
                 throw new Exception("F41 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F41"), F41);
            if(null==CardAcceptorTerminalIdentification && !false){
                 throw new Exception("CardAcceptorTerminalIdentification is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("CardAcceptorTerminalIdentification"), CardAcceptorTerminalIdentification);
            if(null==Acq && !false){
                 throw new Exception("Acq is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Acq"), Acq);
            if(null==AcquiringInstitutionCode && !false){
                 throw new Exception("AcquiringInstitutionCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("AcquiringInstitutionCode"), AcquiringInstitutionCode);
            if(null==Iss && !false){
                 throw new Exception("Iss is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Iss"), Iss);
            if(null==IssuerMemberId && !false){
                 throw new Exception("IssuerMemberId is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("IssuerMemberId"), IssuerMemberId);
            if(null==Mid && !false){
                 throw new Exception("Mid is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Mid"), Mid);
            if(null==MerchantIdentificationCode && !false){
                 throw new Exception("MerchantIdentificationCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("MerchantIdentificationCode"), MerchantIdentificationCode);
            if(null==Bnb && !false){
                 throw new Exception("Bnb is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Bnb"), Bnb);
            if(null==BeneficiaryIdentify && !false){
                 throw new Exception("BeneficiaryIdentify is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("BeneficiaryIdentify"), BeneficiaryIdentify);
            if(null==F102 && !false){
                 throw new Exception("F102 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F102"), F102);
            if(null==FromAccount && !false){
                 throw new Exception("FromAccount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("FromAccount"), FromAccount);
            if(null==F103 && !false){
                 throw new Exception("F103 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F103"), F103);
            if(null==ToAccount && !false){
                 throw new Exception("ToAccount is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ToAccount"), ToAccount);
            if(null==F37 && !false){
                 throw new Exception("F37 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F37"), F37);
            if(null==Rrn && !false){
                 throw new Exception("Rrn is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rrn"), Rrn);
            if(null==F38 && !false){
                 throw new Exception("F38 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("F38"), F38);
            if(null==AuthorizationNumber && !false){
                 throw new Exception("AuthorizationNumber is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("AuthorizationNumber"), AuthorizationNumber);
            if(null==Trn && !false){
                 throw new Exception("Trn is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Trn"), Trn);
            if(null==TransactionReferenceNumber && !false){
                 throw new Exception("TransactionReferenceNumber is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("TransactionReferenceNumber"), TransactionReferenceNumber);
            if(null==Rrc && !false){
                 throw new Exception("Rrc is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rrc"), Rrc);
            if(null==ResponseCode && !false){
                 throw new Exception("ResponseCode is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ResponseCode"), ResponseCode);
            if(null==Rsv1Def && !false){
                 throw new Exception("Rsv1Def is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv1Def"), Rsv1Def);
            if(null==Rsv1 && !false){
                 throw new Exception("Rsv1 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv1"), Rsv1);
            if(null==Rsv2Def && !false){
                 throw new Exception("Rsv2Def is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv2Def"), Rsv2Def);
            if(null==Rsv2 && !false){
                 throw new Exception("Rsv2 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv2"), Rsv2);
            if(null==Rsv3Def && !false){
                 throw new Exception("Rsv3Def is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv3Def"), Rsv3Def);
            if(null==Rsv3 && !false){
                 throw new Exception("Rsv3 is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Rsv3"), Rsv3);
            if(null==Csr && !false){
                 throw new Exception("Csr is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("Csr"), Csr);
            if(null==ChecksumRecordValue && !false){
                 throw new Exception("ChecksumRecordValue is null.");
            }
            set(fileDataRecordVectorMetaData.getVectorFieldMetaData("ChecksumRecordValue"), ChecksumRecordValue);
        }
        public void clear() {
            setDataRecord(null);
            setMtiDef(null);
            setMessageTypeIdentifierCode(null);
            setF2(null);
            setCardNumber(null);
            setF3(null);
            setProcessingCode(null);
            setSvcDef(null);
            setNapasSvcCode(null);
            setTccDef(null);
            setTransactionChannelCode(null);
            setF4(null);
            setTransactionAmount(null);
            setRta(null);
            setRealTransactionAmount(null);
            setF49(null);
            setTransactionCurrencyCode(null);
            setF5(null);
            setSettlementAmount(null);
            setF50(null);
            setSettlementCurrencyCode(null);
            setF9(null);
            setFxRate(null);
            setF6(null);
            setCardholderAmount(null);
            setRca(null);
            setRealCardholerAmount(null);
            setF51(null);
            setCardholerCurrencyCode(null);
            setF10(null);
            setCardholderFxRate(null);
            setF11(null);
            setSystemTraceNumber(null);
            setF12(null);
            setLocalTransactionTime(null);
            setF13(null);
            setLocalTransactionDate(null);
            setF15(null);
            setSettlementDate(null);
            setF18(null);
            setTerminalType(null);
            setF22(null);
            setServiceCode(null);
            setF25(null);
            setServiceConditionCode(null);
            setF41(null);
            setCardAcceptorTerminalIdentification(null);
            setAcq(null);
            setAcquiringInstitutionCode(null);
            setIss(null);
            setIssuerMemberId(null);
            setMid(null);
            setMerchantIdentificationCode(null);
            setBnb(null);
            setBeneficiaryIdentify(null);
            setF102(null);
            setFromAccount(null);
            setF103(null);
            setToAccount(null);
            setF37(null);
            setRrn(null);
            setF38(null);
            setAuthorizationNumber(null);
            setTrn(null);
            setTransactionReferenceNumber(null);
            setRrc(null);
            setResponseCode(null);
            setRsv1Def(null);
            setRsv1(null);
            setRsv2Def(null);
            setRsv2(null);
            setRsv3Def(null);
            setRsv3(null);
            setCsr(null);
            setChecksumRecordValue(null);
        }
    }
    public class FileHeaderRecord {
        public void setHeaderRecord(java.lang.String p_headerRecord) {
           headerRecord = p_headerRecord;
        }
        public java.lang.String getHeaderRecord() {
          return headerRecord;
        }
        public void setBinDef(java.lang.String p_binDef) {
           binDef = p_binDef;
        }
        public java.lang.String getBinDef() {
          return binDef;
        }
        public void setBin(java.lang.String p_bin) {
           bin = p_bin;
        }
        public java.lang.String getBin() {
          return bin;
        }
        public void setDateDef(java.lang.String p_dateDef) {
           dateDef = p_dateDef;
        }
        public java.lang.String getDateDef() {
          return dateDef;
        }
        public void setTransactionDate(java.lang.String p_transactionDate) {
           transactionDate = p_transactionDate;
        }
        public java.lang.String getTransactionDate() {
          return transactionDate;
        }
        public void evaluate() {
            if(headerRecord == null)
                headerRecord="HR";
            if(binDef == null)
                binDef="[REV]";
            if(dateDef == null)
                dateDef="[DATE]";
        }
        public void update() throws Exception {
            evaluate();
            if(null==headerRecord && !false){
                 throw new Exception("headerRecord is null.");
            }
            set(fileHeaderRecordVectorMetaData.getVectorFieldMetaData("headerRecord"), headerRecord);
            if(null==binDef && !false){
                 throw new Exception("binDef is null.");
            }
            set(fileHeaderRecordVectorMetaData.getVectorFieldMetaData("binDef"), binDef);
            if(null==bin && !false){
                 throw new Exception("bin is null.");
            }
            set(fileHeaderRecordVectorMetaData.getVectorFieldMetaData("bin"), bin);
            if(null==dateDef && !false){
                 throw new Exception("dateDef is null.");
            }
            set(fileHeaderRecordVectorMetaData.getVectorFieldMetaData("dateDef"), dateDef);
            if(null==transactionDate && !false){
                 throw new Exception("transactionDate is null.");
            }
            set(fileHeaderRecordVectorMetaData.getVectorFieldMetaData("transactionDate"), transactionDate);
        }
        public void clear() {
            setHeaderRecord(null);
            setBinDef(null);
            setBin(null);
            setDateDef(null);
            setTransactionDate(null);
        }
    }
    public class FileTrailerRecord {
        public void setTrailerRecord(java.lang.String p_trailerRecord) {
           trailerRecord = p_trailerRecord;
        }
        public java.lang.String getTrailerRecord() {
          return trailerRecord;
        }
        public void setNotDef(java.lang.String p_notDef) {
           notDef = p_notDef;
        }
        public java.lang.String getNotDef() {
          return notDef;
        }
        public void setNumberOfRecordsInTheFile(java.lang.String p_numberOfRecordsInTheFile) {
           numberOfRecordsInTheFile = p_numberOfRecordsInTheFile;
        }
        public java.lang.String getNumberOfRecordsInTheFile() {
          return numberOfRecordsInTheFile;
        }
        public void setGeneratorDef(java.lang.String p_generatorDef) {
           generatorDef = p_generatorDef;
        }
        public java.lang.String getGeneratorDef() {
          return generatorDef;
        }
        public void setGenerator(java.lang.String p_generator) {
           generator = p_generator;
        }
        public java.lang.String getGenerator() {
          return generator;
        }
        public void setGenerateTimeDef(java.lang.String p_generateTimeDef) {
           generateTimeDef = p_generateTimeDef;
        }
        public java.lang.String getGenerateTimeDef() {
          return generateTimeDef;
        }
        public void setFileGenerationTime(java.lang.String p_fileGenerationTime) {
           fileGenerationTime = p_fileGenerationTime;
        }
        public java.lang.String getFileGenerationTime() {
          return fileGenerationTime;
        }
        public void setGenerateDateDef(java.lang.String p_generateDateDef) {
           generateDateDef = p_generateDateDef;
        }
        public java.lang.String getGenerateDateDef() {
          return generateDateDef;
        }
        public void setFileGenerationDate(java.lang.String p_fileGenerationDate) {
           fileGenerationDate = p_fileGenerationDate;
        }
        public java.lang.String getFileGenerationDate() {
          return fileGenerationDate;
        }
        public void setCsfDef(java.lang.String p_csfDef) {
           csfDef = p_csfDef;
        }
        public java.lang.String getCsfDef() {
          return csfDef;
        }
        public void setChecksumFileValue(java.lang.String p_checksumFileValue) {
           checksumFileValue = p_checksumFileValue;
        }
        public java.lang.String getChecksumFileValue() {
          return checksumFileValue;
        }
        public void evaluate() {
            if(trailerRecord == null)
                trailerRecord="TR";
            if(notDef == null)
                notDef="[NOT]";
            if(generatorDef == null)
                generatorDef="[CRE]";
            if(generateTimeDef == null)
                generateTimeDef="[TIME]";
            if(generateDateDef == null)
                generateDateDef="[DATE]";
            if(csfDef == null)
                csfDef="[CSF]";
        }
        public void update() throws Exception {
            evaluate();
            if(null==trailerRecord && !false){
                 throw new Exception("trailerRecord is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("trailerRecord"), trailerRecord);
            if(null==notDef && !false){
                 throw new Exception("notDef is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("notDef"), notDef);
            if(null==numberOfRecordsInTheFile && !false){
                 throw new Exception("numberOfRecordsInTheFile is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("numberOfRecordsInTheFile"), numberOfRecordsInTheFile);
            if(null==generatorDef && !false){
                 throw new Exception("generatorDef is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("generatorDef"), generatorDef);
            if(null==generator && !false){
                 throw new Exception("generator is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("generator"), generator);
            if(null==generateTimeDef && !false){
                 throw new Exception("generateTimeDef is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("generateTimeDef"), generateTimeDef);
            if(null==fileGenerationTime && !false){
                 throw new Exception("fileGenerationTime is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("fileGenerationTime"), fileGenerationTime);
            if(null==generateDateDef && !false){
                 throw new Exception("generateDateDef is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("generateDateDef"), generateDateDef);
            if(null==fileGenerationDate && !false){
                 throw new Exception("fileGenerationDate is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("fileGenerationDate"), fileGenerationDate);
            if(null==csfDef && !false){
                 throw new Exception("csfDef is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("csfDef"), csfDef);
            if(null==checksumFileValue && !false){
                 throw new Exception("checksumFileValue is null.");
            }
            set(fileTrailerRecordVectorMetaData.getVectorFieldMetaData("checksumFileValue"), checksumFileValue);
        }
        public void clear() {
            setTrailerRecord(null);
            setNotDef(null);
            setNumberOfRecordsInTheFile(null);
            setGeneratorDef(null);
            setGenerator(null);
            setGenerateTimeDef(null);
            setFileGenerationTime(null);
            setGenerateDateDef(null);
            setFileGenerationDate(null);
            setCsfDef(null);
            setChecksumFileValue(null);
        }
    }
}
