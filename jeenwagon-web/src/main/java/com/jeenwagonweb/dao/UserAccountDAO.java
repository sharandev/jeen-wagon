/**
 * 
 */
package com.jeenwagonweb.dao;

import java.util.List;

import com.jeenwagonweb.auth.UserNotFoundException;
import com.jeenwagonweb.entity.User;

/**
 * @author sharanabasava.d
 *
 */
public interface UserAccountDAO {
	
	public User getUser(Long userId);
	
	public Long createUser(User user);
	
	public boolean deleteUser(Long userId);
	
	public User updateUser(User user);
	
	public User findUserByUserName(String userName) throws UserNotFoundException;
	
	public List<User> listUsers();
}
