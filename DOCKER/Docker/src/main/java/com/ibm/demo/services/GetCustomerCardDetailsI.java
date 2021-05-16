package com.ibm.demo.services;

import com.ibm.demo.model.GetCustomerCardDetailsP;
import com.ibm.demo.model.GetCustomerCardDetailsResponseWrapper;

public interface GetCustomerCardDetailsI {

    public GetCustomerCardDetailsResponseWrapper execute(GetCustomerCardDetailsP requestParams);

    public <T> T error(int statusCode, Class<T> type,Exception exception) throws InstantiationException, IllegalAccessException;

}
