/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import uddk.entity.Room;
import uddk.model.RoomDAO;

/**
 *
 * @author USER
 */
public class RoomController {

    public static Vector getRegisteredRoomForTable(Date date) {
        try {
            return RoomDAO.getRegisteredRoomForTable(date);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static boolean checkIn(String roomCode, String period, String userId, String date) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return RoomDAO.checkIn(roomCode, period, userId, parsedDate) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public static boolean checkOut(String roomCode, String period, String userId, String date) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return RoomDAO.checkOut(roomCode, period, userId, parsedDate) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public static boolean checkAvailableRoom(String roomCode, String period, String date) {
        try {
            Date parsedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return RoomDAO.checkAvailableRoom(roomCode, period, parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public static Room getRoomByRoomId(String roomId) {
        try {
            return RoomDAO.getRoomByRoomId(roomId);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static ArrayList<String> getBrokenDeviceOfRoomId(String roomId) {
        try {
            return RoomDAO.getBrokenDeviceOfRoomId(roomId);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static boolean registerRoom(String roomId, String period, String userId, String date) {
        try {
            Date parsedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            if (RoomDAO.registerRoom(roomId, period, userId, parsedDate) > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
