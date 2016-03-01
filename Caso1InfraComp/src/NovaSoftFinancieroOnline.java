import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NovaSoftFinancieroOnline {

	// Atributos
	
	private Servidor s;
	
	private Clientes c;
	
	private Buffer b;
	
	// Constructor
	
	public NovaSoftFinancieroOnline(int numTsServidor, int numTsClientes,int numConsultasClientes, int capBuffer)
	{

		b= new Buffer(capBuffer, numTsClientes);
		s= new Servidor(numTsServidor, b);
		c= new Clientes(numTsClientes,numConsultasClientes, b);		
	}
	
	//Main
	
	/**
	 * @param args 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in= new BufferedReader(new FileReader(new File("./data/parametros.txt")));
		String line= in.readLine();
		int numTsServidor = Integer.parseInt(line);
		line= in.readLine();
		int numTsClientes = Integer.parseInt(line);
		line= in.readLine();
		int numConsultasClientes = Integer.parseInt(line);
		line= in.readLine();
		int capBuffer = Integer.parseInt(line);
		new NovaSoftFinancieroOnline(numTsServidor, numTsClientes, numConsultasClientes, capBuffer);
	}

}
