package com.example.domain;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Data

// @NoArgsConstructor
//
// @AllArgsConstructor

public class LunchHackCreate {

	@Id

	@GeneratedValue

	private Integer id_status;

	private String date;

	private String dateCreate;

	private String start_time;

	private String end_time;

	private Integer lunch_flg;

	private Integer id_user;

	private String username;

	// コンストラクタ
	public LunchHackCreate(LunchUserStatus userStatus, String date) {

		this.id_status = userStatus.getId_status();
		this.start_time = userStatus.getStart_time();
		this.end_time = userStatus.getEnd_time();
		this.lunch_flg = userStatus.getLunch_flg();
		String lunch_flg00 = lunch_flg.toString();
		if (lunch_flg == 0) {
			// lunch_flg = new Integer(0);

			lunch_flg00 = "行きたい";

			System.out.println(lunch_flg00);
			// this.lunch_flg = lunch_flg00;
		}
		if (lunch_flg == 1) {
			// lunch_flg = new Integer(0);

			lunch_flg00 = "行きたくない";

			System.out.println(lunch_flg00);
			// this.lunch_flg = lunch_flg00;
		}
		this.id_user = userStatus.getId_user();
		this.date = userStatus.getDate();

		this.username = username;
	}

}