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
 * LimitTypeNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class LimitTypeNs3   {
  @JsonProperty("creditLimit")
  private BigDecimal creditLimit = null;

  @JsonProperty("temporaryCreditLimit")
  private BigDecimal temporaryCreditLimit = null;

  @JsonProperty("tpLimitFromDate")
  private String tpLimitFromDate = null;

  @JsonProperty("tpLimitToDate")
  private String tpLimitToDate = null;

  public LimitTypeNs3 creditLimit(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
    return this;
  }

  /**
   * Get creditLimit
   * minimum: 0
   * @return creditLimit
  **/
  @ApiModelProperty(value = "")

  @Valid
@DecimalMin("0")
  public BigDecimal getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
  }

  public LimitTypeNs3 temporaryCreditLimit(BigDecimal temporaryCreditLimit) {
    this.temporaryCreditLimit = temporaryCreditLimit;
    return this;
  }

  /**
   * Get temporaryCreditLimit
   * minimum: 0
   * @return temporaryCreditLimit
  **/
  @ApiModelProperty(value = "")

  @Valid
@DecimalMin("0")
  public BigDecimal getTemporaryCreditLimit() {
    return temporaryCreditLimit;
  }

  public void setTemporaryCreditLimit(BigDecimal temporaryCreditLimit) {
    this.temporaryCreditLimit = temporaryCreditLimit;
  }

  public LimitTypeNs3 tpLimitFromDate(String tpLimitFromDate) {
    this.tpLimitFromDate = tpLimitFromDate;
    return this;
  }

  /**
   * Get tpLimitFromDate
   * @return tpLimitFromDate
  **/
  @ApiModelProperty(value = "")


  public String getTpLimitFromDate() {
    return tpLimitFromDate;
  }

  public void setTpLimitFromDate(String tpLimitFromDate) {
    this.tpLimitFromDate = tpLimitFromDate;
  }

  public LimitTypeNs3 tpLimitToDate(String tpLimitToDate) {
    this.tpLimitToDate = tpLimitToDate;
    return this;
  }

  /**
   * Get tpLimitToDate
   * @return tpLimitToDate
  **/
  @ApiModelProperty(value = "")


  public String getTpLimitToDate() {
    return tpLimitToDate;
  }

  public void setTpLimitToDate(String tpLimitToDate) {
    this.tpLimitToDate = tpLimitToDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LimitTypeNs3 limitTypeNs3 = (LimitTypeNs3) o;
    return Objects.equals(this.creditLimit, limitTypeNs3.creditLimit) &&
        Objects.equals(this.temporaryCreditLimit, limitTypeNs3.temporaryCreditLimit) &&
        Objects.equals(this.tpLimitFromDate, limitTypeNs3.tpLimitFromDate) &&
        Objects.equals(this.tpLimitToDate, limitTypeNs3.tpLimitToDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditLimit, temporaryCreditLimit, tpLimitFromDate, tpLimitToDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LimitTypeNs3 {\n");
    
    sb.append("    creditLimit: ").append(toIndentedString(creditLimit)).append("\n");
    sb.append("    temporaryCreditLimit: ").append(toIndentedString(temporaryCreditLimit)).append("\n");
    sb.append("    tpLimitFromDate: ").append(toIndentedString(tpLimitFromDate)).append("\n");
    sb.append("    tpLimitToDate: ").append(toIndentedString(tpLimitToDate)).append("\n");
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

