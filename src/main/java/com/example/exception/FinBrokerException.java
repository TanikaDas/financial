package com.example.exception;

public class FinBrokerException extends Exception{

private static final long serialVersionUID = 1L;
	
	public FinBrokerException() {}
	
	public FinBrokerException(String msg) {
		super(msg);
	}

}
