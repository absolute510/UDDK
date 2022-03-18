/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import java.util.Vector;
import uddk.entity.User;
import uddk.model.UserDAO;

/**
 *
 * @author USER
 */
public class UserManagerController {

    public static Vector getAllUserDataForTable() {
        try {
            return UserDAO.getAllUserDataForTable();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static User getUserById(String userId) {
        try {
            return UserDAO.getUserByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static boolean updateUser(User user) {
        try {
            return UserDAO.updateUserById(user) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
    
    public static boolean deleteUserById(String userId) {
        try {
            return UserDAO.deleteUserById(userId) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
