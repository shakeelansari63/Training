/*******************************************************************************
 * Licensed materials - Property of IBM
 * 6949-63D
 * Developed by Digital Integration Practice
 * (C) Copyright IBM Corp. 2016 All Rights Reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp. 
 * This asset is provided ``as is'' and any expressed or implied warranties, including, but not limited to, the implied warranties and fitness 
 * for a particular purpose are disclaimed. in no event shall IBM be liable for any direct, indirect, incidental, special, 
 * exemplary, or consequential damages.
 * 
 *******************************************************************************/
package com.ibm.demo.exception;

import com.google.gson.Gson;
/**
 * This class defines the customException. 
 * An exception can be thrown as CustomException by setting the ErrorResponse with its information.
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorResponse errorResponse;

	public CustomException() {
		super();
		errorResponse = new ErrorResponse();
	}

	public CustomException(Exception e) {
		super(e);
		errorResponse = new ErrorResponse();
	}

	public CustomException(String message, ErrorResponse errorResponse) {
		super(message);
		this.errorResponse = errorResponse;
	}

	public CustomException(String message, Exception e) {
		super(message, e);
		errorResponse = new ErrorResponse();
	}

	public CustomException(String message, ErrorResponse errorResponse, Exception e) {
		super(message, e);
		this.errorResponse = errorResponse;
	}

	public int getHttpCode() {
		if (errorResponse != null && errorResponse.getError() != null && errorResponse.getError().getCode() != null) {
			try {
				return Integer.parseInt(errorResponse.getError().getCode());
			} catch (NumberFormatException nfe) {
				return 400;
			}
		}
		return 400;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public String getErrorResponseText() {
		return new Gson().toJson(errorResponse);
	}
}
