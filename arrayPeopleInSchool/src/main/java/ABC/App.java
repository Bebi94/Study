package ABC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App 
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/bkacad?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASS = "Bearcat1994";
    static final String QUERY = "Select * from students";
    public static void main( String[] args )
    {
          try (
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", DOB: " + rs.getDate("dob").toString());
            System.out.println();
         }
 
      } catch (SQLException e) {
         e.printStackTrace();
      }
                
    }
}
