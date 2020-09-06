package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberBean;

/**
 * Servlet implementation class _03_joinPro
 */
@WebServlet("/joinPro.do")
public class _03_JoinPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String name = request.getParameter("name");
		
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		request.setAttribute("tel", tel);
		
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		
		MemberBean bean = new MemberBean(id, pw, name, tel, email);
		MemberDAO mdao = MemberDAO.getInstance();
		int check = mdao.joinMember(bean);
		
		RequestDispatcher dis = request.getRequestDispatcher("03_joinPro.jsp");
		dis.forward(request, response);
	}

}
