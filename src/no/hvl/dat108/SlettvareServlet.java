package no.hvl.dat108;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandlelisteServlet
 */
@WebServlet("/slett")
public class SlettvareServlet extends HttpServlet {
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
			if (request.getSession(false).getAttribute("loggedinn") != null) {
				try {
					liste = em.getAlle();
				} catch (EJBException e) {
					request.getRequestDispatcher("WEB-INF/feil.jsp").forward(request, response);
				}

				request.setAttribute("liste", liste);
				request.getRequestDispatcher("WEB-INF/slettvare.jsp").forward(request, response);
			}else {
				response.sendRedirect("login");
			}
		} else {
			response.sendRedirect("login");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] navnpavare = request.getParameterValues("slettvare");
		if (navnpavare != null) {
			for (int i = 0; i < navnpavare.length; i++) {
				em.slett(navnpavare[i]);
			}
		}

		response.sendRedirect("juster");
	}

}
