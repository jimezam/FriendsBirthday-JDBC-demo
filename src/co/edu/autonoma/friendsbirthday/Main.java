/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.friendsbirthday;

import co.edu.autonoma.friendsbirthday.data.Database;
import co.edu.autonoma.friendsbirthday.gui.MainFrame;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

/**
 *
 * @author educacion
 */
public class Main 
{
    private static byte[] getPasswordHash(String password)
        throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        return hash;
    }
    
    public static void main(String[] args) 
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        // String encoded = Base64.getEncoder().encodeToString(hash);
        // System.out.println(getPasswordHash("hola123"));
        
        String pass = "Dz/eAQPdRAd8BAIVovq9CaCXrsw=";
        byte[] decoded = Base64.getDecoder().decode(pass);

        if (Arrays.equals(decoded, getPasswordHash("hola123")))
            System.out.println("YES");
        else
            System.out.println("NO");
        
        ////////////////////////////////////////////////////////////////////////
        
        // IMPORTANTE: configurar MySQL para conexiones TCP externas.
        // $ sudo vi /etc/mysql/my.cnf
        //  [mysqld]
        //  bind-address="0.0.0.0"
        
        // IMPORTANTE: actualizar los datos de conexión a la base de datos
        
        Database database = new Database("com.mysql.cj.jdbc.Driver",
                                         "jdbc:mysql://192.168.1.69/birthdayfriends",
                                         "birthday_user",
                                         "hola123");
        
        try {
            database.registerDriver();
            database.connect();
            
            System.out.println("Database connected!");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: the required JDBC driver is not present");
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("ERROR: the database connection failed");
            System.out.println("Message: " + ex.getMessage());
            System.exit(2);
        }
        
        FriendsBirthday friends = new FriendsBirthday();
        friends.setDatabase(database);
        
        MainFrame frame = new MainFrame(friends);
        frame.setTitle("Birthday Friends");
        frame.setVisible(true);
    }
}
