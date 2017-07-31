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
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ����Ĳ���
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
			System.out.println("UserServlet.userOut("+oper+")û���ҵ�");
		}
	}

	private void userSignOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String unumber=req.getParameter("unumber");
			String outTime=req.getParameter("outTime");
			String outDate=req.getParameter("outDate");
//			System.out.println("UserServlet:"+unumber+":"+outTime+":"+outDate);
		//����������Ϣ
			//����service�㽫ǩ����Ϣ���µ����ݿ���
				UserService service = new UserServiceImp();
			//��ѯ�Ƿ��Ѿ�ǩ��
				boolean flag = service.checkInInfoService(unumber, outDate);
				if(flag){
					int i=service.updateSignOutInfoService(unumber,outTime,outDate);
//					System.out.println("ǩ�˽��Ϊ:"+i);
					//��Ӧ������
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
		//��ȡ������Ϣ
		String unumber=req.getParameter("unumber");
		String inDate=req.getParameter("inDate");
		String inTime=req.getParameter("inTime");
		//����������Ϣ
			//����service�㽫��Ϣ�������ݿ�
				UserService service = new UserServiceImp();
			//��ѯ�û��Ƿ��Ѿ�ǩ��
				boolean flag = service.checkInInfoService(unumber,inDate);
			//��ʼǩ��
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
		// ��ȡ������Ϣ
		String unumber = req.getParameter("unumber");
		String upwd = req.getParameter("upwd");
		System.out.println("UserServlet.service(" + unumber + ":" + upwd + ")");
		// ����������Ϣ
		UserService service = new UserServiceImp();
		User user = service.checkLoginInfo(unumber, upwd);
		// ��Ӧ������
		if (user != null) {
			//��ȡ�û���ɫȨ�޶�Ӧ�Ĳ˵�
			List<Menu> list= service.getMenuInfoByRid(user.getRid());
			System.out.println(list);
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("menu", list);
			req.getRequestDispatcher("main/main.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "ѧ�Ż��������");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}
