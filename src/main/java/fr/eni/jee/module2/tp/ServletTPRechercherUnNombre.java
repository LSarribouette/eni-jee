package fr.eni.jee.module2.tp;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTPRechercherUnNombre
 */
@WebServlet("/module2/tp/ServletTPRechercherUnNombre")
public class ServletTPRechercherUnNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int nombreATrouver;
	private int nombreSaisi;
	private boolean aGagne = false;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		nombreATrouver = new Random().nextInt(11);
	    System.out.println(nombreATrouver);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nombreSaisi = Integer.parseInt(request.getParameter("number"));
		
		if (nombreSaisi == nombreATrouver && !this.aGagne) {
			this.aGagne = true;
			response.sendRedirect("/eni-jee/modules/module11/m2tp1/victoire.html");
		} else {
			response.sendRedirect("/eni-jee/modules/module11/m2tp1/defaite.html");
		}
	
	}

}
