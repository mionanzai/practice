package com.example.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.ForbiddenContextVariableRestriction;

import com.example.domain.LunchUserMaster;
import com.example.service.LunchUserMasterService;

public class NumberValidator implements ConstraintValidator<NumberValid, String> {
	private Pattern pattern;

	@Autowired
	LunchUserMasterService lunchUserMasterService;

	@Override
	public void initialize(NumberValid nv) {
		// pattern= Parttern.compile();
	}

	@Override
	public boolean isValid(String in, ConstraintValidatorContext cxt) {

		List<LunchUserMaster> user_name_list = lunchUserMasterService.findAll();

		for (int i = 0; i < user_name_list.size(); i++) {
			if (in.equals(user_name_list.get(i).getUsername())) {

				return false;
			}
		}
			return true;

		}
	}

