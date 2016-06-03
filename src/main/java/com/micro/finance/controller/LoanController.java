package com.micro.finance.controller;


import com.micro.finance.model.Loan;
import com.micro.finance.service.CustomerService;
import com.micro.finance.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class LoanController {

    private LoanService loanService;

    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Autowired(required = true)
    @Qualifier(value="loanService")
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;

    }

    @Autowired(required = true)
    @Qualifier(value="customerService")
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public String ListLoans(Model model)
    {
        model.addAttribute("loan", new Loan());
        model.addAttribute("listLoan", this.loanService.listLoan());
        model.addAttribute("listCustomer",this.customerService.listCustomer());
        return "loan";
    }

    @RequestMapping(value= "/loan/add", method = RequestMethod.POST)
    public String addLoan(@ModelAttribute("loan") Loan officer){
        if(officer.getId() == 0){
            //new loan, add it
            this.loanService.addLoan(officer);
        }else{
            //existing loan, call update
            this.loanService.updateLoan(officer);
        }

        return "redirect:/loans";

    }

    @RequestMapping("/loan/remove/{id}")
    public String removeLoan(@PathVariable("id") int id){

        this.loanService.removeLoan(id);
        return "redirect:/loans";
    }

    @RequestMapping("/loan/edit/{id}")
    public String editLoan(@PathVariable("id") int id, Model model){
        model.addAttribute("loan", this.loanService.getLoan(id));
        model.addAttribute("listLoan", this.loanService.listLoan());
        model.addAttribute("listCustomer",this.customerService.listCustomer());
        return "loan";
    }


}
