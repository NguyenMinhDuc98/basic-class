package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends CommonDAO implements IUserDAO {

    @Override
    public List<User> all() {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "SELECT id, name, email, birthday FROM user";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthDay = rs.getDate("birthday");
                User user = new User(id, name, email, birthDay);
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public User find(int id) {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "SELECT id, name, email, birthday FROM basic_class.user where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthDay = rs.getDate("birthday");
                User user = new User(ID, name, email, birthDay);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        try {
            Connection connection = connect();
            String sql = "INSERT INTO user(name, email, birthday) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(user.getBirthDay());
            ps.setDate(3, java.sql.Date.valueOf(stringDate));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            Connection connection = connect();
            String sql = "update user\n"
                    + "set name = ?, email = ?, birthday = ?\n"
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(user.getBirthDay());
            ps.setDate(3, java.sql.Date.valueOf(stringDate));
            ps.setInt(4, user.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User user) {
        try {
            Connection connection = connect();
            String sql = "delete from user where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
