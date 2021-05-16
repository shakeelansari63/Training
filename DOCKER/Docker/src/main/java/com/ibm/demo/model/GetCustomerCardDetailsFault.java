package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCustomerCardDetailsFault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class GetCustomerCardDetailsFault   {
  @JsonProperty("getCustomerCardDetailsFault")
  private ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns getCustomerCardDetailsFault = null;

  public GetCustomerCardDetailsFault getCustomerCardDetailsFault(ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns getCustomerCardDetailsFault) {
    this.getCustomerCardDetailsFault = getCustomerCardDetailsFault;
    return this;
  }

  /**
   * Get getCustomerCardDetailsFault
   * @return getCustomerCardDetailsFault
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns getGetCustomerCardDetailsFault() {
    return getCustomerCardDetailsFault;
  }

  public void setGetCustomerCardDetailsFault(ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns getCustomerCardDetailsFault) {
    this.getCustomerCardDetailsFault = getCustomerCardDetailsFault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCustomerCardDetailsFault getCustomerCardDetailsFault = (GetCustomerCardDetailsFault) o;
    return Objects.equals(this.getCustomerCardDetailsFault, getCustomerCardDetailsFault.getCustomerCardDetailsFault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCustomerCardDetailsFault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCustomerCardDetailsFault {\n");
    
    sb.append("    getCustomerCardDetailsFault: ").append(toIndentedString(getCustomerCardDetailsFault)).append("\n");
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

