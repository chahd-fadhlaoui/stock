package stock.viewControl;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import stock.Model.Admin;
import stock.control.LoginControl;
public class LoginForm_CL {
	 @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Button button;

	    @FXML
	    private Label errorm;
	    
	    Admin ad=new Admin();
	    LoginControl lg=new LoginControl();
	    
	    public void isSign(Event e) throws SQLException	,IOException{
	    	ad.setUsername(username.getText());
	    	ad.setPassword(password.getText());
	    	if (lg.isLogin(ad))
	    	{
	    		Node node=(Node) e.getSource();
	    		Stage stage =(Stage) node.getScene().getWindow();
	    		//stage.close();
	    		Parent root=FXMLLoader.load(getClass().getResource("/stock/view/Home.fxml"));
	    		Scene scene =new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();
	    		
	    		
	    	}
	    	else 
	    		
	    		errorm.setText("username or password wrong ");
	    	
	    	
	    }

}
