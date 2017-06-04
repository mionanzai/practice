package com.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.LunchUserMasterRepository;
import com.example.repository.LunchUserStatusRepository;



@SpringBootApplication

public class UserStatusApplication implements CommandLineRunner {

	@Autowired
    LunchUserMasterRepository lunchuserMasterRepository;
	@Autowired
    LunchUserStatusRepository lunchUserStatusRepository;
	@Override
    public void run(final String... strings) throws Exception {
        lunchuserMasterRepository.findAll().forEach(System.out::println);
        lunchUserStatusRepository.findAll().forEach(System.out::println);
     
    }
	public static void main(String[] args) {
		SpringApplication.run(UserStatusApplication.class, args);
	}
}

