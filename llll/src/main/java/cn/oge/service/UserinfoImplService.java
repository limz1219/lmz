package cn.oge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.oge.Mapper.UserinfoMapper;
import cn.oge.bean.Role;
import cn.oge.bean.Userinfo;
@Service
public class UserinfoImplService implements UserinfoService {
	@Autowired
	public UserinfoMapper userinfoMapper;
	
//条件查询总条数	
	
	public int getTotalCount_lmz(Userinfo user_name) {
		return userinfoMapper.getTotalCount_lmz(user_name);
	}




	
	public void AddUserInfo_lmz(Userinfo us) {
		userinfoMapper.AddUserInfo_lmz(us);
		
	}

	
	public int only_lmz(Userinfo us) {
		return userinfoMapper.only_lmz(us);
	}

	
	public String getID(Userinfo us) {
		return userinfoMapper.getID(us);
	}

	
	public void update_lmz(Userinfo us) {
		userinfoMapper.update_lmz(us);
		
	}

	
	public void delUserInfo_lmz(Userinfo us) {
		userinfoMapper.delUserInfo_lmz(us);
		
	}

	
	public List<Userinfo> findUserinfoByUser_name(Map m) {
		return userinfoMapper.findUserinfoByUser_name(m);
	}



	
	public List<Role> findType_lmz() {
		return userinfoMapper.findType_lmz();
	}











}
