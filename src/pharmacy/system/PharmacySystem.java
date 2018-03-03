
package pharmacy.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pharmacy.system.FramePackage.Login;

public class PharmacySystem extends ConnectDB{
    public static void main(String[] args) {
        new Login().setVisible(true);
    }  
}
