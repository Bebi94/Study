package ABC;

import java.beans.Statement;
import java.sql.*;

public class SQLdatabase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bkacad?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "Bearcat1994";
    
    ResultSet getRecords(String queryString){
        try(
            Connection conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
        ){

        }
    }
}
