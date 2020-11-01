package com.bridgelabz.iplproblem;

public class IPLAnalyserException extends Exception{

	enum ExceptionType{
		IPL_FILE_PROBLEM, UNABLE_TO_PARSE
	}
	
	public ExceptionType type;
	private String name;

	public IPLAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type=type;
	}
	
	public IPLAnalyserException(String message, ExceptionType type, Throwable cause){
		super(message,cause);
		this.type=type;
	}
	public IPLAnalyserException(String message, String name){
		super(message);
		this.name=name;
	}

}
