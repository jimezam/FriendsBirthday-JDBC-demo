/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.friendsbirthday.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author educacion
 */
public class Database {
    
    private String driver = "";
    private String url = "";
    private String username = "";
    private String password = "";
    private Connection connection = null;
    
    public Database(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void registerDriver() throws ClassNotFoundException {
        Class.forName(driver);
    }
    
    public void connect() throws SQLException
    {
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public void disconnect() throws SQLException
    {
        if(connection != null)
            connection.close();
    }
}
