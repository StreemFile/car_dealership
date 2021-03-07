package chnu.coursework.car_dealership.controller.ui;

import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CustomerUiController
 *
 * @Autor: vovamv
 * @DateTime: 18.02.2021|08:55
 * @Version CustomerUiController: 1.0
 */
@Controller
@RequestMapping("/web/customers")
@CrossOrigin("*")
public class CustomerUiController {

    @Autowired
    CustomerServiceImpl service;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("customers", service.getAll());
        return "customers";
    }
    
    @GetMapping("/getById//")
    public String getById(String id, Model model){
        Customer customer = service.getById(id);
        model.addAttribute("customer", customer);
        return "customerById";
    }

    @GetMapping("/create/")
    public String showCreatePage(Model model){
        return "createCustomer";
    }

    @PostMapping("/create/")
    public String create(@RequestParam String name,
                         @RequestParam String telephone,
                         @RequestParam String placeOfResidence,
                         @RequestParam String address,
                         @RequestParam String passport,
                         @RequestParam String description,
                         Model model){
        Customer customer = new Customer(UUID.randomUUID().toString(), name,
                telephone, placeOfResidence, address, passport, description,
                LocalDateTime.now(), null);
        service.create(customer);
        return "redirect:/web/customers";
    }

    @GetMapping("/edit/{id}")
    public String showCreatePage(@PathVariable String id, Model model){
        model.addAttribute("customer",service.getById(id));
        return "editCustomer";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id,
                         @RequestParam String name,
                         @RequestParam String telephone,
                         @RequestParam String placeOfResidence,
                         @RequestParam String address,
                         @RequestParam String passport,
                         @RequestParam String description,
                         Model model){
        Customer updatedCustomer = Customer.builder()
                .id(id)
                .name(name)
                .telephone(telephone)
                .placeOfResidence(placeOfResidence)
                .address(address)
                .passport(passport)
                .description(description)
                .build();
        service.update(updatedCustomer);
        return "redirect:/web/customers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id,Model model){
        service.delete(service.getById(id));
        return "redirect:/web/customers";
    }
}
