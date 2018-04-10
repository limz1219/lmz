package cn.oge.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.oge.bean.Userinfo;
import cn.oge.service.UserService;

@Controller
/*
 
 */
public class LoginController {

	@Autowired
	private UserService UserService;

	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		try {
//		System.out.println("进方法了");
			Userinfo ui = new Userinfo();
			HttpSession session = request.getSession();
			String name = request.getParameter("txt");
			String pwd = request.getParameter("login_pws");

			response.setCharacterEncoding("GBK");
			PrintWriter out = response.getWriter();
			
			if ("".equals(name) || "".equals(pwd)) {
//				System.out.println("空串");
				request.setAttribute("message", "账号或密码不能为空");
				return "login.jsp";
			} else {

				ui.setUser_loginName(name);
				ui.setUser_password(pwd);

				Userinfo u = UserService.login(ui);
				if (u != null) {
					// 取下拉框内容
					String li = request.getParameter("testcheck");                      
					session.setAttribute("u", u);
	//				System.out.println(li);
					String type = u.getUser_type();
//					System.out.println("选下拉框");
					if (li.equals(type)) {
						// 判断角色登录，跳到对应页面
						if ("1".equals(type)) {
							out.print("<script type='text/javascript'>alert('登录成功!');window.location='admin_index.jsp'</script>");
						} else if ("4".equals(type)) {
							out.print("<script type='text/javascript'>alert('登录成功!');window.location='zhuguan.jsp'</script>");
						} else if ("2".equals(type)) {
							out.print("<script type='text/javascript'>alert('登录成功!');window.location='jiaowu.jsp'</script>");
						} else if ("5".equals(type)) {
							out.print("<script type='text/javascript'>alert('登录成功!');window.location='HR_Show_cjx.do'</script>");
						} else if ("3".equals(type)) {
							out.print("<script type='text/javascript'>alert('登录成功!');window.location='zhuanyuan.jsp'</script>");
						}
					} else {
//						System.out.println("角色不匹配");
						request.setAttribute("message", "账号或密码错误");
						return "login.jsp";
					}
				} else {
//					 System.out.println("没查到");
					request.setAttribute("message", "账号或密码错误");
					return "login.jsp";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("esc.do")
	public void esc(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 清空session
			request.getSession().invalidate();
			// System.out.println("执行退出操作");
			PrintWriter pw = response.getWriter();
			String url = "<script>window.parent.location.href=('";
			url += request.getContextPath();
			url += "/login.jsp')</script>";
			pw.print(url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}