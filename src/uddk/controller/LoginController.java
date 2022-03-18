/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uddk.controller;

import uddk.model.UserDAO;

/**
 *
 * @author USER
 */
public class LoginController {

    public static boolean login(String username, String password) {
        try {
            return UserDAO.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public static boolean isAdmin(String username) {
        try {
            return UserDAO.isAdmin(username);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
    public static String getUserIdByUsername(String username) {
        try {
            return UserDAO.getUserIdByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
