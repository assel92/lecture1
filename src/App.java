import controllers.CustomerControllers;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    private final CustomerControllers customerControllers;
    private final Scanner sc;
    public App(CustomerControllers customerControllers) {
        this.customerControllers = customerControllers;
        sc = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Application");
            System.out.println("Select option:");
            System.out.println("1. Get all customers");
            System.out.println("2. Get customer by id");
            System.out.println("3. Create customer");
            System.out.println("4. Delete customer");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (0-4): ");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllCustomersMenu();
                } else if (option == 2) {
                    getCustomerByIdMenu();
                } else if (option == 3) {
                    createCustomerMenu();
                } else if (option == 4) {
                    deleteCustomerMenu();
                }
                else
                {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                sc.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("                   ");
        }
    }
    public void getAllCustomersMenu() {
        String r = customerControllers.getAllCustomers();
        System.out.println(r);
    }
    public void getCustomerByIdMenu(){
        System.out.println("Enter Customer ID");
        int id = sc.nextInt();
        String r = customerControllers.getCustomer(id);
        System.out.println(r);
    }
    public void createCustomerMenu(){
        System.out.println("Enter Customer's ID");
        int id = sc.nextInt();
        System.out.println("Enter Customer's Name");
        String name = sc.next();
        System.out.println("Enter Customer's Last name");
        String lastName = sc.next();
        System.out.println("Enter Customer's email");
        String email = sc.next();
        String r = customerControllers.createCustomer(id, name, lastName, email);
        System.out.println(r);
    }
    public void deleteCustomerMenu(){
        System.out.println("Enter Customer's ID");
        int id = sc.nextInt();
        String r = customerControllers.deleteCustomer(id);
        System.out.println(r);
    }
}
