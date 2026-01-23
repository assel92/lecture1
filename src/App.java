import controllers.CustomerControllers;
import controllers.PhoneControllers;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    private final CustomerControllers customerControllers;
    private final PhoneControllers phoneControllers;
    private final Scanner sc;
    public App(CustomerControllers customerControllers, PhoneControllers phoneControllers) {
        this.customerControllers = customerControllers;
        this.phoneControllers = phoneControllers;
        sc = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Application");
            System.out.println("Select option:");
            System.out.println("1. Customers table");
            System.out.println("2. Phone table");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (0-2): ");
                int option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Select option:");
                    System.out.println("1.Create customer");
                    System.out.println("2.Get all customers");
                    System.out.println("3.Delete customer");
                    System.out.println("4.Select customer");
                    System.out.println("5.Exit");
                    try {
                        System.out.print("Enter option (1-4): ");
                        int option2 = sc.nextInt();
                        if (option2 == 1) {
                            createCustomerMenu();
                        } else if (option2 == 2) {
                            getAllCustomersMenu();
                        } else if (option2 == 3) {
                            deleteCustomerMenu();
                        } else if (option2 == 4) {
                            getCustomerByIdMenu();
                        } else if (option2 == 5) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("                   ");
                }

                if (option == 2) {
                    System.out.println("Select option:");
                    System.out.println("1.Add phone");
                    System.out.println("2.Get phones");
                    System.out.println("3.Delete phone");
                    System.out.println("4.Select phone");
                    System.out.println("5.Update color");
                    System.out.println("6.Exit");
                    try {
                        System.out.print("Enter option (1-5): ");
                        int option3 = sc.nextInt();
                        if (option3 == 1) {
                            addPhoneMenu();
                        }
                        if (option3 == 2) {
                            getAllPhonesMenu();
                        }
                        if (option3 == 3) {
                            deletePhoneMenu();
                        }
                        if (option3 == 4) {
                            getPhoneMenu();
                        }
                        if (option3 == 5) {
                           updatePhoneColorMenu();
                        }
                        if (option3 == 6) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("                   ");
                } else {
                    break;
                }
            } finally {
                System.out.println("**********************");
            }
        }
    }

        public void getAllCustomersMenu() {
            String r = customerControllers.getAllCustomers();
            System.out.println(r);
        }
        public void getCustomerByIdMenu() {
            System.out.println("Enter Customer ID");
            int id = sc.nextInt();
            String r = customerControllers.getCustomer(id);
            System.out.println(r);
        }
        public void createCustomerMenu() {
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
        public void deleteCustomerMenu() {
            System.out.println("Enter Customer's ID");
            int id = sc.nextInt();
            String r = customerControllers.deleteCustomer(id);
            System.out.println(r);
        }
        public void getAllPhonesMenu() {
            String r = phoneControllers.getAllPhones();
            System.out.println(r);
        }
        public void getPhoneMenu() {
            System.out.println("Enter Phone ID");
            int id = sc.nextInt();
            String r = phoneControllers.getPhone(id);
            System.out.println(r);
        }
        public void addPhoneMenu() {
            System.out.println("Enter Phone's ID");
            int id = sc.nextInt();
            System.out.println("Enter number of phones");
            int number = sc.nextInt();
            System.out.println("Enter price of phones");
            float price = sc.nextFloat();
            System.out.println("Enter brand");
            String brand = sc.next();
            System.out.println("Enter OS");
            String OS = sc.next();
            System.out.println("Enter storage in GB");
            int storage = sc.nextInt();
            System.out.println("Enter color");
            String color = sc.next();
            String r = phoneControllers.addPhone(id, number, price, brand, OS, storage, color);
            System.out.println(r);
        }
        public void deletePhoneMenu() {
            System.out.println("Enter Phone's ID");
            int id = sc.nextInt();
            String r = phoneControllers.deletePhone(id);
            System.out.println(r);
        }
        public void  updatePhoneColorMenu() {
            System.out.println("Enter phone id:");
            int id = sc.nextInt();

            System.out.println("Enter new color:");
            String color = sc.next();
            String r = phoneControllers.updatePhoneColor(id, color);
            System.out.println(r);
        }

    }

