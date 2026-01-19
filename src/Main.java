import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Inventory inventory = new Inventory();
        inventory.add(new Phone(2, 300000, "Iphone11", "iOS", 256));
        inventory.add(new Phone(3, 250000, "Samsung", "Android", 128));

        System.out.println("Search ID 2: " + inventory.searchById(2));
        System.out.println("Filter brand Samsung: " + inventory.filterByBrand("Samsung"));

        inventory.sortByPriceAscending();
        System.out.println("Sorted Ascending: " + inventory.getAll());
        {
            String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(connectionUrl, "postgres", "password");

                        stmt = con.createStatement();

                rs = stmt.executeQuery("select * from Customers");
                while (rs.next()) { // Processing the result
                    System.out.println(rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getString("last name"));
                }

            }
            catch(Exception e) {
                System.out.println("Exception occured!");
            }finally {
                    try { // Close connection - clean up the system resources
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Exception occurred!");
                    }
                }

                System.out.println("Finished!");
            }
        }
    }

