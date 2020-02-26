package com.pop.mapper;

import com.pop.model.LoginVO;
import com.pop.model.UserVO;

public interface UserMapper {
	public UserVO login(LoginVO log) throws Exception;
}
