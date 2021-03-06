package co.edu.uniandes.iteracion2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.iteracion2.fachada.BancAndes;
import co.edu.uniandes.iteracion2.fachada.Cuenta;
import co.edu.uniandes.iteracion2.fachada.Oficina;
import co.edu.uniandes.iteracion2.fachada.PuntoAtencion;
import co.edu.uniandes.iteracion2.fachada.Usuario;

public class ServletRespuestaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BancAndes banco;
	

    private ServletRespuestaAdmin(){
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
        
        if(usuario.equals("Registrar Usuario")){
        	escribirContenidoRegUsuario( request, response );
        }
        if(usuario.equals("Registrar Oficina")){
        	escribirContenidoRegOficina( request, response );
        }
        if(usuario.equals("Registrar Punto de Atencion")){
        	escribirContenidoRegPuntoAtencion( request, response );
        }
        if(usuario.equals("Consultar")){
        	escribirContenidoConsultarCuenta( request, response );
        }
        if(usuario.equals("ConsultarCliente")){
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
		
		String login = request.getParameter("login");
		String nombre = request.getParameter("nombre");
		String contrasenia = request.getParameter("contrasenia");
		String id = request.getParameter("id");
		String tipo = request.getParameter("tipo");
		System.out.println("AAAAAAAAACCCCCAAAAA" +login +" "+nombre+contrasenia);
		Usuario usu = new Usuario(nombre, Integer.parseInt(contrasenia), Integer.parseInt(id), tipo,0,login);
		banco.registrarEmpleado(usu);
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "SE REGISTRO EL USUARIO "+login+"DE TIPO: "+tipo+"</p>" );
	}
	private void escribirContenidoRegOficina(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		String direccion =request.getParameter("direccion");
		String telefono =request.getParameter("telefono");
		String nombreGerente =request.getParameter("gerente");
        PrintWriter respuesta = response.getWriter( );
        Oficina of = new Oficina(nombre, direccion, telefono, nombreGerente);
        banco.registrarOficina(of);
        respuesta.println( "SE REGISTRO LA OFICINA "+nombre+"</p>" );
	}
	private void escribirContenidoRegPuntoAtencion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tipo = request.getParameter("tipo");
		String locacion = request.getParameter("locacion");
		String oficina = request.getParameter("oficina");
        PrintWriter respuesta = response.getWriter( );
        PuntoAtencion pa = new PuntoAtencion(tipo, locacion, oficina);
        banco.registrarPuntoAtencion(pa);      
        respuesta.println( "SE REGISTRO EL PUNTO DE ATECION</p>" );
	}
	private void escribirContenidoConsultarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tipo = request.getParameter("numero");
		ArrayList<Cuenta> res= banco.darCuentas(tipo);
		for(int i=0; i<res.size();i++){
		System.out.println(tipo+" numero de cuenta a buscar");
		Cuenta cue =  res.get(i);
		if(cue==null)System.out.println("la cuenta no existe");
		System.out.println(cue.darNumero());
		String numero= cue.darNumero();
		int idCliente = cue.darIdCliente();
		String plazo = cue.darPlazo();
		int cantidadDinero = cue.darCantidadDinero();
		tipo = cue.darTipo();
        PrintWriter respuesta = response.getWriter( );
        respuesta.println( "Numero: "+numero+ "</p>" +"</n>");
        respuesta.println( "Cliente: "+idCliente+ "</p>" );
        respuesta.println( "Cantidad de Dinero: "+cantidadDinero+ "</p>" );
        respuesta.println( "Tipo: "+tipo+ "</p>" );
        respuesta.println( "Plazo: "+plazo+ "</p>" +"</n>");
		}
	}
	private void escribirContenidoConsultarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero = request.getParameter("numero");
        PrintWriter respuesta = response.getWriter( );
        String info= banco.consultarUsuario(Integer.parseInt(numero));
        respuesta.println( "INFO CLIENTE: "+info+ "</p>" );
	}

}
