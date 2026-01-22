package repositories;
import data.interfaces.IDB;
import Entites.Phone;
import repositories.interfaces.PhRepos;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PhoneRepository implements PhRepos {
    private final IDB db;

    public PhoneRepository (IDB db) {
        this.db = db;
    }

    @Override
    public boolean addPhone(Phone phone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Phone(id, number, price,brand, OS, storage) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, phone.getId());
            st.setInt(2, phone.getNumber());
            st.setFloat(3, phone.getPrice());
            st.setString(4, phone.getBrand());
            st.setString(5, phone.getOS());
            st.setInt(6, phone.getStorage());
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
    public Phone getPhone(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, number, price, brand, OS, storage FROM Phone WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Phone phone = new Phone(rs.getInt("id"),
                        rs.getInt("number"),
                        rs.getFloat("price"),
                        rs.getString("brand"),
                        rs.getString("OS"),
                        rs.getInt("storage"));
                return phone;
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
    public List<Phone> getAllPhones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, number, price, brand, OS, storage FROM Phone";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Phone> phones = new LinkedList<>();
            while (rs.next()) {
                Phone phone = new Phone(rs.getInt("id"),
                        rs.getInt("number"),
                        rs.getFloat("price"),
                        rs.getString("brand"),
                        rs.getString("OS"),
                        rs.getInt("storage"));
                phones.add(phone);
            }
            return phones;
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

    public boolean deletePhone(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Phone WHERE id=?";
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
