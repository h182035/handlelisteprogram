package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListeServlet
 */
@WebServlet("/juster")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Vare> liste;
	@EJB
	VareEAO em;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getSession(false) != null) {
			if(request.getSession(false).getAttribute("loggedinn") != null) {
				liste = em.getAlle();
				request.setAttribute("liste", liste);
				request.setAttribute("sti", "C:/Users/rambe/eclipse-webapps/Handlelisteprogramv2/WebContent/bilder");
				request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request, response);
			}else {
				response.sendRedirect("login?expired=1");
			}
			
		} else {
			response.sendRedirect("login?expired=1");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String navnpavare = (String) request.getParameter("vare");
		em.nedjuster(navnpavare);

		response.sendRedirect("juster");
	}

}
