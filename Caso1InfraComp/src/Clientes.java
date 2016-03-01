

public class Clientes extends Thread
{
	
	//Atributos
	
	private int idThread;
	private int numThreads;
	private int numConsultas;
	public Mensaje mensaje;
	Clientes [] threads;
	private Buffer buffer;
	private boolean termino;

	//Constructor (principal)
	
	public Clientes(int numTsClientes,int j, Buffer b){
		threads = new Clientes[numTsClientes];
		for(int i=0;i< numTsClientes;i++)
		{
			threads[i]= new Clientes(i,j, b,false);
			System.out.println("se creo el cliente "+i);
			threads[i].start();
		}	
	}
	
	//Constructor 2 (threads)
	
	public Clientes(int id,int numConsultas, Buffer b,boolean termino)
	{
		idThread=id;
		buffer=b;
		this.numConsultas=numConsultas;
		this.termino=termino;	
	}
	

	public void run()
	{
		for (int i = 0; i < numConsultas; i++) {
			mensaje=new Mensaje(1000+idThread*100+i);
			try {
				while(!buffer.enviarMensaje(mensaje)){
					System.out.println("No hay espacio, Cliente "+ idThread+" a la espera");
					yield();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Desperte");
		}
		buffer.despacharCliente();
		termino=true;
	}
}
