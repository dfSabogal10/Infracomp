package co.edu.uniandes.iteracion2.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import co.edu.uniandes.iteracion2.fachada.BancAndes;
import co.edu.uniandes.iteracion2.fachada.Cuenta;
import co.edu.uniandes.iteracion2.fachada.Usuario;
import oracle.sql.DATE;

public class ConsultaDAOMio {

	private BancAndes one;
	Savepoint primero = null;
	Savepoint segundo = null;
	Savepoint tercero = null;

	private static final String ARCHIVO_CONEXION = "data/conexion.properties";

	/**
	 * conexion con la base de datos
	 */
	public Connection conexion;

	/**
	 * nombre del usuario para conectarse a la base de datos.
	 */
	private static String usuario = "ISIS2304131520";

	/**
	 * clave de conexión a la base de datos.
	 */
	private static String clave ="AB6zptSv4Ca6";
	/**
	 * URL al cual se debe conectar para acceder a la base de datos.
	 */
	private static String cadenaConexion = "jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod";

	//METODOS
	public void inicializar()
	{
		try
		{
			File arch= new File(ARCHIVO_CONEXION);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream( arch );

			prop.load( in );
			in.close( );

			cadenaConexion = prop.getProperty("url");	// El url, el usuario y passwd deben estar en un archivo de propiedades.
			// url: "jdbc:oracle:thin:@chie.uniandes.edu.co:1521:chie10";
			usuario = prop.getProperty("usuario");	// "s2501aXX";
			clave = prop.getProperty("clave");	// "c2501XX";
			final String driver = prop.getProperty("driver");
			Class.forName(driver);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	private void establecerConexion() throws SQLException
	{
		try
		{

			System.out.println(cadenaConexion +" "+usuario+clave);
			conexion = DriverManager.getConnection(cadenaConexion,usuario,clave);
//			conexion.commit();
		}
		catch( SQLException exception )
		{
			exception.printStackTrace();
			throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexin." );
		}
	}
	public void closeConnection(Connection connection) throws Exception {        
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexión.");
		}
	} 


	//Consultas 
	public Usuario AutenticarUsuario(int pid, int pclave)
	{


		PreparedStatement prepStmt = null;
		String agregar = "SELECT * FROM USUARIO U WHERE U.ID =" +pid+" AND U.CLAVE = "+pclave ;


		try {
			establecerConexion();

			prepStmt = conexion.prepareStatement(agregar);

			ResultSet rs = prepStmt.executeQuery();

			int id = rs.getInt("ID");
			int clave = rs.getInt("CLAVE");
			String nombre = rs.getString("NOMBRE");
			int tipoDoc = rs.getInt("TIPO");
			if(nombre!=null){
				Usuario d= new Usuario(nombre, clave, id, "Cliente", tipoDoc,"");
				one=new BancAndes();
				one.iniciarsesion(d);
				return d;
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		return null;

	}
	public Usuario AutenticarEmpleado(int pid, int pclave)
	{


		PreparedStatement prepStmt = null;
		String agregar = "SELECT * FROM EMPLEADO U WHERE U.ID =" +pid+" AND U.CLAVE = "+pclave ;


		try {
			establecerConexion();

			prepStmt = conexion.prepareStatement(agregar);

			ResultSet rs = prepStmt.executeQuery();

			int id = rs.getInt("ID");
			int clave = rs.getInt("CLAVE");
			String nombre = rs.getString("NOMBRE");
			String tipo = rs.getString("TIPO");
			if(nombre!=null){
				Usuario d= new Usuario(nombre, clave, id, tipo,0,"");
				one=new BancAndes();
				one.iniciarsesion(d);
				return d;
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		return null;

	}

	public void registrarEmpleado(int pid, int pclave, String Nombre, int tipodoc, String tipo, String suc){


		PreparedStatement prepStmt = null;
	

		try {
			establecerConexion();

//			prepStmt = conexion.prepareStatement(agregar);

//			ResultSet rs = prepStmt.executeQuery();
//
//			int id = rs.getInt("ID");
//			if(id >0 && one.darActual().darTipo().equals("Asesor")){
				String add="INSERT INTO EMPLEADO (ID, CLAVE, NOMSUCURSAL,TIPO) VALUES ("+pid+","+pclave+",'"+suc+"','"+tipo+"')";
				prepStmt=conexion.prepareStatement(add);
				ResultSet rs = prepStmt.executeQuery();
//			}
//			prepStmt=conexion.prepareStatement(cli);
//			rs = prepStmt.executeQuery();
//			id = rs.getInt("ID");
//			if(tipo.equals("Cliente")){
//			if(id >0 && (one.darActual().darTipo().equals("Gerente")||one.darActual().darTipo().equals("Cajero"))){
//				String add="INSERT INTO USUARIO (ID, CLAVE, NOMBRE,TIPO) VALUES ("+pid+","+pclave+","+Nombre+","+tipodoc+")";
//				conexion.prepareStatement(add);
//			}
//			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}
	public void registrarUsuario(int pid, int pclave, String Nombre, int tipodoc, String tipo, String suc){


		PreparedStatement prepStmt = null;
	

		try {
			establecerConexion();

//			prepStmt = conexion.prepareStatement(agregar);

//			ResultSet rs = prepStmt.executeQuery();
//
//			int id = rs.getInt("ID");
//			if(id >0 && one.darActual().darTipo().equals("Asesor")){
//				String add="INSERT INTO EMPLEADO (ID, CLAVE, NOMSUCURSAL,TIPO) VALUES ("+pid+","+pclave+",'"+suc+"','"+tipo+"')";
				
//			}
//			prepStmt=conexion.prepareStatement(cli);
//			rs = prepStmt.executeQuery();
//			id = rs.getInt("ID");
//			if(tipo.equals("Cliente")){
//			if(id >0 && (one.darActual().darTipo().equals("Gerente")||one.darActual().darTipo().equals("Cajero"))){
				String add="INSERT INTO USUARIO (ID, CLAVE, NOMBRE,TIPO,EDAD) VALUES ("+pid+","+pclave+",'"+Nombre+"',"+tipodoc+", 18)";

				prepStmt=conexion.prepareStatement(add);
				ResultSet rs = prepStmt.executeQuery();
//			}
//			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}
	public void registrarSucursal( String Nombre, String pDir, String tipo){


		PreparedStatement prepStmt = null;
		String add="INSERT INTO SUCURSAL (NOMBRE , DIRECCION , NOMBREBANCO ,TIPO ) VALUES ('"+Nombre+"','"+pDir+"', 'BancAndes' ,'"+tipo+"')";


		try {
	
			establecerConexion();
		


//			ResultSet rs = prepStmt.executeQuery();

//			String nombre = rs.getString("NOMBRE");
//			if(one.darActual().darTipo().equals("Asesor")){
			System.out.println(add);
				prepStmt =conexion.prepareStatement(add);
				System.out.println(add+"fff");
				ResultSet rs = prepStmt.executeQuery();
			
				System.out.println("ok"+Nombre);
//			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}
	public void registrarCuenta( int Numtrans, int numcuenta, int pcant, String tipo){


		PreparedStatement prepStmt = null;

		


		try {
			establecerConexion();

			

			
//			if(num!=0 && one.darActual().darTipo().equals("Gerente")){
				String add="INSERT INTO TRANSACCION_CUENTA (NUM_TRANSACCION, NUM_CUENTA, CANTIDAD ,TIPO) VALUES ("+Numtrans+","+numcuenta+", "+pcant+",'"+tipo+"')";
				prepStmt= conexion.prepareStatement(add);
				ResultSet rs = prepStmt.executeQuery();
//			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}
	public void registrarCredito( int pnumero, double pint, int pidus, int pcant, String tipo){


		PreparedStatement prepStmt = null;
		String agregar = "SELECT * FROM CREDITO U WHERE U.CODIGO =" +pnumero ;
		


		try {
			establecerConexion();

			prepStmt = null;

		
//			if(num!=0 && one.darActual().darTipo().equals("Gerente")){
				String add="INSERT INTO CREDITO (CODIGO,INTERES, CANTIDADDINERO, IDCLIENTE ,TIPO) VALUES ("+pnumero+","+5+","+pcant+", "+pidus+",'"+tipo+"')";
				
				prepStmt=conexion.prepareStatement(add);
				ResultSet rs = prepStmt.executeQuery();
//			}
//			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}

	public void hacerTransCuenta(int numtras, int idcuenta,int cant,String tipo){
		PreparedStatement prepStmt = null;
		try {
			establecerConexion();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			java.util.Date fecha=new java.util.Date();
			String add= "INSERT INTO TRANSACCION_CUENTA (NUM_TRANSACCION, NUM_CUENTA, CANTIDAD, TIPO, FECHA) VALUES ("+idcuenta*cant+","+idcuenta+","+cant+","+tipo+","+"TO_DATE('2015-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS')"+")";
//			INSERT INTO "ISIS2304131520"."TRANSACCION_CUENTA" (NUM_TRANSACCION, NUM_CUENTA, CANTIDAD, TIPO, FECHA) VALUES ('223232', '5945', '12500', 'RETIRAR', TO_DATE('2015-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'))

			System.out.println(add);
//						prepStmt=conexion.prepareStatement(add);
//						int  rs = prepStmt.executeUpdate(add);
//						System.out.println("ok1");
						
						if(tipo.equalsIgnoreCase("CONSIGNAR")&& idcuenta>0 && cant>0){
							 add="UPDATE CUENTA  SET CANTIDADDINERO = CANTIDADDINERO+"+cant+"WHERE NUMERO='"+idcuenta+"'";
							 conexion.setAutoCommit(false);
								conexion.setTransactionIsolation(conexion.TRANSACTION_READ_COMMITTED);
								segundo = conexion.setSavepoint("opeth");
								prepStmt = conexion.prepareStatement(add);
								int resultado = prepStmt.executeUpdate( add);
								conexion.commit();
							System.out.println("ok2");
						}
						if(tipo.equalsIgnoreCase("RETIRAR")){
							
							add="UPDATE CUENTA  SET CANTIDADDINERO = CANTIDADDINERO-"+cant+"WHERE NUMERO='"+idcuenta+"'";
							 conexion.setAutoCommit(false);
								conexion.setTransactionIsolation(conexion.TRANSACTION_READ_COMMITTED);
							segundo = conexion.setSavepoint("opeth");
							prepStmt = conexion.prepareStatement(add);
							int resultado = prepStmt.executeUpdate( add);
							conexion.commit();
							 System.out.println("ok2"+tipo);
						}
						if(tipo.equalsIgnoreCase("Eliminar")){
							add="UPDATE CUENTA  SET CANTIDADDINERO = 0 WHERE NUMERO='"+idcuenta+"'";
							 conexion.setAutoCommit(false);
								conexion.setTransactionIsolation(conexion.TRANSACTION_READ_COMMITTED);
							segundo = conexion.setSavepoint("opeth");
							prepStmt = conexion.prepareStatement(add);
							int resultado = prepStmt.executeUpdate( add);
							conexion.commit();
							 System.out.println("ok2");

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
	public void hacerTransCred(int numtras, int codcred,int cant,String tipo){
		try {
			establecerConexion();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement prepStmt = null;
		try {
			
			if(tipo.equalsIgnoreCase("Pagar cuota")||tipo.equals("Pagar cuota extraordinaria")){
				prepStmt=conexion.prepareStatement("UPDATE CREDITO  SET CANTIDADDINERO = CANTIDADDINERO-"+cant+"WHERE CODIGO='"+codcred+"'");
				ResultSet rs = prepStmt.executeQuery();
			}
			if(tipo.equalsIgnoreCase("Rechazar")){
				prepStmt=conexion.prepareStatement("UPDATE CUENTA  SET CANTIDADDINERO = 0 WHERE CODIGO='"+codcred+"'");
				ResultSet rs = prepStmt.executeQuery();
			}
			if(tipo.equalsIgnoreCase("Cerrar")){
				prepStmt=conexion.prepareStatement("UPDATE CUENTA  SET CANTIDADDINERO = 0 WHERE CODIGO='"+codcred+"'");
				ResultSet rs = prepStmt.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String darUsuario(int usu){
		try {
			establecerConexion();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PreparedStatement prepStmt = null;
		try {
			
			String add ="SELECT * FROM (USUARIO U INNER JOIN CUENTA C ON U.ID=C.IDCLIENTE INNER JOIN CREDITO D ON U.ID=D.IDCLIENTE)WHERE ID="+usu;
			prepStmt=conexion.prepareStatement(add);
			ResultSet rs = prepStmt.executeQuery();
			String id = "";
			String clave ="";
			String edad = "";
			String tipo = "";
			String nombre = "";
			String num = "";
			String cantidadD = "";
			String tipo1 = "";
			String cod = "";
			String cant = "";
			String interes = "";
			String tipo2 = "";
			while(rs.next()){
			id = rs.getString("ID");
			clave = rs.getString("CLAVE");
			edad = rs.getString("EDAD");
			 tipo = rs.getString("TIPO");
			nombre = rs.getString("NOMBRE");
			num = rs.getString("NUMERO");
			cantidadD = rs.getString("CANTIDADDINERO");
			 cod = rs.getString("CODIGO");
			interes = rs.getString("INTERES");
			}
			
			return "ID: "+id+"\n CLAVE: "+clave+"\nEDAD: "+edad+"\nTIPO: "+tipo+"\nNOMBRE: "+nombre+"\nNUMERO: "+num+"\nCANTIDAD DE DINERO "+cantidadD+" "+tipo1+"\nCODIGO: "+cod+"\nCANT: "+cant+"\nINTERES "+interes+" "+tipo2;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "esto!";
	}
	public ArrayList<Cuenta> darCuentas(String tipo){
		try {
			inicializar();
			establecerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Cuenta>res=new ArrayList<>();
		PreparedStatement prepStmt = null;
		String add="SELECT * FROM CUENTA WHERE TIPO='"+tipo+"'";
		ResultSet rs=null;
		

		try {
			Statement st = conexion.createStatement( );
			ResultSet resultado = st.executeQuery( add );
			while (resultado.next()){
//				INSERT INTO "ISIS2304131520"."TRANSACCION_CUENTA" (NUM_TRANSACCION, NUM_CUENTA, CANTIDAD, TIPO, FECHA) VALUES ('223232', '5945', '12500', 'RETIRAR', TO_DATE('2015-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'))

				int numtrans=resultado.getInt("NUMERO");
				int numCLI= resultado.getInt("IDCLIENTE");
				int cant= resultado.getInt("CANTIDADDINERO");
				String tip= resultado.getString("TIPO");
				System.out.println(numtrans);
				Cuenta one= new Cuenta(tip, numtrans+"", cant, 0+"", numCLI);
				res.add(one);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return res;
		
	}
	
	//	public void actualizarUnidadesEnEspera(int unidadesFinales,String producto) throws SQLException 
//	{
//		String sql = "UPDATE PRODUCTO SET UNIDADES_ESPERA = "+ unidadesFinales+" WHERE NOMBRE_PRODUCTO = '"+producto+ "'";
//
//		inicializar();
//		establecerConexion();
		
//	}


}
