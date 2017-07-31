package com.coderli.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.Service.GroupService;
import com.coderli.ServiceImp.GroupServiceImp;
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
		}
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
