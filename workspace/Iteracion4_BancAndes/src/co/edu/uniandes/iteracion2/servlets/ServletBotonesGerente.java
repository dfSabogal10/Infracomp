package co.edu.uniandes.iteracion2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.iteracion2.fachada.Usuario;

public class ServletBotonesGerente extends HttpServlet {
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
        String botonergerente = request.getParameter("botonergerente");
        
        if(botonergerente.equals("Registrar Cuenta")){
        	escribirContenidoRegCuenta( request, response );
        }
        if(botonergerente.equals("Cerrar Cuenta")){
        	escribirContenidoCerrarCuenta( request, response );
        }
        if(botonergerente.equals("Registrar Operacion")){
        	escribirContenidoRegOperacion( request, response );
        }
        if(botonergerente.equals("Registrar Prestamo")){
        	escribirContenidoRegPrestamo( request, response );
        }
        if(botonergerente.equals("Cerrar Prestamo")){
        	escribirContenidoCerrarPrestamo( request, response );
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
	private void escribirContenidoRegCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaGerente.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"tipo\" value=\"\" placeholder=\"Tipo\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"idCliente\" value=\"\" placeholder=\"id Cliente\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"cantidadDinero\" value=\"\" placeholder=\"Cantidad de Dinero\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"plazo\" value=\"\" placeholder=\"Plazo\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"numero\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Registrar Cuenta\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoCerrarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
        respuesta.println("<form method=\"post\" action=\"RespuestaGerente.htm\">");
        respuesta.println( "<p><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"Numero\"></p>" );
        respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Cerrar Cuenta\"></p>" );
        respuesta.println( "</form>" );
	}
	private void escribirContenidoRegOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaGerente.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"cantidad\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuentaOrigen\" value=\"\" placeholder=\"Numero de Cuenta Origen\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuentaDestino\" value=\"\" placeholder=\"Numero de Cuenta Destino\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Transferir\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"cantidad\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuenta\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Consignar\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"cantidadRetiro\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuentaRetiro\" value=\"\" placeholder=\"Id Cuenta\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Retirar\"></p>" );
       respuesta.println( "</form>" );
	}
	
	private void escribirContenidoRegPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
       PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaGerente.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"cantidad\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"idCliente\" value=\"\" placeholder=\"Id Cliente\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Registrar Prestamo\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoCerrarPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
       PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaGerente.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"idCliente\" value=\"\" placeholder=\"Id Cliente\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Cerrar Prestamo\"></p>" );
       respuesta.println( "</form>" );
	}
}
