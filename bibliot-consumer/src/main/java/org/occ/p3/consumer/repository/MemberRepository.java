package org.occ.p3.consumer.repository;


import java.util.Date;
import java.util.List;

import org.occ.p3.model.Book;
import org.occ.p3.model.Member;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface MemberRepository extends CrudRepository<Member, Integer>{

	public List<Member> findByAddressContaining(String address);
	public List<Member> findByBirthdateContaining(Date date);
	public List<Member> findByEmailadressContaining(String address);
	public List<Member> findByNameContaining(String address);
	public List<Member> findByProfilePictureContaining(String address);
	

	
}
