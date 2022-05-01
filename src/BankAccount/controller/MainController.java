
package BankAccount.controller;

import com.dbhelper.CategoryDAO;
import com.model.CategoryModel;
import java.util.List;

public class MainController {
    List<CategoryModel> categories;
    int index = -1;
    
    public void fetchAll() {
        categories = CategoryDAO.getAll();
    }
    
    public CategoryModel next() {
        if (index<categories.size()-1) {
            index++;
            return categories.get(index);
        }
        return null;
    }    
    
    public boolean hasNext() {
        return index<categories.size()-1;
    }
    
    
}
