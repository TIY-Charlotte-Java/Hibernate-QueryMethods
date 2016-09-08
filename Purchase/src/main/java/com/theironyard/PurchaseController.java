package com.theironyard;

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

@Controller
public class PurchaseController {

    @Autowired
    PurchaseRepository purchases; //will give us an instance of purchase repository

    @Autowired
    CustomerRepository customers; //will give us an instance of customer repository


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) { // have parameter list contain model and category passed in
        List<Purchase> purchasesList; // put into list everything in purchase repository
        if (category != null) { // if category is not null run findByCategory method and pass in category that was passed into me
            purchasesList = (List) purchases.findByCategory(category); //purchase list is only that of category
        } else {
            purchasesList = (List) purchases.findAll(); // otherwise show entire purchase list
        }
        model.addAttribute("purchases", purchasesList); // give list of purchases to model
        return "home";
    }

    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) { //only parse if the customer repository is empty
            File fCustom = new File("customers.csv"); // create new file from csv
            Scanner fileScannerCust = new Scanner(fCustom); // scanner to read that file
            fileScannerCust.nextLine(); // ignore first line since is header
            while (fileScannerCust.hasNext()) { // while there is a token to be read on next line
                String line = fileScannerCust.nextLine(); //turn that line into a string
                String[] columnsCust = line.split(","); // turn that string into an array, split by comma
                Customer customerObject = new Customer(columnsCust[0], columnsCust[1]); // create customer object with name (index 0)
                // and email (index 1)
                customers.save(customerObject); //save that object to the customer repo
            }
        }
        // do same for purchases
        if (purchases.count() == 0) {

            File fPurch = new File("purchases.csv");
            Scanner fileScannerPurch = new Scanner(fPurch);
            fileScannerPurch.nextLine();
            while (fileScannerPurch.hasNext()) {
                String line = fileScannerPurch.nextLine();
                String[] columnsPurch = line.split(",");
                Purchase purchaseObject = new Purchase(columnsPurch[1], columnsPurch[2], Integer.valueOf(columnsPurch[3]), columnsPurch[4],
                        customers.findOne(Integer.valueOf(columnsPurch[0]))); //except take customer id in purchases and use that
                // as id to find that customer in the customer repo -- put that customer object into purchase object
                purchases.save(purchaseObject);
            }
        }

    }

}



