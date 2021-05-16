package com.ibm.demo.exception;

import java.util.HashMap;
import java.util.Map;

import com.ibm.demo.exception.ApiExceptionResponse;
import com.ibm.demo.exception.ErrorStatusCode;
import com.ibm.demo.model.*;

public class MetaData {

	public static final Map<String,Map<ErrorStatusCode, ApiExceptionResponse>> apiExceptions;
	
	static {		
		apiExceptions = new HashMap<String,Map<ErrorStatusCode, ApiExceptionResponse>>();

		Map<ErrorStatusCode, ApiExceptionResponse> responses; 
		try {
		
		 responses = new HashMap<ErrorStatusCode, ApiExceptionResponse>();
		 responses.put(ErrorStatusCode.getStatusCode(400),ApiExceptionResponse.getInstance(400,GetCustomerCardDetailsFault.class,"Bad Request"));
		 responses.put(ErrorStatusCode.getStatusCode(404),ApiExceptionResponse.getInstance(404,GetCustomerCardDetailsFault.class,"Not found"));
		 responses.put(ErrorStatusCode.getStatusCode(405),ApiExceptionResponse.getInstance(405,GetCustomerCardDetailsFault.class,"Method Not Found"));
		 responses.put(ErrorStatusCode.getStatusCode(429),ApiExceptionResponse.getInstance(429,GetCustomerCardDetailsFault.class,"Too Many Request"));
		 responses.put(ErrorStatusCode.getStatusCode(500),ApiExceptionResponse.getInstance(500,GetCustomerCardDetailsFault.class,"Internal Server Error"));
		 responses.put(ErrorStatusCode.getStatusCode(503),ApiExceptionResponse.getInstance(503,GetCustomerCardDetailsFault.class,"Service Unavailable"));
		 
		 apiExceptions.put("getCustomerCardDetails",responses);
		 
		 responses = new HashMap<ErrorStatusCode, ApiExceptionResponse>();
		 responses.put(ErrorStatusCode.getStatusCode(400),ApiExceptionResponse.getInstance(400,CreateCardTransactionFault.class,"Bad Request"));
		 responses.put(ErrorStatusCode.getStatusCode(404),ApiExceptionResponse.getInstance(404,CreateCardTransactionFault.class,"Not found"));
		 responses.put(ErrorStatusCode.getStatusCode(405),ApiExceptionResponse.getInstance(405,CreateCardTransactionFault.class,"Method Not Found"));
		 responses.put(ErrorStatusCode.getStatusCode(429),ApiExceptionResponse.getInstance(429,CreateCardTransactionFault.class,"Too Many Request"));
		 responses.put(ErrorStatusCode.getStatusCode(500),ApiExceptionResponse.getInstance(500,CreateCardTransactionFault.class,"Internal Server Error"));
		 responses.put(ErrorStatusCode.getStatusCode(503),ApiExceptionResponse.getInstance(503,CreateCardTransactionFault.class,"Service Unavailable"));
		 
		 apiExceptions.put("createCardTransaction",responses);
		 
		 responses = new HashMap<ErrorStatusCode, ApiExceptionResponse>();
		 responses.put(ErrorStatusCode.getStatusCode(400),ApiExceptionResponse.getInstance(400,GetCardAccountEnquiryFault.class,"Bad Request"));
		 responses.put(ErrorStatusCode.getStatusCode(404),ApiExceptionResponse.getInstance(404,GetCardAccountEnquiryFault.class,"Not found"));
		 responses.put(ErrorStatusCode.getStatusCode(405),ApiExceptionResponse.getInstance(405,GetCardAccountEnquiryFault.class,"Method Not Found"));
		 responses.put(ErrorStatusCode.getStatusCode(429),ApiExceptionResponse.getInstance(429,GetCardAccountEnquiryFault.class,"Too Many Request"));
		 responses.put(ErrorStatusCode.getStatusCode(500),ApiExceptionResponse.getInstance(500,GetCardAccountEnquiryFault.class,"Internal Server Error"));
		 responses.put(ErrorStatusCode.getStatusCode(503),ApiExceptionResponse.getInstance(503,GetCardAccountEnquiryFault.class,"Service Unavailable"));
		 
		 apiExceptions.put("getCardAccountEnquiry",responses);
		 
		 responses = new HashMap<ErrorStatusCode, ApiExceptionResponse>();
		 responses.put(ErrorStatusCode.getStatusCode(400),ApiExceptionResponse.getInstance(400,UpdateDirectDebitsFault.class,"Bad Request"));
		 responses.put(ErrorStatusCode.getStatusCode(404),ApiExceptionResponse.getInstance(404,UpdateDirectDebitsFault.class,"Not found"));
		 responses.put(ErrorStatusCode.getStatusCode(405),ApiExceptionResponse.getInstance(405,UpdateDirectDebitsFault.class,"Method Not Found"));
		 responses.put(ErrorStatusCode.getStatusCode(429),ApiExceptionResponse.getInstance(429,UpdateDirectDebitsFault.class,"Too Many Request"));
		 responses.put(ErrorStatusCode.getStatusCode(500),ApiExceptionResponse.getInstance(500,UpdateDirectDebitsFault.class,"Internal Server Error"));
		 responses.put(ErrorStatusCode.getStatusCode(503),ApiExceptionResponse.getInstance(503,UpdateDirectDebitsFault.class,"Service Unavailable"));
		 
		 apiExceptions.put("updateDirectDebits",responses);
		 
		
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
