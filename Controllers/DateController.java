package org.esq.toddrom.CivicGeo.Controllers;

import org.esq.toddrom.CivicGeo.Models.Data.CandidateDao;
import org.esq.toddrom.CivicGeo.Models.Data.DateDao;
import org.esq.toddrom.CivicGeo.Models.Forms.Candidate;
import org.esq.toddrom.CivicGeo.Models.Forms.DateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("dates")
public class DateController {

    @Autowired
    private DateDao dateDao;


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("dates", dateDao.findAll());
        model.addAttribute("title", "Date List");
        return "dates/index";
    }

    @RequestMapping(value = "add_candidate", method = RequestMethod.GET)
    public String displayAddDateForm(Model model) {
        model.addAttribute("title", "Add Date");
        model.addAttribute(new DateWrapper());
        return "dates/add_date";
    }

    @RequestMapping(value = "add_candidate", method = RequestMethod.POST)
    public String processAddDateForm(@ModelAttribute @Valid DateWrapper newDate,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "add Date");
            return "dates/add_date";
        }

        dateDao.save(newDate);
        return "redirect:";
    }

}
