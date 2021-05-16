package com.ibm.demo.api;

import com.ibm.demo.model.CreateCardTransactionFault;
import com.ibm.demo.model.CreateCardTransactionInput;
import com.ibm.demo.model.CreateCardTransactionOutput;
import com.ibm.demo.model.GetCardAccountEnquiryFault;
import com.ibm.demo.model.GetCardAccountEnquiryOutput;
import com.ibm.demo.model.GetCustomerCardDetailsFault;
import com.ibm.demo.model.GetCustomerCardDetailsOutput;
import com.ibm.demo.model.UpdateDirectDebitsFault;
import com.ibm.demo.model.UpdateDirectDebitsInput;
import com.ibm.demo.model.UpdateDirectDebitsOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import com.ibm.demo.services.GetCustomerCardDetailsI;
import com.ibm.demo.model.GetCustomerCardDetailsP;
import com.ibm.demo.model.GetCustomerCardDetailsResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibm.demo.services.CreateCardTransactionI;
import com.ibm.demo.model.CreateCardTransactionP;
import com.ibm.demo.model.CreateCardTransactionResponseWrapper;
import com.ibm.demo.services.GetCardAccountEnquiryI;
import com.ibm.demo.model.GetCardAccountEnquiryP;
import com.ibm.demo.model.GetCardAccountEnquiryResponseWrapper;
import com.ibm.demo.services.UpdateDirectDebitsI;
import com.ibm.demo.model.UpdateDirectDebitsP;
import com.ibm.demo.model.UpdateDirectDebitsResponseWrapper;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-15T09:26:20.476Z")

@Controller
public class CardsApiController implements CardsApi {

	@Autowired
	UpdateDirectDebitsI updateDirectDebitsI;


	@Autowired
	GetCardAccountEnquiryI getCardAccountEnquiryI;


	@Autowired
	CreateCardTransactionI createCardTransactionI;


	@Autowired
	GetCustomerCardDetailsI getCustomerCardDetailsI;


    private static final Logger log = LoggerFactory.getLogger(CardsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CardsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CreateCardTransactionOutput> createCardTransaction(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CreateCardTransactionInput body,@ApiParam(value = "" ,required=true) @RequestHeader(value="branchId", required=true) String branchId,@ApiParam(value = "" ,required=true) @RequestHeader(value="financialInstitution", required=true) String financialInstitution,@ApiParam(value = "" ,required=true) @RequestHeader(value="journeyId", required=true) String journeyId,@ApiParam(value = "" ,required=true) @RequestHeader(value="lang", required=true) String lang,@ApiParam(value = "" ,required=true) @RequestHeader(value="originUserId", required=true) String originUserId,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerLogin", required=true) String providerLogin,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerPassword", required=true) String providerPassword,@ApiParam(value = "" ,required=true) @RequestHeader(value="timeStamp", required=true) String timeStamp,@ApiParam(value = "" ) @RequestHeader(value="correlationId", required=false) String correlationId,@ApiParam(value = "" ) @RequestHeader(value="key", required=false) String key,@ApiParam(value = "" ) @RequestHeader(value="originChannelId", required=false) String originChannelId,@ApiParam(value = "" ) @RequestHeader(value="originDeptId", required=false) String originDeptId,@ApiParam(value = "" ) @RequestHeader(value="originEmployeeId", required=false) String originEmployeeId,@ApiParam(value = "" ) @RequestHeader(value="originSourceId", required=false) String originSourceId,@ApiParam(value = "" ) @RequestHeader(value="originTerminalId", required=false) String originTerminalId,@ApiParam(value = "" ) @RequestHeader(value="value", required=false) String value) {
        
        CreateCardTransactionResponseWrapper res  = createCardTransactionI.execute(new CreateCardTransactionP(body, branchId, correlationId, financialInstitution, journeyId, key, lang, originChannelId, originDeptId, originEmployeeId, originSourceId, originTerminalId, originUserId, providerLogin, providerPassword, timeStamp, value));

        return new ResponseEntity<>(res.getResponse(),res.getHeaders(), HttpStatus.OK);
}

    public ResponseEntity<GetCardAccountEnquiryOutput> getCardAccountEnquiry(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "accountId", required = true) String accountId,@ApiParam(value = "" ,required=true) @RequestHeader(value="branchId", required=true) String branchId,@ApiParam(value = "" ,required=true) @RequestHeader(value="financialInstitution", required=true) String financialInstitution,@ApiParam(value = "" ,required=true) @RequestHeader(value="journeyId", required=true) String journeyId,@ApiParam(value = "" ,required=true) @RequestHeader(value="lang", required=true) String lang,@ApiParam(value = "" ,required=true) @RequestHeader(value="originUserId", required=true) String originUserId,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerLogin", required=true) String providerLogin,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerPassword", required=true) String providerPassword,@ApiParam(value = "" ,required=true) @RequestHeader(value="timeStamp", required=true) String timeStamp,@ApiParam(value = "Customer Identifier") @Valid @RequestParam(value = "cif", required = false) String cif,@ApiParam(value = "" ) @RequestHeader(value="correlationId", required=false) String correlationId,@ApiParam(value = "" ) @RequestHeader(value="key", required=false) String key,@ApiParam(value = "" ) @RequestHeader(value="originChannelId", required=false) String originChannelId,@ApiParam(value = "" ) @RequestHeader(value="originDeptId", required=false) String originDeptId,@ApiParam(value = "" ) @RequestHeader(value="originEmployeeId", required=false) String originEmployeeId,@ApiParam(value = "" ) @RequestHeader(value="originSourceId", required=false) String originSourceId,@ApiParam(value = "" ) @RequestHeader(value="originTerminalId", required=false) String originTerminalId,@ApiParam(value = "" ) @RequestHeader(value="value", required=false) String value,@ApiParam(value = "") @Valid @RequestParam(value = "cutOffDate", required = false) String cutOffDate,@ApiParam(value = "") @Valid @RequestParam(value = "cardNumber", required = false) String cardNumber) {
        
        GetCardAccountEnquiryResponseWrapper res  = getCardAccountEnquiryI.execute(new GetCardAccountEnquiryP(accountId, cif, branchId, correlationId, financialInstitution, journeyId, key, lang, originChannelId, originDeptId, originEmployeeId, originSourceId, originTerminalId, originUserId, providerLogin, providerPassword, timeStamp, value, cutOffDate, cardNumber));

        return new ResponseEntity<>(res.getResponse(),res.getHeaders(), HttpStatus.OK);
}

    public ResponseEntity<GetCustomerCardDetailsOutput> getCustomerCardDetails(@ApiParam(value = "" ,required=true) @RequestHeader(value="branchId", required=true) String branchId,@ApiParam(value = "" ,required=true) @RequestHeader(value="financialInstitution", required=true) String financialInstitution,@ApiParam(value = "" ,required=true) @RequestHeader(value="journeyId", required=true) String journeyId,@ApiParam(value = "" ,required=true) @RequestHeader(value="lang", required=true) String lang,@ApiParam(value = "" ,required=true) @RequestHeader(value="originUserId", required=true) String originUserId,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerLogin", required=true) String providerLogin,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerPassword", required=true) String providerPassword,@ApiParam(value = "" ,required=true) @RequestHeader(value="timeStamp", required=true) String timeStamp,@ApiParam(value = "") @Valid @RequestParam(value = "cif", required = false) String cif,@ApiParam(value = "") @Valid @RequestParam(value = "legalId", required = false) String legalId,@ApiParam(value = "" ) @RequestHeader(value="correlationId", required=false) String correlationId,@ApiParam(value = "" ) @RequestHeader(value="key", required=false) String key,@ApiParam(value = "" ) @RequestHeader(value="originChannelId", required=false) String originChannelId,@ApiParam(value = "" ) @RequestHeader(value="originDeptId", required=false) String originDeptId,@ApiParam(value = "" ) @RequestHeader(value="originEmployeeId", required=false) String originEmployeeId,@ApiParam(value = "" ) @RequestHeader(value="originSourceId", required=false) String originSourceId,@ApiParam(value = "" ) @RequestHeader(value="originTerminalId", required=false) String originTerminalId,@ApiParam(value = "" ) @RequestHeader(value="value", required=false) String value,@ApiParam(value = "") @Valid @RequestParam(value = "accountNumber", required = false) String accountNumber,@ApiParam(value = "") @Valid @RequestParam(value = "cardNumber", required = false) String cardNumber,@ApiParam(value = "Customer Identifier") @Valid @RequestParam(value = "cardStatus", required = false) String cardStatus) {
        
        GetCustomerCardDetailsResponseWrapper res  = getCustomerCardDetailsI.execute(new GetCustomerCardDetailsP(cif, legalId, branchId, correlationId, financialInstitution, journeyId, key, lang, originChannelId, originDeptId, originEmployeeId, originSourceId, originTerminalId, originUserId, providerLogin, providerPassword, timeStamp, value, accountNumber, cardNumber, cardStatus));

        return new ResponseEntity<>(res.getResponse(),res.getHeaders(), HttpStatus.OK);
}

    public ResponseEntity<UpdateDirectDebitsOutput> updateDirectDebits(@ApiParam(value = "" ,required=true) @RequestHeader(value="branchId", required=true) String branchId,@ApiParam(value = "" ,required=true) @RequestHeader(value="financialInstitution", required=true) String financialInstitution,@ApiParam(value = "" ,required=true) @RequestHeader(value="journeyId", required=true) String journeyId,@ApiParam(value = "" ,required=true) @RequestHeader(value="lang", required=true) String lang,@ApiParam(value = "" ,required=true) @RequestHeader(value="originUserId", required=true) String originUserId,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerLogin", required=true) String providerLogin,@ApiParam(value = "" ,required=true) @RequestHeader(value="providerPassword", required=true) String providerPassword,@ApiParam(value = "" ,required=true) @RequestHeader(value="timeStamp", required=true) String timeStamp,@ApiParam(value = "" ,required=true )  @Valid @RequestBody UpdateDirectDebitsInput body,@ApiParam(value = "" ) @RequestHeader(value="correlationId", required=false) String correlationId,@ApiParam(value = "" ) @RequestHeader(value="key", required=false) String key,@ApiParam(value = "" ) @RequestHeader(value="originChannelId", required=false) String originChannelId,@ApiParam(value = "" ) @RequestHeader(value="originDeptId", required=false) String originDeptId,@ApiParam(value = "" ) @RequestHeader(value="originEmployeeId", required=false) String originEmployeeId,@ApiParam(value = "" ) @RequestHeader(value="originSourceId", required=false) String originSourceId,@ApiParam(value = "" ) @RequestHeader(value="originTerminalId", required=false) String originTerminalId,@ApiParam(value = "" ) @RequestHeader(value="value", required=false) String value) {
        
        UpdateDirectDebitsResponseWrapper res  = updateDirectDebitsI.execute(new UpdateDirectDebitsP(branchId, correlationId, financialInstitution, journeyId, key, lang, originChannelId, originDeptId, originEmployeeId, originSourceId, originTerminalId, originUserId, providerLogin, providerPassword, timeStamp, value, body));

        return new ResponseEntity<>(res.getResponse(),res.getHeaders(), HttpStatus.OK);
	} 
}
