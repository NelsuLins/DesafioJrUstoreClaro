import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = null;
        int period = 4;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/funcionarios","root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery
                    ("select e.`id`, e.`name`, sum(s.`value`)/"+ period +" as `average_salary`\n" +
                            "from employee as e join salary as s\n" +
                            "on e.`id` = s.`employee_id`\n" +
                            "where s.`payment_date` <= (CURRENT_DATE - "+ period * 30 +")\n" +
                            "group by e.`id`\n" +
                            "order by `average_salary` desc\n" +
                            "limit 3");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " +
                        resultSet.getString("name") + " " + resultSet.getString("average_salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
