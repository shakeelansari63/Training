package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.ErrorWithHeaderNs1;
import com.ibm.demo.model.GetCardAccountEnquiryResponseXsd4;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCardAccountEnquiryResponseTns
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class GetCardAccountEnquiryResponseTns   {
  @JsonProperty("exception")
  private ErrorWithHeaderNs1 exception = null;

  @JsonProperty("response")
  private GetCardAccountEnquiryResponseXsd4 response = null;

  public GetCardAccountEnquiryResponseTns exception(ErrorWithHeaderNs1 exception) {
    this.exception = exception;
    return this;
  }

  /**
   * Get exception
   * @return exception
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ErrorWithHeaderNs1 getException() {
    return exception;
  }

  public void setException(ErrorWithHeaderNs1 exception) {
    this.exception = exception;
  }

  public GetCardAccountEnquiryResponseTns response(GetCardAccountEnquiryResponseXsd4 response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GetCardAccountEnquiryResponseXsd4 getResponse() {
    return response;
  }

  public void setResponse(GetCardAccountEnquiryResponseXsd4 response) {
    this.response = response;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCardAccountEnquiryResponseTns getCardAccountEnquiryResponseTns = (GetCardAccountEnquiryResponseTns) o;
    return Objects.equals(this.exception, getCardAccountEnquiryResponseTns.exception) &&
        Objects.equals(this.response, getCardAccountEnquiryResponseTns.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exception, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCardAccountEnquiryResponseTns {\n");
    
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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

