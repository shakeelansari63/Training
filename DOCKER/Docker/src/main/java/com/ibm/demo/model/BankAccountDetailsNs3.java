package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BankAccountDetailsNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class BankAccountDetailsNs3   {
  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("defaultAccountFlag")
  private String defaultAccountFlag = null;

  @JsonProperty("defaultFastCashAccountFlag")
  private String defaultFastCashAccountFlag = null;

  @JsonProperty("defaultPurchaseAccountFlag")
  private String defaultPurchaseAccountFlag = null;

  @JsonProperty("directDebitEnabledFlag")
  private String directDebitEnabledFlag = null;

  @JsonProperty("directDebitOrderNumber")
  private String directDebitOrderNumber = null;

  @JsonProperty("entityId")
  private String entityId = null;

  @JsonProperty("entityType")
  private String entityType = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("serviceIndex")
  private String serviceIndex = null;

  public BankAccountDetailsNs3 accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BankAccountDetailsNs3 accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public BankAccountDetailsNs3 defaultAccountFlag(String defaultAccountFlag) {
    this.defaultAccountFlag = defaultAccountFlag;
    return this;
  }

  /**
   * Get defaultAccountFlag
   * @return defaultAccountFlag
  **/
  @ApiModelProperty(value = "")


  public String getDefaultAccountFlag() {
    return defaultAccountFlag;
  }

  public void setDefaultAccountFlag(String defaultAccountFlag) {
    this.defaultAccountFlag = defaultAccountFlag;
  }

  public BankAccountDetailsNs3 defaultFastCashAccountFlag(String defaultFastCashAccountFlag) {
    this.defaultFastCashAccountFlag = defaultFastCashAccountFlag;
    return this;
  }

  /**
   * Get defaultFastCashAccountFlag
   * @return defaultFastCashAccountFlag
  **/
  @ApiModelProperty(value = "")


  public String getDefaultFastCashAccountFlag() {
    return defaultFastCashAccountFlag;
  }

  public void setDefaultFastCashAccountFlag(String defaultFastCashAccountFlag) {
    this.defaultFastCashAccountFlag = defaultFastCashAccountFlag;
  }

  public BankAccountDetailsNs3 defaultPurchaseAccountFlag(String defaultPurchaseAccountFlag) {
    this.defaultPurchaseAccountFlag = defaultPurchaseAccountFlag;
    return this;
  }

  /**
   * Get defaultPurchaseAccountFlag
   * @return defaultPurchaseAccountFlag
  **/
  @ApiModelProperty(value = "")


  public String getDefaultPurchaseAccountFlag() {
    return defaultPurchaseAccountFlag;
  }

  public void setDefaultPurchaseAccountFlag(String defaultPurchaseAccountFlag) {
    this.defaultPurchaseAccountFlag = defaultPurchaseAccountFlag;
  }

  public BankAccountDetailsNs3 directDebitEnabledFlag(String directDebitEnabledFlag) {
    this.directDebitEnabledFlag = directDebitEnabledFlag;
    return this;
  }

  /**
   * Get directDebitEnabledFlag
   * @return directDebitEnabledFlag
  **/
  @ApiModelProperty(value = "")


  public String getDirectDebitEnabledFlag() {
    return directDebitEnabledFlag;
  }

  public void setDirectDebitEnabledFlag(String directDebitEnabledFlag) {
    this.directDebitEnabledFlag = directDebitEnabledFlag;
  }

  public BankAccountDetailsNs3 directDebitOrderNumber(String directDebitOrderNumber) {
    this.directDebitOrderNumber = directDebitOrderNumber;
    return this;
  }

  /**
   * Get directDebitOrderNumber
   * @return directDebitOrderNumber
  **/
  @ApiModelProperty(value = "")


  public String getDirectDebitOrderNumber() {
    return directDebitOrderNumber;
  }

  public void setDirectDebitOrderNumber(String directDebitOrderNumber) {
    this.directDebitOrderNumber = directDebitOrderNumber;
  }

  public BankAccountDetailsNs3 entityId(String entityId) {
    this.entityId = entityId;
    return this;
  }

  /**
   * Get entityId
   * @return entityId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }

  public BankAccountDetailsNs3 entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Get entityType
   * @return entityType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public BankAccountDetailsNs3 iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  **/
  @ApiModelProperty(value = "")


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public BankAccountDetailsNs3 serviceIndex(String serviceIndex) {
    this.serviceIndex = serviceIndex;
    return this;
  }

  /**
   * Get serviceIndex
   * @return serviceIndex
  **/
  @ApiModelProperty(value = "")


  public String getServiceIndex() {
    return serviceIndex;
  }

  public void setServiceIndex(String serviceIndex) {
    this.serviceIndex = serviceIndex;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccountDetailsNs3 bankAccountDetailsNs3 = (BankAccountDetailsNs3) o;
    return Objects.equals(this.accountNumber, bankAccountDetailsNs3.accountNumber) &&
        Objects.equals(this.accountType, bankAccountDetailsNs3.accountType) &&
        Objects.equals(this.defaultAccountFlag, bankAccountDetailsNs3.defaultAccountFlag) &&
        Objects.equals(this.defaultFastCashAccountFlag, bankAccountDetailsNs3.defaultFastCashAccountFlag) &&
        Objects.equals(this.defaultPurchaseAccountFlag, bankAccountDetailsNs3.defaultPurchaseAccountFlag) &&
        Objects.equals(this.directDebitEnabledFlag, bankAccountDetailsNs3.directDebitEnabledFlag) &&
        Objects.equals(this.directDebitOrderNumber, bankAccountDetailsNs3.directDebitOrderNumber) &&
        Objects.equals(this.entityId, bankAccountDetailsNs3.entityId) &&
        Objects.equals(this.entityType, bankAccountDetailsNs3.entityType) &&
        Objects.equals(this.iban, bankAccountDetailsNs3.iban) &&
        Objects.equals(this.serviceIndex, bankAccountDetailsNs3.serviceIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, accountType, defaultAccountFlag, defaultFastCashAccountFlag, defaultPurchaseAccountFlag, directDebitEnabledFlag, directDebitOrderNumber, entityId, entityType, iban, serviceIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccountDetailsNs3 {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    defaultAccountFlag: ").append(toIndentedString(defaultAccountFlag)).append("\n");
    sb.append("    defaultFastCashAccountFlag: ").append(toIndentedString(defaultFastCashAccountFlag)).append("\n");
    sb.append("    defaultPurchaseAccountFlag: ").append(toIndentedString(defaultPurchaseAccountFlag)).append("\n");
    sb.append("    directDebitEnabledFlag: ").append(toIndentedString(directDebitEnabledFlag)).append("\n");
    sb.append("    directDebitOrderNumber: ").append(toIndentedString(directDebitOrderNumber)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    serviceIndex: ").append(toIndentedString(serviceIndex)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

