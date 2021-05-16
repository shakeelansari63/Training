package com.ibm.demo.model;

import com.ibm.demo.model.CreateCardTransactionOutput;

public class CreateCardTransactionP {

    private CreateCardTransactionInput body;
    private String branchId;
    private String correlationId;
    private String financialInstitution;
    private String journeyId;
    private String key;
    private String lang;
    private String originChannelId;
    private String originDeptId;
    private String originEmployeeId;
    private String originSourceId;
    private String originTerminalId;
    private String originUserId;
    private String providerLogin;
    private String providerPassword;
    private String timeStamp;
    private String value;

    public CreateCardTransactionP() {

    }

    public CreateCardTransactionP(CreateCardTransactionInput body,String branchId,String correlationId,String financialInstitution,String journeyId,String key,String lang,String originChannelId,String originDeptId,String originEmployeeId,String originSourceId,String originTerminalId,String originUserId,String providerLogin,String providerPassword,String timeStamp,String value) {
        this.body = body;
        this.branchId = branchId;
        this.correlationId = correlationId;
        this.financialInstitution = financialInstitution;
        this.journeyId = journeyId;
        this.key = key;
        this.lang = lang;
        this.originChannelId = originChannelId;
        this.originDeptId = originDeptId;
        this.originEmployeeId = originEmployeeId;
        this.originSourceId = originSourceId;
        this.originTerminalId = originTerminalId;
        this.originUserId = originUserId;
        this.providerLogin = providerLogin;
        this.providerPassword = providerPassword;
        this.timeStamp = timeStamp;
        this.value = value;
    }

    public CreateCardTransactionInput getBody () {
        return body;
    }

    public void setBody (CreateCardTransactionInput body) {
        this.body = body;
    }
    public String getBranchId () {
        return branchId;
    }

    public void setBranchId (String branchId) {
        this.branchId = branchId;
    }
    public String getCorrelationId () {
        return correlationId;
    }

    public void setCorrelationId (String correlationId) {
        this.correlationId = correlationId;
    }
    public String getFinancialInstitution () {
        return financialInstitution;
    }

    public void setFinancialInstitution (String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }
    public String getJourneyId () {
        return journeyId;
    }

    public void setJourneyId (String journeyId) {
        this.journeyId = journeyId;
    }
    public String getKey () {
        return key;
    }

    public void setKey (String key) {
        this.key = key;
    }
    public String getLang () {
        return lang;
    }

    public void setLang (String lang) {
        this.lang = lang;
    }
    public String getOriginChannelId () {
        return originChannelId;
    }

    public void setOriginChannelId (String originChannelId) {
        this.originChannelId = originChannelId;
    }
    public String getOriginDeptId () {
        return originDeptId;
    }

    public void setOriginDeptId (String originDeptId) {
        this.originDeptId = originDeptId;
    }
    public String getOriginEmployeeId () {
        return originEmployeeId;
    }

    public void setOriginEmployeeId (String originEmployeeId) {
        this.originEmployeeId = originEmployeeId;
    }
    public String getOriginSourceId () {
        return originSourceId;
    }

    public void setOriginSourceId (String originSourceId) {
        this.originSourceId = originSourceId;
    }
    public String getOriginTerminalId () {
        return originTerminalId;
    }

    public void setOriginTerminalId (String originTerminalId) {
        this.originTerminalId = originTerminalId;
    }
    public String getOriginUserId () {
        return originUserId;
    }

    public void setOriginUserId (String originUserId) {
        this.originUserId = originUserId;
    }
    public String getProviderLogin () {
        return providerLogin;
    }

    public void setProviderLogin (String providerLogin) {
        this.providerLogin = providerLogin;
    }
    public String getProviderPassword () {
        return providerPassword;
    }

    public void setProviderPassword (String providerPassword) {
        this.providerPassword = providerPassword;
    }
    public String getTimeStamp () {
        return timeStamp;
    }

    public void setTimeStamp (String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getValue () {
        return value;
    }

    public void setValue (String value) {
        this.value = value;
    }

}
