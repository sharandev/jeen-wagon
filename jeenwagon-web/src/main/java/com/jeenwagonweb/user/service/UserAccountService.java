/**
 * 
 */
package com.jeenwagonweb.user.service;

import com.jeenwagonweb.user.dto.RegistrationForm;
import com.jeenwagonweb.user.entity.User;

/**
 * @author sharanabasava.d
 *
 */
public interface UserAccountService {
	
	 public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;

}
