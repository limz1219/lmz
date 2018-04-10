package cn.oge.bean;

import java.util.List;

/**
 * 权限表
 * @author lmz
 *
 */
public class Resources {
	private String re_id;//菜单id
	private String re_name;//菜单名称
	private String re_url;//菜单路径
	private String Parent;//父id
	private String Icon;///图标
	private String ishide;//是否禁用(0启用，1禁用)
	private String isdel;//是否删除0是已删除1是未删除
	private List list;
	public String getRe_id() {
		return re_id;
	}
	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public String getRe_url() {
		return re_url;
	}
	public void setRe_url(String re_url) {
		this.re_url = re_url;
	}
	public String getParent() {
		return Parent;
	}
	public void setParent(String parent) {
		Parent = parent;
	}
	public String getIcon() {
		return Icon;
	}
	public void setIcon(String icon) {
		Icon = icon;
	}
	public String getIshide() {
		return ishide;
	}
	public void setIshide(String ishide) {
		this.ishide = ishide;
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
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}

}
