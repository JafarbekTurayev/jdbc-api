package config;

import model.University;

import java.sql.*;
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

    public static void addUniversity() throws SQLException {
        Connection connection = DBConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into university(id,name,address,rektor) values(?,?,?,?)");

        preparedStatement.setInt(1, 17);
        preparedStatement.setString(2, "123Sejong");
        preparedStatement.setString(3, "Se");
        preparedStatement.setString(4, "Jafar");
//        boolean execute = preparedStatement.execute();
        System.out.println(preparedStatement.execute());
//        if (execute) {
//            System.out.println("Qo'shildi!");
//        } else {
//            System.out.println("Xatolik");
//        }
    }
}
