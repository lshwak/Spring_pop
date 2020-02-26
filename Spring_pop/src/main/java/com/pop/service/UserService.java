package com.pop.service;

import com.pop.model.LoginVO;
import com.pop.model.UserVO;

public interface UserService {
	public UserVO login(LoginVO log) throws Exception;
}
