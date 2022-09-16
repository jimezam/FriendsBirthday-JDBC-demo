/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.friendsbirthday;

import co.edu.autonoma.friendsbirthday.data.Database;
import co.edu.autonoma.friendsbirthday.elements.Friend;
import co.edu.autonoma.friendsbirthday.elements.FriendDAO;
import co.edu.autonoma.friendsbirthday.elements.FriendDAOImpl;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educacion
 */
public class FriendsBirthday 
{
    private Database database;
    private String userInSession;

    public FriendsBirthday() {
        userInSession = "jimezam@autonoma.edu.co";      // Valor temporal
    }
    
    public ResultSet getAllFriends()
    {
        FriendDAO dao = new FriendDAOImpl(database);
        
        try {
            return dao.readAll();
        } catch (SQLException ex) {
            System.out.println("ERROR loading friends: " + ex.getMessage());
            return null;
        }
    }
    
    public Friend getFriend(long id)
    {
        FriendDAO dao = new FriendDAOImpl(database);
        
        try {
            return dao.read(id);
        } catch (SQLException ex) {
            System.out.println("ERROR loading friend: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean addFriend(Friend friend)
    {
        FriendDAO dao = new FriendDAOImpl(database);
    
        try {
            dao.insert(friend);
        } catch (SQLException ex) {
            System.out.println("ERROR loading friend: " + ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean deleteFriend(long id)
    {
        FriendDAO dao = new FriendDAOImpl(database);
    
        try {
            dao.delete(id);
            
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR deleting friend: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean updateFriend(Friend friend)
    {
        FriendDAO dao = new FriendDAOImpl(database);
    
        try {
            dao.update(friend);
        } catch (SQLException ex) {
            System.out.println("ERROR updating friend: " + ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public void close()
    {
        try {
            database.disconnect();
        } catch (SQLException ex) {
            System.out.println("ERROR: disconnecting from database");
        }
        
        System.exit(0);
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
