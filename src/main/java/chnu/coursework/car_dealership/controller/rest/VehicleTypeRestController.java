package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.VehicleType;
import chnu.coursework.car_dealership.service.vehicleType.impls.VehicleTypeServiceImpl;
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
 * car_dealership.VehicleTypeRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version VehicleTypeRestController: 1.0
 */
@Tag(name = "VehicleType",
        description = "Відповідає за керування даними колекції VehicleType")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/vehicleTypes")
public class VehicleTypeRestController {
    @Autowired
    VehicleTypeServiceImpl service;


    @Operation(
            summary = "Вивід всіх типів кузова",
            description = "Виводить всю інформацію про всі існуючі типи кузовів"
    )
    @GetMapping
    public List<VehicleType> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід кузова по id",
            description = "Виводить всю інформацію про шуканий кузов"
    )
    @GetMapping("/get/{id}")
    public VehicleType getById(@PathVariable("id")
                                 @Parameter(description = "ID кузова")
                                         String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення кузова по id",
            description = "Видаляє заданий кузов"
    )
    @GetMapping("/delete/{id}")
    public VehicleType delete(@PathVariable("id")
                                @Parameter(description = "ID кузова")
                                        String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового кузова",
            description = "Створює новий кузов"
    )
    @PostMapping("/create")
    public VehicleType create(@RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового кузову")
                                        VehicleType vehicleType){
        vehicleType.setId(UUID.randomUUID().toString());
        vehicleType.setCreated_at(LocalDateTime.now());
        return service.create(vehicleType);
    }

    @Operation(
            summary = "Редагування кузова",
            description = "Шукає кузов по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public VehicleType update(@PathVariable
                                @Parameter(description = "ID кузова")
                                        String id,
                                @RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого кузова")
                                        VehicleType vehicleType){
        vehicleType.setCreated_at(service.getById(id).getCreated_at());
        return service.update(vehicleType);
    }
}
