package com.ibm.demo.model;

import org.springframework.util.MultiValueMap;

import org.springframework.util.LinkedMultiValueMap;

public class GetCardAccountEnquiryResponseWrapper {

	private GetCardAccountEnquiryOutput response;

        public MultiValueMap<String, String> getHeaders(){
            final MultiValueMap<String, String> map=new LinkedMultiValueMap<String, String>();
            return map;
	}

	public void setHeaders(){
            
	}
 
	public GetCardAccountEnquiryOutput getResponse(){
            return response;
	}
 
	public void setResponse(GetCardAccountEnquiryOutput response){
            this.response=response;
	} 
}
