package fr.eni.jee.module2.tp;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTPRechercherUnNombreAvecInitParametres
 */
@WebServlet(urlPatterns = {"/module2/tp/ServletTPRechercherUnNombreAvecInitParametres"},
			initParams = {
					@WebInitParam(name = "BORNE_MIN", value = "0"),
					@WebInitParam(name = "BORNE_MAX", value = "10")
					}
)
public class ServletTPRechercherUnNombreAvecInitParametres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int borneMin = 50;
	private int borneMax = 100;
	
	private int nombreATrouver;
	private int nombreSaisi;
	private boolean aGagne = false;
	
	@Override
	public void init() throws ServletException {
    	if(this.getInitParameter("BORNE_MIN") != null) {
    		borneMin = Integer.parseInt(this.getInitParameter("BORNE_MIN"));
    	}
    	if(this.getInitParameter("BORNE_MAX") != null) {
    		borneMax = Integer.parseInt(this.getInitParameter("BORNE_MAX"));
    	}
    	nombreATrouver = new Random().nextInt(borneMax-borneMin+1) + borneMin;
	    System.out.println(nombreATrouver);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nombreSaisi = Integer.parseInt(request.getParameter("number"));
		
		if (nombreSaisi == nombreATrouver && !this.aGagne) {
			this.aGagne = true;
			response.sendRedirect("/eni-jee/modules/module11/m2tp2/victoire.html");
		} else {
			response.sendRedirect("/eni-jee/modules/module11/m2tp2/defaite.html");
		}
	
	}

}
