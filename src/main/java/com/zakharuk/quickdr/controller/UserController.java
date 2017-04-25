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

    @RequestMapping("/register")
    @ResponseBody
    public String registerUser() {
        StringBuilder res = new StringBuilder();
        res.append(Constants.HEADER);
        //Patient patient = patientService.getPatientById(id);
        res.append("<div class=\"jumbotron\">\n" +
                "        <div>\n" +
                "            Name <input type=\"text\" id=\"name\" name=\"name\"  /><br />\n" +
                "            Password <input type=\"password\" id=\"password\" name=\"password\" /><br />\n" +
                "            Role <input type=\"text\" id=\"role\" name=\"role\"/><br />\n" +
                "            <a id=\"link\" href=\"/\" class = \"btn btn-info regist\">Register</a>\n" +
                "            <!--<input type=\"submit\" />-->\n" +
                "        </div>\n" +
                "    </div>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

    @RequestMapping("/edit-profile")
    @ResponseBody
    public String editUser(String login) {
        StringBuilder res = new StringBuilder();
        res.append(Constants.HEADER);
        User user = userDao.get(login);
        res.append("<div class=\"jumbotron\">\n" +
                "        <div>\n" +
                "            Name <input type=\"text\" id=\"name\" name=\"name\" value=\""
                + user.getName() + "\" /><br />\n" +
                "            Password <input type=\"password\" id=\"password\" name=\"password\" value=\""
                + "" + "\" /><br />\n" +
                "            Role <input type=\"text\" id=\"role\" name=\"role\" value=\""
                + user.getRole() + "\" /><br />\n" +
                "            <a id=\"link\" href=\"/\" class = \"btn btn-info update-user\">Update</a>\n" +
                "            <!--<input type=\"submit\" />-->\n" +
                "        </div>\n" +
                "    </div>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

}
