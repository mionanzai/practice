package com.example.domain;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

@Data

@NoArgsConstructor

@AllArgsConstructor

@Entity

@Table(name = "user_status")

public class LunchUserStatus {

	@Id

	@GeneratedValue

	private Integer id_status;

	private String date;
	
	private String start_time;
	
	private String end_time;
	
	private Integer lunch_flg;
	
	private Integer id_user;

}
