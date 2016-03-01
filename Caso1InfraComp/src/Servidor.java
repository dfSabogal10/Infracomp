
public class Servidor extends Thread
{
	//Attributes
	int idThread;
	Servidor [] threads;
	Buffer buffer;
	boolean termino;
	
	//Constructor (para el principal)
	public Servidor(int numTsServidor, Buffer b)
	{
		threads = new Servidor[numTsServidor];
		for(int i=0;i< numTsServidor;i++)
		{
			threads[i]= new Servidor(i, b,false);
			System.out.println("se creo el servidor "+i);
			threads[i].start();
		}
	}
	
	//Constructor 2 (para los threads)
	public Servidor(int id, Buffer b,boolean termino)
	{
		idThread=id;
		buffer=b;
		this.termino=termino;	
	}

	public void run() 
	{
		boolean termino=false;
		while(buffer.getNumClientes()!=0)
		{	
				while(!buffer.retirar() && !termino)
				{
					if(buffer.getNumClientes()==0)termino=true;
					yield();
					System.out.println("No hay mensajes, servidor "+ idThread + " a la espera");					
				}			
		}
		termino=true;
	}

}
