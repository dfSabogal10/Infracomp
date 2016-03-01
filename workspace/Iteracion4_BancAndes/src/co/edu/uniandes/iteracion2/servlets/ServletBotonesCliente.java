package co.edu.uniandes.iteracion2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.iteracion2.fachada.Usuario;

public class ServletBotonesCliente extends HttpServlet {
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
        String botonescliente= request.getParameter("botonescliente");
        
        if(botonescliente.equals("Registrar Operacion")){
        	escribirContenidoRegOperacion( request, response );
        }
        if(botonescliente.equals("Consultar Cuenta")){
        	escribirContenidoConsultarCuenta( request, response );
        }
        if(botonescliente.equals("Asociar Cuenta de Persona Natural")){
        	escribirContenidoAsociarCuenta( request, response );
        }
        if(botonescliente.equals("Pagar Empleados")){
        	escribirContenidoPagarEmpleados( request, response );
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
	private void escribirContenidoRegOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String login = request.getParameter("login");
        PrintWriter respuesta = response.getWriter( );
       respuesta.println("<form method=\"post\" action=\"RespuestaCliente.htm\">");
       respuesta.println( "<p><input type=\"text\" name=\"cantidad\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuenta\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Consignar\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"cantidadRetiro\" value=\"\" placeholder=\"Cantidad\"></p>" );
       respuesta.println( "<p><input type=\"text\" name=\"numeroCuentaRetiro\" value=\"\" placeholder=\"Id Cuenta\"></p>" );
       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Retirar\"></p>" );
       respuesta.println( "</form>" );
	}
	private void escribirContenidoConsultarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter respuesta = response.getWriter( );
	       respuesta.println("<form method=\"post\" action=\"RespuestaCliente.htm\">");
	       respuesta.println( "<p><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );
	       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Consultar\"></p>" );
	       respuesta.println( "</form>" );
	}
	private void escribirContenidoAsociarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter respuesta = response.getWriter( );
	       respuesta.println("<form method=\"post\" action=\"RespuestaCliente.htm\">");
	       respuesta.println( "<p><input type=\"text\" name=\"numeroOrigen\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );
	       respuesta.println( "<p><input type=\"text\" name=\"numeroCliente\" value=\"\" placeholder=\"Numero de Cuenta Del Empleado\"></p>" );
	       respuesta.println( "<p><input type=\"text\" name=\"nombre\" value=\"\" placeholder=\"Nombre Del Empleado\"></p>" );
	       respuesta.println( "<p><input type=\"text\" name=\"cantidad\" value=\"\" placeholder=\"Cantidad\"></p>" );
	       respuesta.println( "<p><input type=\"text\" name=\"frecuencia\" value=\"\" placeholder=\"Frecuencia\"></p>" );
	       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Asociar\"></p>" );
	       respuesta.println( "</form>" );
	}

	private void escribirContenidoPagarEmpleados(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter respuesta = response.getWriter( );
	       respuesta.println("<form method=\"post\" action=\"RespuestaCliente.htm\">");
	       respuesta.println( "<p><input type=\"text\" name=\"numeroOrigen\" value=\"\" placeholder=\"Numero de Cuenta\"></p>" );;
	       respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Pagar\"></p>" );
	       respuesta.println( "</form>" );
	}

}
