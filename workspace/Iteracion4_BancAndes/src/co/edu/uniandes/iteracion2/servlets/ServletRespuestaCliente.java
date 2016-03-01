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

public class ServletRespuestaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BancAndes banco;
	

    private ServletRespuestaCliente(){
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
        
        if(usuario.equals("Consignar")){
        	escribirContenidoConsignar( request, response );
        }
        if(usuario.equals("Retirar")){
        	escribirContenidoRetirar( request, response );
        }
        if(usuario.equals("Consultar")){
        	escribirContenidoConsultarCuenta( request, response );
        }
        if(usuario.equals("Aociar")){
        	escribirContenidoAsociar( request, response );
        }
        if(usuario.equals("Pagar")){
        	escribirContenidoPagar( request, response );
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
	private void escribirContenidoConsignar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String numeroCuenta = request.getParameter("numeroCuenta");
        PrintWriter respuesta = response.getWriter( );
        banco.consignar(numeroCuenta, cantidad);     
        respuesta.println( "SE CONSIGNO A LA CUENTA "+numeroCuenta+" "+cantidad +"</p>" );
	}
	private void escribirContenidoRetirar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidadRetiro"));
		String numeroCuenta = request.getParameter("numeroCuentaRetiro");
        PrintWriter respuesta = response.getWriter( );
        banco.retirar(numeroCuenta, cantidad);     
        respuesta.println( "SE RETIRO A LA CUENTA "+numeroCuenta+" "+cantidad +"</p>" );
	}
	private void escribirContenidoConsultarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero = request.getParameter("numero");
		System.out.println(numero+" numero de cuenta a buscar");
		Cuenta cue =  banco.darCuenta(numero);
		if(cue==null)System.out.println("la cuenta no existe");
		int idCliente = cue.darIdCliente();
		String plazo = cue.darPlazo();
		int cantidadDinero = cue.darCantidadDinero();
		String tipo = cue.darTipo();
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "Numero: "+numero+ "</p>" );
        respuesta.println( "Cliente: "+idCliente+ "</p>" );
        respuesta.println( "Cantidad de Dinero: "+cantidadDinero+ "</p>" );
        respuesta.println( "Tipo: "+tipo+ "</p>" );
        respuesta.println( "Plazo: "+plazo+ "</p>" );
	}

	private void escribirContenidoAsociar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String numeroCuentaOrigen = request.getParameter("numeroCuentaOrigen");
		String numeroCuentaDestino = request.getParameter("numeroCuentaDestino");
		String nombre = request.getParameter("nombre");
		String frecuencia = request.getParameter("frecuencia");
        PrintWriter respuesta = response.getWriter( );
        banco.asociarCuenta(numeroCuentaOrigen,numeroCuentaDestino,nombre, frecuencia, cantidad);     
        respuesta.println( "SE ASOCIO LA CUENTA "+numeroCuentaDestino+" Con Frecuencia: "+frecuencia+"</p>" );
	}
	private void escribirContenidoPagar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numeroCuentaOrigen = request.getParameter("numeroCuentaOrigen");;
        PrintWriter respuesta = response.getWriter( );
        boolean sePago = banco.sePuedePagar();
        banco.asociarPagarEmpleados(numeroCuentaOrigen);     
        if(sePago){
        respuesta.println( "SE PAGO TODO" );
        }
        else{
        respuesta.println( "NO SE PUDO PAGAR, INSUFICIENTE DINERO" );
        }
	}

}
