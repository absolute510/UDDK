/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import uddk.entity.Room;

/**
 *
 * @author USER
 */
public class RoomDAO {

    public static Vector getAllDataForTable() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT Maphong AS 'Mã phòng', Loaiphong AS 'Loại phòng', Succhua AS 'Sức chứa' FROM thongtinphong";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            // Get column
            ResultSetMetaData rsmd = rs.getMetaData();
            Vector vcol = new Vector();
            Vector vdata = new Vector();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                vcol.add(rsmd.getColumnLabel(i));
            }

            // Get data
            while (rs.next()) {
                Vector vtemp = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vtemp.add(rs.getString(i));
                }
                vdata.add(vtemp);
            }

            //Return data
            data.add(vdata);
            data.add(vcol);
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector getAllUniqueRoomType() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Loaiphong FROM thongtinphong";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            data = new Vector();
            // Get data
            while (rs.next()) {
                data.add(rs.getString(1));
            }

            //Return data
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector getAllUniqueRoomCapacity() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Succhua FROM thongtinphong";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            data = new Vector();
            // Get data
            while (rs.next()) {
                data.add(rs.getInt(1));
            }

            //Return data
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector getAllUniqueRoomTime() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Thoigian FROM thoigianphong";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            data = new Vector();
            // Get data
            while (rs.next()) {
                data.add(rs.getString(1));
            }

            //Return data
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector getAllUniqueRoomStatus() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Trangthaiphong FROM thongtinphongchitiet";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            data = new Vector();
            // Get data
            while (rs.next()) {
                data.add(rs.getString(1));
            }

            //Return data
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector filterRoom(String roomType, String capacity) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data;
        try {
            String sql = "SELECT Maphong AS 'Mã phòng',"
                    + " Loaiphong AS 'Loại phòng',"
                    + " Succhua AS 'Sức chứa'"
                    + " FROM thongtinphong"
                    + " WHERE Loaiphong LIKE ?"
                    + " AND Succhua LIKE ?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + roomType + "%");
            ps.setString(2, "%" + capacity + "%");
            rs = ps.executeQuery();
            data = new Vector();

            // Get column
            ResultSetMetaData rsmd = rs.getMetaData();
            Vector vcol = new Vector();
            Vector vdata = new Vector();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                vcol.add(rsmd.getColumnName(i));
            }

            // Get data
            while (rs.next()) {
                Vector vtemp = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vtemp.add(rs.getString(i));
                }
                vdata.add(vtemp);
            }

            //Return data
            data.add(vdata);
            data.add(vcol);
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static Vector getRegisteredRoomForTable(Date date) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "SELECT * FROM `thongtinphongdadangky` WHERE ngay=?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            rs = ps.executeQuery();

            // Get column
            ResultSetMetaData rsmd = rs.getMetaData();
            Vector vcol = new Vector();
            Vector vdata = new Vector();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                vcol.add(rsmd.getColumnLabel(i));
            }

            // Get data
            while (rs.next()) {
                Vector vtemp = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vtemp.add(rs.getString(i));
                }
                vdata.add(vtemp);
            }

            //Return data
            data.add(vdata);
            data.add(vcol);
            return data;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static int checkIn(String roomCode, String period, String userId, Date date) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "UPDATE thongtinphongdadangky SET"
                    + " Trangthai=?"
                    + " WHERE ngay=? AND Thoigian=? AND Magiaovien=? AND Maphong=? AND Trangthai=?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "dang dung");
            ps.setDate(2, sqlDate);
            ps.setString(3, period);
            ps.setString(4, userId);
            ps.setString(5, roomCode);
            ps.setString(6, "san sang");
            
            n = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }

        return n;
    }

    public static int checkOut(String roomCode, String period, String userId, Date date) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "UPDATE thongtinphongdadangky SET"
                    + " Trangthai=?"
                    + " WHERE ngay=? AND Thoigian=? AND Magiaovien=? AND Maphong=? AND Trangthai=?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "da su dung");
            ps.setDate(2, sqlDate);
            ps.setString(3, period);
            ps.setString(4, userId);
            ps.setString(5, roomCode);
            ps.setString(6, "dang dung");
            n = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }

        return n;
    }

    public static int registerRoom(String roomCode, String period, String userId, Date date) throws Exception {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            String sql = "INSERT INTO thongtinphongdadangky(ngay, Thoigian, Magiaovien, Maphong, Trangthai) VALUES"
                    + " (?, ?, ?, ?, ?)";

            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setDate(1, sqlDate);
            ps.setString(2, period);
            ps.setString(3, userId);
            ps.setString(4, roomCode);
            ps.setString(5, "san sang");
            n = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }

        return n;
    }

    public static boolean checkAvailableRoom(String roomCode, String period, Date date) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "SELECT COUNT(*) FROM thongtinphongdadangky WHERE ngay = ? AND Thoigian = ? AND Maphong = ? AND Trangthai <> 'da su dung'";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setString(2, period);
            ps.setString(3, roomCode);
            rs = ps.executeQuery();

            while (rs.next()) {
                int count = rs.getInt(1);
                return count < 1 ? true : false;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
        return false;
    }
    
    public static Room getRoomByRoomId(String roomId) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM thongtinphong WHERE Maphong = ?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, roomId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Room(rs.getString("Maphong"), rs.getString("Loaiphong"), rs.getInt("Succhua"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
        return null;
    }
    
    public static ArrayList<String> getBrokenDeviceOfRoomId(String roomId) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
            String sql = "SELECT Tenthietbi FROM thietbi WHERE Maphong = ? AND Tinhtrang = 'hong'";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, roomId);
            rs = ps.executeQuery();

            while (rs.next()) {
                arr.add(rs.getString("Tenthietbi"));
            }
            return arr;
        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

}
