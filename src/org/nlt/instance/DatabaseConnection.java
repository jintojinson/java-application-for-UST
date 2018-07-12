
package org.nlt.instance;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dbc;
    private DatabaseConnection(){
        try {
            forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplecrud","root","");
            System.out.println("Connection Established");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static DatabaseConnection getDatabaseConnection()
    {
        if(dbc==null)
        {
           dbc= new DatabaseConnection();
        }
        return dbc;
    }
    
    public Connection getConnection()
    {
        return con;
    }
}
