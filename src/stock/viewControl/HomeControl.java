package stock.viewControl;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeControl {

    @FXML
    private Button btnP;

    @FXML
    private Button btnS;

    @FXML
    private Button btnE;

    @FXML
    private Button btnSt;
    
    public void openProduct(Event e) throws IOException {
    	Node node=(Node) e.getSource();
		Stage stage =(Stage) node.getScene().getWindow();
		//stage.close();
		Parent root=FXMLLoader.load(getClass().getResource("/stock/view/Produits.fxml"));
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }
    public void openService(Event e) throws IOException {
    	Node node=(Node) e.getSource();
		Stage stage =(Stage) node.getScene().getWindow();
		//stage.close();
		Parent root=FXMLLoader.load(getClass().getResource("/stock/view/Produits.fxml"));
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }
    public void openEmploye(Event e) throws IOException {
    	Node node=(Node) e.getSource();
		Stage stage =(Stage) node.getScene().getWindow();
		//stage.close();
		Parent root=FXMLLoader.load(getClass().getResource("/stock/view/Produits.fxml"));
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }
    public void openStatistic(Event e) throws IOException {
    	Node node=(Node) e.getSource();
		Stage stage =(Stage) node.getScene().getWindow();
		//stage.close();
		Parent root=FXMLLoader.load(getClass().getResource("/stock/view/Produits.fxml"));
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }




}
