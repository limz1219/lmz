package cn.oge.bean;

import java.util.List;

/**
 * 权限角色中间表
 * @author lmz
 *
 */
public class Role_res {
	private String id;//主键
	private String roleid;//角色表主键
	private String res_id;//权限表主键
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
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Role_res() {
		super();
		// TODO Auto-generated constructor stub
	}


}
