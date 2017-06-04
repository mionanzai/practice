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

@Table(name = "user_master")

public class LunchUserMaster {

	@Id

	@GeneratedValue

	private Integer id_user;

	
	private String username;

}
