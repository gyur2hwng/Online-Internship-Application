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
 * Servlet implementation class _11_UpdatePro
 */
@WebServlet("/updatePro.do")
public class _11_UpdatePro extends HttpServlet {
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
		String id = (String)session.getAttribute("memid");
		
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
	    String tel3 = request.getParameter("tel3");
	    String tel = tel1 + "-" + tel2 + "-" + tel3;
			
	    String email = request.getParameter("email");
	    String field = request.getParameter("field");
	        
	    String[] arr = request.getParameterValues("skill");
	    String skill = "";
	    for(int i=0; i<arr.length; i++) {
	    	skill += arr[i];
	        if(i != arr.length - 1) {
	        	skill += ",";
	        }
	    }
	        
	    String major = request.getParameter("major");

	    MemberBean bean = new MemberBean(pw, name, tel, email, field, skill, major);
	        
	    MemberDAO mdao = MemberDAO.getInstance();
		mdao.updateMember(id, bean);
			
		RequestDispatcher dis = request.getRequestDispatcher("11_updatePro.jsp");
		dis.forward(request, response);
	}

}
