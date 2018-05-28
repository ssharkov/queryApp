package queryapp;

import queryapp.tables.Persons;
import queryapp.utils.ConsolePrinter;
import queryapp.utils.SetUp;
import queryapp.utils.SqlBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static SetUp setUp = new SetUp();
    private static String databaseUrl = setUp.getDataProperties("databaseUrl");
    private static String user = setUp.getDataProperties("user");
    private static String password = setUp.getDataProperties("password");
    private static SqlBuilder sqlBuilder = new SqlBuilder();

    public static void selectAll() {
        Statement statement = establishConnection();
        try {
            ResultSet resultSet = statement.executeQuery(sqlBuilder.selectAll("Persons"));
            ConsolePrinter consolePrinter = new ConsolePrinter();
            System.out.println("Persons:");
            consolePrinter.print(resultSet);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(ArrayList<Persons> person) {
        Statement statement = establishConnection();
        try {
            for (Persons aPerson : person) {
                statement.executeUpdate(sqlBuilder.insert(aPerson));
            }
            System.out.println("Inserted " + person.size() + " rows");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int[] id) {
        Statement statement = establishConnection();
        try {
            for (int i = 0; i < id.length; i++) {
                statement.executeUpdate(sqlBuilder.delete(id[i]));
            }
            System.out.println("Deleted " + id.length + " rows");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, Persons person) {
        Statement statement = establishConnection();
        try {
            statement.executeUpdate(sqlBuilder.update(id, person));
            System.out.println("Updated 1 row");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Statement establishConnection() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(databaseUrl, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static List<String> getAll() throws SQLException {
        Statement statement = establishConnection();
        List<String> list = new ArrayList<String>();
        try {
            ResultSet resultSet = statement.executeQuery(sqlBuilder.selectAll("Persons"));
            while (resultSet.next()) {
                list.add(resultSet.getString("id"));
                list.add(resultSet.getString("Name"));
                list.add(resultSet.getString("LastName"));
                list.add(resultSet.getString("Salary"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
