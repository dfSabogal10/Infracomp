package co.edu.uniandes.iteracion2.fachada;

public class Oficina {
private String nombre;
private String direccion;
private String telefono;
private Empleado gerente;


public Oficina(String nNombre, String nDireccion, String nTelefono, String idGerente){
	nombre = nNombre;
	direccion = nDireccion;
	telefono = nTelefono;
	
}
public String darNombre(){
	return nombre;
}
public String darDireccion(){
	return direccion;
}
public String darTelefono(){
	return telefono;
}
//public String darGerente(){
//	return nombre;
//}
}
