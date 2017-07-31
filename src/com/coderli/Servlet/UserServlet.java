package com.coderli.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coderli.Service.UserService;
import com.coderli.ServiceImp.UserServiceImp;
import com.coderli.entry.Menu;
import com.coderli.entry.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求的参数
		String oper = req.getParameter("oper");
		if ("login".equals(oper)) {
			userLogin(req, resp);
			return;
		} else if("out".equals(oper)) {
			userOut(req, resp);
			return;
		}else if("in".equals(oper)){
			userSign(req,resp);
		}else if("sout".equals(oper)){
			userSignOut(req,resp);
		}else{
			System.out.println("UserServlet.userOut("+oper+")没有找到");
		}
	}

	private void userSignOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String unumber=req.getParameter("unumber");
			String outTime=req.getParameter("outTime");
			String outDate=req.getParameter("outDate");
//			System.out.println("UserServlet:"+unumber+":"+outTime+":"+outDate);
		//处理请求信息
			//调用service层将签退信息更新到数据库中
				UserService service = new UserServiceImp();
			//查询是否已经签到
				boolean flag = service.checkInInfoService(unumber, outDate);
				if(flag){
					int i=service.updateSignOutInfoService(unumber,outTime,outDate);
//					System.out.println("签退结果为:"+i);
					//响应处理结果
					if(i>0){
						resp.getWriter().write("true");
					}else{
						resp.getWriter().write("false");
					}
				}else{
					resp.getWriter().write("a");
				}
	}

	private void userSign(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
		String unumber=req.getParameter("unumber");
		String inDate=req.getParameter("inDate");
		String inTime=req.getParameter("inTime");
		//处理请求信息
			//调用service层将信息插入数据库
				UserService service = new UserServiceImp();
			//查询用户是否已经签到
				boolean flag = service.checkInInfoService(unumber,inDate);
			//开始签到
				if(!flag){
					int count = service.insertSign(unumber,inTime,inDate);
					if(count>0){
						resp.getWriter().write("true");
					}else{
						resp.getWriter().write("false");
					}
				}else{
					resp.getWriter().write("a");
				}
	}

	private void userOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("login.jsp");
	}

	private void userLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取请求信息
		String unumber = req.getParameter("unumber");
		String upwd = req.getParameter("upwd");
		System.out.println("UserServlet.service(" + unumber + ":" + upwd + ")");
		// 处理请求信息
		UserService service = new UserServiceImp();
		User user = service.checkLoginInfo(unumber, upwd);
		// 响应处理结果
		if (user != null) {
			//获取用户角色权限对应的菜单
			List<Menu> list= service.getMenuInfoByRid(user.getRid());
			System.out.println(list);
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("menu", list);
			req.getRequestDispatcher("main/main.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "学号或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}
