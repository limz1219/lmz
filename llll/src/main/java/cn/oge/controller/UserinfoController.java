package cn.oge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.oge.Util.Page;
import cn.oge.bean.Role;
import cn.oge.bean.Userinfo;
import cn.oge.service.UserinfoService;

@Controller
public class UserinfoController {

	@Autowired
	public UserinfoService userinfoService;// 相当于创建service层对象

	/**
	 * 展现全部
	 */

	@RequestMapping("show_lmz.do")
	public String showUserinfo_lmz(HttpServletRequest request) {
		Map<String,Object> m =new HashMap<String,Object>();
		
		String user_name = request.getParameter("user_name");// 从前台页面取查询条件
		
		Userinfo userinfo = new Userinfo();
		userinfo.setUser_name(user_name);// 将前台取得username set
		// 制作分页
		Page page = new Page();
		String currPage = request.getParameter("currPage");
		if (currPage == null || "".equals(currPage) || "0".equals("currPage")) {
			currPage = "1";
		}
		page.setCurrPage(Integer.parseInt(currPage)); // 获取当前页
		page.setPageCount(5); // 每页显示条数

		page.setTotalCount(userinfoService.getTotalCount_lmz(userinfo));// 总条数
		
		/*List<Userinfo> list = null;
		page.setList(list);*/
		
		int begin = (page.getCurrPage() - 1) * page.getPageCount();
		
		m.put("u", userinfo);
		m.put("begin", begin);
		m.put("count", page.getPageCount());
		List<Userinfo> l = userinfoService.findUserinfoByUser_name(m);// 获得所有用户赋给l

		/*for (Userinfo u : l) {
			System.out.println(u.getUser_type());
			List<Role> role = u.getList();
			for (Role r : role) {
				System.out.println("角色" + r.getRolename());
			}
			System.out.println(u.getUser_name());
		}*/

		/*System.out.println("当前页"+page.getCurrPage());
		System.out.println("每页显示多少条"+page.getPageCount());
		System.out.println("总条数"+page.getTotalCount());
		System.out.println("总页数"+page.getTotalPages());*/
		
		request.setAttribute("p", page); // 回显
		request.setAttribute("lmz", l);// 把赋给lmz传给前台
		request.setAttribute("user_name", user_name);// 把赋给lmz传给前台

		return "00alluser.jsp";

	}

	/**
	 * 查询type
	 */
	@RequestMapping("findType_lmz.do")
	public String findType_lmz(HttpServletRequest request) {
		List<Role> r = userinfoService.findType_lmz();
		request.setAttribute("list", r);
		return "02new_user.jsp";

	}

	/**
	 * 新增
	 */

	@RequestMapping("add_lmz.do")
	public String AddUserInfo_lmz(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Userinfo us = new Userinfo();

		// 从页面表单中取得数据
		String name = request.getParameter("username");
		String loginname = request.getParameter("user_loginName");
		String password = request.getParameter("user_password");
		String type = request.getParameter("user_type");

		// 创建活动对象 将浏览器取得的结果给us

		us.setUser_name(name);
		us.setUser_loginName(loginname);
		us.setUser_password(password);
		us.setUser_type(type);

		userinfoService.AddUserInfo_lmz(us);
		// userinfoService.AddUser_Role(us);
		return "show_lmz.do";

	}

	/**
	 * 唯一
	 */
	@RequestMapping("only_lmz.do")
	public void only_lmz(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			// 从页面获取需要唯一验证的登录名

			String loginName = request.getParameter("user_loginName");
			System.out.println(loginName);
			String pwd = request.getParameter("user_password");

			PrintWriter out = response.getWriter();

			Userinfo us = new Userinfo();
			us.setUser_loginName(loginName);
			int a = userinfoService.only_lmz(us);
           System.out.println(a+"a");
			if (a == 0) {

				out.write("yes");// 可用
			} else {
				out.write("no");// 唯一验证
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 修改
	 */
	@RequestMapping("update_lmz.do")
	public String update_lmz(HttpServletRequest request) {

		Userinfo us = new Userinfo();
		// 获取userid
		String user_id = request.getParameter("user_id");
		String username = request.getParameter("username");
		String loginName = request.getParameter("user_loginName");
		String userpwd = request.getParameter("user_password");
		String method = request.getParameter("method");
		System.out.println(user_id + "\t" + method);

		us.setUser_id(user_id);
		us.setUser_name(username);
		us.setUser_loginName(loginName);
		us.setUser_password(userpwd);

		if (method != null) {

			userinfoService.update_lmz(us);
			return "show_lmz.do";
		} else {

			request.setAttribute("us", us);
			return "03edit_user.jsp";

		}

	}

	/**
	 * 逻辑删除
	 */
	@RequestMapping("delUserInfo_lmz.do")
	public void delUserInfo_lmz(HttpServletRequest request,
			HttpServletResponse response) {
		Userinfo us = new Userinfo();

		String user_id = request.getParameter("user_id");
		us.setUser_id(user_id);
		userinfoService.delUserInfo_lmz(us);
		try {
			response.getWriter().write("1");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
