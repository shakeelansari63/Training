package com.ibm.demo.services;

import com.ibm.demo.model.CreateCardTransactionP;
import com.ibm.demo.model.CreateCardTransactionResponseWrapper;

public interface CreateCardTransactionI {

    public CreateCardTransactionResponseWrapper execute(CreateCardTransactionP requestParams);

    public <T> T error(int statusCode, Class<T> type,Exception exception) throws InstantiationException, IllegalAccessException;

}
