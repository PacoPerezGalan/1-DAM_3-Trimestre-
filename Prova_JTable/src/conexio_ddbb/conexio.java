package conexio_ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;


public class conexio {
	
	Connection con = null;
	Object[] dadesBBDD;
	DefaultTableModel dtmBBDD;
	public conexio(DefaultTableModel dtm){
		dtmBBDD=dtm;
		registraDriver();
		
		//...
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=");
		// Otros y operaciones sobre la base de datos...
		} catch (SQLException ex) {
		// Mantener el control sobre el tipo de error
		System.out.println("SQLException: " + ex.getMessage());
		}
		consultarDades();
	}

	public void registraDriver(){
		//Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Registro exitoso");
		} catch (Exception e) {
			System.out.println(e.toString());
		}					
	}
	
	public void consultarDades(){
			

		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT host,user,password FROM user");
			
			dadesBBDD=new Object[]{"Host","User","Password"};
			dtmBBDD.addRow(dadesBBDD);
			while (rs.next()) {

				String host = rs.getString("host");
				String user = rs.getString("user");
				String pass = rs.getString("password");
				dadesBBDD=new Object[]{host,user,pass}; 
				dtmBBDD.addRow(dadesBBDD);
				System.out.println(host + "-" + user + "-" + pass);

				}

				rs.close();
		}catch(Exception e){
		}
	}
	
}
