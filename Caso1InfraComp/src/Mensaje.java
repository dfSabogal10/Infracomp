
public class Mensaje 
{
	//Atributos
	
	private int mensaje;
	
	//Constructor
	
	public Mensaje(int mensaje)
	{
		this.mensaje=mensaje;
	}
	
	//M�todos
	
	public int getMensaje() 
	{
		return mensaje;
	}
	
	public boolean procesar()
	{
		mensaje++;
		return true;
	}

}
