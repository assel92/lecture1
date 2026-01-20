import controllers.CustomerControllers;
import data.PostgreDB;
import repositories.CustomerRepository;
import repositories.interfaces.CustRepos;
import data.interfaces.IDB;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        IDB db = new PostgreDB();
        CustRepos repo = new CustomerRepository(db);
        CustomerControllers customerControllers = new CustomerControllers(repo);
        App app = new App(customerControllers);
        app.start();
    }
}


