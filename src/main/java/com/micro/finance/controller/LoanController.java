package com.micro.finance.controller;


import com.micro.finance.model.Customer;
import com.micro.finance.model.FieldOfficer;
import com.micro.finance.model.Loan;
import com.micro.finance.model.TransferDetail;
import com.micro.finance.service.CustomerService;
import com.micro.finance.service.FieldOfficerService;
import com.micro.finance.service.LoanService;
import com.micro.finance.service.TransferDetailService;
import org.hibernate.MappingException;
import org.hibernate.mapping.ValueVisitor;
import org.hibernate.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ssvh on 3/4/16.
 */

@Controller
public class LoanController {

    private LoanService loanService;

    private CustomerService customerService;

    private FieldOfficerService fieldOfficerService;

    private TransferDetailService transferDetailService;

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

    @Autowired(required = true)
    @Qualifier(value="fieldOfficerService")
    public void setFieldOfficerService(FieldOfficerService fieldOfficerService){
        this.fieldOfficerService = fieldOfficerService;
    }

    @Autowired(required = true)
    @Qualifier(value="transferDetailService")
    public void setFieldOfficerService(TransferDetailService transferDetailService){
        this.transferDetailService = transferDetailService;
    }

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public String ListLoans(ModelMap model)
    {
        model.put("loan", new Loan());
        model.put("transferDetail",new TransferDetail());
        model.put("listTransferDetail", this.transferDetailService.listTransferDetail());
        model.put("listLoan", this.loanService.listLoan());
        model.put("listCustomer",this.customerService.listCustomer());
        model.put("listFieldOfficer",this.fieldOfficerService.listFieldOfficer());
        return "loan";
    }

    @RequestMapping(value= "/loan/add", method = RequestMethod.POST)
    public String addLoan(
            @ModelAttribute("transferDetail") TransferDetail transferDetail,
            @RequestParam Map<String,String> allRequestParams){
        transferDetail.setReason("ordinary method");
       // transferDetail.getLoan().setTransferDetails(transferDetails);
        //if(transferDetail.getLoan().getId() == 0){
            //new transferDetail, add it
          //  this.transferDetailService.addTransferDetail(transferDetail);
        //}else{
            //existing transferDetail, call update
         //   this.transferDetailService.addTransferDetail(transferDetail);
        //}

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
        model.addAttribute("listFieldOfficer",this.fieldOfficerService.listFieldOfficer());
        return "loan";
    }


}
