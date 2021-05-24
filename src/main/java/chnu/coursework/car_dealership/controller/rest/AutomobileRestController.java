package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Automobile;
import chnu.coursework.car_dealership.service.automobile.impls.AutomobileServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.AutomobileRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version AutomobileRestController: 1.0
 */
@Tag(name = "Automobile",
        description = "Відповідає за керування даними колекції Automobile")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/automobiles")
public class AutomobileRestController {
    @Autowired
    AutomobileServiceImpl service;


    @Operation(
            summary = "Вивід автомобілів",
            description = "Виводить всю інформацію про всі існуючі автомобілі"
    )
    @GetMapping
    public List<Automobile> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід автомобіля по id",
            description = "Виводить всю інформацію про шуканий автомобіль"
    )
    @GetMapping("/get/{id}")
    public Automobile getById(@PathVariable("id") @Parameter(description = "ID автомобіля") String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення автомобіля по id",
            description = "Видаляє заданий автомобіль"
    )
    @GetMapping("/delete/{id}")
    public Automobile delete(@PathVariable("id") @Parameter(description = "ID автомобіля") String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового автомобіля",
            description = "Створює новий автомобіль"
    )
    @PostMapping("/create")
    public Automobile create(@RequestBody
                                 @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового автомобіля")
                                         Automobile automobile){
        return service.create(automobile);
    }

    @Operation(
            summary = "Редагування автомобіля",
            description = "Шукає автомобіль по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Automobile update(@PathVariable
                                 @Parameter(description = "ID автомобіля")
                                         String id,
                             @RequestBody
                             @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого автомобіля")
                                     Automobile automobile){
        automobile.setId(service.getById(id).getId());
        automobile.setCreated_at(service.getById(id).getCreated_at());
        return service.update(automobile);
    }

    @GetMapping("/filter/city-is-{city}")
    public List<Automobile> getAllByDealershipCity(@PathVariable String city){
        return service.getAllByDealershipCity(city);
    }

//    @GetMapping("/get/make/volkswagen/seats/seven/minMaxAvg")
//    public Object getVolkswagenWithSevenSeatsMinMaxAvgPrice(){
//        return service.getVolkswagenWithSevenSeatsMinMaxAvgPrice();
//    }
//
//    @GetMapping("/get/make/volkswagen/transmission/gearbox/cubicCapacity/min1600")
//    public Object getVolkswagenGearboxMin1600CubicCapacity(){
//        return service.getVolkswagenGearboxMin1600CubicCapacity();
//    }


}
