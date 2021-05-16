package com.ibm.demo.services.impl;
 
import java.util.*;
 
import com.ibm.demo.model.GetCardAccountEnquiryP;
import com.ibm.demo.model.GetCardAccountEnquiryResponseWrapper;
import com.ibm.demo.services.GetCardAccountEnquiryI;
 
import org.springframework.stereotype.Service;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
 
@Service
public class GetCardAccountEnquiryImpl implements GetCardAccountEnquiryI {
 
    private static final Log logger = LogFactory.getLog(GetCardAccountEnquiryImpl.class);
   
    @Override
    public GetCardAccountEnquiryResponseWrapper execute(GetCardAccountEnquiryP requestParams){
        //TODO
        return new GetCardAccountEnquiryResponseWrapper();
    }

              
    public <T> T error(int statusCode, Class<T> type,Exception exception) throws InstantiationException, IllegalAccessException {
        //TODO to write error response //NOSONAR
        return type.newInstance();
    }
              
  }
