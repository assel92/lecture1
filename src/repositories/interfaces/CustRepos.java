package repositories.interfaces;
import Entites.Customer;
import java.util.List;

public interface CustRepos {
        boolean createCustomer(Customer customer);
        Customer getCustomer(int id);
        List<Customer> getAllCustomers();
        boolean deleteCustomer(int id);
}
