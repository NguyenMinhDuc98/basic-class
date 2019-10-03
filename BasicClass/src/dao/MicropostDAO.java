/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Micropost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class MicropostDAO extends CommonDAO implements IMicropostDAO {

    @Override
    public List<Micropost> all() {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "select id, user_id, content from micropost";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Micropost> list = new ArrayList<Micropost>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String content = rs.getString("content");
                Micropost micropost = new Micropost(id, user_id, content);
                list.add(micropost);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public Micropost find(int id) {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "select id, user_id, content from micropost where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String content = rs.getString("content");
                Micropost micropost = new Micropost(ID, user_id, content);
                return micropost;
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
    public void create(Micropost micropost) {
        try {
            Connection connection = connect();
            String sql = "insert into micropost values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, micropost.getId());
            ps.setInt(2, micropost.getUser_id());
            ps.setString(3, micropost.getContent());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Micropost micropost) {
        try {
            Connection connection = connect();
            String sql = "update micropost\n"
                    + "set user_id = ?, content = ?\n"
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(3, micropost.getId());
            ps.setInt(1, micropost.getUser_id());
            ps.setString(2, micropost.getContent());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Micropost micropost) {
        try {
            Connection connection = connect();
            String sql = "delete from micropost where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, micropost.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countContent(int id) {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "select a.user_id, count(a.content) as count\n"
                    + "from micropost a\n"
                    + "where a.user_id = ?\n"
                    + "group by a.user_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("user_id");
                int count = rs.getInt("count");
                System.out.println("ID: " + ID + "-----count: " + count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public void join() {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "select a.name, a.email, b.content\n"
                    + "from user a\n"
                    + "inner join micropost b on a.id = b.user_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String content = rs.getString("content");
                System.out.println("Name: " + name + "----email: " + email + "----content: " + content);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public void subquery() {
        ResultSet rs = null;
        try {
            Connection connection = connect();
            String sql = "select a.name, a.email\n"
                    + "from user a\n"
                    + "where a.id in (\n"
                    + "	select b.user_id\n"
                    + "    from micropost b\n"
                    + ")";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name + "----email: " + email);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MicropostDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}
