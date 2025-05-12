package database;

import model.Keycap;
import model.Switch;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/keyboards";
    private static final String USER = "postgres";
    private static final String PASSWORD = "parola";

    public static byte[] getImage(String query) {
        byte[] imgBytes = null;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                imgBytes = rs.getBytes("picture");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgBytes;
    }

    public static void loadImage(String componentName, JLabel componentImageLabel, String tableName) {
        // what? the name of the component. where? the name of the label.
        String query = "select picture from " + tableName + " where name='" + componentName + "'";
        byte[] imgBytes = getImage(query);
        if (imgBytes != null) {
            ImageIcon imageIcon = new ImageIcon(imgBytes);
            Image image = imageIcon.getImage(); // transforms imageIcon to image
            Image newImage = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            imageIcon = new ImageIcon(newImage); // transforms image to imageIcon
            componentImageLabel.setIcon(imageIcon);
        }
    }

    public static List<String> getNames(String tableName) {
        List<String> names = new ArrayList<>();
        String query = "SELECT name FROM " + tableName;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    public static Integer getPrice(String tableName, String name) {
        Integer price = null;
        String query = "SELECT price FROM " + tableName + " WHERE name='" + name + "'";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                price = rs.getInt("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    public static String getType(String tableName, String name) {
        String type = null;
        String query = "SELECT type FROM " + tableName + " WHERE name='" + name + "'";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                type = rs.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public static String getMaterial(String tableName, String name) {
        String material = null;
        String query = "SELECT material FROM " + tableName + " WHERE name='" + name + "'";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                material = rs.getString("material");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

    public static String getProfile(String tableName, String name) {
        String profile = null;
        String query = "SELECT profile FROM " + tableName + " WHERE name='" + name + "'";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                profile = rs.getString("profile");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }

    public static Integer getActuationForce(String tableName, String name) {
        Integer actuationForce = null;
        String query = "SELECT actuation_force FROM " + tableName + " WHERE name='" + name + "'";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                actuationForce = rs.getInt("actuation_force");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actuationForce;
    }

    // /////////////////////////////////////////////////////////////////////

    public static Switch getSwitch(String name) {
        Switch s = new Switch();
        String query = "SELECT * FROM switches WHERE name = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    s.setName(rs.getString("name"));
                    s.setPrice(rs.getInt("price"));
                    s.setImage(rs.getBytes("picture"));
                    s.setType(rs.getString("type"));
                    s.setActuationForce(String.valueOf(rs.getInt("actuation_force")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static Keycap getKeycap(String name) {
        Keycap k = new Keycap();
        String query = "SELECT * FROM keycaps WHERE name = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    k.setId(rs.getInt("id"));
                    k.setName(rs.getString("name"));
                    k.setPrice(rs.getInt("price"));
                    k.setImage(rs.getBytes("picture"));
                    k.setMaterial(rs.getString("material"));
                    k.setProfile(rs.getString("profile"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }

    // /////////////////////////////////////////////////////////////////////

    public static boolean userExists(String username) {
        boolean exists = false;
        String query = "SELECT 1 FROM \"user\" WHERE username = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                exists = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public static String getPassword(String username) {
        String password = null;
        String query = "SELECT password FROM \"user\" WHERE username = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    password = rs.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    // THIS METHOD IS USED TO EXECUTE QUERIES IN ViewsView, BUT SOMETHING DOESN'T WORK (probably not in this query)

    // getTable would've been a better name
    public static String executeQuery(String query) {
        String sql = "";
        switch (query) {
            case "Keyboards that have switches that cost more than 200":
                sql = "select keyboard.name as keyboard, switches.price as switch_price from keyboard\n" +
                        "join public.keyboard_switches ks on keyboard.id = ks.keyboard_id\n" +
                        "join switches on ks.switches_id = switches.id\n" +
                        "where switches.price > 200";
                break;
            case "Keycaps with Cherry profile":
                sql = "select keyboard.name as keyboard, profile from keyboard\n" +
                        "join public.keyboard_keycaps kk on keyboard.id = kk.keyboard_id\n" +
                        "join public.keycaps k on kk.keycaps_id = k.id\n" +
                        "where profile = 'Cherry'";
                break;
            case "Users that gave under 4 stars":
                sql = "select username, rating from review\n" +
                        "join public.user on review.user_id = public.user.id\n" +
                        "where rating <= 3\n" +
                        "order by rating";
                break;
            case "How many types of switches are there":
                sql = "select type, count(id) from switches\n" +
                        "group by type";
                break;
        }

        StringBuilder result = new StringBuilder();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                result.append(rsmd.getColumnName(i)).append("\t");
            }
            result.append("\n");

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    result.append(rs.getObject(i)).append("\t");
                }
                result.append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}