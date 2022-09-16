/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.friendsbirthday.elements;

import co.edu.autonoma.friendsbirthday.data.Database;
import java.sql.Date;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author educacion
 */
public class FriendDAOImpl implements FriendDAO {

    private Database database;
    
    public FriendDAOImpl(Database database) {
        this.database = database;
    }

    @Override
    public int insert(Friend f) throws SQLException {
        /*
        Statement statement = database.getConnection().createStatement();
                
        String sql = "INSERT INTO friends(email, name, birthday) " 
                        + "VALUES ("
                        + "'" + f.getEmail()+ "',"
                        + "'" + f.getName() + "',"
                        + "'" + f.getBirthday() + "'"
                        + ");";
        
        return statement.executeUpdate(sql);
        */
        
        String sql = "INSERT INTO friends(email, name, birthday) " 
                        + "VALUES (?, ?, ?);";
        
        PreparedStatement statement = database.getConnection().prepareStatement(sql); 
        
        statement.setString(1, f.getEmail());
        statement.setString(2, f.getName());
        statement.setDate(3, java.sql.Date.valueOf(f.getBirthday()));

        return statement.executeUpdate();
    }

    @Override
    public int update(Friend f) throws SQLException {
        String sql = "UPDATE friends SET " +
                     "name=?, email=?, birthday=? " +
                     "WHERE id=?";
        
        PreparedStatement statement = database.getConnection().prepareStatement(sql); 
        
        statement.setString(1, f.getName());
        statement.setString(2, f.getEmail());
        statement.setDate(3, java.sql.Date.valueOf(f.getBirthday()));
        statement.setLong(4, f.getId());
        
        return statement.executeUpdate();
    }

    @Override
    public int delete(long id) throws SQLException {
        String sql = "DELETE FROM friends WHERE id = ?;";
        
        PreparedStatement statement = database.getConnection().prepareStatement(sql); 
        
        statement.setLong(1, id);

        return statement.executeUpdate();
    }

    @Override
    public Friend read(long id) throws SQLException {
        String sql = "SELECT * FROM friends WHERE id = ?;";
        
        PreparedStatement statement = database.getConnection().prepareStatement(sql); 
        
        statement.setLong(1, id);

        ResultSet resultset = statement.executeQuery();
        
        resultset.next();
        
        return new Friend(resultset.getLong("id"),
                          resultset.getString("email"),
                          resultset.getString("name"),
                          resultset.getDate("birthday").toLocalDate());
    }

    @Override
    public ResultSet readAll() throws SQLException {
        String sql = "SELECT * FROM friends ORDER BY birthday ASC;";
        
        PreparedStatement statement = database.getConnection().prepareStatement(sql); 
        
        return statement.executeQuery();
    }
    
}
