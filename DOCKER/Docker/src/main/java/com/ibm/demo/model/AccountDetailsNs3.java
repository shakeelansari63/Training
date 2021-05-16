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
 * AccountDetailsNs3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

public class AccountDetailsNs3   {
  @JsonProperty("accountCif")
  private String accountCif = null;

  @JsonProperty("accountOpenDate")
  private String accountOpenDate = null;

  @JsonProperty("accountProduct")
  private String accountProduct = null;

  @JsonProperty("accountStatus")
  private String accountStatus = null;

  @JsonProperty("accountStatusChangeDate")
  private String accountStatusChangeDate = null;

  @JsonProperty("accountingBranch")
  private String accountingBranch = null;

  @JsonProperty("advancesRate")
  private BigDecimal advancesRate = null;

  @JsonProperty("arrearsAmount")
  private BigDecimal arrearsAmount = null;

  @JsonProperty("availableBalance")
  private BigDecimal availableBalance = null;

  @JsonProperty("cardAccount")
  private String cardAccount = null;

  @JsonProperty("directDebitOrderNumber")
  private String directDebitOrderNumber = null;

  @JsonProperty("dueDate")
  private String dueDate = null;

  @JsonProperty("graceDate")
  private String graceDate = null;

  @JsonProperty("holdAmount")
  private BigDecimal holdAmount = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("installmentBalance")
  private BigDecimal installmentBalance = null;

  @JsonProperty("lastAuthorizationDate")
  private String lastAuthorizationDate = null;

  @JsonProperty("lastPaymentAmount")
  private BigDecimal lastPaymentAmount = null;

  @JsonProperty("lastPaymentDate")
  private String lastPaymentDate = null;

  @JsonProperty("lastStatementDate")
  private String lastStatementDate = null;

  @JsonProperty("lastTransactionDate")
  private String lastTransactionDate = null;

  @JsonProperty("ledgerBalance")
  private BigDecimal ledgerBalance = null;

  @JsonProperty("ledgerCurrency")
  private String ledgerCurrency = null;

  @JsonProperty("limit")
  private BigDecimal limit = null;

  @JsonProperty("minimumDue")
  private String minimumDue = null;

  @JsonProperty("minimumPaymentAmount")
  private BigDecimal minimumPaymentAmount = null;

  @JsonProperty("otherRate")
  private BigDecimal otherRate = null;

  @JsonProperty("purchaseRate")
  private BigDecimal purchaseRate = null;

  @JsonProperty("saveAlaCarteProfileCode")
  private String saveAlaCarteProfileCode = null;

  @JsonProperty("saveAlaCarteSavingAccountNumber")
  private String saveAlaCarteSavingAccountNumber = null;

  @JsonProperty("settlementBalance")
  private BigDecimal settlementBalance = null;

  @JsonProperty("statementBalance")
  private BigDecimal statementBalance = null;

  @JsonProperty("statementCode")
  private String statementCode = null;

  @JsonProperty("statementOption")
  private String statementOption = null;

  @JsonProperty("uncollectedAmount")
  private BigDecimal uncollectedAmount = null;

  public AccountDetailsNs3 accountCif(String accountCif) {
    this.accountCif = accountCif;
    return this;
  }

  /**
   * Get accountCif
   * @return accountCif
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountCif() {
    return accountCif;
  }

  public void setAccountCif(String accountCif) {
    this.accountCif = accountCif;
  }

  public AccountDetailsNs3 accountOpenDate(String accountOpenDate) {
    this.accountOpenDate = accountOpenDate;
    return this;
  }

  /**
   * Get accountOpenDate
   * @return accountOpenDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountOpenDate() {
    return accountOpenDate;
  }

  public void setAccountOpenDate(String accountOpenDate) {
    this.accountOpenDate = accountOpenDate;
  }

  public AccountDetailsNs3 accountProduct(String accountProduct) {
    this.accountProduct = accountProduct;
    return this;
  }

  /**
   * Get accountProduct
   * @return accountProduct
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountProduct() {
    return accountProduct;
  }

  public void setAccountProduct(String accountProduct) {
    this.accountProduct = accountProduct;
  }

  public AccountDetailsNs3 accountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * Get accountStatus
   * @return accountStatus
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

  public AccountDetailsNs3 accountStatusChangeDate(String accountStatusChangeDate) {
    this.accountStatusChangeDate = accountStatusChangeDate;
    return this;
  }

  /**
   * Get accountStatusChangeDate
   * @return accountStatusChangeDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountStatusChangeDate() {
    return accountStatusChangeDate;
  }

  public void setAccountStatusChangeDate(String accountStatusChangeDate) {
    this.accountStatusChangeDate = accountStatusChangeDate;
  }

  public AccountDetailsNs3 accountingBranch(String accountingBranch) {
    this.accountingBranch = accountingBranch;
    return this;
  }

  /**
   * Get accountingBranch
   * @return accountingBranch
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountingBranch() {
    return accountingBranch;
  }

  public void setAccountingBranch(String accountingBranch) {
    this.accountingBranch = accountingBranch;
  }

  public AccountDetailsNs3 advancesRate(BigDecimal advancesRate) {
    this.advancesRate = advancesRate;
    return this;
  }

  /**
   * Get advancesRate
   * minimum: 0
   * @return advancesRate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getAdvancesRate() {
    return advancesRate;
  }

  public void setAdvancesRate(BigDecimal advancesRate) {
    this.advancesRate = advancesRate;
  }

  public AccountDetailsNs3 arrearsAmount(BigDecimal arrearsAmount) {
    this.arrearsAmount = arrearsAmount;
    return this;
  }

  /**
   * Get arrearsAmount
   * minimum: 0
   * @return arrearsAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getArrearsAmount() {
    return arrearsAmount;
  }

  public void setArrearsAmount(BigDecimal arrearsAmount) {
    this.arrearsAmount = arrearsAmount;
  }

  public AccountDetailsNs3 availableBalance(BigDecimal availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  /**
   * Get availableBalance
   * minimum: 0
   * @return availableBalance
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(BigDecimal availableBalance) {
    this.availableBalance = availableBalance;
  }

  public AccountDetailsNs3 cardAccount(String cardAccount) {
    this.cardAccount = cardAccount;
    return this;
  }

  /**
   * Get cardAccount
   * @return cardAccount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCardAccount() {
    return cardAccount;
  }

  public void setCardAccount(String cardAccount) {
    this.cardAccount = cardAccount;
  }

  public AccountDetailsNs3 directDebitOrderNumber(String directDebitOrderNumber) {
    this.directDebitOrderNumber = directDebitOrderNumber;
    return this;
  }

  /**
   * Get directDebitOrderNumber
   * @return directDebitOrderNumber
  **/
  @ApiModelProperty(value = "")


  public String getDirectDebitOrderNumber() {
    return directDebitOrderNumber;
  }

  public void setDirectDebitOrderNumber(String directDebitOrderNumber) {
    this.directDebitOrderNumber = directDebitOrderNumber;
  }

  public AccountDetailsNs3 dueDate(String dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  /**
   * Get dueDate
   * @return dueDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public AccountDetailsNs3 graceDate(String graceDate) {
    this.graceDate = graceDate;
    return this;
  }

  /**
   * Get graceDate
   * @return graceDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getGraceDate() {
    return graceDate;
  }

  public void setGraceDate(String graceDate) {
    this.graceDate = graceDate;
  }

  public AccountDetailsNs3 holdAmount(BigDecimal holdAmount) {
    this.holdAmount = holdAmount;
    return this;
  }

  /**
   * Get holdAmount
   * minimum: 0
   * @return holdAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getHoldAmount() {
    return holdAmount;
  }

  public void setHoldAmount(BigDecimal holdAmount) {
    this.holdAmount = holdAmount;
  }

  public AccountDetailsNs3 iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public AccountDetailsNs3 installmentBalance(BigDecimal installmentBalance) {
    this.installmentBalance = installmentBalance;
    return this;
  }

  /**
   * Get installmentBalance
   * minimum: 0
   * @return installmentBalance
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getInstallmentBalance() {
    return installmentBalance;
  }

  public void setInstallmentBalance(BigDecimal installmentBalance) {
    this.installmentBalance = installmentBalance;
  }

  public AccountDetailsNs3 lastAuthorizationDate(String lastAuthorizationDate) {
    this.lastAuthorizationDate = lastAuthorizationDate;
    return this;
  }

  /**
   * Get lastAuthorizationDate
   * @return lastAuthorizationDate
  **/
  @ApiModelProperty(value = "")


  public String getLastAuthorizationDate() {
    return lastAuthorizationDate;
  }

  public void setLastAuthorizationDate(String lastAuthorizationDate) {
    this.lastAuthorizationDate = lastAuthorizationDate;
  }

  public AccountDetailsNs3 lastPaymentAmount(BigDecimal lastPaymentAmount) {
    this.lastPaymentAmount = lastPaymentAmount;
    return this;
  }

  /**
   * Get lastPaymentAmount
   * minimum: 0
   * @return lastPaymentAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getLastPaymentAmount() {
    return lastPaymentAmount;
  }

  public void setLastPaymentAmount(BigDecimal lastPaymentAmount) {
    this.lastPaymentAmount = lastPaymentAmount;
  }

  public AccountDetailsNs3 lastPaymentDate(String lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
    return this;
  }

  /**
   * Get lastPaymentDate
   * @return lastPaymentDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastPaymentDate() {
    return lastPaymentDate;
  }

  public void setLastPaymentDate(String lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  public AccountDetailsNs3 lastStatementDate(String lastStatementDate) {
    this.lastStatementDate = lastStatementDate;
    return this;
  }

  /**
   * Get lastStatementDate
   * @return lastStatementDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastStatementDate() {
    return lastStatementDate;
  }

  public void setLastStatementDate(String lastStatementDate) {
    this.lastStatementDate = lastStatementDate;
  }

  public AccountDetailsNs3 lastTransactionDate(String lastTransactionDate) {
    this.lastTransactionDate = lastTransactionDate;
    return this;
  }

  /**
   * Get lastTransactionDate
   * @return lastTransactionDate
  **/
  @ApiModelProperty(value = "")


  public String getLastTransactionDate() {
    return lastTransactionDate;
  }

  public void setLastTransactionDate(String lastTransactionDate) {
    this.lastTransactionDate = lastTransactionDate;
  }

  public AccountDetailsNs3 ledgerBalance(BigDecimal ledgerBalance) {
    this.ledgerBalance = ledgerBalance;
    return this;
  }

  /**
   * Get ledgerBalance
   * minimum: 0
   * @return ledgerBalance
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getLedgerBalance() {
    return ledgerBalance;
  }

  public void setLedgerBalance(BigDecimal ledgerBalance) {
    this.ledgerBalance = ledgerBalance;
  }

  public AccountDetailsNs3 ledgerCurrency(String ledgerCurrency) {
    this.ledgerCurrency = ledgerCurrency;
    return this;
  }

  /**
   * Get ledgerCurrency
   * @return ledgerCurrency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLedgerCurrency() {
    return ledgerCurrency;
  }

  public void setLedgerCurrency(String ledgerCurrency) {
    this.ledgerCurrency = ledgerCurrency;
  }

  public AccountDetailsNs3 limit(BigDecimal limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * minimum: 0
   * @return limit
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getLimit() {
    return limit;
  }

  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

  public AccountDetailsNs3 minimumDue(String minimumDue) {
    this.minimumDue = minimumDue;
    return this;
  }

  /**
   * Get minimumDue
   * @return minimumDue
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMinimumDue() {
    return minimumDue;
  }

  public void setMinimumDue(String minimumDue) {
    this.minimumDue = minimumDue;
  }

  public AccountDetailsNs3 minimumPaymentAmount(BigDecimal minimumPaymentAmount) {
    this.minimumPaymentAmount = minimumPaymentAmount;
    return this;
  }

  /**
   * Get minimumPaymentAmount
   * minimum: 0
   * @return minimumPaymentAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getMinimumPaymentAmount() {
    return minimumPaymentAmount;
  }

  public void setMinimumPaymentAmount(BigDecimal minimumPaymentAmount) {
    this.minimumPaymentAmount = minimumPaymentAmount;
  }

  public AccountDetailsNs3 otherRate(BigDecimal otherRate) {
    this.otherRate = otherRate;
    return this;
  }

  /**
   * Get otherRate
   * minimum: 0
   * @return otherRate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getOtherRate() {
    return otherRate;
  }

  public void setOtherRate(BigDecimal otherRate) {
    this.otherRate = otherRate;
  }

  public AccountDetailsNs3 purchaseRate(BigDecimal purchaseRate) {
    this.purchaseRate = purchaseRate;
    return this;
  }

  /**
   * Get purchaseRate
   * minimum: 0
   * @return purchaseRate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getPurchaseRate() {
    return purchaseRate;
  }

  public void setPurchaseRate(BigDecimal purchaseRate) {
    this.purchaseRate = purchaseRate;
  }

  public AccountDetailsNs3 saveAlaCarteProfileCode(String saveAlaCarteProfileCode) {
    this.saveAlaCarteProfileCode = saveAlaCarteProfileCode;
    return this;
  }

  /**
   * Get saveAlaCarteProfileCode
   * @return saveAlaCarteProfileCode
  **/
  @ApiModelProperty(value = "")


  public String getSaveAlaCarteProfileCode() {
    return saveAlaCarteProfileCode;
  }

  public void setSaveAlaCarteProfileCode(String saveAlaCarteProfileCode) {
    this.saveAlaCarteProfileCode = saveAlaCarteProfileCode;
  }

  public AccountDetailsNs3 saveAlaCarteSavingAccountNumber(String saveAlaCarteSavingAccountNumber) {
    this.saveAlaCarteSavingAccountNumber = saveAlaCarteSavingAccountNumber;
    return this;
  }

  /**
   * Get saveAlaCarteSavingAccountNumber
   * @return saveAlaCarteSavingAccountNumber
  **/
  @ApiModelProperty(value = "")


  public String getSaveAlaCarteSavingAccountNumber() {
    return saveAlaCarteSavingAccountNumber;
  }

  public void setSaveAlaCarteSavingAccountNumber(String saveAlaCarteSavingAccountNumber) {
    this.saveAlaCarteSavingAccountNumber = saveAlaCarteSavingAccountNumber;
  }

  public AccountDetailsNs3 settlementBalance(BigDecimal settlementBalance) {
    this.settlementBalance = settlementBalance;
    return this;
  }

  /**
   * Get settlementBalance
   * minimum: 0
   * @return settlementBalance
  **/
  @ApiModelProperty(value = "")

  @Valid
@DecimalMin("0")
  public BigDecimal getSettlementBalance() {
    return settlementBalance;
  }

  public void setSettlementBalance(BigDecimal settlementBalance) {
    this.settlementBalance = settlementBalance;
  }

  public AccountDetailsNs3 statementBalance(BigDecimal statementBalance) {
    this.statementBalance = statementBalance;
    return this;
  }

  /**
   * Get statementBalance
   * minimum: 0
   * @return statementBalance
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getStatementBalance() {
    return statementBalance;
  }

  public void setStatementBalance(BigDecimal statementBalance) {
    this.statementBalance = statementBalance;
  }

  public AccountDetailsNs3 statementCode(String statementCode) {
    this.statementCode = statementCode;
    return this;
  }

  /**
   * Get statementCode
   * @return statementCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStatementCode() {
    return statementCode;
  }

  public void setStatementCode(String statementCode) {
    this.statementCode = statementCode;
  }

  public AccountDetailsNs3 statementOption(String statementOption) {
    this.statementOption = statementOption;
    return this;
  }

  /**
   * Get statementOption
   * @return statementOption
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStatementOption() {
    return statementOption;
  }

  public void setStatementOption(String statementOption) {
    this.statementOption = statementOption;
  }

  public AccountDetailsNs3 uncollectedAmount(BigDecimal uncollectedAmount) {
    this.uncollectedAmount = uncollectedAmount;
    return this;
  }

  /**
   * Get uncollectedAmount
   * minimum: 0
   * @return uncollectedAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getUncollectedAmount() {
    return uncollectedAmount;
  }

  public void setUncollectedAmount(BigDecimal uncollectedAmount) {
    this.uncollectedAmount = uncollectedAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountDetailsNs3 accountDetailsNs3 = (AccountDetailsNs3) o;
    return Objects.equals(this.accountCif, accountDetailsNs3.accountCif) &&
        Objects.equals(this.accountOpenDate, accountDetailsNs3.accountOpenDate) &&
        Objects.equals(this.accountProduct, accountDetailsNs3.accountProduct) &&
        Objects.equals(this.accountStatus, accountDetailsNs3.accountStatus) &&
        Objects.equals(this.accountStatusChangeDate, accountDetailsNs3.accountStatusChangeDate) &&
        Objects.equals(this.accountingBranch, accountDetailsNs3.accountingBranch) &&
        Objects.equals(this.advancesRate, accountDetailsNs3.advancesRate) &&
        Objects.equals(this.arrearsAmount, accountDetailsNs3.arrearsAmount) &&
        Objects.equals(this.availableBalance, accountDetailsNs3.availableBalance) &&
        Objects.equals(this.cardAccount, accountDetailsNs3.cardAccount) &&
        Objects.equals(this.directDebitOrderNumber, accountDetailsNs3.directDebitOrderNumber) &&
        Objects.equals(this.dueDate, accountDetailsNs3.dueDate) &&
        Objects.equals(this.graceDate, accountDetailsNs3.graceDate) &&
        Objects.equals(this.holdAmount, accountDetailsNs3.holdAmount) &&
        Objects.equals(this.iban, accountDetailsNs3.iban) &&
        Objects.equals(this.installmentBalance, accountDetailsNs3.installmentBalance) &&
        Objects.equals(this.lastAuthorizationDate, accountDetailsNs3.lastAuthorizationDate) &&
        Objects.equals(this.lastPaymentAmount, accountDetailsNs3.lastPaymentAmount) &&
        Objects.equals(this.lastPaymentDate, accountDetailsNs3.lastPaymentDate) &&
        Objects.equals(this.lastStatementDate, accountDetailsNs3.lastStatementDate) &&
        Objects.equals(this.lastTransactionDate, accountDetailsNs3.lastTransactionDate) &&
        Objects.equals(this.ledgerBalance, accountDetailsNs3.ledgerBalance) &&
        Objects.equals(this.ledgerCurrency, accountDetailsNs3.ledgerCurrency) &&
        Objects.equals(this.limit, accountDetailsNs3.limit) &&
        Objects.equals(this.minimumDue, accountDetailsNs3.minimumDue) &&
        Objects.equals(this.minimumPaymentAmount, accountDetailsNs3.minimumPaymentAmount) &&
        Objects.equals(this.otherRate, accountDetailsNs3.otherRate) &&
        Objects.equals(this.purchaseRate, accountDetailsNs3.purchaseRate) &&
        Objects.equals(this.saveAlaCarteProfileCode, accountDetailsNs3.saveAlaCarteProfileCode) &&
        Objects.equals(this.saveAlaCarteSavingAccountNumber, accountDetailsNs3.saveAlaCarteSavingAccountNumber) &&
        Objects.equals(this.settlementBalance, accountDetailsNs3.settlementBalance) &&
        Objects.equals(this.statementBalance, accountDetailsNs3.statementBalance) &&
        Objects.equals(this.statementCode, accountDetailsNs3.statementCode) &&
        Objects.equals(this.statementOption, accountDetailsNs3.statementOption) &&
        Objects.equals(this.uncollectedAmount, accountDetailsNs3.uncollectedAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountCif, accountOpenDate, accountProduct, accountStatus, accountStatusChangeDate, accountingBranch, advancesRate, arrearsAmount, availableBalance, cardAccount, directDebitOrderNumber, dueDate, graceDate, holdAmount, iban, installmentBalance, lastAuthorizationDate, lastPaymentAmount, lastPaymentDate, lastStatementDate, lastTransactionDate, ledgerBalance, ledgerCurrency, limit, minimumDue, minimumPaymentAmount, otherRate, purchaseRate, saveAlaCarteProfileCode, saveAlaCarteSavingAccountNumber, settlementBalance, statementBalance, statementCode, statementOption, uncollectedAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountDetailsNs3 {\n");
    
    sb.append("    accountCif: ").append(toIndentedString(accountCif)).append("\n");
    sb.append("    accountOpenDate: ").append(toIndentedString(accountOpenDate)).append("\n");
    sb.append("    accountProduct: ").append(toIndentedString(accountProduct)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    accountStatusChangeDate: ").append(toIndentedString(accountStatusChangeDate)).append("\n");
    sb.append("    accountingBranch: ").append(toIndentedString(accountingBranch)).append("\n");
    sb.append("    advancesRate: ").append(toIndentedString(advancesRate)).append("\n");
    sb.append("    arrearsAmount: ").append(toIndentedString(arrearsAmount)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    cardAccount: ").append(toIndentedString(cardAccount)).append("\n");
    sb.append("    directDebitOrderNumber: ").append(toIndentedString(directDebitOrderNumber)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    graceDate: ").append(toIndentedString(graceDate)).append("\n");
    sb.append("    holdAmount: ").append(toIndentedString(holdAmount)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    installmentBalance: ").append(toIndentedString(installmentBalance)).append("\n");
    sb.append("    lastAuthorizationDate: ").append(toIndentedString(lastAuthorizationDate)).append("\n");
    sb.append("    lastPaymentAmount: ").append(toIndentedString(lastPaymentAmount)).append("\n");
    sb.append("    lastPaymentDate: ").append(toIndentedString(lastPaymentDate)).append("\n");
    sb.append("    lastStatementDate: ").append(toIndentedString(lastStatementDate)).append("\n");
    sb.append("    lastTransactionDate: ").append(toIndentedString(lastTransactionDate)).append("\n");
    sb.append("    ledgerBalance: ").append(toIndentedString(ledgerBalance)).append("\n");
    sb.append("    ledgerCurrency: ").append(toIndentedString(ledgerCurrency)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    minimumDue: ").append(toIndentedString(minimumDue)).append("\n");
    sb.append("    minimumPaymentAmount: ").append(toIndentedString(minimumPaymentAmount)).append("\n");
    sb.append("    otherRate: ").append(toIndentedString(otherRate)).append("\n");
    sb.append("    purchaseRate: ").append(toIndentedString(purchaseRate)).append("\n");
    sb.append("    saveAlaCarteProfileCode: ").append(toIndentedString(saveAlaCarteProfileCode)).append("\n");
    sb.append("    saveAlaCarteSavingAccountNumber: ").append(toIndentedString(saveAlaCarteSavingAccountNumber)).append("\n");
    sb.append("    settlementBalance: ").append(toIndentedString(settlementBalance)).append("\n");
    sb.append("    statementBalance: ").append(toIndentedString(statementBalance)).append("\n");
    sb.append("    statementCode: ").append(toIndentedString(statementCode)).append("\n");
    sb.append("    statementOption: ").append(toIndentedString(statementOption)).append("\n");
    sb.append("    uncollectedAmount: ").append(toIndentedString(uncollectedAmount)).append("\n");
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

