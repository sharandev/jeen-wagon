/**
 * 
 */
package com.jeenwagonweb.user.service;

/**
 * @author sharanabasava.d
 *
 */
public class DuplicateEmailException extends Exception {

    /**
	 *  The exception is thrown when the email given during the registration
	 *  phase is already found from the database.
	 */
	private static final long serialVersionUID = 5546372642639823822L;

	public DuplicateEmailException(String message) {
        super(message);
    }

}
