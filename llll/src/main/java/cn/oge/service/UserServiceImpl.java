package cn.oge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.oge.Mapper.UserMapper;
import cn.oge.bean.Userinfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserMapper UserMapper;
	
	public Userinfo login(Userinfo ui) {
		return UserMapper.login(ui);
	}

}
