package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by emileenmarianayagam on 1/19/17.
 */

@Controller
public class PurchasesController {

    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){


        return "home";
    }


    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) {
           File f = new File("customers.csv");
           Scanner fileScanner = new Scanner(f);
           while(fileScanner.hasNext()){
               String line = fileScanner.nextLine();
               String [] columns = line.split(",");
               Customer newCustomer = new Customer(columns[0],columns[1]);
               customers.save(newCustomer);
           }
        }

        if(purchases.count() == 0){
            File f = new File ("purchases.csv");
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String [] columns = line.split(",");
                Purchase newPurchase = new Purchase(columns[1],(columns[2]), Integer.valueOf(columns[3]),
                        columns[4]);
                purchases.save(newPurchase);
            }
        }
    }




}
