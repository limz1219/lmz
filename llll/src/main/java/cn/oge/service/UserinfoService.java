package cn.oge.service;

import java.util.List;
import java.util.Map;

import cn.oge.bean.Role;
import cn.oge.bean.Userinfo;

public interface UserinfoService {
	public int getTotalCount_lmz(Userinfo user_name);
	
	
	public void AddUserInfo_lmz(Userinfo us);
	public int only_lmz(Userinfo us);
	public String getID(Userinfo us);
	public void update_lmz(Userinfo us);
	public void delUserInfo_lmz(Userinfo us);
	public List<Userinfo> findUserinfoByUser_name(Map m);
	public List<Role> findType_lmz();
	
}
