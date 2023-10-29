import java.sql.*;

public class School {

    private String schoolName;

    public void addStudent(Student student) {
        Connection connection = SchoolConnect.connection();
        String sql = "INSERT INTO student values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Student a = student;
            preparedStatement.setString(1, a.getStudentID());
            preparedStatement.setString(2, a.getFirstName());
            preparedStatement.setString(3, a.getLastName());
            preparedStatement.setString(4, a.getEmail());
            preparedStatement.setString(5, a.getDegree());
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeStudent(String studentID) {
        Connection connection = SchoolConnect.connection();
        String sql = "DELETE FROM student where studentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentID);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayStudentDetails() {
        Connection connection = SchoolConnect.connection();
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                System.out.println(results.getString(1)+
                        " "+results.getString(2)+
                        " "+ results.getString(3)+
                        " "+ results.getString(4)+
                        " "+ results.getString(5)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchStudent(String studentID) {
        Connection connection = SchoolConnect.connection();
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM student WHERE studentID = ? ";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                System.out.println(results.getString(1)+
                        " "+results.getString(2)+
                        " "+ results.getString(3)+
                        " "+ results.getString(4)+
                        " "+ results.getString(5)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudent(String studentID) {
        Connection connection = SchoolConnect.connection();
        String sql = "SELECT * FROM student WHERE studentID = ? ";
        PreparedStatement preparedStatement;
        Student student = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentID);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            String firstName = result.getString(2);
            String lastName = result.getString(3);
            String email = result.getString(4);
            String degree = result.getString(5);
            student = new Student(studentID, firstName, lastName, email, degree);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
