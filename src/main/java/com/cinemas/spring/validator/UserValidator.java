package com.cinemas.spring.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cinemas.spring.entities.User;
import com.cinemas.spring.services.UserService;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * @Autowired private UserService userService;
	 * 
	 * 
	 * @Override public boolean supports(Class<?> aClass) { return
	 * User.class.equals(aClass); }
	 * 
	 * @Override public void validate(Object o, Errors errors) { User user = (User)
	 * o;
	 * 
	 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountname", "NotEmpty");
	 * if(user.getAccountname().length() < 5 || user.getAccountname().length() > 30)
	 * { errors.rejectValue("accoutname", "Size.userForm.accoutname"); }
	 * if(userService.findByAccountname(user.getAccountname()) != null) {
	 * errors.rejectValue("accoutname", "Duplicate.userForm.accoutname"); }
	 * 
	 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	 * if(user.getPassword().length()<5 || user.getPassword().length() >8) {
	 * errors.rejectValue("password", "Size.userForm.password"); }
	 * 
	 * if(!user.getPasswordConfirm().equals(user.getPassword())) {
	 * errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm"); }
	 * 
	 * }
	 */

	

}
