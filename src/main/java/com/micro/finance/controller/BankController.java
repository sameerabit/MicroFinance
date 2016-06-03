package com.micro.finance.controller;

import com.micro.finance.model.Bank;
import com.micro.finance.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 2/6/16.
 */
@Controller
public class BankController {

    private BankService bankService;


    @Autowired(required = true)
    @Qualifier(value="bankService")
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    public String ListBanks(Model model)
    {
        model.addAttribute("bank", new Bank());
        model.addAttribute("listBank", this.bankService.listBank());
        return "bank";
    }

    @RequestMapping(value= "/bank/add", method = RequestMethod.POST)
    public String addBank(@ModelAttribute("bank") Bank bank){

        if(bank.getId() == 0){
            //new bank, add it
            this.bankService.addBank(bank);
        }else{
            //existing bank, call update
            this.bankService.updateBank(bank);
        }

        return "redirect:/banks";

    }

    @RequestMapping("/bank/remove/{id}")
    public String removeBank(@PathVariable("id") int id){

        this.bankService.removeBank(id);
        return "redirect:/banks";
    }

    @RequestMapping("/bank/edit/{id}")
    public String editBank(@PathVariable("id") int id, Model model){
        model.addAttribute("bank", this.bankService.getBank(id));
        model.addAttribute("listBank", this.bankService.listBank());
        return "bank";
    }
}
