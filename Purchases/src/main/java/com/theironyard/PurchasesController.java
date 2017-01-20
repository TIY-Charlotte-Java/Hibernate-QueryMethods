package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kelseynewman on 1/19/17.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init() throws IOException{
        if (customers.count()==0) {
            File file = new File("customers.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] columns = line.split("\\,");
                Customer customer = new Customer(columns[0], columns[1]);
                customers.save(customer);
            }

        }
        if (purchases.count()==0) {
            File file = new File("purchases.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] columns = line.split("\\,");

                Purchase purchase = new Purchase(customers.findById(Integer.valueOf(columns[0])), columns[1], columns[2], Integer.valueOf(columns[3]), columns[4]);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping (path = "/", method = RequestMethod.GET)
    public String home (Model model, String category) {
        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        } else {
            purchaseList = (List)purchases.findAll();
        }

        model.addAttribute("purchaseList", purchaseList);

        return "home";
    }
}
