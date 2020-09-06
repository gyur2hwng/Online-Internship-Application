package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import model.MemberDAO;
import model.MemberBean;

/**
 * Servlet implementation class _05_LoginPro
 */
@WebServlet("/loginPro.do")
public class _05_LoginPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		int check = dao.loginCheck(id, pw);
		int admin = dao.adminCheck(id, pw);
		
		if (admin == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memAdmin", admin);
		}
		
		if(check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
		}
		
		request.setAttribute("check", check);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("05_loginPro.jsp");
		dis.forward(request, response);
	}
		
}
