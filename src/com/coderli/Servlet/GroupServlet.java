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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String oper = req.getParameter("oper");
		if("groupInfo".equals(oper)){
			getGroupInfo(req,resp);
		}else if("showSign".equals(oper)){
			showSignInfo(req,resp);
		}else{
			resp.getWriter().write("�����url������");
		}
	}
	private void showSignInfo(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String unumber=req.getParameter("unumber");
		String uname= req.getParameter("uname");
		String page=req.getParameter("page");
		page=Integer.parseInt(page)<1?1+"":page;
		//����������Ϣ
		GroupService service = new GroupServiceImp();
		long count=service.getSignCountService(unumber);
		//��������ʱֱ����ת
		if(count==0){
			req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
			return;
		}
		int pageCount=(int)Math.ceil(count*1.0/5);
		page=Integer.parseInt(page)>pageCount?pageCount+"":page;
		List<Sign> list =service.getSignInfoService(unumber,page);
		//��Ӧ������
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		req.setAttribute("uname", uname);
		req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
	}
	private void getGroupInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		int unumber= ((User)req.getSession().getAttribute("user")).getUnumber();
		//����������Ϣ
		GroupService service = new GroupServiceImp();
		List<User> list = service.getGroupInfoService(unumber);
//		System.out.println(list);
		//��Ӧ������
		req.setAttribute("list", list);
		req.getRequestDispatcher("group/groupList.jsp").forward(req, resp);
	}
}
