package BankAccount.model;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoryModel {
    private int id;
    private String label;
    private List<ProductModel> products;
    
    
    public CategoryModel(ResultSet rs) {
        try {
            this.id = rs.getInt("categoryid");
            this.label = rs.getString("categorylabel");
        } catch (SQLException e) {
            System.out.println("Error creating category model [" + e.getMessage() + "]");
        }
        
        products = new ArrayList<>();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProductModel> getProducts() {
        return products;
    }
    
    public void addProduct(ProductModel product) {
        products.add(product);
    }

    @Override
    public String toString() {
        String s = "Categoryid=" + id + ", label=" + label;
        for(ProductModel p: products) {
            s+="\n     "+p.toString();
        }
        return s;
    }
    
    
    

    
}
