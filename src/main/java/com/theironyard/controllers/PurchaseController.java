package com.theironyard.controllers;

import com.theironyard.entities.Customer;
import com.theironyard.entities.Purchase;
import com.theironyard.services.CustomerRepository;
import com.theironyard.services.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

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
        if (customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] columns = line.split(",");
                Customer newCustomer = new Customer(columns[0], columns[1]);
                customers.save(newCustomer);
            }
        }

        if (purchases.count() == 0) {
            File f = new File("purchases.csv");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] columns = line.split(",");
                Purchase newPurchase = new Purchase(customers.findOne(Integer.valueOf(columns[0])), columns[1], columns[2],
                        Integer.valueOf(columns[3]), columns[4]);
                purchases.save(newPurchase);
            }
        }
    }
}
