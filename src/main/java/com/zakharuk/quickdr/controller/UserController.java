package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.dao.UserDao;
import com.zakharuk.quickdr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by matvii on 13.04.17.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/createuser")
    @ResponseBody
    public String create(String name, String password, String role) {
        //System.err.println("HERE");
        String userId = "";
        try {
            User user = new User(name, password, role);
            user.setEnabled(true);
            userDao.add(user);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error creating the user: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "User succesfully created "  + Constants.FOOTER;
    }

    @RequestMapping("/deleteuser")
    @ResponseBody
    public String delete(String id) {
        try {
            User user = new User();
            user.setName(id);
            userDao.remove(user);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error deleting the user:" + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "User succesfully deleted!" + Constants.FOOTER;
    }


    @RequestMapping("/updateuser")
    @ResponseBody
    public String updateUser(String name, String password, String role) {
        try {
            User user = userDao.get(name);
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
            userDao.update(user);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error updating the user: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "User succesfully updated!" + Constants.FOOTER;
    }

}
