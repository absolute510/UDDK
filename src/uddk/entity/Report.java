/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.entity;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Report {
    private int id;
    private Date date;
    private String userId;
    private String roomId;
    private String period;
    private String issue;
    private boolean status;

    public Report() {
    }

    public Report(int id, Date date, String userId, String roomId, String period, String issue, boolean status) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.roomId = roomId;
        this.period = period;
        this.issue = issue;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
