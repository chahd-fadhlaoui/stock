package stock.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import stock.Model.Admin;

public class LoginControl{
	Statement st;
	public boolean isLogin(Admin ad) throws SQLException {
	    try (Statement st = ConnectionDB.openConnection().createStatement()) {
	        ResultSet res = st.executeQuery("SELECT * FROM admins WHERE username='" + ad.getUsername() + "' AND password = '" + ad.getPassword() + "'");
	        return res.next();
	    }
	}

}
