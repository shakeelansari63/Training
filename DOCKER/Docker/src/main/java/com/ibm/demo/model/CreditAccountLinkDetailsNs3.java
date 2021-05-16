package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.LimitTypeNs3;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditAccountLinkDetailsNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class CreditAccountLinkDetailsNs3   {
  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("creditProfile")
  private String creditProfile = null;

  @JsonProperty("cycleCode")
  private String cycleCode = null;

  @JsonProperty("directDebitOption")
  private String directDebitOption = null;

  @JsonProperty("interestIndex")
  private String interestIndex = null;

  @JsonProperty("limits")
  private LimitTypeNs3 limits = null;

  @JsonProperty("minDueIndex")
  private String minDueIndex = null;

  @JsonProperty("penalityFeeWaiver")
  private String penalityFeeWaiver = null;

  @JsonProperty("statementCode")
  private String statementCode = null;

  @JsonProperty("statementOption")
  private String statementOption = null;

  @JsonProperty("updateCreditAccountPaymentMode")
  private String updateCreditAccountPaymentMode = null;

  public CreditAccountLinkDetailsNs3 accountNumber(String accountNumber) {
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

  public CreditAccountLinkDetailsNs3 creditProfile(String creditProfile) {
    this.creditProfile = creditProfile;
    return this;
  }

  /**
   * Get creditProfile
   * @return creditProfile
  **/
  @ApiModelProperty(value = "")


  public String getCreditProfile() {
    return creditProfile;
  }

  public void setCreditProfile(String creditProfile) {
    this.creditProfile = creditProfile;
  }

  public CreditAccountLinkDetailsNs3 cycleCode(String cycleCode) {
    this.cycleCode = cycleCode;
    return this;
  }

  /**
   * Get cycleCode
   * @return cycleCode
  **/
  @ApiModelProperty(value = "")


  public String getCycleCode() {
    return cycleCode;
  }

  public void setCycleCode(String cycleCode) {
    this.cycleCode = cycleCode;
  }

  public CreditAccountLinkDetailsNs3 directDebitOption(String directDebitOption) {
    this.directDebitOption = directDebitOption;
    return this;
  }

  /**
   * Get directDebitOption
   * @return directDebitOption
  **/
  @ApiModelProperty(value = "")


  public String getDirectDebitOption() {
    return directDebitOption;
  }

  public void setDirectDebitOption(String directDebitOption) {
    this.directDebitOption = directDebitOption;
  }

  public CreditAccountLinkDetailsNs3 interestIndex(String interestIndex) {
    this.interestIndex = interestIndex;
    return this;
  }

  /**
   * Get interestIndex
   * @return interestIndex
  **/
  @ApiModelProperty(value = "")


  public String getInterestIndex() {
    return interestIndex;
  }

  public void setInterestIndex(String interestIndex) {
    this.interestIndex = interestIndex;
  }

  public CreditAccountLinkDetailsNs3 limits(LimitTypeNs3 limits) {
    this.limits = limits;
    return this;
  }

  /**
   * Get limits
   * @return limits
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LimitTypeNs3 getLimits() {
    return limits;
  }

  public void setLimits(LimitTypeNs3 limits) {
    this.limits = limits;
  }

  public CreditAccountLinkDetailsNs3 minDueIndex(String minDueIndex) {
    this.minDueIndex = minDueIndex;
    return this;
  }

  /**
   * Get minDueIndex
   * @return minDueIndex
  **/
  @ApiModelProperty(value = "")


  public String getMinDueIndex() {
    return minDueIndex;
  }

  public void setMinDueIndex(String minDueIndex) {
    this.minDueIndex = minDueIndex;
  }

  public CreditAccountLinkDetailsNs3 penalityFeeWaiver(String penalityFeeWaiver) {
    this.penalityFeeWaiver = penalityFeeWaiver;
    return this;
  }

  /**
   * Get penalityFeeWaiver
   * @return penalityFeeWaiver
  **/
  @ApiModelProperty(value = "")


  public String getPenalityFeeWaiver() {
    return penalityFeeWaiver;
  }

  public void setPenalityFeeWaiver(String penalityFeeWaiver) {
    this.penalityFeeWaiver = penalityFeeWaiver;
  }

  public CreditAccountLinkDetailsNs3 statementCode(String statementCode) {
    this.statementCode = statementCode;
    return this;
  }

  /**
   * Get statementCode
   * @return statementCode
  **/
  @ApiModelProperty(value = "")


  public String getStatementCode() {
    return statementCode;
  }

  public void setStatementCode(String statementCode) {
    this.statementCode = statementCode;
  }

  public CreditAccountLinkDetailsNs3 statementOption(String statementOption) {
    this.statementOption = statementOption;
    return this;
  }

  /**
   * Get statementOption
   * @return statementOption
  **/
  @ApiModelProperty(value = "")


  public String getStatementOption() {
    return statementOption;
  }

  public void setStatementOption(String statementOption) {
    this.statementOption = statementOption;
  }

  public CreditAccountLinkDetailsNs3 updateCreditAccountPaymentMode(String updateCreditAccountPaymentMode) {
    this.updateCreditAccountPaymentMode = updateCreditAccountPaymentMode;
    return this;
  }

  /**
   * Get updateCreditAccountPaymentMode
   * @return updateCreditAccountPaymentMode
  **/
  @ApiModelProperty(value = "")


  public String getUpdateCreditAccountPaymentMode() {
    return updateCreditAccountPaymentMode;
  }

  public void setUpdateCreditAccountPaymentMode(String updateCreditAccountPaymentMode) {
    this.updateCreditAccountPaymentMode = updateCreditAccountPaymentMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditAccountLinkDetailsNs3 creditAccountLinkDetailsNs3 = (CreditAccountLinkDetailsNs3) o;
    return Objects.equals(this.accountNumber, creditAccountLinkDetailsNs3.accountNumber) &&
        Objects.equals(this.creditProfile, creditAccountLinkDetailsNs3.creditProfile) &&
        Objects.equals(this.cycleCode, creditAccountLinkDetailsNs3.cycleCode) &&
        Objects.equals(this.directDebitOption, creditAccountLinkDetailsNs3.directDebitOption) &&
        Objects.equals(this.interestIndex, creditAccountLinkDetailsNs3.interestIndex) &&
        Objects.equals(this.limits, creditAccountLinkDetailsNs3.limits) &&
        Objects.equals(this.minDueIndex, creditAccountLinkDetailsNs3.minDueIndex) &&
        Objects.equals(this.penalityFeeWaiver, creditAccountLinkDetailsNs3.penalityFeeWaiver) &&
        Objects.equals(this.statementCode, creditAccountLinkDetailsNs3.statementCode) &&
        Objects.equals(this.statementOption, creditAccountLinkDetailsNs3.statementOption) &&
        Objects.equals(this.updateCreditAccountPaymentMode, creditAccountLinkDetailsNs3.updateCreditAccountPaymentMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, creditProfile, cycleCode, directDebitOption, interestIndex, limits, minDueIndex, penalityFeeWaiver, statementCode, statementOption, updateCreditAccountPaymentMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditAccountLinkDetailsNs3 {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
    sb.append("    cycleCode: ").append(toIndentedString(cycleCode)).append("\n");
    sb.append("    directDebitOption: ").append(toIndentedString(directDebitOption)).append("\n");
    sb.append("    interestIndex: ").append(toIndentedString(interestIndex)).append("\n");
    sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
    sb.append("    minDueIndex: ").append(toIndentedString(minDueIndex)).append("\n");
    sb.append("    penalityFeeWaiver: ").append(toIndentedString(penalityFeeWaiver)).append("\n");
    sb.append("    statementCode: ").append(toIndentedString(statementCode)).append("\n");
    sb.append("    statementOption: ").append(toIndentedString(statementOption)).append("\n");
    sb.append("    updateCreditAccountPaymentMode: ").append(toIndentedString(updateCreditAccountPaymentMode)).append("\n");
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

