package BankAccount.view;

import BankAccount.controller.MainController;

public class MainView {

    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.fetchAll();
        while(controller.hasNext()) {
            System.out.println(controller.next());
        }
    }
    
}
