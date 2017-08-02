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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
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
			resp.getWriter().write("url���������¼��url�Ƿ���ȷ");
		}
	}
	//����û���Ϣ
	private void addUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String unumber= req.getParameter("unumber");
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		String usex=req.getParameter("usex");
		String uage=req.getParameter("uage");
		String uaddress=req.getParameter("uaddress");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		String[] params={unumber,uname,upwd,usex,uage,uaddress,rid,pnumber};
		//�����û�
		AdminService service = new AdminServiceImp();
		int count =service.addUserInfoService(params);
		if(count>0){
			req.setAttribute("flag", "true");
			req.getRequestDispatcher("admin/addUser.jsp").forward(req, resp);
		}
	}
	private void deleteUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String unumber=req.getParameter("unumber");
		//ɾ��ָ�����û�
		AdminService service = new AdminServiceImp();
		int count = service.deleteUserInfoService(unumber);
		if(count>0){
			req.setAttribute("flag", "true");
			getAdminInfo(req,resp);
		}
	}
	private void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String unumber=req.getParameter("unumber");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		//����������Ϣ
		AdminService service = new AdminServiceImp();
		//�����û�������
		int count = service.updateUserInfoService(unumber,rid,pnumber);
		if(count>0){
			req.setAttribute("flag", "true");
			getAdminInfo(req,resp);
		}
	}
	private void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ��������
		String rid= req.getParameter("rid");
		//���ð೤��service��
		ClazzService service = new ClazzServiceImp();
		//�����û���rid��ȡ��Ӧ������
		List<User> list = service.getClazzInfoService(rid);
		//������ת��json��ʽ
		String data=new Gson().toJson(list);
		//ֱ����Ӧ
		resp.getWriter().write(data);
	}
	private void getRoleInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		AdminService service = new AdminServiceImp();
		//��ȡ���еĽ�ɫ��Ϣ
		List<Role> list = service.getRoleInfoService();
		//�����ݷ�װΪjson��ʽ
		String data = new Gson().toJson(list);
		//ֱ����Ӧ
		resp.getWriter().write(data);
	}
	private void getAdminInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�೤service
		ClazzService service = new ClazzServiceImp();
		//��ȡѧ����Ϣ
		List<User> list = service.getClazzInfoService(null);
		//�ж�
		if(list!=null){
			//�����ݷŵ�request��������
			req.setAttribute("list", list);
			//����ת��
			req.getRequestDispatcher("admin/adminList.jsp").forward(req, resp);
		}
	}
}
