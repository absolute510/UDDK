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
import java.util.Vector;

/**
 *
 * @author USER
 */
public class DeviceDAO {

    public static Vector getAllDataForTable() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT Maphong AS 'Mã phòng', Mathietbi AS 'Mã thiết bị', Tenthietbi AS 'Tên thiết bị', Tinhtrang AS 'Tình trạng' FROM thietbi";
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

    public static Vector getAllUniqueDeviceName() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Tenthietbi FROM thietbi";
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

    public static Vector getAllUniqueDeviceStatus() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT DISTINCT Tinhtrang FROM thietbi";
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

    public static Vector filterDevice(String name, String status, String code) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data;
        try {
            String sql = "SELECT * FROM thietbi WHERE (Maphong LIKE ? OR Mathietbi LIKE ?) AND Tenthietbi LIKE ? AND Tinhtrang LIKE ?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + code + "%");
            ps.setString(2, "%" + code + "%");
            ps.setString(3, "%" + name + "%");
            ps.setString(4, "%" + status + "%");
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

    public static int deleteDeviceById(String deviceId) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            String sql = "DELETE FROM thietbi WHERE Mathietbi = ?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, deviceId);
            n = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
        return n;
    }

    public static int updateDeviceStatusById(String deviceId, boolean status) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            String sql = "UPDATE thietbi SET Tinhtrang = ? WHERE Mathietbi = ?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, status ? "hong" : "tot");
            ps.setString(2, deviceId);
            n = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
        return n;
    }
}
