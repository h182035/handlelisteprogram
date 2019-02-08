package no.hvl.dat108;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String passord = "hemmelig";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> ip = new ArrayList<String>();
		ip.add("158.37.233.94");
		ip.add("62.92.133.10");
		ip.add("192.168.10.111");
		System.out.println(request.getRemoteAddr());
		if(ip.contains(request.getRemoteAddr())) {
			LoginUtil.login(request, response);
		}else {
			LoginUtil.feilmelding(request);
		
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("password").equals(passord)) {
			LoginUtil.login(request, response);
		}else {
			response.sendRedirect("login?invalid=1");
		}
		
	}

}
