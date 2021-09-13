package config;

import model.University;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBService {
    public static List<University> universityList = new ArrayList<>();

    //logic
    public static List<University> getUniversityList() throws SQLException {
        String ketmon = "select * from university";

        Connection connection = DBConfig.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(ketmon);

        while (resultSet.next()) {
            University university = new University();
            university.setId(resultSet.getInt(1)); //id
            university.setName(resultSet.getString(2));
            university.setAddress(resultSet.getString(3));
            university.setRektor(resultSet.getString(4));
            universityList.add(university);
        }
        return universityList;
    }
}
