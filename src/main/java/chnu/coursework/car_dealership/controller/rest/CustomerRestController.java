package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CustomerRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version CustomerRestController: 1.0
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerServiceImpl service;

    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Customer getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public Customer delete(@PathVariable("id") String id){
         return service.delete(service.getById(id));
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return service.create(customer);
    }

    @PostMapping("/update")
        public Customer update(@RequestBody Customer customer){
            return service.update(customer);
        }
    }


