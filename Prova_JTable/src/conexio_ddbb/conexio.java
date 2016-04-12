package conexio_ddbb;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class conexio {

	public conexio(){
		registraDriver();
		
	}

	public void registraDriver(){
		//Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Registro exitoso");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		/*Connection con = null;

		//...

		try {

		con = DriverManager.getConnection(

		"jdbc:mysql://localhost/TuBaseDeDatos?"

		+ "user=TuUsuario&password=TuPass");

		// Otros y operaciones sobre la base de datos...

		} catch (SQLException ex) {

		// Mantener el control sobre el tipo de error

		System.out.println("SQLException: " + ex.getMessage());
		}*/
				
	}
}
