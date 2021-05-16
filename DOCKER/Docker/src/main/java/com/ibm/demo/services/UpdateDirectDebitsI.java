package com.ibm.demo.services;

import com.ibm.demo.model.UpdateDirectDebitsP;
import com.ibm.demo.model.UpdateDirectDebitsResponseWrapper;

public interface UpdateDirectDebitsI {

    public UpdateDirectDebitsResponseWrapper execute(UpdateDirectDebitsP requestParams);

    public <T> T error(int statusCode, Class<T> type,Exception exception) throws InstantiationException, IllegalAccessException;

}
