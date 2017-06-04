package com.example.service;

import com.example.domain.LunchUserMaster;
import com.example.repository.LunchUserMasterRepository;
import com.example.web.LunchUserMasterForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LunchUserMasterService {

    @Autowired
    LunchUserMasterRepository lunchUserMasterRepository;
    public List<LunchUserMaster> findAll() {
        return lunchUserMasterRepository.findAllOrderByUsername();
    }

    public Page<LunchUserMaster> findAll(Pageable pageable) {
        return lunchUserMasterRepository.findAllOrderByUsername(pageable);
    }

    public LunchUserMaster findOne(Integer id_user) {
        return lunchUserMasterRepository.findOne(id_user);
    }

    public LunchUserMaster create(LunchUserMaster user_master) {
        return lunchUserMasterRepository.save(user_master);
    }

    public LunchUserMaster update(LunchUserMaster user_master) {
        return lunchUserMasterRepository.save(user_master);
    }

    public void delete(Integer id_user) {
    	lunchUserMasterRepository.delete(id_user);
    }
		
	}
