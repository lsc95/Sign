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
		} else if ("out".equals(oper)) {
			userOut(req, resp);
			return;
		} else if ("in".equals(oper)) {
			userSign(req, resp);
		} else if ("sout".equals(oper)) {
			userSignOut(req, resp);
		} else if ("pwd".equals(oper)) {
			userCheckOldPwd(req, resp);
		} else if ("newPwd".equals(oper)) {
			userUpdateNewPwd(req, resp);
		} else if ("info".equals(oper)) {
			getUserInfo(req, resp);
		} else {
			if(req.getSession().getAttribute("user")==null){
				resp.sendRedirect("/sign/login.jsp");
				return;
			}
			System.out.println("UserServlet.userOut(" + oper + ")û���ҵ�");
			
		}
	}

	private void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ�û�������Ϣ
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		//�����û�������Ϣ
		UserService service = new UserServiceImp();
		String rname=service.getRnameInfoService(rid);
		String pname=service.getPnameInfoService(pnumber);
		//��Ӧ������
		String str="{rname:'"+rname+"',pname:'"+pname+"'}";
		resp.getWriter().write(str);
	}

	private void userUpdateNewPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ��������
		String newPwd = req.getParameter("newPwd");
		int unumber = ((User) req.getSession().getAttribute("user"))
				.getUnumber();
		// ������������
		UserService service = new UserServiceImp();
		int count = service.updateUserNewPwdInfoService(newPwd, unumber);
		System.out.println("������Ϊ:" + count);
		// ��Ӧ������
		if (count > 0) {
			resp.sendRedirect("login.jsp");
		}
	}

	private void userCheckOldPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ��������
		String oldPwd = req.getParameter("oldPwd");
		// ������������
		String pwd = ((User) req.getSession().getAttribute("user")).getUpwd();
		if (pwd.equals(oldPwd)) {
			resp.getWriter().write("true");
		} else {
			resp.getWriter().write("false");
		}
	}

	private void userSignOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ������Ϣ
		String unumber = req.getParameter("unumber");
		String outTime = req.getParameter("outTime");
		String outDate = req.getParameter("outDate");
		String outStatus = req.getParameter("outStatus");
		// System.out.println("UserServlet:"+unumber+":"+outTime+":"+outDate);
		// ����������Ϣ
		// ����service�㽫ǩ����Ϣ���µ����ݿ���
		UserService service = new UserServiceImp();
		// ��ѯ�Ƿ��Ѿ�ǩ��
		boolean flag = service.checkInInfoService(unumber, outDate);
		if (flag) {
			int i = service.updateSignOutInfoService(unumber, outTime, outDate,
					outStatus);
			// System.out.println("ǩ�˽��Ϊ:"+i);
			// ��Ӧ������
			if (i > 0) {
				resp.getWriter().write(outStatus);
			} else {
				resp.getWriter().write("false");
			}
		} else {
			resp.getWriter().write("a");
		}
	}

	private void userSign(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ������Ϣ
		String unumber = req.getParameter("unumber");
		String inDate = req.getParameter("inDate");
		String inTime = req.getParameter("inTime");
		String inStatus = req.getParameter("inStatus");
		// ����������Ϣ
		// ����service�㽫��Ϣ�������ݿ�
		UserService service = new UserServiceImp();
		// ��ѯ�û��Ƿ��Ѿ�ǩ��
		boolean flag = service.checkInInfoService(unumber, inDate);
		// ��ʼǩ��
		if (!flag) {
			int count = service.insertSign(unumber, inTime, inDate, inStatus);
			if (count > 0) {
				resp.getWriter().write(inStatus);

			} else {
				resp.getWriter().write("false");
			}
		} else {
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
			// ��ȡ�û���ɫȨ�޶�Ӧ�Ĳ˵�
			List<Menu> list = service.getMenuInfoByRid(user.getRid());
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
