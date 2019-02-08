package no.hvl.dat108;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUtil {

	public static void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("loggedinn", 1);
		session.setMaxInactiveInterval(10*60);
		try {
			response.sendRedirect("juster");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void feilmelding(HttpServletRequest request) {
		String feilmelding = "";
		if(request.getParameter("expired") != null) {
			feilmelding = "Du ble automatisk logget ut fordi du var inaktiv for lenge";
			request.setAttribute("feilmelding", feilmelding);
		}
		if(request.getParameter("invalid") != null) {
			feilmelding = "Feil brukernavn eller passord";
			request.setAttribute("feilmelding", feilmelding);
		}
		
	}

}
