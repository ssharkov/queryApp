package queryapp;

import queryapp.App;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class GenerateTable {
    public static void main(String[] args) throws IOException, SQLException {
        StringBuilder buf = new StringBuilder();
        buf.append("<html>" +
                "<head><style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>LastName</th>" +
                "<th>Salary</th>" +
                "</tr>");
        App app = new App();
        List<String> list = app.getAll();
        for (int i = 0; i < list.size(); i = i + 4) {
            buf.append("<tr><td>")
                    .append(list.get(i))
                    .append("</td><td>")
                    .append(list.get(i + 1))
                    .append("</td><td>")
                    .append(list.get(i + 2))
                    .append("</td><td>")
                    .append(list.get(i + 3))
                    .append("</td></tr>");
        }
        buf.append("</table>" +
                "</body>" +
                "</html>");
        String html = buf.toString();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\Projects\\queryApp\\src\\main\\java\\Persons.html"));
        bufferedOutputStream.write(html.getBytes());
        bufferedOutputStream.close();
    }
}
