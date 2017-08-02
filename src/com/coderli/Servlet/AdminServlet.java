package com.coderli.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.Service.AdminService;
import com.coderli.Service.ClazzService;
import com.coderli.ServiceImp.AdminServiceImp;
import com.coderli.ServiceImp.ClazzServiceImp;
import com.coderli.entry.Role;
import com.coderli.entry.User;
import com.google.gson.Gson;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=req.getParameter("oper");
		if("adminInfo".equals(oper)){
			getAdminInfo(req,resp);
		}else if("roleInfo".equals(oper)){
			getRoleInfo(req,resp);
		}else if("userInfo".equals(oper)){
			getUserInfo(req,resp);
		}else if("updateUser".equals(oper)){
			updateUserInfo(req,resp);
		}else if("deleteUser".equals(oper)){
			deleteUserInfo(req,resp);
		}else if("addUser".equals(oper)){
			addUserInfo(req,resp);
		}else{
			resp.getWriter().write("url错误，请重新检查url是否正确");
		}
	}
	//添加用户信息
	private void addUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String unumber= req.getParameter("unumber");
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		String usex=req.getParameter("usex");
		String uage=req.getParameter("uage");
		String uaddress=req.getParameter("uaddress");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		String[] params={unumber,uname,upwd,usex,uage,uaddress,rid,pnumber};
		//增加用户
		AdminService service = new AdminServiceImp();
		int count =service.addUserInfoService(params);
		if(count>0){
			req.setAttribute("flag", "true");
			req.getRequestDispatcher("admin/addUser.jsp").forward(req, resp);
		}
	}
	private void deleteUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String unumber=req.getParameter("unumber");
		//删除指定的用户
		AdminService service = new AdminServiceImp();
		int count = service.deleteUserInfoService(unumber);
		if(count>0){
			req.setAttribute("flag", "true");
			getAdminInfo(req,resp);
		}
	}
	private void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String unumber=req.getParameter("unumber");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		//处理请求信息
		AdminService service = new AdminServiceImp();
		//更新用户的数据
		int count = service.updateUserInfoService(unumber,rid,pnumber);
		if(count>0){
			req.setAttribute("flag", "true");
			getAdminInfo(req,resp);
		}
	}
	private void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求数据
		String rid= req.getParameter("rid");
		//调用班长的service层
		ClazzService service = new ClazzServiceImp();
		//根据用户的rid获取对应的数据
		List<User> list = service.getClazzInfoService(rid);
		//将数据转成json格式
		String data=new Gson().toJson(list);
		//直接响应
		resp.getWriter().write(data);
	}
	private void getRoleInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		AdminService service = new AdminServiceImp();
		//获取所有的角色信息
		List<Role> list = service.getRoleInfoService();
		//将数据封装为json格式
		String data = new Gson().toJson(list);
		//直接响应
		resp.getWriter().write(data);
	}
	private void getAdminInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取班长service
		ClazzService service = new ClazzServiceImp();
		//获取学生信息
		List<User> list = service.getClazzInfoService(null);
		//判断
		if(list!=null){
			//将数据放到request作用域中
			req.setAttribute("list", list);
			//请求转发
			req.getRequestDispatcher("admin/adminList.jsp").forward(req, resp);
		}
	}
}
