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
 * Servlet implementation class _13_DeleteAdmin
 */
@WebServlet("/deleteAdmin.do")
public class _13_DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO mdao = MemberDAO.getInstance();
		int nodelete;
		
		String[] arr = request.getParameterValues("delMember");
		if (arr != null) {
			nodelete = 1;
			for(int i=0; i<arr.length; i++) {
				mdao.delete(arr[i]);
			}
		}
		else {
			nodelete = 0;
		}
		
		request.setAttribute("nodelete", nodelete);
			
		RequestDispatcher dis = request.getRequestDispatcher("13_deleteAdmin.jsp");
		dis.forward(request, response);
		
	}
}
