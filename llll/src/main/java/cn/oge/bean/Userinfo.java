package cn.oge.bean;

import java.util.List;

/**
 * 用户表
 * @author lmz
 *
 */
public class Userinfo {
	private String user_id;//主键
	private String user_name;//用户姓名
	private String user_loginName;//登录名	
	private String user_password;//密码
	private String user_email;//邮箱
	private String user_phone;//手机
	private String user_addre;//地址
	private String user_type;//用户类型 1系统管理员 2教务 3就业专员 4就业主管 5企业
	private String Corporate_name;//公司名称
	private String status;//用户状态
	private String isdel;//是否删除0是已删除1是未删除
	private String userimg;//用户头像
	
	private List list;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_loginName() {
		return user_loginName;
	}

	public void setUser_loginName(String user_loginName) {
		this.user_loginName = user_loginName;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_addre() {
		return user_addre;
	}

	public void setUser_addre(String user_addre) {
		this.user_addre = user_addre;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getCorporate_name() {
		return Corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		Corporate_name = corporate_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getUserimg() {
		return userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}


}
