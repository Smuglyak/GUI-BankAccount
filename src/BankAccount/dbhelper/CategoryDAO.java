package BankAccount.dbhelper;

import BankAccount.model.ProductModel;
import BankAccount.model.CategoryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public CategoryModel getCategory(int id) {
        String sql = "SELECT C.id as categoryID, C.label AS categorylabel, "
                + " P.id, P.price, P.label FROM category C LEFT JOIN product P "
                + " ON C.id=P.categoryId WHERE C.id=?";
        try {
            Connection con = ConnectionGenerator.getConnection();
            PreparedStatement stm
                    = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            CategoryModel category = null;
            while (rs.next()) {
                if (category == null) {
                    category = new CategoryModel(rs);
                }
                int i = rs.getInt("id");
                if(!rs.wasNull()) {
                    category.addProduct(new ProductModel(rs));
                }
            }
            return category;
        } catch (Exception e) {
            System.out.println("Error Connecting to the DB [" + e.getMessage() + "]");
        }
        return null;

    }

    public static boolean saveOrUpdate(CategoryModel category) {
        if (category == null) {
            return false;
        }

        try {
            Connection con = ConnectionGenerator.getConnection();
            PreparedStatement stm
                    = con.prepareStatement("INSERT INTO category (id, label) VALUES (?, ?) "
                            + " ON CONFLICT (id) DO UPDATE SET label=?");
            stm.setInt(1, category.getId());
            stm.setString(2, category.getLabel());
            stm.setString(3, category.getLabel());
            stm.executeUpdate();            
            category.getProducts().forEach(p -> ProductDAO.saveOrUpdate(p));
            return true;

        } catch (Exception e) {
            System.out.println("Error Connecting to the DB [" + e.getMessage() + "]");
        }
        return false;

    }

    public static List<CategoryModel> getAll() {
        List<CategoryModel> result = new ArrayList<>();
        String sql = "SELECT C.id as categoryID, C.label AS categorylabel, "
                + " P.id, P.price, P.label FROM category C LEFT JOIN product P "
                + " ON C.id=P.categoryId ORDER BY 1";
        try {
            Connection con = ConnectionGenerator.getConnection();
            PreparedStatement stm
                    = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            CategoryModel category = null;
            int prevCategoryId = -1;
            while (rs.next()) {
                if (rs.getInt("categoryId") != prevCategoryId) {
                    category = new CategoryModel(rs);
                    result.add(category);
                    prevCategoryId = category.getId();
                }
                int i = rs.getInt("id");
                if(!rs.wasNull()) {
                    category.addProduct(new ProductModel(rs));
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Error Connecting to the DB [" + e.getMessage() + "]");
        }
        return null;

    }

}
