package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.ICardManagementFinancialTransactiongetCardAccountEnquiryFaultTns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCardAccountEnquiryFault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class GetCardAccountEnquiryFault   {
  @JsonProperty("getCardAccountEnquiryFault")
  private ICardManagementFinancialTransactiongetCardAccountEnquiryFaultTns getCardAccountEnquiryFault = null;

  public GetCardAccountEnquiryFault getCardAccountEnquiryFault(ICardManagementFinancialTransactiongetCardAccountEnquiryFaultTns getCardAccountEnquiryFault) {
    this.getCardAccountEnquiryFault = getCardAccountEnquiryFault;
    return this;
  }

  /**
   * Get getCardAccountEnquiryFault
   * @return getCardAccountEnquiryFault
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ICardManagementFinancialTransactiongetCardAccountEnquiryFaultTns getGetCardAccountEnquiryFault() {
    return getCardAccountEnquiryFault;
  }

  public void setGetCardAccountEnquiryFault(ICardManagementFinancialTransactiongetCardAccountEnquiryFaultTns getCardAccountEnquiryFault) {
    this.getCardAccountEnquiryFault = getCardAccountEnquiryFault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCardAccountEnquiryFault getCardAccountEnquiryFault = (GetCardAccountEnquiryFault) o;
    return Objects.equals(this.getCardAccountEnquiryFault, getCardAccountEnquiryFault.getCardAccountEnquiryFault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCardAccountEnquiryFault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCardAccountEnquiryFault {\n");
    
    sb.append("    getCardAccountEnquiryFault: ").append(toIndentedString(getCardAccountEnquiryFault)).append("\n");
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

