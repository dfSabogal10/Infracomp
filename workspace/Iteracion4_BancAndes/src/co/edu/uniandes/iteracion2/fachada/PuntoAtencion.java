package co.edu.uniandes.iteracion2.fachada;

public class PuntoAtencion {
	private String tipo;
	private String locacion;
	private String oficina;

	public PuntoAtencion(String nTipo, String nLocacion, String nOficina){
		tipo = nTipo;
		locacion = nLocacion;
		oficina = nOficina;
	}

public String darTipo(){
	return tipo;
}
public String darLocacion(){
	return locacion;
}
public String darOficina(){
	return oficina;
}
}