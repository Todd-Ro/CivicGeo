package org.esq.toddrom.CivicGeo.Controllers;

import org.esq.toddrom.CivicGeo.Models.Data.CandidateDao;
import org.esq.toddrom.CivicGeo.Models.Forms.Candidate;
import org.esq.toddrom.CivicGeo.Models.Data.CandidatePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("candidates")
public class CandidateController {

    @Autowired
    private CandidateDao candidateDao;


    @RequestMapping(value= "")
    public String index(Model model) {
        model.addAttribute("candidates", candidateDao.findAll());
        model.addAttribute("title", "Candidate List");
        return "candidates/candidate_viewer";
    }

    @RequestMapping(value = "add_candidate", method = RequestMethod.GET)
    public String displayAddCandidateForm(Model model) {
        model.addAttribute("title", "Add Candidate");
        model.addAttribute(new Candidate());
        return "candidates/add_candidate";
    }

    @RequestMapping(value = "add_candidate", method = RequestMethod.POST)
    public String processAddCandidateForm(@ModelAttribute @Valid Candidate newCandidate,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "add Candidate");
            return "candidates/add_candidate";
        }

        candidateDao.save(newCandidate);
        return "redirect:";
    }

}
