package org.occ.p3.consumer.repository;


import java.util.List;

import org.occ.p3.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT u FROM User u where u.userName = :userName")
	public User FindByuserName(@Param("userName") String userName);
	
	public User findByUserNameAndPassword(String user, String password);
 
}
