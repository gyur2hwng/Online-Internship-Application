package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberBean;

/**
 * Servlet implementation class _12_memberList
 */
@WebServlet("/memberList.do")
public class _12_MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MemberDAO dao = MemberDAO.getInstance();
		Vector<MemberBean> memList = dao.getAllMember();
		
		request.setAttribute("memList", memList);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("12_memberList.jsp");
		dis.forward(request, response);
		
	}

}
