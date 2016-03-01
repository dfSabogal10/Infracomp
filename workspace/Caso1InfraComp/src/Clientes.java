

public class Clientes extends Thread
{
	
	
	private int numThreads;
	private int numConsultas;
	public Mensaje mensaje;
	public static Buffer buffer;

	public Clientes(int i,int j, Buffer b){
		numConsultas=j;
		numThreads=i;
		buffer=b;	
	}
	

	public void run()
	{
		mensaje=new Mensaje(1110);
		while(buffer.darCapacidad()>0){
			try 
			{
				buffer.enviarMensaje(mensaje);
				System.out.println("Desperte");
				
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void finalize() throws Throwable {

	}
}
