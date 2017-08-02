package com.syf.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syf.boot.dao.MainDao;
import com.syf.boot.model.User;

@Service
public class MvcDemoServiceImp implements MvcDemoService {

	@Autowired
	MainDao mainDao;

	@Override
	public User save(User user) {
		return mainDao.save(user);
	}

	@Override
	public User getDetails(String username, String password) {
		return mainDao.getDetails(username, password);
	}

}
