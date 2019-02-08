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
@WebServlet("/liste")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Vare> liste;
	List<Vare> liste2;
	List<Uvare> liste3;
	@EJB
	VareEAO em;
	@EJB
	UvareEAO uem;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) != null) {
			if (request.getSession(false).getAttribute("loggedinn") != null) {
				try {
					liste = em.getTomt();
					liste2 = em.getNestenTomt();
					liste3 = uem.getAlle();
				} catch (EJBException e) {
					request.getRequestDispatcher("WEB-INF/feil.jsp").forward(request, response);
				}

				request.setAttribute("liste", liste);
				request.setAttribute("liste2", liste2);
				request.setAttribute("liste3", liste3);
				request.getRequestDispatcher("WEB-INF/liste.jsp").forward(request, response);
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
		String[] navnpavare = request.getParameterValues("tomvare");
		if (navnpavare != null) {
			for (int i = 0; i < navnpavare.length; i++) {
				if(!em.handter(navnpavare[i])) {
					uem.slett(navnpavare[i]);
				}
				//em.nedjuster(navnpavare[i]);
			}
		}

		String[] navnpavare2 = request.getParameterValues("nestentomvare");
		if (navnpavare2 != null) {
			for (int i = 0; i < navnpavare2.length; i++) {
				em.nedjusterNestenTomVare(navnpavare2[i]);
			}
		}

		response.sendRedirect("juster");
	}

}
