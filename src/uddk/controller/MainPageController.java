/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import java.util.Vector;
import uddk.model.RoomDAO;
import uddk.model.UserDAO;

/**
 *
 * @author USER
 */
public class MainPageController {

    public static Vector getAllRoomForTable() {
        try {
            return RoomDAO.getAllDataForTable();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueRoomType() {
        try {
            return RoomDAO.getAllUniqueRoomType();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueRoomCapacity() {
        try {
            return RoomDAO.getAllUniqueRoomCapacity();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueRoomTime() {
        try {
            return RoomDAO.getAllUniqueRoomTime();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueRoomStatus() {
        try {
            return RoomDAO.getAllUniqueRoomStatus();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector filterRoom(String roomType, String roomCap) {
        try {
            return RoomDAO.filterRoom(roomType, roomCap);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
