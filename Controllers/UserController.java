package org.esq.toddrom.CivicGeo.Controllers;


import org.esq.toddrom.CivicGeo.Models.Data.UserDao;
import org.esq.toddrom.CivicGeo.Models.Forms.User;

import org.esq.toddrom.CivicGeo.Models.Forms.UserAdminType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserDao userDao;


    //@Autowired
    //AdminDao adminDao;

    @RequestMapping(value= "")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "User List");
        return "users/user_list";
    }

    @RequestMapping(value = "add_user", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        model.addAttribute("admin_types", UserAdminType.values());
        return "users/add_user";
    }

    @RequestMapping(value = "add_user", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                          Errors errors, @RequestParam String adminTypeId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "add User");
            model.addAttribute("admin_types", UserAdminType.values());
            return "users/add_user";
        }

        newUser.setAdminType(UserAdminType.valueOf(adminTypeId));
        userDao.save(newUser);
        return "redirect:";
    }
}
