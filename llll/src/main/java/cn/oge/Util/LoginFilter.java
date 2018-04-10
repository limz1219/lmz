package cn.oge.Util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import cn.oge.bean.Userinfo;

/*
 
 */
public class LoginFilter implements Filter {
	private FilterConfig config;

	// 判断是否包含
	public boolean isContains(String container, String[] regx) {
		boolean result = false;

		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1) {
				return true;
			}
		}
		return result;
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
				response);

		String outPath = config.getInitParameter("outPath");// 不过滤的路径

		String includePath = config.getInitParameter("includePath");// 需要过滤的路径.do.jsp

		String redirectPath = request.getContextPath()
				+ config.getInitParameter("redirectPath");// 没有登陆转向页面

		String disablefilter = config.getInitParameter("disablefilter");// 过滤器是否有效

		if (disablefilter.toUpperCase().equals("Y")) { // 过滤无效
			arg2.doFilter(request, response);
			return;
		}

		String[] outList = outPath.split(";");
		String[] includeList = includePath.split(";");

		if (!this.isContains(request.getRequestURI(), includeList)) {// 只对指定过滤参数后缀进行过滤
			arg2.doFilter(request, response);
			return;
		}

		if (this.isContains(request.getRequestURI(), outList)) {// 对页面不进行过滤
			arg2.doFilter(request, response);
			return;
		}

		Userinfo user = (Userinfo) request.getSession().getAttribute("u");// 判断用户是否登录
		String loginUrl = request.getContextPath();
		if (user == null) {
//			System.out.println("user == null");
			PrintWriter pw = response.getWriter();
			String url = "<script>window.parent.location.href=('";
			url += request.getContextPath();
			url += "/login.jsp')</script>";
			pw.print(url);
			return;
		} else {
			String uri = request.getRequestURI();
			String b = user.getUser_type();
			String c;
			if ("/ems/admin_index.jsp".equals(uri)) {
//				System.out.println("admin_index.jsp");
				c = "1";
				if (c.equals(b)) {
					arg2.doFilter(request, response);
					return;
				} else {
			//		wrapper.sendRedirect(redirectPath);
					response.sendRedirect(loginUrl + "/login.jsp");
					return;
				}
			}
			if ("/ems/zhuguan.jsp".equals(uri)) {
//				System.out.println("zhuguan.jsp");
				c = "4";
				if (c.equals(b)) {
					arg2.doFilter(request, response);
					return;
				} else {
		//			wrapper.sendRedirect(redirectPath);
					response.sendRedirect(loginUrl + "/login.jsp");
					return;
				}
			}
			if ("/ems/jiaowu.jsp".equals(uri)) {
//				System.out.println("jiaowu.jsp");
				c = "2";
				if (c.equals(b)) {
					arg2.doFilter(request, response);
					return;
				} else {
		//			wrapper.sendRedirect(redirectPath);
					response.sendRedirect(loginUrl + "/login.jsp");
					return;
				}
			}
			if ("/ems/hr-index.jsp".equals(uri)) {
//				System.out.println("hr-index.jsp");
				c = "5";
				if (c.equals(b)) {
					arg2.doFilter(request, response);
					return;
				} else {
		//			wrapper.sendRedirect(redirectPath);
					response.sendRedirect(loginUrl + "/login.jsp");
					return;
				}
			}
			if ("/ems/zhuanyuan.jsp".equals(uri)) {
//				System.out.println("zhuanyuan.jsp");
				c = "3";
				if (c.equals(b)) {
					arg2.doFilter(request, response);
					return;
				} else {
		//			wrapper.sendRedirect(redirectPath);
					response.sendRedirect(loginUrl + "/login.jsp");
					return;
				}
			}

			arg2.doFilter(request, response);
			return;
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
