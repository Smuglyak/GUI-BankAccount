package BankAccount.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductModel {

    private int id;
    private String label;
    private int price;
    private int categoryId;

    public ProductModel(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.price = rs.getInt("price");
            this.label = rs.getString("label");
            this.categoryId = rs.getInt("categoryId");
        } catch (SQLException e) {
            System.out.println("Error creating product model [" + e.getMessage() + "]");
        }
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Productid=" + id + ", label=" + label + ", price=" + price + ", categoryId=" + categoryId;
    }

}
