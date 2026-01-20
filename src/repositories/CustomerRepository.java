package repositories;
import data.interfaces.IDB;
import Entites.Customer;
import repositories.interfaces.CustRepos;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements CustRepos {
    private final IDB db;

    public CustomerRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO customers(customerid, first_name, last_name, email) VALUES (?,?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, customer.getId());
            st.setString(2, customer.getFirstName());
            st.setString(3, customer.getLastName());
            st.setString(4, customer.getEmail());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Customer getCustomer(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT customers.customerid, first_name, last_name, email FROM customers WHERE customers.customerid=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getInt("customerid"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
                return customer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT customers.customerid, first_name, last_name, email FROM customers";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Customer> customers = new LinkedList<>();
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customerid"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public boolean deleteCustomer(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM customers WHERE customers.customerid=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
             if (rowsAffected == 0){
                 return false;
             }
            return  true;
        } catch(SQLException throwables){
                throwables.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } finally{
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        return false;
        }

    }