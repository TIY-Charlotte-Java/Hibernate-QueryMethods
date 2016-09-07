package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mfahrner on 9/7/16.
 */
@Controller
public class HibernateQueryMethodsController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository items;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Purchase> itemList = (List)items.findAll();
        List<Customer> customerList = (List)customers.findAll();
        model.addAttribute("purchases", itemList);
        model.addAttribute("customers", customerList);
        return "home";
    }

    @PostConstruct
    public void init() throws IOException {
        if (customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNext()) {

                String line = fileScanner.nextLine();
                String[] columns = line.split(",");

                Customer customer = new Customer(columns[0], columns[1]);
                customers.save(customer);
            }
        }

        if (items.count() == 0) {

            File j = new File("purchases.csv");
            Scanner fileScanner2 = new Scanner(j);

            while (fileScanner2.hasNext()) {

                String line2 = fileScanner2.nextLine();
                String[] columns2 = line2.split(",");
                Integer custId = Integer.valueOf(columns2[0]);

                Purchase purchase = new Purchase(columns2[1], columns2[2], Integer.valueOf(columns2[3]), columns2[4],
                        customers.findOne(custId));
                items.save(purchase);
            }
        }
    }


}
