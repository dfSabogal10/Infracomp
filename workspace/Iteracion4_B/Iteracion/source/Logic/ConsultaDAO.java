package Logic;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vos.EmpleadoValue;
import vos.UsuarioValue;

public class ConsultaDAO {
	
	
	
	private static Connection con;
		
		private String usuario;
		
		private String clave;
		
		private static final String ACTIVA ="activa";
		
		private static final String PRESTAMO ="prestamo";
		
		private static final String RETIRO = "retiro";
		
		private static final String TRANSFERENCIA ="transferencia";
		
		private static final String ABIERTO ="abierto";
		
		private static final String CERRADA ="cerrada";
		
		
		
		
		
		public ConsultaDAO() {
			
		}
		
		public void conexionBancAndes()
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = null;
			try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod","ISIS2304321520","PRuvpD2dTrxd");
			}
			catch (SQLException i)
			{
			i.printStackTrace();
			}
			}
		
		private void establecerCon (String url, String usuario, String clave) throws SQLException
	    {
	    	try
	        {
				con = DriverManager.getConnection(url,usuario,clave);
	        }
	        catch( SQLException exception )
	        {
	            throw new SQLException( "ERROR" );
	        }
	    }
		
		public void closeCon () throws Exception
		{
			if (con != null)
			{
				try{ 
				con.close();
				con = null;
				}catch (SQLException exception) {
					throw new Exception("ERROR");
				}
			}
		}
		
		public void closeConnection(Connection connection) throws Exception {        
			try {
				connection.close();
				connection = null;
			} catch (SQLException exception) {
				throw new Exception("ERROR");
			}
	    } 
		
		
		public void agregarUsuario(String email,String nombre, String direccion,String telefono, double cedula,String nacionalidad, String ciudad, String departamento,int codigoP, String rol) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into USUARIO values('"+email+"','"+nombre+"','"+direccion+"','"+telefono+"','"+cedula+"','"+nacionalidad+"','"+ciudad+"','"+departamento+"','"+codigoP+"','"+rol+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarOficina(double P_ID,String NOMBRE,String DIRECCION,String TELEFONO, double IDPUNTO) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into oficina values('"+P_ID+"','"+NOMBRE+"','"+DIRECCION+"','"+TELEFONO+"','"+IDPUNTO+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarPuntoA(double P_ID,String TIPO,String UBICACION) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into PUNTODEATENCION values('"+P_ID+"','"+TIPO+"','"+UBICACION+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void agregarCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into cuenta values('"+P_ID+"','"+BALANCE+"','"+SALDO+"','"+LIMITERETIRO+"','"+TIPOCUENTA+"','"+IDOPERACION+"','"+IDMONEDA+"','"+CLIENTE+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void updateCuenta(double P_ID,double BALANCE,double SALDO,double LIMITERETIRO,String TIPOCUENTA,double IDOPERACION,double IDMONEDA,String CLIENTE) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update cuenta set balance = '"+BALANCE+"', SALDO = '"+SALDO+"', LIMITERETIRO = '"+LIMITERETIRO+"',TIPOCUENTA = '"+TIPOCUENTA+"',IDOPERACION = '"+IDOPERACION+"', IDMONEDA = '"+IDMONEDA+"' ,CLIENTE = '"+CLIENTE+"' where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void agregarOperacion(double P_ID,int CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA, double idCuenta) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into operacion values('"+P_ID+"','"+CANTIDAD+"','"+BALANCEACTUAL+"','"+FECHA+"','"+ESTADO+"','"+HORA+"','"+idCuenta+"')";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		public void cerrarCuenta(double P_ID) throws SQLException
		{
			
			String cerrada = "CERRADA";
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update cuenta set TIPOCUENTA = '"+cerrada+"'where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void agregarPrestamo(double P_ID, double INTERES, double MONTO,String TIPOPRESTAMO, int NUMEROCUOTAS,int DIADEPAGO, double VALORCUOTA, String ESTADO) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "insert into prestamo values('"+P_ID+"','"+INTERES+"','"+MONTO+"','"+TIPOPRESTAMO+"','"+NUMEROCUOTAS+"','"+DIADEPAGO+"','"+VALORCUOTA+"','"+ESTADO+"',)";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		public void updateOperacion(double P_ID,double CANTIDAD,double BALANCEACTUAL,Date FECHA,String ESTADO,String HORA) throws SQLException
		{
			
			
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update operacion set cantidad = '"+CANTIDAD+"', balanceactual = '"+BALANCEACTUAL+"', fecha = '"+FECHA+"',estado = '"+ESTADO+"',hora = '"+HORA+"' where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		public void cerrarPrestamo(double P_ID) throws SQLException
		{
			
			String cerrado = "CERRADO";
			
			conexionBancAndes();
			
			Statement stm = null;
			
			stm = con.createStatement();
			
			
			
			String q = "update prestamo set ESTADO = '"+cerrado+"'where p_id = '"+P_ID+"'";
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					con.commit();
					stm.close();
					}
				
				
			}
				
				
			}
		
		
		
		
		
		public ArrayList consultarCuenta(String select,String filtro, String dato, String ordenamiento) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select '"+select+"' from cuenta where  '"+filtro+"' =  '"+dato+"' group by '"+select+"' order by '"+ordenamiento+"'" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		public ArrayList consultarCliente(String select,String filtro, String dato, String ordenamiento) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select '"+select+"' from cliente where  '"+filtro+"' =  '"+dato+"' group by '"+select+"' order by '"+ordenamiento+"'" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		public ArrayList consultarClientes() throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from cliente" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
			
			
		
		public ArrayList consultarCuentas() throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from cuenta" ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	int count = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				for (int i = 1; i < count ; i++)
				{
				
					 String row  = rs.getString(i);
					 String r = rs.getMetaData().getColumnName(i);
					 
					 respuesta.add(r);
					 respuesta.add(row);
					 
				}
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		
		
		public ArrayList BuscarUsuario(String rol) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from usuario where P_ID = '"+rol+"' " ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
			
			while(rs.next())
			{
			
				UsuarioValue nuevo = new UsuarioValue();
				nuevo.setEmail(rs.getString(0));
				nuevo.setNombre(rs.getString(1));
				nuevo.setDireccion(rs.getString(2));
				nuevo.setTelefono(rs.getString(3));
				nuevo.setCedula(rs.getDouble(4));
				nuevo.setNacionalidad(rs.getString(5));
				nuevo.setCiudad(rs.getString(6));
				nuevo.setDepartamento(rs.getString(7));
				nuevo.setCodigoPostal(rs.getString(8));
				nuevo.setRol(rs.getString(9));
				
				
				respuesta.add(nuevo);
				
				
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
		
		
		public ArrayList BuscarEmpleado(String rol) throws SQLException
		{
			
			conexionBancAndes();
			
			Statement stm = null;
			
			ArrayList respuesta = new ArrayList();
			
			stm = con.createStatement();
			
			
			
			String q = "select * from empleado where idusuario = '"+rol+"' " ;
			try
			{
			
			ResultSet rs = stm.executeQuery(q);
			
	
			
			while(rs.next())
			{
			
				EmpleadoValue nuevo = new EmpleadoValue();
				nuevo.setIdEmpleado(rs.getDouble(0));
				nuevo.setLogin(rs.getString(1));
				nuevo.setPassword(rs.getString(2));
				nuevo.setCargo(rs.getString(3));
				nuevo.setIdoficina(rs.getDouble(4));
				nuevo.setIdusuario(rs.getDouble(5));
				
				
				respuesta.add(nuevo);
				
				
			}
				
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				if (stm != null) {
					stm.close();
					}
				
				
			}
			
			return respuesta;
			}
		
	public void registrarOperacionCuenta(int idCuenta, int idEmpleado, int idPuesto,int idOperacion,int cantidad, int idCliente, String fecha,String hora,String tipoOp) throws Exception
	{
		
		
		
	        PreparedStatement activaStmt = null;
			PreparedStatement opStmt = null;
			PreparedStatement repStmt = null;
			
			
			
			try{
	            conexionBancAndes();
				con.setAutoCommit(false);
				con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
				
				String queryActiva = "select estado from cuenta where P_ID = '"+idCuenta+"'";
				String queryOperacion = "insert into operacion values ('"+idOperacion+"','"+cantidad+"','"+fecha+"','"+ACTIVA+"','"+hora+"','"+idCuenta+"','"+idEmpleado+"','"+tipoOp+"','"+idCliente+"')";
				String queryRealiza = "insert into realizaop values ('"+idOperacion+"','"+idPuesto+"');";
				activaStmt = con.prepareStatement(queryActiva);
				
				ResultSet rs = activaStmt.executeQuery();
				if(rs.getString(0).equals(ACTIVA)){
					
					opStmt = con.prepareStatement(queryOperacion);
					opStmt.executeQuery();
					
					repStmt = con.prepareStatement(queryRealiza);
					repStmt.executeQuery();
				}	
				else{
					throw new Exception("La cuenta no se encuantra activa, revisar el estado de cuenta");
				}
                con.commit();
			}
			catch (SQLException e){
				con.rollback();
				e.printStackTrace();
				throw new Exception("ERROR:  ejecutando el statement");
			}
			finally{
				if (activaStmt != null){
					try{
						activaStmt.close();
					} 
					catch (SQLException exception){
						throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
					}
				}
				if (opStmt != null){
					try{
						opStmt.close();
					} 
					catch (SQLException exception){
						throw new Exception("ERROR: cerrando una conexion.");
					}
				}
				
				}
			
			if (repStmt != null){
				try{
					repStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: cerrando una conexion.");
				}
			}
			
			
				con.setAutoCommit(true);
				closeConnection(con);
			}
			
	
	public void registrarOperacionPrestamo(int idCuenta, int idEmpleado, int idPuntoAtencion, int idPuesto,int idOperacion,int cantidad, int idCliente, String fecha,String hora, int interes,int idPrestamo, int tipoPrestamo, int cuotas, String diaPago, int valorCuota) throws Exception
	{
		registrarOperacionCuenta(idCuenta, idEmpleado, idPuesto, idOperacion, cantidad, idCliente, fecha, hora,PRESTAMO);
		
		PreparedStatement prestamoStmt = null;
		PreparedStatement prestamoStmt1 = null;
		PreparedStatement prestamoStmt2 = null;
		PreparedStatement prestamoStmt3 = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryPrestamo = "insert into prestamo values ('"+idPrestamo+"','"+interes+"','"+cantidad+"','"+tipoPrestamo+"','"+cuotas+"','"+diaPago+"','"+valorCuota+"','"+ABIERTO+"','"+idCliente+"','"+idOperacion+"')";
			String queryCuenta = "SELECT saldo FROM cuenta FOR UPDATE";
			String guerySaldo = "select saldo from cuenta where p_id = '"+idCuenta+"'";
			
			prestamoStmt = con.prepareStatement(queryPrestamo);
			prestamoStmt.executeQuery();
			
			prestamoStmt2 = con.prepareStatement(guerySaldo);
			ResultSet rs = prestamoStmt2.executeQuery();
			int saldoActual = rs.getInt(0);
			
			int saldoFinal = saldoActual + cantidad;
			
			prestamoStmt1 = con.prepareStatement(queryCuenta);
			prestamoStmt1.executeQuery();
			
			
			
			String gueryUpdate = "UPDATE cuenta SET saldo = '"+saldoFinal+"' WHERE p_id = '"+idCuenta+"'";
			prestamoStmt3 = con.prepareStatement(gueryUpdate);
			prestamoStmt3.executeQuery();
			
			
			
			
			
			
			
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (prestamoStmt != null){
				try{
					prestamoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (prestamoStmt1 != null){
				try{
					prestamoStmt1.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (prestamoStmt2 != null){
				try{
					prestamoStmt2.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (prestamoStmt3 != null){
				try{
					prestamoStmt3.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		}
		
		
		
	
	public void registrarOperacionRetiro(int idCuenta, int idEmpleado, int idPuesto,int idOperacion,int cantidad, int idCliente, String fecha,String hora, int idRetiro) throws Exception
	{
		registrarOperacionCuenta(idCuenta, idEmpleado, idPuesto, idOperacion, cantidad, idCliente, fecha, hora,RETIRO);
		
		PreparedStatement retiroStmt = null;
		PreparedStatement retiroStmt1 = null;
		PreparedStatement retiroStmt2 = null;
		PreparedStatement retiroStmt3 = null;
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryPrestamo = "insert into retiro values ('"+idRetiro+"','"+idOperacion+"')";
			String queryCuenta = "SELECT saldo FROM cuenta FOR UPDATE";
			String guerySaldo = "select saldo from cuenta where p_id = '"+idCuenta+"'";
			
			retiroStmt = con.prepareStatement(queryPrestamo);
			retiroStmt.executeQuery();
			
			retiroStmt2 = con.prepareStatement(guerySaldo);
			ResultSet rs = retiroStmt2.executeQuery();
			

			int saldoActual = rs.getInt(0);
			int saldoFinal = saldoActual - cantidad;
			
			retiroStmt1 = con.prepareStatement(queryCuenta);
			retiroStmt1.executeQuery();
			
			
			
			
			String gueryUpdate = "UPDATE cuenta SET saldo = '"+saldoFinal+"' WHERE p_id = '"+idCuenta+"'";
			retiroStmt3 = con.prepareStatement(gueryUpdate);
			retiroStmt3.executeQuery();
			
			
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (retiroStmt != null){
				try{
					retiroStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (retiroStmt1 != null){
				try{
					retiroStmt1.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (retiroStmt2 != null){
				try{
					retiroStmt2.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (retiroStmt3 != null){
				try{
					retiroStmt3.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		}
	
	
	
	
	public void registrarOperacionTransferencia(int idCuenta, int idEmpleado, int idPuesto,int idOperacion,int cantidad, int idCliente, String fecha,String hora, int idTransferencia, int idCuentaDestino,String nombreDestino) throws Exception
	{
		registrarOperacionCuenta(idCuenta, idEmpleado, idPuesto, idOperacion, cantidad, idCliente, fecha, hora,TRANSFERENCIA);
		
		PreparedStatement transferenciaStmt = null;
		PreparedStatement transferenciaStmt1 = null;
		PreparedStatement transferenciaStmt2 = null;
		PreparedStatement transferenciaStmt3 = null;
		PreparedStatement transferenciaStmt4 = null;
		PreparedStatement transferenciaStmt5 = null;
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryPrestamo = "insert into transferencia values ('"+idTransferencia+"','"+idCuentaDestino+"','"+idOperacion+"','"+nombreDestino+"')";
			String queryCuenta = "SELECT saldo FROM cuenta FOR UPDATE";
			String guerySaldo = "select saldo from cuenta where p_id = '"+idCuenta+"'";
			String guerySaldo2 = "select saldo from cuenta where p_id = '"+idCuentaDestino+"'";
			
			transferenciaStmt = con.prepareStatement(queryPrestamo);
			transferenciaStmt.executeQuery();
			

			transferenciaStmt2 = con.prepareStatement(guerySaldo);
			ResultSet rs = transferenciaStmt2.executeQuery();
			
			int saldoActual = rs.getInt(0);
			int saldoFinal = saldoActual - cantidad;
			
			transferenciaStmt3 = con.prepareStatement(guerySaldo2);
			ResultSet rs2 = transferenciaStmt3.executeQuery();
			
			int saldoActualDestino = rs2.getInt(0);
			int saldoFinalDestino = saldoActualDestino + cantidad;
			
			transferenciaStmt1 = con.prepareStatement(queryCuenta);
			transferenciaStmt1.executeQuery();
			
			
			String gueryUpdate = "UPDATE cuenta SET saldo = '"+saldoFinal+"' WHERE p_id = '"+idCuenta+"'";
			transferenciaStmt4 = con.prepareStatement(gueryUpdate);
			transferenciaStmt4.executeQuery();
			
			String gueryUpdate2 = "UPDATE cuenta SET saldo = '"+saldoFinalDestino+"' WHERE p_id = '"+idCuentaDestino+"'";
			transferenciaStmt5 = con.prepareStatement(gueryUpdate2);
			transferenciaStmt5.executeQuery();
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (transferenciaStmt != null){
				try{
					transferenciaStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (transferenciaStmt1 != null){
				try{
					transferenciaStmt1.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			if (transferenciaStmt2 != null){
				try{
					transferenciaStmt2.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			if (transferenciaStmt3 != null){
				try{
					transferenciaStmt3.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			if (transferenciaStmt4 != null){
				try{
					transferenciaStmt4.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			if (transferenciaStmt5 != null){
				try{
					transferenciaStmt5.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		}
	
	
	
	public void insertarClienteCorporativo(int id, int idCliente, int idEmpleado,int idCuenta, int idBanco) throws Exception
	{
		
		PreparedStatement insertStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryInsert = "insert into clientecorp values ('"+id+"','"+idCliente+"','"+idEmpleado+"','"+idCuenta+"','"+idBanco+"')";
			
			
			insertStmt = con.prepareStatement(queryInsert);
			insertStmt.executeQuery();
			
			
			
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (insertStmt != null){
				try{
					insertStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
	}
	
	
	
	public void insertarCuentaPago(int id, int idEmpleado,String frecuencia, int saldo) throws Exception
	{
		
		PreparedStatement insertStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryInsert = "insert into cuentaspago values ('"+id+"','"+idEmpleado+"','"+frecuencia+"','"+saldo+"')";
			
			
			insertStmt = con.prepareStatement(queryInsert);
			insertStmt.executeQuery();
			
			
			
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (insertStmt != null){
				try{
					insertStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
	}
	
	
	public void pagarEmpleado(int idEmpleado,int idCuenta, int idPuesto, int idOperacion,int idCliente, String fecha, String hora, int idTransferencia, String nombre) throws Exception
	{
		
		PreparedStatement montoStmt = null;
		PreparedStatement cuentaStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryMonto = "select saldo from cuentaspago where idempleado = '"+idEmpleado+"'";
			String queryCuenta = "select p_id from cuentaspago where idempleado = '"+idEmpleado+"'";
			
			
			
			montoStmt = con.prepareStatement(queryMonto);
			ResultSet rs = montoStmt.executeQuery();
			
			int cantidadPago = rs.getInt(0);
			

			cuentaStmt = con.prepareStatement(queryCuenta);
			ResultSet rs2 = cuentaStmt.executeQuery();
			
			int cuenta = rs2.getInt(0);
			
			registrarOperacionTransferencia(idCuenta, idEmpleado, idPuesto, idOperacion, cantidadPago, idCliente, fecha, hora, idTransferencia,cuenta,nombre);
			
			
			
			
            con.commit();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (montoStmt != null){
				try{
					montoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (cuentaStmt != null){
				try{
					cuentaStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
	
		
	}
	
	
	public void pagarEmpleados(String fecha, String hora) throws Exception
	{
		PreparedStatement pagoStmt = null;
		
		int idOperacion = 100;
		
		int idTransferencia = 100;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryPago = "select * from EMPLEADO e inner join CUENTASPAGO l on e.P_ID = l.idempleado inner join usuario u on e.IDUSUARIO = u.P_CEDULA inner join clientecorp r on r.IDEMPLEADO = e.P_ID";
			
			
			
			pagoStmt = con.prepareStatement(queryPago);
			ResultSet rs = pagoStmt.executeQuery();
			
			while(rs.next())
			{
			
				
			int idEmpleado = rs.getInt(0);	
			int idCuenta = rs.getInt(23);
			int idPuesto = rs.getInt(4);
		    int idCliente = rs.getInt(21);
			String nombre = rs.getString(10);
				
				
				
		pagarEmpleado(idEmpleado, idCuenta, idPuesto, idOperacion, idCliente, fecha, hora, idTransferencia, nombre);
		
		
		
		
				
		idOperacion ++;
		idTransferencia++;
		
			}
			
			
			
			
            con.commit();
            con.setSavepoint();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (pagoStmt != null){
				try{
					pagoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		}
	
	public void cancelarCuenta(int idCuenta) throws Exception
	{
		
		int saldoCancelado = 0;
		
		PreparedStatement estadoStmt = null;
		PreparedStatement saldoStmt = null;
		PreparedStatement upEstadoStmt = null;
		PreparedStatement upSaldoStmt = null;
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryEstado = "SELECT estado FROM cuenta FOR UPDATE";
			String querySaldo = "SELECT saldo FROM cuenta FOR UPDATE";
			String queryUpSaldo = "UPDATE cuenta SET saldo = '"+saldoCancelado+"' WHERE p_id = '"+idCuenta+"'";
			String queryUpEstado = "UPDATE cuenta SET estado = '"+CERRADA+"' WHERE p_id = '"+idCuenta+"'";
			
			estadoStmt = con.prepareStatement(queryEstado);
			estadoStmt.executeQuery();
			
			saldoStmt = con.prepareStatement(querySaldo);
			saldoStmt.executeQuery();
			
			upEstadoStmt = con.prepareStatement(queryUpSaldo);
			upEstadoStmt.executeQuery();
			
			upSaldoStmt = con.prepareStatement(queryUpEstado);
			upSaldoStmt.executeQuery();
			
			con.commit();
			con.setSavepoint();
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (estadoStmt != null){
				try{
					estadoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (saldoStmt != null){
				try{
					saldoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (upEstadoStmt != null){
				try{
					upEstadoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			if (upSaldoStmt != null){
				try{
					upSaldoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
		
		
		
	}
	
	
	public ArrayList consultarOperaciones(String criterio, String fecha, String valor , String operador) throws Exception
	{
		
		ArrayList respuesta = new ArrayList();
		
		PreparedStatement estadoStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryEstado = "SELECT * FROM operacion WHERE '"+criterio+"' = '"+valor+"' and fecha'"+operador+"''"+fecha+"'";
			
			
			estadoStmt = con.prepareStatement(queryEstado);
			ResultSet rs = estadoStmt.executeQuery();
			
			int count = rs.getMetaData().getColumnCount();
					
					while(rs.next())
					{
						for (int i = 1; i < count ; i++)
						{
						
							 String row  = rs.getString(i);
							 String r = rs.getMetaData().getColumnName(i);
							 
							 respuesta.add(r);
							 respuesta.add(row);
							 
						}
					}
			
			
			
			con.commit();
			
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (estadoStmt != null){
				try{
					estadoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
		
		return respuesta;
		
	}
	
	
	
	public ArrayList consultarOperacionesNo(String criterio, String fecha, String valor , String operador) throws Exception
	{
		
		ArrayList respuesta = new ArrayList();
		
		PreparedStatement estadoStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryEstado = "SELECT * FROM operacion WHERE '"+criterio+"' <> '"+valor+"' and fecha'"+operador+"''"+fecha+"'";
			
			
			estadoStmt = con.prepareStatement(queryEstado);
			ResultSet rs = estadoStmt.executeQuery();
			
			int count = rs.getMetaData().getColumnCount();
					
					while(rs.next())
					{
						for (int i = 1; i < count ; i++)
						{
						
							 String row  = rs.getString(i);
							 String r = rs.getMetaData().getColumnName(i);
							 
							 respuesta.add(r);
							 respuesta.add(row);
							 
						}
					}
			
			
			
			con.commit();
			
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (estadoStmt != null){
				try{
					estadoStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
		
		return respuesta;
		
	}
	
	
	
	public ArrayList consultarConsignaciones(String x, String y) throws Exception
	{
		
		ArrayList respuesta = new ArrayList();
		
		PreparedStatement conStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryEstado = "select * from operacion where CANTIDAD > '"+x+"' and TIPOOPERACION = '"+y+"'";
			
			
			conStmt = con.prepareStatement(queryEstado);
			ResultSet rs = conStmt.executeQuery();
			
			int count = rs.getMetaData().getColumnCount();
					
					while(rs.next())
					{
						for (int i = 1; i < count ; i++)
						{
						
							 String row  = rs.getString(i);
							 String r = rs.getMetaData().getColumnName(i);
							 
							 respuesta.add(r);
							 respuesta.add(row);
							 
						}
					}
			
			
			
			con.commit();
			
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (conStmt != null){
				try{
					conStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
		
		return respuesta;
		
	}
	
	
	
	public ArrayList consultarPunto(int one, int two) throws Exception
	{
		
		ArrayList respuesta = new ArrayList();
		
		PreparedStatement conStmt = null;
		
		
		try{
            conexionBancAndes();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			String queryEstado = "select o.*,l.* from realizaop p inner join operacion o on p.IDOPERACION = o.P_ID inner join cuenta c on o.IDCUENTA = c.P_ID inner join cliente l on c.P_ID = l.IDCUENTA where p.IDPUESTO = '"+one+"' union select o.*,l.* from realizaop p inner join operacion o on p.IDOPERACION = o.P_ID inner join cuenta c on o.IDCUENTA = c.P_ID inner join cliente l on c.P_ID = l.IDCUENTA where p.IDPUESTO = '"+two+"'";

			
			
			conStmt = con.prepareStatement(queryEstado);
			ResultSet rs = conStmt.executeQuery();
			
			int count = rs.getMetaData().getColumnCount();
					
					while(rs.next())
					{
						for (int i = 1; i < count ; i++)
						{
						
							 String row  = rs.getString(i);
							 String r = rs.getMetaData().getColumnName(i);
							 
							 respuesta.add(r);
							 respuesta.add(row);
							 
						}
					}
			
			
			
			con.commit();
			
		}
		catch (SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("ERROR:  ejecutando el statement");
		}
		finally{
			if (conStmt != null){
				try{
					conStmt.close();
				} 
				catch (SQLException exception){
					throw new Exception("ERROR: ConsultaDAO:   cerrando una conexion.");
				}
			}
			
			
			
			con.setAutoCommit(true);
			closeConnection(con);
		}
		
		
		return respuesta;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		public static void main(String[] args) throws Exception {
			
			ConsultaDAO nueva = new ConsultaDAO();
			
			
			
			
			
			nueva.cancelarCuenta(25);
			
		}
		
		}
