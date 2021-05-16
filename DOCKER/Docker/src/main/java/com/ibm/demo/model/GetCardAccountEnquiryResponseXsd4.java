package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.AccountDetailsNs3;
import com.ibm.demo.model.ResponseHeaderXsd1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCardAccountEnquiryResponseXsd4
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class GetCardAccountEnquiryResponseXsd4   {
  @JsonProperty("payload")
  private AccountDetailsNs3 payload = null;

  @JsonProperty("responseHeader")
  private ResponseHeaderXsd1 responseHeader = null;

  public GetCardAccountEnquiryResponseXsd4 payload(AccountDetailsNs3 payload) {
    this.payload = payload;
    return this;
  }

  /**
   * Get payload
   * @return payload
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AccountDetailsNs3 getPayload() {
    return payload;
  }

  public void setPayload(AccountDetailsNs3 payload) {
    this.payload = payload;
  }

  public GetCardAccountEnquiryResponseXsd4 responseHeader(ResponseHeaderXsd1 responseHeader) {
    this.responseHeader = responseHeader;
    return this;
  }

  /**
   * Get responseHeader
   * @return responseHeader
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ResponseHeaderXsd1 getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeaderXsd1 responseHeader) {
    this.responseHeader = responseHeader;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCardAccountEnquiryResponseXsd4 getCardAccountEnquiryResponseXsd4 = (GetCardAccountEnquiryResponseXsd4) o;
    return Objects.equals(this.payload, getCardAccountEnquiryResponseXsd4.payload) &&
        Objects.equals(this.responseHeader, getCardAccountEnquiryResponseXsd4.responseHeader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, responseHeader);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCardAccountEnquiryResponseXsd4 {\n");
    
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
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

