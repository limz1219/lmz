package cn.oge.bean;

import java.util.List;

/**
 * 用户权限中间表	
 * @author LMZ
 *
 */
public class User_role {

	private String id;//主键
	private String roleid;//角色表主键
	private String userid;//用户表主键
	private List list;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public User_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
