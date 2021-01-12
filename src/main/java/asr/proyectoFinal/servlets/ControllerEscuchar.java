package asr.proyectoFinal.servlets;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asr.proyectoFinal.services.Text2Speech;


/**
 * Servlet implementation class ControllerEscuchar
 */
@WebServlet(urlPatterns = {"/escuchar"})
public class ControllerEscuchar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		switch(request.getServletPath())	{
			
			case "/escuchar":
				byte[] audio ;
				String parametro = "Palabra inicial";
				parametro = request.getParameter("texto");
				audio = Text2Speech.escuchar(parametro);
				response.getOutputStream().write(audio);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
