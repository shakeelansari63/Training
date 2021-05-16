package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.BankAccountDetailsNs3;
import com.ibm.demo.model.CreditAccountLinkDetailsNs3;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateDirectDebitsTns
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class UpdateDirectDebitsTns   {
  @JsonProperty("actionCode")
  private String actionCode = null;

  @JsonProperty("bankAccountDetails")
  private BankAccountDetailsNs3 bankAccountDetails = null;

  @JsonProperty("creditAccountLinkDeatils")
  private CreditAccountLinkDetailsNs3 creditAccountLinkDeatils = null;

  public UpdateDirectDebitsTns actionCode(String actionCode) {
    this.actionCode = actionCode;
    return this;
  }

  /**
   * Get actionCode
   * @return actionCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getActionCode() {
    return actionCode;
  }

  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  public UpdateDirectDebitsTns bankAccountDetails(BankAccountDetailsNs3 bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
    return this;
  }

  /**
   * Get bankAccountDetails
   * @return bankAccountDetails
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BankAccountDetailsNs3 getBankAccountDetails() {
    return bankAccountDetails;
  }

  public void setBankAccountDetails(BankAccountDetailsNs3 bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
  }

  public UpdateDirectDebitsTns creditAccountLinkDeatils(CreditAccountLinkDetailsNs3 creditAccountLinkDeatils) {
    this.creditAccountLinkDeatils = creditAccountLinkDeatils;
    return this;
  }

  /**
   * Get creditAccountLinkDeatils
   * @return creditAccountLinkDeatils
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CreditAccountLinkDetailsNs3 getCreditAccountLinkDeatils() {
    return creditAccountLinkDeatils;
  }

  public void setCreditAccountLinkDeatils(CreditAccountLinkDetailsNs3 creditAccountLinkDeatils) {
    this.creditAccountLinkDeatils = creditAccountLinkDeatils;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDirectDebitsTns updateDirectDebitsTns = (UpdateDirectDebitsTns) o;
    return Objects.equals(this.actionCode, updateDirectDebitsTns.actionCode) &&
        Objects.equals(this.bankAccountDetails, updateDirectDebitsTns.bankAccountDetails) &&
        Objects.equals(this.creditAccountLinkDeatils, updateDirectDebitsTns.creditAccountLinkDeatils);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionCode, bankAccountDetails, creditAccountLinkDeatils);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDirectDebitsTns {\n");
    
    sb.append("    actionCode: ").append(toIndentedString(actionCode)).append("\n");
    sb.append("    bankAccountDetails: ").append(toIndentedString(bankAccountDetails)).append("\n");
    sb.append("    creditAccountLinkDeatils: ").append(toIndentedString(creditAccountLinkDeatils)).append("\n");
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

