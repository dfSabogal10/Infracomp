
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
		while(buffer.getNumClientes()!=0)
		{
			Mensaje m;
			try {
				m = buffer.retirar();
				m.procesar();
				System.out.println(m.getMensaje());
				synchronized(m){m.notify();}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

}
