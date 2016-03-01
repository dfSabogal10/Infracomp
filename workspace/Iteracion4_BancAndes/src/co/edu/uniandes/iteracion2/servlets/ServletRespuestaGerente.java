package co.edu.uniandes.iteracion2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.iteracion2.fachada.BancAndes;
import co.edu.uniandes.iteracion2.fachada.Cuenta;
import co.edu.uniandes.iteracion2.fachada.Oficina;
import co.edu.uniandes.iteracion2.fachada.PuntoAtencion;
import co.edu.uniandes.iteracion2.fachada.Usuario;

public class ServletRespuestaGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BancAndes banco;
	

    private ServletRespuestaGerente(){
    	banco = new BancAndes();
    }
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
        String usuario = request.getParameter("usuario");
        
        if(usuario.equals("Registrar Cuenta")){
        	escribirContenidoRegCuenta( request, response );
        }
        if(usuario.equals("Cerrar Cuenta")){
        	escribirContenidoCerrarCuenta( request, response );
        }
        if(usuario.equals("Transferir")){
        	escribirContenidoTransferir( request, response );
        }
        if(usuario.equals("Consignar")){
        	escribirContenidoConsignar( request, response );
        }
        if(usuario.equals("Retirar")){
        	escribirContenidoRetirar( request, response );
        }
        if(usuario.equals("Registrar Prestamo")){
        	escribirContenidoRegPrestamo( request, response );
        }
        if(usuario.equals("Cerrar Prestamo")){
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
		
		String tipo = request.getParameter("tipo");
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		String numero = request.getParameter("numero");
		String plazo = request.getParameter("plazo");
		int cantidadDinero = Integer.parseInt(request.getParameter("cantidadDinero"));
		System.out.println("AAAAAAAAACCCCCAAAAA" +tipo +" "+idCliente+" "+numero);
		Cuenta cue = new Cuenta(tipo, numero, cantidadDinero, plazo, idCliente);
		banco.registrarCuenta(cue);
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "SE REGISTRO LA CUENTA "+numero+"</p>" );
//        respuesta.println("<form method=\"post\" action=\"index.htm\">");
//        respuesta.println( "<p class=\"submit\"><input type=\"submit\" name=\"usuario\" value=\"Volver\"></p>" );
//        respuesta.println( "</form>" );
	}
	private void escribirContenidoCerrarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero = request.getParameter("numero");
        PrintWriter respuesta = response.getWriter( );
        banco.cerrarCuenta(numero);
        respuesta.println( "SE CERRO LA CUENTA "+numero+"</p>" );
	}
	private void escribirContenidoConsignar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String numeroCuenta = request.getParameter("numeroCuenta");
        PrintWriter respuesta = response.getWriter( );
        banco.consignar(numeroCuenta, cantidad);     
        respuesta.println( "SE CONSIGNO A LA CUENTA "+numeroCuenta+" "+cantidad +"</p>" );
	}
	private void escribirContenidoTransferir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String numeroCuentaOrigen = request.getParameter("numeroCuentaOrigen");
		String numeroCuentaDestino = request.getParameter("numeroCuentaDestino");
        PrintWriter respuesta = response.getWriter( );
        banco.transferir(numeroCuentaOrigen,numeroCuentaDestino, cantidad);     
        respuesta.println( "SE TRANSFIRIO A LA CUENTA "+numeroCuentaDestino+" "+cantidad +" DE LA CUENTA: "+numeroCuentaOrigen+"</p>" );
	}
	private void escribirContenidoRetirar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidadRetiro"));
		String numeroCuenta = request.getParameter("numeroCuentaRetiro");
        PrintWriter respuesta = response.getWriter( );
        banco.retirar(numeroCuenta, cantidad);     
        respuesta.println( "SE RETIRO A LA CUENTA "+numeroCuenta+" "+cantidad +"</p>" );
	}
	private void escribirContenidoRegPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		banco.hacerPrestamo(0,idCliente, cantidad);
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "SE PRESTO: "+cantidad+" AL USUARIO "+idCliente+"</p>" );
	}
	private void escribirContenidoCerrarPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		banco.cerrarPrestamo(idCliente);
        PrintWriter respuesta = response.getWriter();
        respuesta.println( "SE CERRO EL PRESTAMO DEL CLIENTE: "+idCliente+"</p>" );
	}

}
