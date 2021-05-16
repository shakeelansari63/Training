package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.CardDetailsNs3;
import com.ibm.demo.model.ResponseHeaderXsd1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCustomerCardDetailsResponseXsd5
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class GetCustomerCardDetailsResponseXsd5   {
  @JsonProperty("payload")
  @Valid
  private List<CardDetailsNs3> payload = null;

  @JsonProperty("responseHeader")
  private ResponseHeaderXsd1 responseHeader = null;

  public GetCustomerCardDetailsResponseXsd5 payload(List<CardDetailsNs3> payload) {
    this.payload = payload;
    return this;
  }

  public GetCustomerCardDetailsResponseXsd5 addPayloadItem(CardDetailsNs3 payloadItem) {
    if (this.payload == null) {
      this.payload = new ArrayList<CardDetailsNs3>();
    }
    this.payload.add(payloadItem);
    return this;
  }

  /**
   * Get payload
   * @return payload
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CardDetailsNs3> getPayload() {
    return payload;
  }

  public void setPayload(List<CardDetailsNs3> payload) {
    this.payload = payload;
  }

  public GetCustomerCardDetailsResponseXsd5 responseHeader(ResponseHeaderXsd1 responseHeader) {
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
    GetCustomerCardDetailsResponseXsd5 getCustomerCardDetailsResponseXsd5 = (GetCustomerCardDetailsResponseXsd5) o;
    return Objects.equals(this.payload, getCustomerCardDetailsResponseXsd5.payload) &&
        Objects.equals(this.responseHeader, getCustomerCardDetailsResponseXsd5.responseHeader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, responseHeader);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCustomerCardDetailsResponseXsd5 {\n");
    
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

