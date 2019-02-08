package no.hvl.dat108;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class LeggtilServlet
 */
@WebServlet("/leggtil")
@MultipartConfig
public class LeggtilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
				List<Uvare> liste = uem.getAlle();
				request.setAttribute("liste", liste);
				request.getRequestDispatcher("WEB-INF/leggtil.jsp").forward(request, response);
			} else {
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
		if(request.getParameter("vanlig") != null) {
			leggTilVanligVare(request);
		}else if(request.getParameter("uvanlig") != null) {
			leggTilUvanligVare(request);
		}
			
			response.sendRedirect("juster");
		
		

	}

	private void leggTilUvanligVare(HttpServletRequest request) {
		String[] navn = request.getParameterValues("navn");
		for(String s : navn) {
			if(!s.equals("")) {
				Uvare vare = new Uvare(s);
				uem.leggTil(vare);
			}
		}
		
		
		
	}

	private void leggTilVanligVare(HttpServletRequest request) {
		String varenavn = request.getParameter("navn");
		Part filePart = null;
		try {
			filePart = request.getPart("fil");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		String uploadPath = getServletContext().getRealPath("") + File.separator + "/bilder";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		String fileName = varenavn;
	    try {
			filePart.write(uploadPath + File.separator + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Vare nyVare = new Vare(varenavn, 0, "", varenavn);
		em.leggTil(nyVare);
		
	}
	


}
