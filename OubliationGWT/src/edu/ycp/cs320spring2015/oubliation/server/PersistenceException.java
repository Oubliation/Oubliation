package edu.ycp.cs320spring2015.oubliation.server;

public class PersistenceException extends RuntimeException {
	private static final long serialVersionUID = 501569924598252279L;

	public PersistenceException(String msg) {
		super(msg);
	}
	
	public PersistenceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
