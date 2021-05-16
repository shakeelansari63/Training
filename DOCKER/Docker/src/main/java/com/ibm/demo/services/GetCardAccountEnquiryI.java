package com.ibm.demo.services;

import com.ibm.demo.model.GetCardAccountEnquiryP;
import com.ibm.demo.model.GetCardAccountEnquiryResponseWrapper;

public interface GetCardAccountEnquiryI {

    public GetCardAccountEnquiryResponseWrapper execute(GetCardAccountEnquiryP requestParams);

    public <T> T error(int statusCode, Class<T> type,Exception exception) throws InstantiationException, IllegalAccessException;

}
