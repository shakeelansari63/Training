package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.ICardManagementFinancialTransactioncreateCardTransactionFaultTns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateCardTransactionFault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class CreateCardTransactionFault   {
  @JsonProperty("createCardTransactionFault")
  private ICardManagementFinancialTransactioncreateCardTransactionFaultTns createCardTransactionFault = null;

  public CreateCardTransactionFault createCardTransactionFault(ICardManagementFinancialTransactioncreateCardTransactionFaultTns createCardTransactionFault) {
    this.createCardTransactionFault = createCardTransactionFault;
    return this;
  }

  /**
   * Get createCardTransactionFault
   * @return createCardTransactionFault
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ICardManagementFinancialTransactioncreateCardTransactionFaultTns getCreateCardTransactionFault() {
    return createCardTransactionFault;
  }

  public void setCreateCardTransactionFault(ICardManagementFinancialTransactioncreateCardTransactionFaultTns createCardTransactionFault) {
    this.createCardTransactionFault = createCardTransactionFault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCardTransactionFault createCardTransactionFault = (CreateCardTransactionFault) o;
    return Objects.equals(this.createCardTransactionFault, createCardTransactionFault.createCardTransactionFault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createCardTransactionFault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCardTransactionFault {\n");
    
    sb.append("    createCardTransactionFault: ").append(toIndentedString(createCardTransactionFault)).append("\n");
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

