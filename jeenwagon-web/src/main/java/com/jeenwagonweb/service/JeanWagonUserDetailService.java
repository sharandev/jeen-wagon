package com.jeenwagonweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jeenwagonweb.auth.JeanWagonUserDetails;
import com.jeenwagonweb.auth.UserNotFoundException;
import com.jeenwagonweb.dao.UserAccountDAO;
import com.jeenwagonweb.entity.User;

/**
 * 
 * @author sharanabasava.d
 *
 */
public class JeanWagonUserDetailService implements UserDetailsService{
	
	private UserAccountDAO userAccountDao;
	
	@Autowired
	public JeanWagonUserDetailService(UserAccountDAO userAccountDAO) {
		this.userAccountDao = userAccountDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user;
		try {
			user = userAccountDao.findUserByUserName(username);
		} catch (UserNotFoundException e) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		}
		 
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
 
        JeanWagonUserDetails principal = JeanWagonUserDetails.getBuilder()
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .socialSignInProvider(user.getSignInProvider())
                .username(user.getEmail())
                .build();
 
        return principal;
	}

}
