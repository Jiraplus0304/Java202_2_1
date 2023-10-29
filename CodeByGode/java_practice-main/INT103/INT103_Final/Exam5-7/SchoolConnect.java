import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolConnect {
    public static Connection connection(){
        String url ="jdbc:msql://localhost:3306/school";
        String user = "root";
        String pass = "mysql@sit";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
