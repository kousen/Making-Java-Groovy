package mjg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDAO implements ProductDAO {
    private static final String URL = "jdbc:h2:build/test";
    private static final String DRIVER = "org.h2.Driver";
    
    public JDBCProductDAO() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
       createAndPopulateTable();
    }
    
    private void createAndPopulateTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
            stmt.execute("drop table product if exists;");
            stmt.execute("create table product (id int primary key, name varchar(25), price double);");
            stmt.executeUpdate("insert into product values (1,'baseball',4.99),(2,'football',14.95),(3,'basketball',14.99)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Product> getAllProducts() {
        Connection conn = null;
        PreparedStatement pst = null;
        List<Product> results = new ArrayList<Product>();
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                results.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
    
    public Product findProductById(int id) {
        Product p = null;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from product where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
    
    public void insertProduct(Product p) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("insert into product (id,name,price) values (?,?,?)");
            pst.setInt(1, p.getId());
            pst.setString(2, p.getName());
            pst.setDouble(3, p.getPrice());
            int uc = pst.executeUpdate();
            if (uc != 1) throw new SQLException("insert of product failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
    }
    
    public void deleteProduct(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("delete from product where id=?");
            pst.setInt(1, id);
            int uc = pst.executeUpdate();
            if (uc != 1) throw new SQLException("delete of product failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
    }
}
