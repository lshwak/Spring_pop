package com.pop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pop.mapper.UserMapper;
import com.pop.model.LoginVO;
import com.pop.model.UserVO;

@Service
public class UserServiceImpl implements UserService {
		
		@Autowired
		private UserMapper um;
		
		@Override
		public UserVO login(LoginVO log) throws Exception {
			return um.login(log);
		}

}
