package com.example.service;

import com.example.domain.LunchUserStatus;
import com.example.repository.LunchUserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LunchUserStatusService {

    @Autowired
    LunchUserStatusRepository lunchUserStatusRepository;
    public List<LunchUserStatus> findAll() {
        return lunchUserStatusRepository.findAllOrderByDate();
    }

//    public Page<LunchUserStatus> findAll(Pageable pageable) {
//        return lunchUserStatusRepository.findAllOrderByDate(pageable);
//    }

    public LunchUserStatus findOne(Integer id_status) {
        return lunchUserStatusRepository.findOne(id_status);
    }

    public LunchUserStatus create(LunchUserStatus user_status) {
        return lunchUserStatusRepository.save(user_status);
    }

    public LunchUserStatus update(LunchUserStatus user_status) {
        return lunchUserStatusRepository.save(user_status);
    }

    public void delete(Integer id_status) {
    	lunchUserStatusRepository.delete(id_status);
    }
}