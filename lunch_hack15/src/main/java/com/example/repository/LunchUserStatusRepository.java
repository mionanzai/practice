package com.example.repository;

import com.example.domain.LunchUserStatus;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LunchUserStatusRepository extends JpaRepository<LunchUserStatus, Integer> {

	@Query("SELECT x FROM LunchUserStatus x ORDER BY x.date")

	List<LunchUserStatus> findAllOrderByDate();

	
//
//	@Query("SELECT x FROM LunchUserStatus x ORDER BY x.date")
//
//	Page<LunchUserStatus> findAllOrderByDate(Pageable pageable);
//
//
//
//	Page<LunchUserStatus> findAllOrderById_user(Pageable pageable);

}