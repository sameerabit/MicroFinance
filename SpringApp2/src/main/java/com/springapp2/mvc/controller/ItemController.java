package com.springapp2.mvc.controller;

import com.springapp2.mvc.entity.Item;
import com.springapp2.mvc.repository.ItemRepository;
import com.springapp2.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 7/17/16.
 */

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/item/add",method = RequestMethod.POST)
    public void addItem(@ModelAttribute("item")Item item){
        itemRepository.save(item);
    }

    @RequestMapping(value = "/item",method = RequestMethod.GET)
    public String viewItem(ModelMap modelMap){
        modelMap.addAttribute("item",new Item());
        modelMap.addAttribute("items",itemRepository.findAll());
        modelMap.addAttribute("users",userRepository.findAll());
        return "items";
    }


}
