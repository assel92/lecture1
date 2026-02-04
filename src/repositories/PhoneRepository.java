package repositories;
import data.interfaces.IDB;
import Entites.Phone;
import repositories.interfaces.PhRepos;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {

    private final IDB db;

    public PhoneRepository (IDB db) {
        this.db = db;
    }

    @Override
    public boolean addPhone(Phone phone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Phone(id, number, price,brand, OS, storage, color) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, phone.getId());
            st.setInt(2, phone.getNumber());
            st.setFloat(3, phone.getPrice());
            st.setString(4, phone.getBrand());
            st.setString(5, phone.getOS());
            st.setInt(6, phone.getStorage());
            st.setString(7, phone.getColor());
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
            String sql = "SELECT id, number, price, brand, OS, storage, color FROM Phone WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Phone phone = new Phone(rs.getInt("id"),
                        rs.getInt("number"),
                        rs.getFloat("price"),
                        rs.getString("brand"),
                        rs.getString("OS"),
                        rs.getInt("storage"),
                        rs.getString("color"));
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
            String sql = "SELECT id, number, price, brand, OS, storage, color FROM Phone";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Phone> phones = new LinkedList<>();
            while (rs.next()) {
                Phone phone = new Phone(rs.getInt("id"),
                        rs.getInt("number"),
                        rs.getFloat("price"),
                        rs.getString("brand"),
                        rs.getString("OS"),
                        rs.getInt("storage"),
                        rs.getString("color"));
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
    public boolean updatePhoneColor(int id, String color) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE Phone SET color = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, color);
            st.setInt(2, id);

            int rows = st.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
