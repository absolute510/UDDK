/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBContext {
    private final String serverName = "localhost";
    private final String dbName = "dangkyphonghoc";
    private final String portNumber = "3306";
    private final String username = "root";
    private final String password = "abc123";
    
    public DBContext() {
        
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
        return DriverManager.getConnection(url, username, password);
    }
    
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
