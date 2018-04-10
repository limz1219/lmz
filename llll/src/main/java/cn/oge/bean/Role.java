package cn.oge.bean;

import java.util.List;

/**
 * 角色表
 * @author LMZ
 *
 */
public class Role {
	
	private String id;//主键
	private String rolename;//角色名称
	private String roledescription;//角色权限描述
	private String remark;//备注
	private String isdel;//是否删除0是已删除1是未删除
	private List list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledescription() {
		return roledescription;
	}
	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsdel() {
		return isdel;
	}
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
