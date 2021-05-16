package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountTransactionNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class AccountTransactionNs3   {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("debitValueDate")
  private String debitValueDate = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("originalReference")
  private String originalReference = null;

  @JsonProperty("originalSequence")
  private String originalSequence = null;

  @JsonProperty("reversalFlag")
  private String reversalFlag = null;

  @JsonProperty("transactionCode")
  private String transactionCode = null;

  public AccountTransactionNs3 amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 0
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AccountTransactionNs3 currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AccountTransactionNs3 debitValueDate(String debitValueDate) {
    this.debitValueDate = debitValueDate;
    return this;
  }

  /**
   * Get debitValueDate
   * @return debitValueDate
  **/
  @ApiModelProperty(value = "")


  public String getDebitValueDate() {
    return debitValueDate;
  }

  public void setDebitValueDate(String debitValueDate) {
    this.debitValueDate = debitValueDate;
  }

  public AccountTransactionNs3 description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AccountTransactionNs3 originalReference(String originalReference) {
    this.originalReference = originalReference;
    return this;
  }

  /**
   * Get originalReference
   * @return originalReference
  **/
  @ApiModelProperty(value = "")


  public String getOriginalReference() {
    return originalReference;
  }

  public void setOriginalReference(String originalReference) {
    this.originalReference = originalReference;
  }

  public AccountTransactionNs3 originalSequence(String originalSequence) {
    this.originalSequence = originalSequence;
    return this;
  }

  /**
   * Get originalSequence
   * @return originalSequence
  **/
  @ApiModelProperty(value = "")


  public String getOriginalSequence() {
    return originalSequence;
  }

  public void setOriginalSequence(String originalSequence) {
    this.originalSequence = originalSequence;
  }

  public AccountTransactionNs3 reversalFlag(String reversalFlag) {
    this.reversalFlag = reversalFlag;
    return this;
  }

  /**
   * Get reversalFlag
   * @return reversalFlag
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getReversalFlag() {
    return reversalFlag;
  }

  public void setReversalFlag(String reversalFlag) {
    this.reversalFlag = reversalFlag;
  }

  public AccountTransactionNs3 transactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
    return this;
  }

  /**
   * Get transactionCode
   * @return transactionCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionNs3 accountTransactionNs3 = (AccountTransactionNs3) o;
    return Objects.equals(this.amount, accountTransactionNs3.amount) &&
        Objects.equals(this.currency, accountTransactionNs3.currency) &&
        Objects.equals(this.debitValueDate, accountTransactionNs3.debitValueDate) &&
        Objects.equals(this.description, accountTransactionNs3.description) &&
        Objects.equals(this.originalReference, accountTransactionNs3.originalReference) &&
        Objects.equals(this.originalSequence, accountTransactionNs3.originalSequence) &&
        Objects.equals(this.reversalFlag, accountTransactionNs3.reversalFlag) &&
        Objects.equals(this.transactionCode, accountTransactionNs3.transactionCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, debitValueDate, description, originalReference, originalSequence, reversalFlag, transactionCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionNs3 {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    debitValueDate: ").append(toIndentedString(debitValueDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
    sb.append("    originalSequence: ").append(toIndentedString(originalSequence)).append("\n");
    sb.append("    reversalFlag: ").append(toIndentedString(reversalFlag)).append("\n");
    sb.append("    transactionCode: ").append(toIndentedString(transactionCode)).append("\n");
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

