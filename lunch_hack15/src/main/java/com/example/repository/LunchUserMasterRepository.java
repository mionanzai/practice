package com.example.repository;

import com.example.domain.LunchUserMaster;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LunchUserMasterRepository extends JpaRepository<LunchUserMaster, Integer> {

	@Query("SELECT x FROM LunchUserMaster x ORDER BY x.id_user, x.username")

	List<LunchUserMaster> findAllOrderByUsername();

	

	@Query("SELECT x FROM LunchUserMaster x ORDER BY x.id_user, x.username")

	Page<LunchUserMaster> findAllOrderById_user(Pageable pageable);



	Page<LunchUserMaster> findAllOrderByUsername(Pageable pageable);

}