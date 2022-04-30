package BankAccount;

public class BankTeller {
    public void addNewClients() {

    }

    public void manageClients() {

    }

    public void createTransactions() {

    }

    public void returnClientReports() {

    }

    public void login(String bakId, String bakPw) {
        try {
            if (bakId != "1111" || bakPw != "1234") {
                System.out.println("No such bank teller in db");
            } else {
                System.out.println("Successful login");

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
