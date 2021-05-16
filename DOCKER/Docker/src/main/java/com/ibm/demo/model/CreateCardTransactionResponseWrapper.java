package com.ibm.demo.model;

import org.springframework.util.MultiValueMap;

import org.springframework.util.LinkedMultiValueMap;

public class CreateCardTransactionResponseWrapper {

	private CreateCardTransactionOutput response;

        public MultiValueMap<String, String> getHeaders(){
            final MultiValueMap<String, String> map=new LinkedMultiValueMap<String, String>();
            return map;
	}

	public void setHeaders(){
            
	}
 
	public CreateCardTransactionOutput getResponse(){
            return response;
	}
 
	public void setResponse(CreateCardTransactionOutput response){
            this.response=response;
	} 
}
