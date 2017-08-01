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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡoper������
		String oper = req.getParameter("oper");
		if("clazzInfo".equals(oper)){
			getClazzInfo(req,resp);
		}else{
			resp.getWriter().write("�����url��Ч������url");
		}
	}
	//��ȡȫ�����Ϣ
	private void getClazzInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String rid= req.getParameter("rid");
		//����������Ϣ
		ClazzService service = new ClazzServiceImp();
		List<User> list =service.getClazzInfoService(rid);
		//�����ݷŵ�request����
		req.setAttribute("list", list);
		req.setAttribute("rid", rid);
		//����ת��
		req.getRequestDispatcher("clazz/clazzInfo.jsp").forward(req, resp);
	}
}
