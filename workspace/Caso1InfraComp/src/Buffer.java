import java.util.ArrayList;



public class Buffer extends Thread
{
	//Atributos
	
	private ArrayList mensajes;
	private int capacidad;
	private int numClientes;
	
	//Constructor
	
	public Buffer(int Capacidad, int numTsClientes)
	{
		this.capacidad=Capacidad;
		mensajes= new ArrayList();
		numClientes=numTsClientes;
		//prueba
//			numClientes=5;
//			for (int i = 0; i < capacidad; i++) {
//				Mensaje m = new Mensaje(i);
//				mensajes.add(m);
//				System.out.println(m.getMensaje());
//			}
	}
	
	//M�todos
	
	public boolean retirar(){
		synchronized(this)
		{
			if(mensajes.size()==0){return false;}
			else
			{
				Mensaje m;

				m=(Mensaje) mensajes.remove(0);
				if(m.procesar())
				{
					synchronized (m) {m.notify();}
					System.out.println("Respuesta = "+m.getMensaje());
				}			

				return true;
			}
		}
	}
	
	public void enviarMensaje(Mensaje mensaje) throws InterruptedException
	{
		synchronized(this)
		{
			
			//Si no hay espacio para guardar m�s mensajes. Se duerme en el buffer
			if(capacidad == 0)
			{
				System.out.println("Espero");
				wait();			
			}
			//Agrega un mensaje despu�s de haber verificado la capacidad.
			mensajes.add(mensaje);
			capacidad--;
			System.out.println("Guarde un mensaje");
		}	
		synchronized(mensaje)
		{
			//Se queda dormido en el mensaje esperando la respuesta.
			mensaje.wait();
		}
	}
	public synchronized void despacharCliente()
	{
		numClientes--;
	}
	
	public int getNumClientes() 
	{
		return numClientes;
	}
	public int darCapacidad(){
		return capacidad;
	}

}
