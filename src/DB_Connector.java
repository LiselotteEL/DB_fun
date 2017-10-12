import java.sql.Connection; //importerer Connection classes fra Java library
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    private static Connection con = null;

    // JDBC driver
    private static final String DRIVER = "com.mysql.jbdc.Driver";

    // the url for the database - jdbc:dbms://host name:port#/db name (<-- template)
    private static String url = "jdbc:mysql://127.0.0.1:3306/liselotte_egholm";

    // username
    private static String username = "root";

    // password
    private static String password = "4444";


    public static Connection connect() {
        System.out.println("\n--Connecting to MySQL JDBC--");


        // Locate MySQL JDBC Driver - JDBC = java database connector
        try {
            Class.forName(DRIVER);
            // Catch exceptions if JDBC is not found
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");
        }
        System.out.println("\n--MySQL JBDC driver registered");

        // Connect to MySQL DB - URL, userName, password
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n--Did not connect - try again--");
        }
        // if connection successful
        if (con != null) {
            System.out.println("\n--Connection successful--");
        } else {
            // if connection fails
            System.out.println("\n--Failed to connect--");
        }
        return con;

    }
}

