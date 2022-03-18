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
import java.util.Date;
import java.util.Vector;
import uddk.entity.Report;

/**
 *
 * @author USER
 */
public class ReportDAO {

    public static Vector getAllReportDataForTable() throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector data = new Vector();
        try {
            String sql = "SELECT Mabaocao AS 'Mã báo cáo', Ngaybaocao AS 'Ngày báo cáo', Magiaovien AS 'Mã giáo viên', Maphong AS 'Mã phòng', Thoigian AS 'Thời gian', Vande AS 'Vấn đề', Trangthai AS 'Trạng thái' FROM thongtinbaocao";
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

    public static Report getReportById(int reportId) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM thongtinbaocao WHERE Mabaocao=?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, reportId);
            rs = ps.executeQuery();

            // Get data
            while (rs.next()) {
                int id = rs.getInt("Mabaocao");
                Date date = new Date(rs.getDate("Ngaybaocao").getTime());
                String userId = rs.getString("Magiaovien");
                String roomId = rs.getString("Maphong");
                String period = rs.getString("Thoigian");
                String issue = rs.getString("Vande");
                boolean status = rs.getString("Trangthai").equals("open");
                return new Report(id, date, userId, roomId, period, issue, status);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
        return null;
    }

    public static boolean closeReport(int reportId) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            String sql = "UPDATE thongtinbaocao SET Trangthai='closed' WHERE Mabaocao=?";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, reportId);
            n = ps.executeUpdate();

            return n > 0 ? true : false;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

    public static boolean createReport(String userId, String roomId, String period, String issue) throws Exception {
        DBContext dbContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            String sql = "INSERT INTO thongtinbaocao(Ngaybaocao, Magiaovien, Maphong, Thoigian, Vande, Trangthai) VALUES"
                    + " (CURRENT_DATE, ?, ?, ?, ?, 'open')";
            connection = dbContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, roomId);
            ps.setString(3, period);
            ps.setString(4, issue);
            n = ps.executeUpdate();

            return n > 0 ? true : false;

        } catch (Exception e) {
            throw e;
        } finally {
            dbContext.closeConnection(rs, ps, connection);
        }
    }

}
