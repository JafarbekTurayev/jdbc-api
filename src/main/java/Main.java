import config.DBService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

      System.out.println(DBService.getUniversityList());
        DBService.addUniversity();
    }
}
