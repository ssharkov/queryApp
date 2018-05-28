package queryapp.utils;

import queryapp.tables.Persons;

public class SqlBuilder {
//    private String sqlSelect = "SELECT * FROM persons";
//    private String sqlInsert = "INSERT INTO persons (`Name`, `LastName`, `Salary`) VALUES ('Bob', 'Marley', '333')";

    public String selectAll(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public String insert(Persons person) {
        return "INSERT INTO persons (`Name`, `LastName`, `Salary`) " +
                "VALUES ('" +
                person.getName() + "', " + "'" +
                person.getLastName() + "', '" +
                person.getSalary() +
                "')";
    }

    public String delete(int id){
        return "DELETE FROM persons where id = " + id;
    }

    public String update(int id, Persons person){
        return "UPDATE persons SET name = '"
                + person.getName() +"', lastname = '"
                + person.getLastName() + "', salary = '"
                + person.getSalary() + "'" +
                " WHERE id = " + id;

    }




}
