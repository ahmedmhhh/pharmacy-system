
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PharmacySystem {

   static Connection conn=null;  
   static String url="jdbc:mysql://localhost:3306/pharmacydb?useSSL=false";
   static String username="root";
   static String password="yourPass";
    public static void main(String[] args) {
        try {
           conn = DriverManager.getConnection(url,username,password);
                   
            System.out.println("connected !");
            
        } catch (SQLException ex) {
              System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
}
        }
    }    
