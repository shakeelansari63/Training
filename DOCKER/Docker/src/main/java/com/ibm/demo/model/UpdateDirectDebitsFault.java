package com.ibm.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.demo.model.ICardManagementFinancialTransactionupdateDirectDebitsFaultTns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateDirectDebitsFault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class UpdateDirectDebitsFault   {
  @JsonProperty("updateDirectDebitsFault")
  private ICardManagementFinancialTransactionupdateDirectDebitsFaultTns updateDirectDebitsFault = null;

  public UpdateDirectDebitsFault updateDirectDebitsFault(ICardManagementFinancialTransactionupdateDirectDebitsFaultTns updateDirectDebitsFault) {
    this.updateDirectDebitsFault = updateDirectDebitsFault;
    return this;
  }

  /**
   * Get updateDirectDebitsFault
   * @return updateDirectDebitsFault
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ICardManagementFinancialTransactionupdateDirectDebitsFaultTns getUpdateDirectDebitsFault() {
    return updateDirectDebitsFault;
  }

  public void setUpdateDirectDebitsFault(ICardManagementFinancialTransactionupdateDirectDebitsFaultTns updateDirectDebitsFault) {
    this.updateDirectDebitsFault = updateDirectDebitsFault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDirectDebitsFault updateDirectDebitsFault = (UpdateDirectDebitsFault) o;
    return Objects.equals(this.updateDirectDebitsFault, updateDirectDebitsFault.updateDirectDebitsFault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateDirectDebitsFault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDirectDebitsFault {\n");
    
    sb.append("    updateDirectDebitsFault: ").append(toIndentedString(updateDirectDebitsFault)).append("\n");
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

