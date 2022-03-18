/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import java.util.Vector;
import uddk.entity.Report;
import uddk.model.ReportDAO;

/**
 *
 * @author USER
 */
public class ReportController {
    public static Vector getAllReportDataForTable() {
        try {
            return ReportDAO.getAllReportDataForTable();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    public static boolean createReport(String userId, String roomId, String period, String issue) {
        try {
            return ReportDAO.createReport(userId, roomId, period, issue);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
    
    public static Report getReportById(String reportId) {
        try {
            return ReportDAO.getReportById(Integer.parseInt(reportId));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    public static boolean closeReport(String reportId) {
        try {
            return ReportDAO.closeReport(Integer.parseInt(reportId));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
