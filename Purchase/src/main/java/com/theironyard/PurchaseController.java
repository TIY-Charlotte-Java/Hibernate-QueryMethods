package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseRepository purchases; //will give us an instance of purchases repository

    @Autowired
    CustomerRepository customers; //will give us an instance of customers repository


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) { // have parameter list contain model
        List<Purchase> purchasesList; // put into list everything in purchase repository
        if (category != null) {
            purchasesList = (List)purchases.findAllByCategory(category);
        } else {
            purchasesList = (List)purchases.findAll();
        }
        model.addAttribute("purchases", purchasesList); // give list of purchases to model
        return "home";
    }

    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner fileScanner = new Scanner(f);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split(",");
                Customer customerObject = new Customer(columns[0], columns[1]);
                customers.save(customerObject);
            }

            File f2 = new File("purchases.csv");
            Scanner fileScanner2 = new Scanner(f2);
            fileScanner2.nextLine();
            while (fileScanner2.hasNext()) {
                String line = fileScanner2.nextLine();
                String[] columns2 = line.split(",");
                Purchase purchaseObject = new Purchase(columns2[1], columns2[2], Integer.valueOf(columns2[3]), columns2[4],
                        customers.findOne(Integer.valueOf(columns2[0])));
                purchases.save(purchaseObject);
            }
        }

    }

}



