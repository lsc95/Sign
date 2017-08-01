package com.coderli.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.Service.ClazzService;
import com.coderli.ServiceImp.ClazzServiceImp;
import com.coderli.entry.User;

public class ClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取oper操作符
		String oper = req.getParameter("oper");
		if("clazzInfo".equals(oper)){
			getClazzInfo(req,resp);
		}else{
			resp.getWriter().write("请求的url无效，请检查url");
		}
	}
	//获取全班的信息
	private void getClazzInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String rid= req.getParameter("rid");
		//处理请求信息
		ClazzService service = new ClazzServiceImp();
		List<User> list =service.getClazzInfoService(rid);
		//将数据放到request域中
		req.setAttribute("list", list);
		req.setAttribute("rid", rid);
		//请求转发
		req.getRequestDispatcher("clazz/clazzInfo.jsp").forward(req, resp);
	}
}
