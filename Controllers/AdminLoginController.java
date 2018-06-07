package org.esq.toddrom.CivicGeo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class AdminLoginController {

    @RequestMapping(value="")
    public String login(
            //Model model
    ) {
        return "login";
    }
}
