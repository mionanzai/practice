package com.example.web;

import com.example.domain.LunchHack;
import com.example.domain.LunchHackCreate;
import com.example.domain.LunchUserMaster;
import com.example.domain.LunchUserStatus;
import com.example.repository.LunchUserMasterRepository;
import com.example.repository.LunchUserStatusRepository;
import com.example.service.LunchUserMasterService;
import com.example.service.LunchUserStatusService;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller

@RequestMapping("user_status")
public class LunchUserStatusController {

	@Autowired
	LunchUserStatusService lunchUserStatusService;
	@Autowired
	LunchUserMasterService lunchUserMasterService;
	@Autowired
	LunchUserStatusRepository lunchUserStatusRepository;

	@ModelAttribute
	LunchUserStatusForm setUpForm() {
		return new LunchUserStatusForm();
	}

	@GetMapping
	String list(Model model) {
		List<LunchUserStatus> user_status = lunchUserStatusService.findAll();
		List<LunchHack> lunchHack = new ArrayList<>();
		System.out.println(user_status);
		lunchUserStatusService.findAll().forEach(System.out::println);

		System.out.println(user_status.get(1));
		System.out.println(user_status.get(1).getId_user());

		// id_statusから一行取り出す
		lunchUserStatusService.findOne(1);
		System.out.println(user_status);

		List<LunchUserMaster> user_master = lunchUserMasterService.findAll();
		System.out.println(54321);
		lunchUserMasterService.findAll().forEach(System.out::println);

		System.out.println(user_master.get(1));
		System.out.println(user_master.get(1).getId_user());

		for (int i = 0; i < user_status.size(); i++) {
			for (int j = 0; j < user_master.size(); j++) {

				if (user_status.get(i).getId_user() == user_master.get(j).getId_user()) {
					System.out.println(user_master.get(j).getUsername());

					// コンストラクタの呼び出し
					LunchHack lunch_hack = new LunchHack(user_status.get(i), user_master.get(j).getUsername());
					System.out.println("コンストラクタの中身" + lunch_hack);
					lunchHack.add(lunch_hack);
					System.out.println("リストの中身" + lunchHack);
				}
			}
		}
		model.addAttribute("user_status", lunchHack);
		return "user_status/user_status_top";
	}

	@PostMapping(path = "create")
	String create(@Validated LunchUserStatusForm form, BindingResult result, Model model) {
		LunchUserStatus lunchUserStatus = new LunchUserStatus();
		List<LunchUserMaster> user_master = lunchUserMasterService.findAll();

		List<LunchUserStatus> user_status = lunchUserStatusService.findAll();
		if (result.hasErrors()) {
			return list(model);
		}

		BeanUtils.copyProperties(form, lunchUserStatus);

		Calendar cal1 = Calendar.getInstance(); // (1)オブジェクトの生成
		int year = cal1.get(Calendar.YEAR); // (2)現在の年を取得
		int month = cal1.get(Calendar.MONTH) + 1; // (3)現在の月を取得
		int day = cal1.get(Calendar.DATE); // (4)現在の日を取得

		String date = (year + "-" + month + "-" + day);
		System.out.println(form);
		System.out.println("日付" + date);

		lunchUserStatus.setDate(date);

		System.out.println("-------------------------------------------");

		int id_create = 0;

		for (int i = 0; i < user_master.size(); i++) {
			user_master.get(i).getId_user();
			if (form.getUsername().equals(user_master.get(i).getUsername())) {

				id_create = user_master.get(i).getId_user();

				lunchUserStatus.setId_user(id_create);
				System.out.println("id_create" + id_create);
			}
		}

		System.out.println(lunchUserStatus);

		// for (int i = 0; i < user_status.size(); i++) {
		// for (int j = 0; j < user_master.size(); j++) {
		// if (user_status.get(i).getId_user() ==
		// user_master.get(j).getId_user()) {
		// System.out.println(user_status.get(i));
		// System.out.println(user_master.get(j));
		//
		// lunchUserStatus.setId_user(user_status.get(i).getId_user());
		// System.out.println("クリエイトするＩＤ" + user_status.get(i).getId_user());
		// // lunchUserStatus.
		// System.out.println("インスタンスの中身" + lunchUserStatus);
		//
		// }
		// }
		//
		// }
		lunchUserStatusService.create(lunchUserStatus);
		return "redirect:/user_status";
	}

	@GetMapping(path = "edit", params = "form")

	String editForm(@RequestParam Integer id_status, LunchUserStatusForm form) {
		LunchUserStatus userStatus = lunchUserStatusService.findOne(id_status);
		BeanUtils.copyProperties(userStatus, form);

		System.out.println("編集開始");
		System.out.println(userStatus);
		System.out.println(form);
		
		
		lunchUserStatusService.update(userStatus);
		return "user_status/edit_user_status";
	}
		

//	//	List<LunchUserMaster> user_master = lunchUserMasterService.findAll();
//		List<LunchUserStatus> user_status = lunchUserStatusService.findAll();
//
//		
//		
//		for (int i = 0; i < user_status.size(); i++) {
//			for (int j = 0; j < user_master.size(); j++) {
//				if (user_status.get(i).getId_user() == user_master.get(j).getId_user()) {
//					userStatus.setStart_time(user_status.get(i).getStart_time());
//					userStatus.setEnd_time(user_status.get(i).getEnd_time());
//					userStatus.setId_user(user_status.get(i).getId_user());
//					userStatus.setLunch_flg(user_status.get(i).getLunch_flg());
//					userStatus.setDate(user_status.get(i).getDate());
//					
//
//					System.out.println("インスタンスの中身" + userStatus);
//
//				}
//			}
//		}
//	}

	@PostMapping(path = "edit")

	String edit(@RequestParam Integer id_status, @Validated LunchUserStatusForm form, BindingResult result) {
		if (result.hasErrors()) {
			return editForm(id_status, form);
		}

		LunchUserStatus user_status = new LunchUserStatus();
		BeanUtils.copyProperties(form, user_status);
		
		user_status.setId_status(id_status);
		
//		user_status.getId_user();
//		
//		user_status.setId_user(id_status);
//		
		System.out.println(form);
		System.out.println(user_status);
		lunchUserStatusService.update(user_status);
		return "redirect:/user_status";
	}

	@GetMapping(path = "edit", params = "goToTop")

	String goToTop() {
		return "redirect:/user_status";

	}

	@PostMapping(path = "delete")

	String delete(@RequestParam Integer id_status) {

		lunchUserStatusService.delete(id_status);

		return "redirect:/user_status";
	}
}
