package pl.coderslab.model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolConn {

        private static final String NameSQL = "school";
        private static final String DB_user = "root";
        private static final String DB_password = "coderslab";
        private static final String DB_port = "3306";

        public static java.sql.Connection getConnection() throws SQLException {
            java.sql.Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:" + DB_port + "/" + NameSQL + "?useSSL=false&characterEncoding=utf8",
                    DB_user,
                    DB_password);

            return connection;
        }
    }

