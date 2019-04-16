package org.occ.p3.service;

import java.util.Date;
import java.util.List;

import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.UserRepository;
import org.occ.p3.model.Member;
import org.occ.p3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	public Member getMemberById(Integer memberId) {
		Member memberGotFromConsumer = memberRepository.findById(memberId).get();
		return memberGotFromConsumer;
	}

	public List<Member> getMemberByName(String memberName) {
		List<Member> memberGotFromConsumer = memberRepository.findByNameContaining(memberName);
		return memberGotFromConsumer;
	}

	public List<Member> getMemberByEmailadress(String userEmailadress) {
		List<Member> memberGotFromConsumer = memberRepository.findByEmailadressContaining(userEmailadress);
		return memberGotFromConsumer;
	}

	public List<Member> getMemberByAddress(String memberAddress) {
		List<Member> memberGotFromConsumer = memberRepository.findByAddressContaining(memberAddress);
		return memberGotFromConsumer;
	}

	public Member saveNewMember(Member member) {
		Member memberSaved = memberRepository.save(member);		
		return memberSaved;
	}

	public List<Member> getMemberByBirthdate(Date memberDate) {
		List<Member> memberGotFromConsumer = memberRepository.findByBirthdateContaining(memberDate);
		return memberGotFromConsumer;
	}

 
	 

}
