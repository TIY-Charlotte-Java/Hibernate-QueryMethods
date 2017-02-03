package com.theironyard.controllers;

import com.theironyard.entities.Purchase;
import com.theironyard.services.CustomerRepository;
import com.theironyard.services.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Ben on 2/3/17.
 */
@Controller
public class PurchaseController {

    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {

        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        } else {
            purchaseList = (List) purchases.findAll();
        }
        model.addAttribute("purchased", purchaseList);
        return "home";
    }

    @PostConstruct
    public void init() throws FileNotFoundException {

    }
}
