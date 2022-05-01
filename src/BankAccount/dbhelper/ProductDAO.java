package BankAccount.dbhelper;

import BankAccount.model.ProductModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
    
    public static ProductModel getProduct(int id) {
        try {
            Connection con = ConnectionGenerator.getConnection();
            PreparedStatement stm  
                    = con.prepareStatement("SELECT id, label, price, categoaryID FROM product WHERE id=?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new ProductModel(rs);
            }
            return null;
        } catch(Exception e) {
            System.out.println("Error Connecting to the DB ["+e.getMessage()+"]");
        }
        return null;
    }
    
    public static boolean saveOrUpdate(ProductModel product) {
        if (product==null) {
            return false;
        }
        try {
            Connection con = ConnectionGenerator.getConnection();
            PreparedStatement stm  
                    = con.prepareStatement("INSERT INTO product (id, label, price, categoryId) VALUES (?, ?, ?, ?) " +
                    " ON CONFLICT (id) DO UPDATE SET label=?, price=?, categoryId=? ");
            stm.setInt(1, product.getId());
            stm.setString(2, product.getLabel());
            stm.setInt(3, product.getPrice());
            stm.setInt(4, product.getCategoryId());
            stm.setString(5, product.getLabel());
            stm.setInt(6, product.getPrice());
            stm.setInt(7, product.getCategoryId());
            stm.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println("Error Connecting to the DB ["+e.getMessage()+"]");
        }
        return false;        
    }
    
}
