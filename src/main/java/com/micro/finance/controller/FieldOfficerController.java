package com.micro.finance.controller;


import com.micro.finance.model.FieldOfficer;
import com.micro.finance.service.FieldOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 3/4/16.
 */

@Controller
public class FieldOfficerController {

    private FieldOfficerService fieldOfficerService;


    @Autowired(required = true)
    @Qualifier(value="fieldOfficerService")
    public void setFieldOfficerService(FieldOfficerService fieldOfficerService) {
        this.fieldOfficerService = fieldOfficerService;
    }

    @RequestMapping(value = "/fieldOfficers", method = RequestMethod.GET)
    public String ListFieldOfficers(Model model)
    {
        model.addAttribute("fieldOfficer", new FieldOfficer());
        model.addAttribute("listFieldOfficer", this.fieldOfficerService.listFieldOfficer());
        return "fieldOfficer";
    }

    @RequestMapping(value= "/fieldOfficer/add", method = RequestMethod.POST)
    public String addFieldOfficer(@ModelAttribute("fieldOfficer") FieldOfficer p){

        if(p.getId() == 0){
            //new fieldOfficer, add it
            this.fieldOfficerService.addFieldOfficer(p);
        }else{
            //existing fieldOfficer, call update
            this.fieldOfficerService.updateFieldOfficer(p);
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
