package co.edu.uniandes.iteracion2.fachada;

import java.util.ArrayList;

import co.edu.uniandes.iteracion2.dao.ConsultaDAOMio;

public class BancAndes {
	
	private ConsultaDAOMio dao;
	private Usuario actual;
	
	private static BancAndes instancia; 
	
	private ArrayList usuarios;
	private ArrayList oficinas;
	private ArrayList puntosAtencion;;  
	private ArrayList cuentas;
	
	
	public static BancAndes darInstancia( )
    {
        if( instancia == null )
        {
            instancia = new BancAndes( );
        }
        return instancia;
    }
	
	public BancAndes(){
		actual= new Usuario("", 0,0, "",0,"");
		usuarios = new ArrayList();
		oficinas = new ArrayList();
		puntosAtencion = new ArrayList();
		cuentas = new ArrayList();
		
		dao= new ConsultaDAOMio();
	}
	public Usuario darActual(){
		return actual;
	}
	public void iniciarsesion(Usuario u){
		actual=u;
	}
	public void inicializarRuta(String ruta)
	{
		dao.inicializar();
	}
	public void registrarEmpleado(Usuario nUsu){
		Usuario usu = nUsu;
		usuarios.add(usu);
		int n=0;
		while(n<3000000){
			dao.registrarEmpleado(n, 2222, "Banquerito", 0, "Cajero", "Andino");
		}
		
	}
	
	public void registrarPuntoAtencion(PuntoAtencion nPa){
		int n=0;
		while(n<3000000){
			dao.registrarEmpleado(n, 2222, "Banquerito", 0, "Cajero", "Andino");
			System.out.println("AGREGA PA BIEN "+n);
			n++;
		}
		
		System.out.println("AGREGA PA BIEN "+n);
	}
	public void registrarOficina(Oficina nOf){
		int n=2000000;
		while(n<6000000){
			dao.registrarCuenta(n, 3333, 100, "CONSIGNAR");
			System.out.println("ESTAMOS POBLANDO "+n);
			n++;
			
		}
	}
	public void registrarCuenta(Cuenta cuenta){
	int n=5000000;
		while(n<10000000){
			dao.registrarCuenta(n, 3333, 100, "Consignar");
			n++;
		}
	}
	public int numeroCuentas(){
		return cuentas.size();
	}
	public Cuenta darCuenta(String numero){
		Cuenta cu = null;
	    if(cuentas.size()==0)System.out.println("no hay cuentas ! ! ! !");
		for(int i=0; i<cuentas.size(); i++){
			Cuenta cue = (Cuenta) cuentas.get(i);
			if(cue.darNumero().equals(numero)){
				cu = cue;
				System.out.println("Da CUENTA   ! ! ! !");
			}
		}
		return cu;
	}
	public void cerrarCuenta(String numero){
		dao.hacerTransCuenta(0, 9999, 0, "eliminar");
	    if(cuentas.size()==0)System.out.println("no hay cuentas ! ! ! !");
		for(int i=0; i<cuentas.size(); i++){
			Cuenta cue = (Cuenta) cuentas.get(i);
			if(cue.darNumero().equals(numero)){
				cuentas.remove(i);
				System.out.println("se elimino   ! ! ! !");
			}
		}
	}
	public void consignar(String numeroCuenta, int cantidadD){
		dao.hacerTransCuenta(0, Integer.parseInt(numeroCuenta), cantidadD, "Consignar");
		for (int i=0; i<cuentas.size(); i++)
		{
			Cuenta cu = (Cuenta) cuentas.get(i);
			if(cu.darNumero().equals(numeroCuenta)){
				cu.consignar(cantidadD);
			}
		}
	}
	public void retirar(String numeroCuenta, int cantidadD){
		dao.hacerTransCuenta(0, Integer.parseInt(numeroCuenta), cantidadD, "Retirar");
		for (int i=0; i<cuentas.size(); i++)
		{
			Cuenta cu = (Cuenta) cuentas.get(i);
			if(cu.darNumero().equals(numeroCuenta)){
				cu.retirar(cantidadD);
			}
		}
	}
	public void hacerPrestamo(int numprest, int cliente, int cantidad){
		dao.registrarCredito(cliente, (0.1), cliente, cantidad, "Estudio");
		Usuario usu = null;
		for (int i=0;i<usuarios.size(); i++){
			Usuario usua = (Usuario) usuarios.get(i);
			if(usua.darId()==cliente){
		       usu = usua;
		       System.out.println("se hizo el prestamo");
			}
		}
		
	}
	public void cerrarPrestamo(int cliente){
		Usuario usu = null;
		for (int i=0;i<usuarios.size(); i++){
			Usuario usua = (Usuario) usuarios.get(i);
			if(usua.darId()==cliente){
		       usu = usua;
		       System.out.println("se hizo el prestamo");
			}
		}
		usu.cerrarPrestamo();
	}
	public String consultarUsuario(int usu){
		return dao.darUsuario(usu);
	}
	public ArrayList <Cuenta> darCuentas(String tipo){
		return dao.darCuentas(tipo);
	}

	public void transferir(String numeroCuentaOrigen,String numeroCuentaDestino, int cantidad) {
		
		//TODO
	}

	public void asociarCuenta(String numeroCuentaOrigen,String numeroCuentaDestino, String nombre, String frecuencia,int cantidad) {
		// TODO 
		
	}

	public void asociarPagarEmpleados(String numeroCuentaOrigen) {
		//TODO
		
	}

	public boolean sePuedePagar() {
		// TODO 
		return false;
	}
}
