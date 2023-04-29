import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class root {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "7413698Aa";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, " +
                    "COUNT(subscription_date) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) " +
                    "AS average_count_of_subscriptions_in_month " +
                    "FROM purchaselist " +
                    "WHERE YEAR(subscription_date) = 2018 " +
                    "GROUP BY course_name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("average_count_of_subscriptions_in_month"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

