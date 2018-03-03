
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectDB extends InsertUser{
   static Connection conn=null;  
   static String url="jdbc:mysql://localhost:3306/pharmacydb?useSSL=false";
   static String username="root";
   static String password="Enter Your Pass";
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
   public boolean insertDB(String ProName,float Price,String Date,int Quantity){
       Connected();
       try {
             Statement st = conn.createStatement(); 
             st.executeUpdate("INSERT INTO `pharmacydb`.`products` "
                     + "(products.Product_name,products.Price,products.Expiration_date,products.Quantity,products.User_email)"
                     + "VALUES ("+"'"+ProName+"'"+","+Price+",'"+Date+"',"+Quantity+",'"+InsertUser.email+"')");
            return true;
             
       } catch (SQLException e) {
            System.err.println(e.getMessage()); 
            return false;
       }
   }
   public ResultSet UserMyQuery(String Query){
       Connected();
       ResultSet rs=null;
        try {
             Statement st = conn.createStatement(); 
             rs=st.executeQuery(Query);
             System.out.println("Query is "+Query);
             
       } catch (Exception e) {
            System.err.println(e.getMessage()); 
       }
        System.out.println(rs.toString());
        return rs;
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
    public void UpdateProduct(String Query){
        Connected();
        
        try {
             Statement st = conn.createStatement(); 
             st.executeUpdate(Query);
 
       } catch (Exception e) {
            System.err.println(e.getMessage()); 
       }
    }
}
