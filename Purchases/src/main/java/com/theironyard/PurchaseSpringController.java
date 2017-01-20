package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by graceconnelly on 1/19/17.
 */
@Controller
public class PurchaseSpringController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init() {
        if (customers.count() == 0) {
            try {
                File csvCustomers = new File("customer.csv");
                Scanner fileScanner = new Scanner(csvCustomers);

                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    String[] columns = line.split(",");
                    Customer customer = new Customer();
                    customer.name = columns[0];
                    customer.email = columns[1];
                    customers.save(customer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (purchases.count() == 0) {
            try {
                File csvPurchases = new File("purchases.csv");
                Scanner fileScanner = new Scanner(csvPurchases);

                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    String[] columns = line.split(",");
                    Purchase purchase = new Purchase();
                    purchase.customer = customers.findById(Integer.valueOf(columns[0]));
                    purchase.date = columns[1];
                    purchase.credit_card = columns[2];
                    purchase.cvv = columns[3];
                    purchase.category = columns[4];
                    purchases.save(purchase);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Purchase> purchaseList;
        purchaseList = (List)purchases.findAll();

        model.addAttribute("purchased", purchaseList);
        return "home";
    }
}