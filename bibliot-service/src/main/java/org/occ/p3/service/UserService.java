package org.occ.p3.service;

import org.occ.p3.model.User;

public interface UserService {

	public User getUserById(Integer userId);
	public User getUserByName(String userName);
	public User getUserByPassword(Integer userPassword); 
	public User saveNewUser(User user);

	public boolean authentificate(String user,String password);
}
