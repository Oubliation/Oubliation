package edu.ycp.cs320spring2015.oubliation.server;

public class UsernameFailureException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsernameFailureException(String msg) {
		super(msg);
	}
	
	public UsernameFailureException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
