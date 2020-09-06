package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberDAO;

/**
 * Servlet implementation class _10_Update
 */
@WebServlet("/update.do")
public class _10_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("memId");
		
		MemberDAO mdao = MemberDAO.getInstance();
		MemberBean bean = mdao.getOneMember(id);
		
		String tel = bean.getTel();
		String[] arr = tel.split("-");
		String tel1 = arr[0];
		String tel2 = arr[1];
		String tel3 = arr[2];
		
		request.setAttribute("tel1", tel1);
		request.setAttribute("tel2", tel2);
		request.setAttribute("tel3", tel3);
		request.setAttribute("bean", bean);
		
		RequestDispatcher dis = request.getRequestDispatcher("10_update.jsp");
		dis.forward(request, response);
	}

}
