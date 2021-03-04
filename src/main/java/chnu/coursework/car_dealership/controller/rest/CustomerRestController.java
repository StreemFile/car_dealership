package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CustomerRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version CustomerRestController: 1.0
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerServiceImpl service;

    @GetMapping("/api/customers")
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Customer getById(@PathVariable("id") String id){
        return service.getById(id);
    }
}
