/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import java.util.Vector;
import uddk.model.DeviceDAO;

/**
 *
 * @author USER
 */
public class DeviceManagerController {

    public static Vector getAllDeviceForTable() {
        try {
            return DeviceDAO.getAllDataForTable();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueDeviceName() {
        try {
            return DeviceDAO.getAllUniqueDeviceName();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector getAllUniqueDeviceStatus() {
        try {
            return DeviceDAO.getAllUniqueDeviceStatus();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Vector filterDevice(String name, String status, String code) {
        try {
            return DeviceDAO.filterDevice(name, status, code);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static boolean deleteDeviceById(String deviceId) {
        try {
            return DeviceDAO.deleteDeviceById(deviceId) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public static boolean updateDeviceStatusById(String deviceId, boolean status) {
        try {
            return DeviceDAO.updateDeviceStatusById(deviceId, status) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
