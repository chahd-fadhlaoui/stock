package stock.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import stock.Model.ModelProduit;

public class ProduitControl {
    Statement st;
    public void insert(ModelProduit prod)
    {
    	try {
    		st=ConnectionDB.openConnection().createStatement();
    		st.executeUpdate("INSERT INTO `Produits` ( `name`, `number`, `price`, `type`, `discount`) VALUES ( '"+prod.getName()+"',"+prod.getNumber()+","+prod.getPrice()+",'"+prod.getType()+"',"+prod.getDiscount()+")");
    		ConnectionDB.closeConnection();
    		
    		
    	}
    	catch(SQLException ex){
    		  ConnectionDB.closeConnection();
              Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }
    public void delete(int id)
    {
        try {
            st = ConnectionDB.openConnection().createStatement();
            st.executeUpdate("Delete FROM `Produits` WHERE id = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(ModelProduit prod)
    {
        try {
            st = ConnectionDB.openConnection().createStatement();
            st.executeUpdate("UPDATE Produits set  `name` = "+"'"+prod.getName()+"'"+", `number` = "+prod.getNumber() +", `price` = " + prod.getPrice() +", `type` = "+"'"+prod.getType()+"'"+", `discount` = "+prod.getDiscount()+" WHERE id = "+prod.getId() );
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
    
    // get all prods 
    public ObservableList<ModelProduit>getAllprods()
    {
    		ObservableList produit = FXCollections.observableArrayList();
            try {
				st = ConnectionDB.openConnection().createStatement();
				ResultSet rs=st.executeQuery("SELECT * from Produits");
				while(rs.next()) 
				{
					ModelProduit objprods=new ModelProduit();
					objprods.setId(rs.getInt(1));
					objprods.setName(rs.getString(2));
					objprods.setNumber(rs.getInt(3));
					objprods.setPrice(rs.getDouble(4));
					objprods.setType(rs.getString(5));
					objprods.setDiscount(rs.getInt(6));
					produit.add(objprods);
				}
	            ConnectionDB.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}

    		
    		
    		return produit;
    }
    
    public ObservableList<ModelProduit>getprodsByName(String name)
    {
    		ObservableList produit = FXCollections.observableArrayList();
            try {
				st = ConnectionDB.openConnection().createStatement();
				ResultSet rs=st.executeQuery("SELECT * from Produits WHERE name LIKE '%"+name+"%'");
				while(rs.next()) 
				{
					ModelProduit objprods=new ModelProduit();
					objprods.setId(rs.getInt(1));
					objprods.setName(rs.getString(2));
					objprods.setNumber(rs.getInt(3));
					objprods.setPrice(rs.getDouble(4));
					objprods.setType(rs.getString(5));
					objprods.setDiscount(rs.getInt(6));
					produit.add(objprods);
				}
	            ConnectionDB.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}

    		
    		
    		return produit;
    }
}
