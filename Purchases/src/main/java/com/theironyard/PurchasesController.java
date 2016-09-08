package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by charlesrath on 9/7/16.
 */
@Controller
public class PurchasesController {

    @Autowired
    CustomersRepository customers;

    @Autowired
    PurchasesRepository purchases;

    @PostConstruct
    public void init() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        if(customers.count() == 0) {
            Scanner scanner = new Scanner(new File("customers.csv"));
            //scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(",");
                String name = values[0];
                String email = values[1];

                if (name.equals("name") && email.equals("email")) {
                    continue;
                }

                Customer customer = new Customer(name, email);
                customers.save(customer);
            }
        }
        if(purchases.count() == 0) {
            Scanner scanner = new Scanner(new File("purchases.csv"));
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(",");

                if (values[0].equals("customer_id")) {
                    continue;
                }
                Integer customer_id = Integer.valueOf(values[0]);
                //Date date = Date.valueOf(values[1]);
                String[] dateSplit = values[1].split("T");
                String dateSanitized = dateSplit[0]+" "+dateSplit[1];
                Date date = dateFormat.parse(dateSanitized);
                String creditCard = values[2];
                String cvv = values[3];
                String category = values[4];

                Customer customer = customers.getOne(customer_id);

                Purchase purchase = new Purchase(date, creditCard, cvv, category, customer);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {

        if(category == null || category.equalsIgnoreCase("All")){
            model.addAttribute("purchases", purchases.findAll());
        }
        else {
            model.addAttribute("purchases", purchases.findByCategory(category));
        }

        model.addAttribute("categories", purchases.getAllCategories());

        return "home";
    }
}
