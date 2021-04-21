package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.AutomobileInOrder;
import chnu.coursework.car_dealership.service.automobileInOrder.impls.AutomobileInOrderServiceImpl;
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
 * car_dealership.AutomobileInOrderRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version AutomobileInOrderRestController: 1.0
 */
@Tag(name = "AutomobileInOrder",
     description = "Відповідає за керування даними колекції AutomobileInOrder")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/automobileInOrders")
public class AutomobileInOrderRestController {
    @Autowired
    AutomobileInOrderServiceImpl service;


    @Operation(
            summary = "Вивід автомобілів",
            description = "Виводить всю інформацію про всі існуючі автомобілі"
    )
    @GetMapping
    public List<AutomobileInOrder> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід автомобіля по id",
            description = "Виводить всю інформацію про шуканий автомобіль"
    )
    @GetMapping("/get/{id}")
    public AutomobileInOrder getById(@PathVariable("id") @Parameter(description = "ID автомобіля") String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення автомобіля по id",
            description = "Видаляє заданий автомобіль"
    )
    @GetMapping("/delete/{id}")
    public AutomobileInOrder delete(@PathVariable("id") @Parameter(description = "ID автомобіля") String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового автомобіля",
            description = "Створює новий автомобіль"
    )
    @PostMapping("/create")
    public AutomobileInOrder create(@RequestBody
                             @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового автомобіля")
                                     AutomobileInOrder automobileInOrder){
        automobileInOrder.setId(UUID.randomUUID().toString());
        automobileInOrder.setCreated_at(LocalDateTime.now());
        return service.create(automobileInOrder);
    }

    @Operation(
            summary = "Редагування автомобіля",
            description = "Шукає автомобіль по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public AutomobileInOrder update(@PathVariable
                             @Parameter(description = "ID автомобіля")
                                     String id,
                             @RequestBody
                             @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого автомобіля")
                                     AutomobileInOrder automobileInOrder){
        automobileInOrder.setCreated_at(service.getById(id).getCreated_at());
        return service.update(automobileInOrder);
    }
}
