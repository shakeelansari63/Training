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
 * CardDetailsNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class CardDetailsNs3   {
  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("activationFlag")
  private String activationFlag = null;

  @JsonProperty("cardActivationDate")
  private String cardActivationDate = null;

  @JsonProperty("cardFeesCode")
  private String cardFeesCode = null;

  @JsonProperty("cardHolderName")
  private String cardHolderName = null;

  @JsonProperty("cardHolderType")
  private String cardHolderType = null;

  @JsonProperty("cardStatus")
  private String cardStatus = null;

  @JsonProperty("cardStatusDate")
  private String cardStatusDate = null;

  @JsonProperty("cardToken")
  private String cardToken = null;

  @JsonProperty("clientCode")
  private String clientCode = null;

  @JsonProperty("corporateEmbossedName")
  private String corporateEmbossedName = null;

  @JsonProperty("corporateId")
  private String corporateId = null;

  @JsonProperty("expiryDate")
  private String expiryDate = null;

  @JsonProperty("formerExpiryDate")
  private String formerExpiryDate = null;

  @JsonProperty("issueDate")
  private String issueDate = null;

  @JsonProperty("maskedCard")
  private String maskedCard = null;

  @JsonProperty("parentCardNumber")
  private String parentCardNumber = null;

  @JsonProperty("previousCardNumber")
  private String previousCardNumber = null;

  @JsonProperty("productCode")
  private String productCode = null;

  @JsonProperty("reportingBranch")
  private String reportingBranch = null;

  @JsonProperty("stopListFlag")
  private String stopListFlag = null;

  @JsonProperty("stopListRangeDate")
  private String stopListRangeDate = null;

  @JsonProperty("stopListReasonCode")
  private String stopListReasonCode = null;

  @JsonProperty("userCif")
  private String userCif = null;

  public CardDetailsNs3 accountNumber(String accountNumber) {
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

  public CardDetailsNs3 activationFlag(String activationFlag) {
    this.activationFlag = activationFlag;
    return this;
  }

  /**
   * This field indicates whether the card is activated or not.
   * @return activationFlag
  **/
  @ApiModelProperty(required = true, value = "This field indicates whether the card is activated or not.")
  @NotNull


  public String getActivationFlag() {
    return activationFlag;
  }

  public void setActivationFlag(String activationFlag) {
    this.activationFlag = activationFlag;
  }

  public CardDetailsNs3 cardActivationDate(String cardActivationDate) {
    this.cardActivationDate = cardActivationDate;
    return this;
  }

  /**
   * This field indicates the last card activation date
   * @return cardActivationDate
  **/
  @ApiModelProperty(required = true, value = "This field indicates the last card activation date")
  @NotNull


  public String getCardActivationDate() {
    return cardActivationDate;
  }

  public void setCardActivationDate(String cardActivationDate) {
    this.cardActivationDate = cardActivationDate;
  }

  public CardDetailsNs3 cardFeesCode(String cardFeesCode) {
    this.cardFeesCode = cardFeesCode;
    return this;
  }

  /**
   * Refers to the card fee code that will be assigned to the customer primary card number of the customer being sent in the request
   * @return cardFeesCode
  **/
  @ApiModelProperty(required = true, value = "Refers to the card fee code that will be assigned to the customer primary card number of the customer being sent in the request")
  @NotNull


  public String getCardFeesCode() {
    return cardFeesCode;
  }

  public void setCardFeesCode(String cardFeesCode) {
    this.cardFeesCode = cardFeesCode;
  }

  public CardDetailsNs3 cardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  /**
   * Card Holder Name
   * @return cardHolderName
  **/
  @ApiModelProperty(required = true, value = "Card Holder Name")
  @NotNull


  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public CardDetailsNs3 cardHolderType(String cardHolderType) {
    this.cardHolderType = cardHolderType;
    return this;
  }

  /**
   * Get cardHolderType
   * @return cardHolderType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCardHolderType() {
    return cardHolderType;
  }

  public void setCardHolderType(String cardHolderType) {
    this.cardHolderType = cardHolderType;
  }

  public CardDetailsNs3 cardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
    return this;
  }

  /**
   * Status of the card
   * @return cardStatus
  **/
  @ApiModelProperty(required = true, value = "Status of the card")
  @NotNull


  public String getCardStatus() {
    return cardStatus;
  }

  public void setCardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
  }

  public CardDetailsNs3 cardStatusDate(String cardStatusDate) {
    this.cardStatusDate = cardStatusDate;
    return this;
  }

  /**
   * Last Status Change Date
   * @return cardStatusDate
  **/
  @ApiModelProperty(required = true, value = "Last Status Change Date")
  @NotNull


  public String getCardStatusDate() {
    return cardStatusDate;
  }

  public void setCardStatusDate(String cardStatusDate) {
    this.cardStatusDate = cardStatusDate;
  }

  public CardDetailsNs3 cardToken(String cardToken) {
    this.cardToken = cardToken;
    return this;
  }

  /**
   * Get cardToken
   * @return cardToken
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
  }

  public CardDetailsNs3 clientCode(String clientCode) {
    this.clientCode = clientCode;
    return this;
  }

  /**
   * Client code linked to the card
   * @return clientCode
  **/
  @ApiModelProperty(required = true, value = "Client code linked to the card")
  @NotNull


  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  public CardDetailsNs3 corporateEmbossedName(String corporateEmbossedName) {
    this.corporateEmbossedName = corporateEmbossedName;
    return this;
  }

  /**
   * Card Corporate Embossed Name
   * @return corporateEmbossedName
  **/
  @ApiModelProperty(value = "Card Corporate Embossed Name")


  public String getCorporateEmbossedName() {
    return corporateEmbossedName;
  }

  public void setCorporateEmbossedName(String corporateEmbossedName) {
    this.corporateEmbossedName = corporateEmbossedName;
  }

  public CardDetailsNs3 corporateId(String corporateId) {
    this.corporateId = corporateId;
    return this;
  }

  /**
   * Get corporateId
   * @return corporateId
  **/
  @ApiModelProperty(value = "")


  public String getCorporateId() {
    return corporateId;
  }

  public void setCorporateId(String corporateId) {
    this.corporateId = corporateId;
  }

  public CardDetailsNs3 expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Card Expiry Date
   * @return expiryDate
  **/
  @ApiModelProperty(required = true, value = "Card Expiry Date")
  @NotNull


  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public CardDetailsNs3 formerExpiryDate(String formerExpiryDate) {
    this.formerExpiryDate = formerExpiryDate;
    return this;
  }

  /**
   * Renewed Card Expiry Date
   * @return formerExpiryDate
  **/
  @ApiModelProperty(required = true, value = "Renewed Card Expiry Date")
  @NotNull


  public String getFormerExpiryDate() {
    return formerExpiryDate;
  }

  public void setFormerExpiryDate(String formerExpiryDate) {
    this.formerExpiryDate = formerExpiryDate;
  }

  public CardDetailsNs3 issueDate(String issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Identification issue date
   * @return issueDate
  **/
  @ApiModelProperty(required = true, value = "Identification issue date")
  @NotNull


  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public CardDetailsNs3 maskedCard(String maskedCard) {
    this.maskedCard = maskedCard;
    return this;
  }

  /**
   * Masked card number
   * @return maskedCard
  **/
  @ApiModelProperty(required = true, value = "Masked card number")
  @NotNull


  public String getMaskedCard() {
    return maskedCard;
  }

  public void setMaskedCard(String maskedCard) {
    this.maskedCard = maskedCard;
  }

  public CardDetailsNs3 parentCardNumber(String parentCardNumber) {
    this.parentCardNumber = parentCardNumber;
    return this;
  }

  /**
   * Card Owner Code. The information will be retreived when the card is secondary and has a link to the prilmary card number 
   * @return parentCardNumber
  **/
  @ApiModelProperty(value = "Card Owner Code. The information will be retreived when the card is secondary and has a link to the prilmary card number ")


  public String getParentCardNumber() {
    return parentCardNumber;
  }

  public void setParentCardNumber(String parentCardNumber) {
    this.parentCardNumber = parentCardNumber;
  }

  public CardDetailsNs3 previousCardNumber(String previousCardNumber) {
    this.previousCardNumber = previousCardNumber;
    return this;
  }

  /**
   * Previous card number in case the card has been replaced
   * @return previousCardNumber
  **/
  @ApiModelProperty(value = "Previous card number in case the card has been replaced")


  public String getPreviousCardNumber() {
    return previousCardNumber;
  }

  public void setPreviousCardNumber(String previousCardNumber) {
    this.previousCardNumber = previousCardNumber;
  }

  public CardDetailsNs3 productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

  /**
   * Get productCode
   * @return productCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public CardDetailsNs3 reportingBranch(String reportingBranch) {
    this.reportingBranch = reportingBranch;
    return this;
  }

  /**
   * Get reportingBranch
   * @return reportingBranch
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getReportingBranch() {
    return reportingBranch;
  }

  public void setReportingBranch(String reportingBranch) {
    this.reportingBranch = reportingBranch;
  }

  public CardDetailsNs3 stopListFlag(String stopListFlag) {
    this.stopListFlag = stopListFlag;
    return this;
  }

  /**
   * This field indicates whether the card is stop listed or not. 
   * @return stopListFlag
  **/
  @ApiModelProperty(value = "This field indicates whether the card is stop listed or not. ")


  public String getStopListFlag() {
    return stopListFlag;
  }

  public void setStopListFlag(String stopListFlag) {
    this.stopListFlag = stopListFlag;
  }

  public CardDetailsNs3 stopListRangeDate(String stopListRangeDate) {
    this.stopListRangeDate = stopListRangeDate;
    return this;
  }

  /**
   * Refers to the period where the card is placed in stop list.
   * @return stopListRangeDate
  **/
  @ApiModelProperty(value = "Refers to the period where the card is placed in stop list.")


  public String getStopListRangeDate() {
    return stopListRangeDate;
  }

  public void setStopListRangeDate(String stopListRangeDate) {
    this.stopListRangeDate = stopListRangeDate;
  }

  public CardDetailsNs3 stopListReasonCode(String stopListReasonCode) {
    this.stopListReasonCode = stopListReasonCode;
    return this;
  }

  /**
   * Reason code indicates the reason behind putting the card in the stop list
   * @return stopListReasonCode
  **/
  @ApiModelProperty(value = "Reason code indicates the reason behind putting the card in the stop list")


  public String getStopListReasonCode() {
    return stopListReasonCode;
  }

  public void setStopListReasonCode(String stopListReasonCode) {
    this.stopListReasonCode = stopListReasonCode;
  }

  public CardDetailsNs3 userCif(String userCif) {
    this.userCif = userCif;
    return this;
  }

  /**
   * Get userCif
   * @return userCif
  **/
  @ApiModelProperty(value = "")


  public String getUserCif() {
    return userCif;
  }

  public void setUserCif(String userCif) {
    this.userCif = userCif;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardDetailsNs3 cardDetailsNs3 = (CardDetailsNs3) o;
    return Objects.equals(this.accountNumber, cardDetailsNs3.accountNumber) &&
        Objects.equals(this.activationFlag, cardDetailsNs3.activationFlag) &&
        Objects.equals(this.cardActivationDate, cardDetailsNs3.cardActivationDate) &&
        Objects.equals(this.cardFeesCode, cardDetailsNs3.cardFeesCode) &&
        Objects.equals(this.cardHolderName, cardDetailsNs3.cardHolderName) &&
        Objects.equals(this.cardHolderType, cardDetailsNs3.cardHolderType) &&
        Objects.equals(this.cardStatus, cardDetailsNs3.cardStatus) &&
        Objects.equals(this.cardStatusDate, cardDetailsNs3.cardStatusDate) &&
        Objects.equals(this.cardToken, cardDetailsNs3.cardToken) &&
        Objects.equals(this.clientCode, cardDetailsNs3.clientCode) &&
        Objects.equals(this.corporateEmbossedName, cardDetailsNs3.corporateEmbossedName) &&
        Objects.equals(this.corporateId, cardDetailsNs3.corporateId) &&
        Objects.equals(this.expiryDate, cardDetailsNs3.expiryDate) &&
        Objects.equals(this.formerExpiryDate, cardDetailsNs3.formerExpiryDate) &&
        Objects.equals(this.issueDate, cardDetailsNs3.issueDate) &&
        Objects.equals(this.maskedCard, cardDetailsNs3.maskedCard) &&
        Objects.equals(this.parentCardNumber, cardDetailsNs3.parentCardNumber) &&
        Objects.equals(this.previousCardNumber, cardDetailsNs3.previousCardNumber) &&
        Objects.equals(this.productCode, cardDetailsNs3.productCode) &&
        Objects.equals(this.reportingBranch, cardDetailsNs3.reportingBranch) &&
        Objects.equals(this.stopListFlag, cardDetailsNs3.stopListFlag) &&
        Objects.equals(this.stopListRangeDate, cardDetailsNs3.stopListRangeDate) &&
        Objects.equals(this.stopListReasonCode, cardDetailsNs3.stopListReasonCode) &&
        Objects.equals(this.userCif, cardDetailsNs3.userCif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, activationFlag, cardActivationDate, cardFeesCode, cardHolderName, cardHolderType, cardStatus, cardStatusDate, cardToken, clientCode, corporateEmbossedName, corporateId, expiryDate, formerExpiryDate, issueDate, maskedCard, parentCardNumber, previousCardNumber, productCode, reportingBranch, stopListFlag, stopListRangeDate, stopListReasonCode, userCif);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardDetailsNs3 {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    activationFlag: ").append(toIndentedString(activationFlag)).append("\n");
    sb.append("    cardActivationDate: ").append(toIndentedString(cardActivationDate)).append("\n");
    sb.append("    cardFeesCode: ").append(toIndentedString(cardFeesCode)).append("\n");
    sb.append("    cardHolderName: ").append(toIndentedString(cardHolderName)).append("\n");
    sb.append("    cardHolderType: ").append(toIndentedString(cardHolderType)).append("\n");
    sb.append("    cardStatus: ").append(toIndentedString(cardStatus)).append("\n");
    sb.append("    cardStatusDate: ").append(toIndentedString(cardStatusDate)).append("\n");
    sb.append("    cardToken: ").append(toIndentedString(cardToken)).append("\n");
    sb.append("    clientCode: ").append(toIndentedString(clientCode)).append("\n");
    sb.append("    corporateEmbossedName: ").append(toIndentedString(corporateEmbossedName)).append("\n");
    sb.append("    corporateId: ").append(toIndentedString(corporateId)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    formerExpiryDate: ").append(toIndentedString(formerExpiryDate)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    maskedCard: ").append(toIndentedString(maskedCard)).append("\n");
    sb.append("    parentCardNumber: ").append(toIndentedString(parentCardNumber)).append("\n");
    sb.append("    previousCardNumber: ").append(toIndentedString(previousCardNumber)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    reportingBranch: ").append(toIndentedString(reportingBranch)).append("\n");
    sb.append("    stopListFlag: ").append(toIndentedString(stopListFlag)).append("\n");
    sb.append("    stopListRangeDate: ").append(toIndentedString(stopListRangeDate)).append("\n");
    sb.append("    stopListReasonCode: ").append(toIndentedString(stopListReasonCode)).append("\n");
    sb.append("    userCif: ").append(toIndentedString(userCif)).append("\n");
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

