package com.example.web;

import com.example.domain.LunchUserMaster;
import com.example.service.LunchUserMasterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

@RequestMapping("user_master")
public class LunchUserMasterController {

	@Autowired
    LunchUserMasterService lunchUserMasterService;

	@ModelAttribute
	LunchUserMasterForm setUpForm() {
		return new LunchUserMasterForm();
	}

	@GetMapping
	String list(Model model) {
		List<LunchUserMaster> user_master = lunchUserMasterService.findAll();
		model.addAttribute("user_master",user_master);
		return "user_master/user_master_top";
	}

	@PostMapping(path = "create")
	String create(@Validated LunchUserMasterForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return list(model);
		}

		LunchUserMaster lunchUserMaster = new LunchUserMaster();
		BeanUtils.copyProperties(form, lunchUserMaster);
		lunchUserMasterService.create(lunchUserMaster);
		return "redirect:/user_master";
	}

	@GetMapping(path = "edit", params = "form")

	String editForm(@RequestParam Integer id_user, LunchUserMasterForm form) {
		LunchUserMaster user_master = lunchUserMasterService.findOne(id_user);
		BeanUtils.copyProperties(user_master, form);
		return "user_master/edit_user_master";
	}

	@PostMapping(path = "edit")

	String edit(@RequestParam Integer id_user, @Validated LunchUserMasterForm form, BindingResult result) {
		if (result.hasErrors()) {
			return editForm(id_user, form);
		}

		LunchUserMaster user_master = new LunchUserMaster();

		BeanUtils.copyProperties(form, user_master);
		user_master.setId_user(id_user);
		lunchUserMasterService.update(user_master);
		return "redirect:/user_master";
	}

	@GetMapping(path = "edit", params = "goToTop")

	String goToTop() {
		return "redirect:/user_master";

	}
	@PostMapping(path = "delete")

	String delete(@RequestParam Integer id_user) {

		lunchUserMasterService.delete(id_user);

		return "redirect:/user_master";
	}
}
