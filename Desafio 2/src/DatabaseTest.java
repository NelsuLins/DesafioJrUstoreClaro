import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/funcionarios","root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery
                    ("select e.`id`, e.`name`, avg(s.`value`) as `average_salary`\n" +
                            "from employee as e join salary as s\n" +
                            "on e.`id` = s.`employee_id`\n" +
                            "where datediff(current_date, s.`payment_date`) < 92\n" +
                            "group by e.`id`\n" +
                            "order by `average_salary` desc\n" +
                            "limit 3;");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " +
                        resultSet.getString("name") + " " + resultSet.getString("average_salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
