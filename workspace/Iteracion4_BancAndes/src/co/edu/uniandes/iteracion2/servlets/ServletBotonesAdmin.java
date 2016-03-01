package co.edu.uniandes.iteracion2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.iteracion2.fachada.Usuario;

public class ServletBotonesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioM;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		procesarPedido(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		procesarPedido(request, response);
	}
	
    private void procesarPedido( HttpServletRequest request, HttpServletResponse response ) throws IOException
    {
    	
        imprimirHeader( request, response );  
        String botonesadministrador = request.getParameter("botonesadministrador");
        String contrasenia = request.getParameter("contrasenia");
        
        if(botonesadministrador.equals("Registrar Usuario")){
        	escribirContenidoRegUsuario( request, response );
        }
        if(botonesadministrador.equals("Resgistrar Oficina")){
        	escribirContenidoRegOficina( request, response );
        }
        if(botonesadministrador.equals("Registrar Punto de Atencion")){
        	escribirContenidoRegPuntoAtencion( request, response );
        }
        if(botonesadministrador.equals("ConsultarCuenta")){
        	escribirContenidoConsultarCuenta( request, response );
        }
        if(botonesadministrador.equals("ConsultarCliente")){
        	escribirContenidoConsultarCliente( request, response );
        }
        imprimirFooter( response );
		
	}



	private void imprimirHeader(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "<html>" );
        respuesta.println( "<head>" );
		
	}
	private void imprimirFooter(HttpServletResponse response) throws IOException {

        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "</html>" );
		
	}
	private void escribirContenidoRegUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaAdmin.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"login\" value=\"\" placeholder=\"Usario\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"nombre\" value=\"\" placeholder=\"nombre\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"id\" value=\"\" placeholder=\"id\"></p>" );
       respuesta.println( "<p><input type=\"password\" name=\"contrasenia\" value=\"\" placeholder=\"Contrasenia\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"tipo\" value=\"\" placeholder=\"Tipo\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Registrar Usuario\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoRegOficina(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaAdmin.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"nombre\" value=\"\" placeholder=\"Nombre\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"direccion\" value=\"\" placeholder=\"Direccion\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"telefono\" value=\"\" placeholder=\"id\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"gerente\" value=\"\" placeholder=\"Gerente a Cargo\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Registrar Oficina\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoRegPuntoAtencion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaAdmin.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"tipo\" value=\"\" placeholder=\"Tipo\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"locacion\" value=\"\" placeholder=\"Locacion\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"oficina\" value=\"\" placeholder=\"Oficina\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Registrar Punto de Atencion\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoConsultarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaAdmin.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Consultar\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoConsultarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaAdmin.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"id cliente\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"ConsultarCliente\"></p>" );
       respuesta.println( "</form>" );
	}
}
