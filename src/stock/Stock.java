package stock;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Stock extends Application {
	@Override
	public void start(Stage stage) throws IOException{
		 try {
		        Parent root = FXMLLoader.load(getClass().getResource("/stock/view/LoginForm.fxml"));
		        Scene scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
