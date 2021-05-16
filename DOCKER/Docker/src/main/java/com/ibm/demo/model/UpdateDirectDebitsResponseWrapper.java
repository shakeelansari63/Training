package com.ibm.demo.model;

import org.springframework.util.MultiValueMap;

import org.springframework.util.LinkedMultiValueMap;

public class UpdateDirectDebitsResponseWrapper {

	private UpdateDirectDebitsOutput response;

        public MultiValueMap<String, String> getHeaders(){
            final MultiValueMap<String, String> map=new LinkedMultiValueMap<String, String>();
            return map;
	}

	public void setHeaders(){
            
	}
 
	public UpdateDirectDebitsOutput getResponse(){
            return response;
	}
 
	public void setResponse(UpdateDirectDebitsOutput response){
            this.response=response;
	} 
}
