package org.occ.p3.service;

import java.util.Date;
import java.util.List;

import org.occ.p3.model.Member;
import org.occ.p3.model.User;

public interface MemberService {


    
	public Member getMemberById(Integer memberId);
	public List<Member> getMemberByName(String memberName);
	public List<Member> getMemberByEmailadress(String userEmailadress);
	public List<Member> getMemberByAddress(String memberAddress);
	public List<Member> getMemberByBirthdate(Date memberDate);
	public Member saveNewMember(Member member);
	
}
