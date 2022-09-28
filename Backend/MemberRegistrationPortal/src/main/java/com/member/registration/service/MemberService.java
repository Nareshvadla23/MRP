package com.member.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.registration.advice.MemberNotFoundException;
import com.member.registration.dao.MemberRepo;
import com.member.registration.entity.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepo memberRepo;

	public Long addMember(Member member) {
		Member member1 = memberRepo.save(member);
		return member1.getId();
	}

	public Member getMemberByName(String name) throws MemberNotFoundException {
		Member member = memberRepo.findByName(name);

		if (member != null) {
			return member;
		} else {
			throw new MemberNotFoundException("Member Details Not with Name :" + name);
		}
	}

}
