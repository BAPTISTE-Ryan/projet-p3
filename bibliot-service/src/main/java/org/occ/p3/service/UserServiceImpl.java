package org.occ.p3.service;

import org.occ.p3.consumer.repository.UserRepository;
import org.occ.p3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public User getUserById(Integer userId) {
		User userGotFromConsumer = userRepository.findById(userId).get();
		return userGotFromConsumer;
	}

	public User getUserByName(String userName) {
		User userGotFromConsumer = userRepository.FindByuserName(userName);
		return userGotFromConsumer;
	}

	public User getUserByPassword(Integer userPassword) {
		return null;
	}

	public User saveNewUser(User user) {
		User userSaved = userRepository.save(user);
		return userSaved;
	}

	public boolean authentificate(String user, String password) {
		if (userRepository.findByUserNameAndPassword(user, password) != null) {
			return true;
		}

		return false;
	}

}
