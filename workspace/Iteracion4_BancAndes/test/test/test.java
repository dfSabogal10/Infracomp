package test;


import co.edu.uniandes.iteracion2.dao.ConsultaDAOMio;
import junit.framework.TestCase;

public class test  extends TestCase {
	ConsultaDAOMio x=null;
	public void setupEscenario1()
	{
		x = new ConsultaDAOMio();
		x.inicializar();
		
	}
	/*
	 * Se agrega un usuario que no es factible por que no cumple con la condicion de la PK de usuarios
	 * 	
	 */
	public void testAgregarUsuarioRepetidoID()
	{
		setupEscenario1();
		String asd = ("INSERT INTO USUARIO (ID, CLAVE , EDAD, TIPO, NOMBRE) VALUES(123456,9999,40,'PAILA')");
		String bien = "";
		try
		{
			x.registrarUsuario(123456, 9999, "pAOLA", 0, "U", "");
		}
		catch (Exception e)
		{
			bien = e.getMessage();
			// TODO: handle exception
		}
		assert ( "ORA-00001: restricción única (ISIS2304131520.PK_USUARIO) violada".equals(	bien) );

	}
	public void testAgregarCuentaSinFK()
	{
		setupEscenario1();
		String asd = ("INSERT INTO CUENTA (NUMERO, CANTIDADDINERO, IDCLIENTE,TIPO) VALUES(9777,99000,996677,'CDT')");
		String bien = "";
		try
		{
			x.registrarCuenta(556665, 3343543, 100000, "CDT");
		}
		catch (Exception e)
		{
			bien = e.getMessage();
			// TODO: handle exception
		}
		assertTrue(!"ORA-02291: restricción de integridad (ISIS2304131520.FK_CUENTA) violada - clave principal no encontrada".equals(	bien) );

	}
	public void testAgregarCuentaCK()
	{
		setupEscenario1();

		String papitas =("INSERT INTO EMPRESA (ID, INGRESOS_MENSUALES, INGRESOS_ANUALES, DEUDAS_) VALUES (1233, -20123, 1010, 123)");
		// TODO: handle exception
		try
		{
			x.registrarCuenta(5657, 123456, 230000, "papa");
		}
		catch (Exception e)
		{
			String bien = e.getMessage();
			assertNotNull(bien);


		}
	}

}
