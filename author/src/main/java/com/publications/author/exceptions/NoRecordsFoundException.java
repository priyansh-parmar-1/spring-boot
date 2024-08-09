package com.publications.author.exceptions;

public class NoRecordsFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordsFoundException(String msg) {
		super(msg);
	}
}
