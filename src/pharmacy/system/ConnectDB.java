
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectDB {
   static Connection conn=null;  
   static String url="jdbc:mysql://localhost:3306/pharmacydb?useSSL=false";
   static String username="root";
   static String password="37492237";
   public void Connected(){
   try {
           conn = DriverManager.getConnection(url,username,password);
                 
            System.out.println("connected !");
            
        } catch (SQLException ex) {
              System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
        }
   }
   public void insertDB(){
       Connected();
       try {
             Statement st = conn.createStatement(); 
             st.executeUpdate("INSERT INTO `pharmacydb`.`users`VALUES(1,'123','a@hotmail.com','0109111111','M')");
       } catch (Exception e) {
           
       }
       
   } 
}
