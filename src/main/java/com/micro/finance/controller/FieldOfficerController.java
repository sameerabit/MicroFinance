package com.micro.finance.controller;


import com.micro.finance.model.Branch;
import com.micro.finance.model.FieldOfficer;
import com.micro.finance.service.BranchService;
import com.micro.finance.service.FieldOfficerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ssvh on 3/4/16.
 */

@Controller
public class FieldOfficerController {

    private FieldOfficerService fieldOfficerService;

    private BranchService branchService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Autowired(required = true)
    @Qualifier(value="fieldOfficerService")
    public void setFieldOfficerService(FieldOfficerService fieldOfficerService) {
        this.fieldOfficerService = fieldOfficerService;

    }

    @Autowired(required = true)
    @Qualifier(value="branchService")
    public void setBranchService(BranchService branchService){
        this.branchService = branchService;
    }

    @RequestMapping(value = "/fieldOfficers", method = RequestMethod.GET)
    public String ListFieldOfficers(Model model)
    {
        model.addAttribute("fieldOfficer", new FieldOfficer());
        model.addAttribute("listFieldOfficer", this.fieldOfficerService.listFieldOfficer());
        model.addAttribute("listBranch",this.branchService.listBranch());
        return "fieldOfficer";
    }

    @RequestMapping(value= "/fieldOfficer/add", method = RequestMethod.POST)
    public String addFieldOfficer(@ModelAttribute("fieldOfficer") FieldOfficer officer){
        if(officer.getId() == 0){
            //new fieldOfficer, add it
            this.fieldOfficerService.addFieldOfficer(officer);
        }else{
            //existing fieldOfficer, call update
            this.fieldOfficerService.updateFieldOfficer(officer);
        }

        return "redirect:/fieldOfficers";

    }

    @RequestMapping("/fieldOfficer/remove/{id}")
    public String removeFieldOfficer(@PathVariable("id") int id){

        this.fieldOfficerService.removeFieldOfficer(id);
        return "redirect:/fieldOfficers";
    }

    @RequestMapping("/fieldOfficer/edit/{id}")
    public String editFieldOfficer(@PathVariable("id") int id, Model model){
        model.addAttribute("fieldOfficer", this.fieldOfficerService.getFieldOfficer(id));
        //model.addAttribute("listFieldOfficer", this.fieldOfficerService.listFieldOfficer());
        return "fieldOfficer";
    }


}
