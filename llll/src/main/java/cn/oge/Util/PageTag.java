package cn.oge.Util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class PageTag extends SimpleTagSupport {

	private Page page;
	private String url;

	@Override
	public void doTag() throws JspException, IOException {

		// 获取输入流
		JspWriter jw = getJspContext().getOut();

		StringBuffer sb = new StringBuffer();

//		 <div class="first disable">首页</div><div class="prev disable">上一页</div><ul class="list">

		
		// 拼接"第一页"和"上一页"
		if (page.getCurrPage() == 1) {
			sb.append("<div class='first disable'>首页</div><div class='prev disable'>上一页</div><ul class='list'>");
		} else {
			sb.append("<div class='first'><a href='");
			sb.append(url);
			sb.append("&currPage=1");
			sb.append("'>首页</a></div>");
			sb.append("<div class='prev'><a  href='");
			sb.append(url);
			sb.append("&currPage=");
			sb.append(page.getCurrPage() - 1);
			sb.append("'>上一页</a></div><ul class='list'>");
		}
		
		int index =page.getCurrPage();
		int begin =index-2;
		if((page.getCurrPage()-2) <=1){//  3 4 5   7/8		
				begin =1;
		}
		
//		int index = page.getTotalPages() % 2 == 0 ? page.getTotalPages() / 2 : page.getTotalPages() / 2 + 1;
//		int begin = index - 2;
//		if (begin <= 1) {
//			begin = 1;
//		}
		int end = index + 2;
		if (end >= page.getTotalPages()) {
			end = page.getTotalPages();
		}

		
//		if (begin > 1) {
//			sb.append("<li><span>...</span></li>");
//		}

//        <li index="#1" class="cur"><a href="">1</a></li>
//        <li index="#2" class=""><a href="">2</a></li>
//        <li index="#3" class=""><a href="">3</a></li>
//        <li index="#4" class=""><a href="">4</a></li>
//        <li index="#5" class=""><a href="">5</a></li></ul>

		// 循环拼接页
		for (int i = begin; i <= end; i++) {
			if(i==page.getCurrPage()){
				sb.append("<li class='cur' index='#"+i+"'><a href='javascript:void(0)'>");
				sb.append(i);
				sb.append("</a></li>");
			}else{
				sb.append("<li  index='#"+i+"'><a href='");
				sb.append(url);
				sb.append("&currPage=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a></li>");
			}
			
			
		}

//		if (end < page.getTotalPages()) {
//			sb.append("<li><span>...</span></li>");
//		}

//	    <div class="next disable">下一页</div><div class="last disable">尾页</div>
		// 拼接"下一页"和"最后一页"
		if (page.getCurrPage() == page.getTotalPages()) {
			sb.append("</ul><div class='next disable'>下一页</div><div class='last disable'>尾页</div>");
		} else {
			sb.append("</ul><div class='next'><a href='");
			sb.append(url);
			sb.append("&currPage=");
			sb.append(page.getCurrPage() + 1);
			sb.append("'>下一页</a></div>");

			sb.append("<div class='last'><a  href='");
			sb.append(url);
			sb.append("&currPage=");
			sb.append(page.getTotalPages());
			sb.append("'>尾页</a></div>");
		}

		// 拼共多少条
//		sb.append("<li><span>共");
//		sb.append(page.getTotalCount());
//		sb.append("条数据</span></li>");

		// 每页显示多少条
//		sb.append("&nbsp;每页显 &nbsp;");
//		sb.append(page.getPageCount());
//		sb.append("条数据<>");

		// 拼共多少页
//		sb.append("<li><span>共");
//		sb.append( page.getTotalPages());
//		sb.append("页</span></li>");

		// 向页面输出
		jw.print(sb.toString());
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
