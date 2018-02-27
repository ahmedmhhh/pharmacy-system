
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
   public String insertDB(String user,String pass,String email,String mobile,char gender){
       String doneInsert="Welcome !";
       Connected();
       try {
             Statement st = conn.createStatement(); 
             st.executeUpdate("INSERT INTO `pharmacydb`.`users` VALUES ("
                     + "+'" +user+"','"+pass+"','"+email+"','"+mobile+"','"+gender+"')");
             System.out.println("inserted");
       } catch (Exception e) {
            System.err.println(e.getMessage()); 
       }
       return doneInsert;
   } 
   public void UserMyQuery(String Query){
       Connected();
        try {
             Statement st = conn.createStatement(); 
             st.executeQuery(Query);
             System.out.println("Query is "+Query);
             
       } catch (Exception e) {
            System.err.println(e.getMessage()); 
       }
   }
    public int UserMyQuery(String Condition,String tablename,String column){
       Connected();
       int count=-1;
        try {
             Statement st = conn.createStatement();   
             String showStatment="select "+Condition+" from "+tablename+" where "+column;
             ResultSet Query=st.executeQuery(showStatment);
             System.out.println("Query is "+showStatment);
             Query.next();
             count = Query.getInt(1);
       } catch (Exception e) {
            System.err.println(e.getMessage()); 
       }
        return count;
   }
}
