/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.autonoma.friendsbirthday.elements;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author educacion
 */
public interface FriendDAO {
    public int insert(Friend f) throws SQLException;
    public int update(Friend f) throws SQLException;
    public int delete(long id) throws SQLException;
    public Friend read(long id) throws SQLException;
    public ResultSet readAll() throws SQLException;
}