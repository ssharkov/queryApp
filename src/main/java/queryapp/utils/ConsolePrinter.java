package queryapp.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsolePrinter {

    public void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("Name");
            String lastName = resultSet.getString("LastName");
            int salary = resultSet.getInt("Salary");

            System.out.print(String.format("|%-3s|", id));
            System.out.print(String.format("%-10s|", name));
            System.out.print(String.format("%-14s|", lastName));
            System.out.print(String.format("%-6s|", salary));
            System.out.println();
        }
    }
}
