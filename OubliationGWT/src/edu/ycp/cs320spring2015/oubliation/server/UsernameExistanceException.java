package edu.ycp.cs320spring2015.oubliation.server;

public class UsernameExistanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsernameExistanceException(String msg) {
		super(msg);
	}
	
	public UsernameExistanceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
