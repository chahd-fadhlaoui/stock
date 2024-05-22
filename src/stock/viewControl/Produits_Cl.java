package stock.viewControl;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import stock.Model.ModelProduit;
import stock.control.ProduitControl;

public class Produits_Cl  implements Initializable{
	  @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtQt;

	    @FXML
	    private TextField txtPrix;

	    @FXML
	    private ComboBox Type;

	    @FXML
	    private TextField txtDiscnt;

	    @FXML
	    private Button btnAdd;

	    @FXML
	    private Button btnUpdate;

	    @FXML
	    private Button btnDelete;

	    @FXML
	    private TableView table;

	    @FXML
	    private TableColumn id;

	    @FXML
	    private TableColumn name;

	    @FXML
	    private TableColumn number;

	    @FXML
	    private TableColumn price;

	    @FXML
	    private TableColumn  type;

	    @FXML
	    private TableColumn  discount;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private TextField txtSearch;
    
    
	ProduitControl   prod=  new ProduitControl();
	
	String typeValue[]= {"minimal","maximal"};
	int Id;
	
    ObservableList<String> obtype=FXCollections.observableArrayList(typeValue);
    
    public void recherche() {
    	table.setItems(prod.getprodsByName(txtSearch.getText()));
    }
    public void addP(Event e ) {
    	ModelProduit mp=new ModelProduit();
    		mp.setName(txtName.getText());
    		mp.setNumber(Integer.parseInt(txtQt.getText()));
    		mp.setPrice(Double.parseDouble(txtPrix.getText()));
    		mp.setDiscount(Integer.parseInt(txtDiscnt.getText()));
    		mp.setType(Type.getValue()+"");
    		
    		prod.insert(mp);
    		table.setItems(prod.getAllprods());

    		txtName.setText("");
    		txtQt.setText("");
    		txtPrix.setText("");
    		txtDiscnt.setText("");

    }
    
    public void updateP(Event e ) {
    	ModelProduit mp=new ModelProduit();
    	mp.setId(Id);
		mp.setName(txtName.getText());
		mp.setNumber(Integer.parseInt(txtQt.getText()));
		mp.setPrice(Double.parseDouble(txtPrix.getText()));
		mp.setDiscount(Integer.parseInt(txtDiscnt.getText()));
		mp.setType(Type.getValue()+"");
		
		prod.update(mp);
		
		table.setItems(prod.getAllprods());

		
		txtName.setText("");
		txtQt.setText("");
		txtPrix.setText("");
		txtDiscnt.setText("");
    }
    
    public void deleteP(Event e ) {
    	prod.delete(Id);
    	
    	 table.setItems(prod.getAllprods());
    	txtName.setText("");
		txtQt.setText("");
		txtPrix.setText("");
		txtDiscnt.setText("");
    	
    }
    public void ClickTable(Event e) {
        ModelProduit mp = (ModelProduit) table.getSelectionModel().getSelectedItem();
        if (mp != null) {
            txtName.setText(mp.getName());
            txtQt.setText(String.valueOf(mp.getNumber()));
            txtPrix.setText(String.valueOf(mp.getPrice()));
            txtDiscnt.setText(String.valueOf(mp.getDiscount()));
            Type.setValue(mp.getType());
            Id = mp.getId();
        }
    }

    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Type.getItems().addAll(obtype);
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		number.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		
		table.setItems(prod.getAllprods());

	}
    
}
