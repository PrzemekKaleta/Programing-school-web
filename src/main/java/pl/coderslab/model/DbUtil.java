package pl.coderslab.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private static DataSource ds;
    public static Connection getConn() throws SQLException {
        return getInstance().getConnection();
    }
    private static DataSource getInstance() {
        if(ds == null) {
            try {
                Context ctx = new InitialContext();
                Class.forName("com.mysql.jdbc.Driver");
                Context initContext = new InitialContext();
                Context envContext  = (Context)initContext.lookup("java:/comp/env");
                ds = (DataSource)envContext.lookup("jdbc/school");
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return ds;}
}
