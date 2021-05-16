package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.SystemErrorResponseXsd1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("system")
  private String system = null;

  @JsonProperty("systemErrorResponse")
  @Valid
  private List<SystemErrorResponseXsd1> systemErrorResponse = null;

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns description(String description) {
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

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns system(String system) {
    this.system = system;
    return this;
  }

  /**
   * Get system
   * @return system
  **/
  @ApiModelProperty(value = "")


  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns systemErrorResponse(List<SystemErrorResponseXsd1> systemErrorResponse) {
    this.systemErrorResponse = systemErrorResponse;
    return this;
  }

  public ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns addSystemErrorResponseItem(SystemErrorResponseXsd1 systemErrorResponseItem) {
    if (this.systemErrorResponse == null) {
      this.systemErrorResponse = new ArrayList<SystemErrorResponseXsd1>();
    }
    this.systemErrorResponse.add(systemErrorResponseItem);
    return this;
  }

  /**
   * Get systemErrorResponse
   * @return systemErrorResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SystemErrorResponseXsd1> getSystemErrorResponse() {
    return systemErrorResponse;
  }

  public void setSystemErrorResponse(List<SystemErrorResponseXsd1> systemErrorResponse) {
    this.systemErrorResponse = systemErrorResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns icardManagementFinancialTransactiongetCustomerCardDetailsFaultTns = (ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns) o;
    return Objects.equals(this.code, icardManagementFinancialTransactiongetCustomerCardDetailsFaultTns.code) &&
        Objects.equals(this.description, icardManagementFinancialTransactiongetCustomerCardDetailsFaultTns.description) &&
        Objects.equals(this.system, icardManagementFinancialTransactiongetCustomerCardDetailsFaultTns.system) &&
        Objects.equals(this.systemErrorResponse, icardManagementFinancialTransactiongetCustomerCardDetailsFaultTns.systemErrorResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, system, systemErrorResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ICardManagementFinancialTransactiongetCustomerCardDetailsFaultTns {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    systemErrorResponse: ").append(toIndentedString(systemErrorResponse)).append("\n");
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

