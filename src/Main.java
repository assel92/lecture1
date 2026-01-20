import controllers.CustomerControllers;
import controllers.PhoneControllers;
import data.PostgreDB;
import repositories.CustomerRepository;
import repositories.PhoneRepository;
import repositories.interfaces.CustRepos;
import data.interfaces.IDB;
import repositories.interfaces.PhRepos;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        IDB db = new PostgreDB();
        CustRepos repo = new CustomerRepository(db);
        CustomerControllers customerControllers = new CustomerControllers(repo);
        PhRepos repos = new PhoneRepository(db);
        PhoneControllers phoneControllers = new PhoneControllers(repos);
        App app = new App(customerControllers, phoneControllers);
        app.start();
    }
}


