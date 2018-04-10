package cn.oge.Mapper;

import java.util.List;
import java.util.Map;

import cn.oge.bean.Enterprise_aud;
import cn.oge.bean.Role;
import cn.oge.bean.Userinfo;

public interface UserinfoMapper {
//	
//	public void addUserInfo_lmz(Userinfo Userinfo);//添加用户
	public int getTotalCount_lmz(Userinfo user_name);//根据查询条件查询总条数
	public void AddUserInfo_lmz(Userinfo us);
	public int only_lmz(Userinfo us);
	public String getID(Userinfo us);
	public void update_lmz(Userinfo us);
	public void delUserInfo_lmz(Userinfo us);
	public List<Userinfo> findUserinfoByUser_name(Map m);
	public List<Role> findType_lmz();

}