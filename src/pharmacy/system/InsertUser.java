
package pharmacy.system;

import java.beans.Statement;
import java.sql.Connection;

public class InsertUser {
    private String username;
    private String password;
    static String email;
    private String mobile;
    private char sex;

    public InsertUser(String username, String password, String email, String mobile, char sex) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.sex = sex;
    }
    public InsertUser(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    } 

    public InsertUser(){
     
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    public void insert(String username,String pass,String email,String mobile,char sex){
        try {
             ConnectDB connectDB=new ConnectDB();
             connectDB.Connected();
             Connection con=ConnectDB.conn;
             Statement stmt=(Statement) con.createStatement();
             stmt.execute();
        } catch (Exception e) {
            
        }     
    }
}
