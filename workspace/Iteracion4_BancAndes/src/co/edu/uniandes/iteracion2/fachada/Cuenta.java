package co.edu.uniandes.iteracion2.fachada;

public class Cuenta {
	private String tipo;
	private String numero;
	private int cantidadDinero;
	private String plazo;
	private int idCliente;
	
	public Cuenta(String nTipo, String nNumero, int nCantidadDinero, String nPlazo, int nIdCliente){
		tipo = nTipo;
		numero = nNumero;
		cantidadDinero = nCantidadDinero;
		plazo = nPlazo;
		idCliente = nIdCliente;
	}
	
	public String darTipo(){
		return tipo;
	}
	public String darNumero(){
		return numero;
	}
	public int darCantidadDinero(){
		return cantidadDinero;
	}
	public String darPlazo(){
		return plazo;
	}
	public int darIdCliente(){
		return idCliente;
	}
	public void consignar(int cantidad){
		cantidadDinero = cantidadDinero + cantidad;
		System.out.println(cantidadDinero);
	}
	public void retirar(int cantidad){
		cantidadDinero = cantidadDinero - cantidad;
	}


}
