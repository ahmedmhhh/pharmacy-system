
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PharmacySystem {

  // static Connection conn=null;  
    public static void main(String[] args) {
        try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb?useSSL=false"
                    ,"root","37492237");
            System.out.println("connected !");
        } catch (SQLException ex) {
              System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
}
        }
    }    
