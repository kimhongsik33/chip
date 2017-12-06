package com.test.mvc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.test.mvc.dto.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Member.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("-------------validate() is called-------------");
		Member member = (Member)obj;
		
		String memberName = member.getName();
		if(memberName == null || memberName.trim().isEmpty()){
			System.out.println("Please, input the Name information");
			errors.rejectValue("name", "error is occured when input");
		}
		
		String memberId = member.getId();
		if(memberId == null || memberId.trim().isEmpty()){
			System.out.println("Please, input the Id information");
			errors.rejectValue("id", "error is occured when input");
		}
		
		int memberNo = member.getMemberNo();
		if(memberNo == 0){
			System.out.println("Please, input the memberNo information");
			errors.rejectValue("memberNo", "error is occured when input");
		}
	}
}
