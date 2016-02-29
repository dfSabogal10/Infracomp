import java.util.ArrayList;


public class Buffer extends Thread
{
	//Atributos
	
	private ArrayList buff;
	private int capacidad;
	Object lleno,vacio;
	private int numClientes;
	
	//Constructor
	
	public Buffer(int Capacidad, int numTsClientes)
	{
		this.capacidad=Capacidad;
		buff= new ArrayList();
		lleno= new Object();
		vacio= new Object();
		//numClientes=numTsClientes;
		//prueba
			numClientes=5;
			for (int i = 0; i < capacidad; i++) {
				Mensaje m = new Mensaje(i);
				buff.add(m);
				System.out.println(m.getMensaje());
			}
	}
	
	//Métodos
	
	public Mensaje retirar() throws InterruptedException {
		if(buff.size()==0)synchronized(vacio){vacio.wait();}
		Mensaje m;
		synchronized(this){m=(Mensaje) buff.remove(0);}
		synchronized(lleno){lleno.notify();}
		return m;
	}
	
	public synchronized void despacharCliente()
	{
		numClientes--;
	}
	
	public int getNumClientes() 
	{
		return numClientes;
	}

}
