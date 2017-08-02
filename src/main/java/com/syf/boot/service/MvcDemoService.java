package com.syf.boot.service;

import org.springframework.stereotype.Service;

import com.syf.boot.model.User;

@Service
public interface MvcDemoService {

	User save(User user);
	User getDetails(String username, String password);

}
