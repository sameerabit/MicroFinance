package com.micro.finance.controller;

import com.micro.finance.model.Branch;
import com.micro.finance.service.BranchService;
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
public class BranchController {

    private BranchService branchService;


    @Autowired(required = true)
    @Qualifier(value="branchService")
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public String ListBranchs(Model model)
    {
        model.addAttribute("branch", new Branch());
        model.addAttribute("listBranch", this.branchService.listBranch());
        return "branch";
    }

    @RequestMapping(value= "/branch/add", method = RequestMethod.POST)
    public String addBranch(@ModelAttribute("branch") Branch p){

        if(p.getId() == 0){
            //new branch, add it
            this.branchService.addBranch(p);
        }else{
            //existing branch, call update
            this.branchService.updateBranch(p);
        }

        return "redirect:/branches";

    }

    @RequestMapping("/branch/remove/{id}")
    public String removeBranch(@PathVariable("id") int id){

        this.branchService.removeBranch(id);
        return "redirect:/branches";
    }

    @RequestMapping("/branch/edit/{id}")
    public String editBranch(@PathVariable("id") int id, Model model){
        model.addAttribute("branch", this.branchService.getBranch(id));
        //model.addAttribute("listBranch", this.branchService.listBranch());
        return "branch";
    }
}
