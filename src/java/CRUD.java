import java.sql.*;

public class CRUD {
    public static void main(String[] args) throws SQLException {

    }

    public static void create(String name, int age) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShi" +
                        "ft=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "login", "password"); Statement statement = conn.createStatement()) {
            statement.executeUpdate("insert person (name,age) values ('" + name + "'," + age + ")");
        }
    }

    public static void read(int id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShi" +
                        "ft=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "login", "password"); Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from person where id = " + id);
            while (resultSet.next()) {
                System.out.print(resultSet.getString(2) + " ");
                System.out.println(resultSet.getString(3));
            }
        }
    }

    public static void update(int id, String newName, int newAge) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShi" +
                        "ft=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "login", "password"); Statement statement = conn.createStatement()) {
            statement.executeUpdate("replace person values (" + id + ", '" + newName + "', " + newAge + ")");
        }
    }

    public static void delete(String name) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShi" +
                        "ft=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "login", "password"); Statement statement = conn.createStatement()) {
            statement.executeUpdate("delete from person where name = '" + name + "'");
        }
    }

    public static void delete(int id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShi" +
                        "ft=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "login", "password"); Statement statement = conn.createStatement()) {
            statement.executeUpdate("delete from person where id = '" + id + "'");
        }
    }

}
