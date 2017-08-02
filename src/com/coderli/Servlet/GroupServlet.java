package com.coderli.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.Service.GroupService;
import com.coderli.ServiceImp.GroupServiceImp;
import com.coderli.entry.Sign;
import com.coderli.entry.User;

public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String oper = req.getParameter("oper");
		if("groupInfo".equals(oper)){
			getGroupInfo(req,resp);
		}else if("showSign".equals(oper)){
			showSignInfo(req,resp);
		}else{
			resp.getWriter().write("请求的url不存在");
		}
	}
	private void showSignInfo(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String unumber=req.getParameter("unumber");
		String uname= req.getParameter("uname");
		String page=req.getParameter("page");
		page=Integer.parseInt(page)<1?1+"":page;
		//处理请求信息
		GroupService service = new GroupServiceImp();
		long count=service.getSignCountService(unumber);
		//当无数据时直接跳转
		if(count==0){
			req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
			return;
		}
		int pageCount=(int)Math.ceil(count*1.0/5);
		page=Integer.parseInt(page)>pageCount?pageCount+"":page;
		List<Sign> list =service.getSignInfoService(unumber,page);
		//响应处理结果
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		req.setAttribute("uname", uname);
		req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
	}
	private void getGroupInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		int unumber= ((User)req.getSession().getAttribute("user")).getUnumber();
		//处理请求信息
		GroupService service = new GroupServiceImp();
		List<User> list = service.getGroupInfoService(unumber);
//		System.out.println(list);
		//响应处理结果
		req.setAttribute("list", list);
		req.getRequestDispatcher("group/groupList.jsp").forward(req, resp);
	}
}
