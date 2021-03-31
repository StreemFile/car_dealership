package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.service.customer.impls.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CustomerRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version CustomerRestController: 1.0
 */

@Tag(name = "Customer",
        description = "Відповідає за керування даними колекції Customer")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerServiceImpl service;

    @Operation(
            summary = "Вивід покупців",
            description = "Виводить всю інформацію про всіх існуючих покупців"
    )
    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @Operation(
            summary = "Вивід покупця по id",
            description = "Виводить всю інформацію про шуканого покупця"
    )
    @GetMapping("/get/{id}")
    public Customer getById(@PathVariable("id")
                                @Parameter(description = "ID покупця")
                                        String id) {
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення покупця по id",
            description = "Видаляє заданого покупця"
    )
    @GetMapping("/delete/{id}")
    public Customer delete(@PathVariable("id")
                               @Parameter(description = "ID покупця")
                                       String id) {
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового покупця",
            description = "Створює нового покупця"
    )
    @PostMapping("/create")
    public Customer create(@RequestBody
                               @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового покупця")
                                       Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        customer.setCreated_at(LocalDateTime.now());
        return service.create(customer);
    }

    @Operation(
            summary = "Редагування покупця",
            description = "Шукає покупця по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Customer update(@PathVariable
                               @Parameter(description = "ID покупця")
                                       String id,
                           @RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого покупця")
                                   Customer customer) {
        customer.setCreated_at(service.getById(id).getCreated_at());
        return service.update(customer);
    }
//
//    @GetMapping("/get/byPlaceOfResidence/{name1}/or/{name2}")
//    public List<Customer> getByTwoPlacesOfResidence(@PathVariable String name1, @PathVariable String name2) {
//        return service.getByTwoPlacesOfResidence(name1,name2);
//    }
//    @GetMapping("/get/byPlaceOfResidence/{place}/name/{name}")
//    public List<Customer> getByPlaceOfResidenceAndName(@PathVariable String place, @PathVariable String name) {
//        return service.getByPlaceOfResidenceAndName(place,name);
//    }
//    @GetMapping("/get/byPlaceOfResidence/except/{place}")
//    public List<Customer> getAllExceptFrom(@PathVariable String place) {
//        return service.getAllExceptFrom(place);
//    }

}


