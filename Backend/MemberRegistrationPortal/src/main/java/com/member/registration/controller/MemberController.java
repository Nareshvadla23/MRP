package com.member.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.registration.advice.MemberNotFoundException;
import com.member.registration.entity.Member;
import com.member.registration.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/register")
	public ResponseEntity<Long> saveMember(@RequestBody @Valid Member member) {
		Long memberId = memberService.addMember(member);
			return new ResponseEntity<Long>(memberId, HttpStatus.OK);
		
	}

	@GetMapping("retrive/name/{name}")
	public ResponseEntity<Member> getMemberByName(@PathVariable String name) throws MemberNotFoundException {
		Member member = memberService.getMemberByName(name);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

}
