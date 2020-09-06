package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

/**
 * Servlet implementation class _08_ApplyPro
 */
@WebServlet("/applyPro.do")
public class _08_ApplyPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		
		String field = request.getParameter("field");
		request.setAttribute("field", field);
		
		String[] arr = request.getParameterValues("skill");
		String skill = "";
		for (int i=0; i<arr.length; i++) {
			skill += arr[i];
			if (i != arr.length - 1) {
				skill += ",";
			}
		}
		request.setAttribute("skill", skill);
		
		String major = request.getParameter("major");
		request.setAttribute("major", major);
		
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.apply(id, field, skill, major);
		
		RequestDispatcher dis = request.getRequestDispatcher("08_applyPro.jsp");
		dis.forward(request, response);
		
	}
		
}
