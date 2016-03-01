package co.edu.uniandes.iteracion2.fachada;

public class Usuario {
	
	private String nombre;
	private int contrasenia;
	
	private int id;
	private int prestamo;
	private int tipodoc;
	private String tipo; //gerente, cliente o cajero
	private String sucur;
	
	public Usuario( String nNombre, int nContrasenia, int nId, String nTipo, int ptipodoc, String psucr){
		nombre=nNombre;
		contrasenia = nContrasenia;
		
		id = nId;
		prestamo=0;
		tipo=nTipo;
		ptipodoc=tipodoc;
		sucur=psucr;
		
	}
	public int dartipodoc(){
		return tipodoc;
	}
	public String darSuc(){
		return sucur;
	}
	public String darNombre(){
		return nombre;
	}
	public int darContrasenia(){
		return contrasenia;
	}
	
	public int darId(){
		return id;
	}
	public String darTipo(){
		return tipo;
	}
	public void hacerPrestamo(int cantidad){
		prestamo = prestamo + cantidad;
	}
	public void cerrarPrestamo(){
		prestamo = 0;
	}

}
