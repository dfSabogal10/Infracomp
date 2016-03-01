package co.edu.uniandes.iteracion2.fachada;

public class Credito {
	
	private int codigo;
	private double interes;
	private int cantDinero;
	private int idUsuario;
	private boolean estado;
	
	public Credito(int cod, int intr, int cant, int idus){
		codigo=cod;
		interes=intr;
		cantDinero=cant;
		idUsuario=idus;
		estado=false;
	}
	public int darCodigo(){
		return codigo;
	}
	public double darInteres(){
		return interes;
	}
	public int darCantDin(){
		return cantDinero;
	}
	public int daridusuario(){
		return idUsuario;
	}
	public boolean darEstado(){
		return estado;
	}
	public void cambiarEstado(){
		estado=true;
	}
	public void cambiarCant(int cant){
		cantDinero= cantDinero+cant;
		
	}

}
