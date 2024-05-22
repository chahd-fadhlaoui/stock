package stock.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection con=null;
    
    
    
    public ConnectionDB() {
		
	}



	public static Connection openConnection() throws SQLException {
    	if(con==null) {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Stock","root", "");
         }
             return con;
    }
	
	 public static void closeConnection()
	    {       
	        if(con != null)
	          con = null;
	    }
	
	
	
    }
