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
 * ResponseHeaderXsd1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class ResponseHeaderXsd1   {
  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("journeyId")
  private String journeyId = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("responseCode")
  private String responseCode = null;

  @JsonProperty("responseDesc")
  private String responseDesc = null;

  @JsonProperty("resultId")
  private String resultId = null;

  @JsonProperty("timeStamp")
  private String timeStamp = null;

  @JsonProperty("value")
  private String value = null;

  public ResponseHeaderXsd1 correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * Get correlationId
   * @return correlationId
  **/
  @ApiModelProperty(value = "")


  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public ResponseHeaderXsd1 journeyId(String journeyId) {
    this.journeyId = journeyId;
    return this;
  }

  /**
   * Get journeyId
   * @return journeyId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getJourneyId() {
    return journeyId;
  }

  public void setJourneyId(String journeyId) {
    this.journeyId = journeyId;
  }

  public ResponseHeaderXsd1 key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ResponseHeaderXsd1 responseCode(String responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  /**
   * Get responseCode
   * @return responseCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public ResponseHeaderXsd1 responseDesc(String responseDesc) {
    this.responseDesc = responseDesc;
    return this;
  }

  /**
   * Get responseDesc
   * @return responseDesc
  **/
  @ApiModelProperty(value = "")


  public String getResponseDesc() {
    return responseDesc;
  }

  public void setResponseDesc(String responseDesc) {
    this.responseDesc = responseDesc;
  }

  public ResponseHeaderXsd1 resultId(String resultId) {
    this.resultId = resultId;
    return this;
  }

  /**
   * Get resultId
   * @return resultId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getResultId() {
    return resultId;
  }

  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public ResponseHeaderXsd1 timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  /**
   * Get timeStamp
   * @return timeStamp
  **/
  @ApiModelProperty(value = "")


  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public ResponseHeaderXsd1 value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseHeaderXsd1 responseHeaderXsd1 = (ResponseHeaderXsd1) o;
    return Objects.equals(this.correlationId, responseHeaderXsd1.correlationId) &&
        Objects.equals(this.journeyId, responseHeaderXsd1.journeyId) &&
        Objects.equals(this.key, responseHeaderXsd1.key) &&
        Objects.equals(this.responseCode, responseHeaderXsd1.responseCode) &&
        Objects.equals(this.responseDesc, responseHeaderXsd1.responseDesc) &&
        Objects.equals(this.resultId, responseHeaderXsd1.resultId) &&
        Objects.equals(this.timeStamp, responseHeaderXsd1.timeStamp) &&
        Objects.equals(this.value, responseHeaderXsd1.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(correlationId, journeyId, key, responseCode, responseDesc, resultId, timeStamp, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseHeaderXsd1 {\n");
    
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    journeyId: ").append(toIndentedString(journeyId)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
    sb.append("    responseDesc: ").append(toIndentedString(responseDesc)).append("\n");
    sb.append("    resultId: ").append(toIndentedString(resultId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

