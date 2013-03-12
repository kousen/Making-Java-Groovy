package mjg.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDAO implements PersonDAO {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:db";
    private static PersonDAO instance = new JdbcPersonDAO();

    private Connection conn;
    private PreparedStatement pst;
    
    static {
        try {
            Class.forName(DRIVER);
            createAndPopulateDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private JdbcPersonDAO() {}
    
    public static PersonDAO getInstance() {
        return instance;
    }
    
    private static void createAndPopulateDatabase() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DriverManager.getConnection(URL);
            
            ps = connection.prepareStatement("drop table if exists people");
            ps.execute();
            
            String createDb = "create table people (id int auto_increment, "
                    + "first varchar(255) not null, "
                    + "last varchar(255) not null, "
                    + "primary key(id))";
            ps = connection.prepareStatement(createDb);
            ps.execute();
            
            List<Person> people = new ArrayList<>();
            people.add(new Person("Jean-Luc", "Picard"));
            people.add(new Person("Johnathan", "Archer"));
            people.add(new Person("James", "Kirk"));
            people.add(new Person("Benjamin", "Sisko"));
            people.add(new Person("Kathryn", "Janeway"));
            String popDb = "insert into people values (null, ?, ?)";
            ps = connection.prepareStatement(popDb);
            for (Person p : people) {
                ps.setString(1, p.getFirst());
                ps.setString(2, p.getLast());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from people");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                people.add(new Person(
                        rs.getLong("id"), rs.getString("first"), rs.getString("last")));
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
        return people;
    }

    @Override
    public Person findById(long id) {
        Person p = null;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from people where id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p = new Person(
                        rs.getLong("id"), rs.getString("first"), rs.getString("last"));
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

    @Override
    public List<Person> findByLastName(String name) {
        List<Person> people = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from people where last like ?");
            pst.setString(1, "%" + name.toLowerCase() + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                people.add(new Person(
                        rs.getLong("id"), rs.getString("first"), rs.getString("last")));
            }
            rs.close();
            
            pst.setString(1, "%" + name.toUpperCase() + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                people.add(new Person(
                        rs.getLong("id"), rs.getString("first"), rs.getString("last")));
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
        return people;
    }

    @Override
    public Person create(Person p) {
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement(
                    "insert into people(id, first, last) values(null, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getFirst());
            pst.setString(2, p.getLast());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs != null && rs.next()) {
                p.setId(rs.getLong(1));
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

    @Override
    public Person update(Person p) {
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("update people set first=?, last=? where id=?");
            pst.setString(1, p.getFirst());
            pst.setString(2, p.getLast());
            pst.setLong(3, p.getId());
            pst.executeUpdate();
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

    @Override
    public boolean delete(long id) {
        int uc = 0;
        try {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("delete from people where id=?");
            pst.setLong(1, id);
            uc = pst.executeUpdate();
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
        return uc == 1;
    }

}
