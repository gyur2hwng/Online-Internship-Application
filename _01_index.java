package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class _01_index
 */
@WebServlet("/index.do")
public class _01_index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		
		request.setAttribute("id", id);
		
		if (session.getAttribute("memAdmin") != null) {
			int admin = (int)session.getAttribute("memAdmin");
			request.setAttribute("admin", admin);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("01_index.jsp");
		dis.forward(request, response);
	}


}
