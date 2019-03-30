package pl.coderslab.model;

import java.sql.*;

public class Test_Data_From_DB {

    public Test_Data_From_DB() {
        try {
            Connection connection = SchoolConn.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM school.solutions");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int a = rs.getInt("solutuion_id");
                int b = rs.getInt("author_id");
                String c = rs.getString("body");
                System.out.println(a + "   " + b + "   " + c);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
