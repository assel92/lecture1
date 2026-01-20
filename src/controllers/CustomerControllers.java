package controllers;
import Entites.Customer;
import repositories.interfaces.CustRepos;
import java.util.List;
public class CustomerControllers {
    private final CustRepos repo;
    public CustomerControllers(CustRepos repo){
        this.repo=repo;
    }
    public String createCustomer(int id,String firstName, String lastName, String email){
        Customer customer = new Customer(id,firstName, lastName, email);
        boolean result = repo.createCustomer(customer);
        return (result ? "Customer was created" : "Customer was not created");
    }
    public String getCustomer(int id){
        Customer customer = repo.getCustomer(id);
        return (customer==null ? "Customer was not found" : customer.toString());
    }
    public String getAllCustomers(){
        List<Customer> customers=repo.getAllCustomers();
        return customers.toString();}

    public String deleteCustomer(int id){
        Customer customer = repo.getCustomer(id);
        return (customer==null ? "Customer was not found" : "Customer was deleted");
    }
}
