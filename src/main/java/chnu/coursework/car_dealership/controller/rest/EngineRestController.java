package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Engine;
import chnu.coursework.car_dealership.service.engine.impls.EngineServiceImpl;
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
 * car_dealership.EngineRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:06
 * @Version EngineRestController: 1.0
 */
@Tag(name = "Engine",
     description = "Відповідає за керування даними колекції Engine")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/engines")
public class EngineRestController {

    @Autowired
    EngineServiceImpl service;

    @Operation(
            summary = "Вивід моторів",
            description = "Виводить всю інформацію про всі мотори"
    )
    @GetMapping
    public List<Engine> getAll(){
        return service.getAll();
    }


    @Operation(
            summary = "Вивід мотора по id",
            description = "Виводить всю інформацію про шуканого мотора"
    )
    @GetMapping("/get/{id}")
    public Engine getById(@PathVariable("id")
                            @Parameter(description = "ID мотора")
                                    String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення мотора по id",
            description = "Видаляє заданий мотор"
    )
    @GetMapping("/delete/{id}")
    public Engine delete(@PathVariable("id")
                           @Parameter(description = "ID мотора")
                                   String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового мотора",
            description = "Створює новий мотор"
    )
    @PostMapping("/create")
    public Engine create(@RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового мотора")
                                   Engine engine){
        engine.setId(UUID.randomUUID().toString());
        engine.setCreated_at(LocalDateTime.now());
        return service.create(engine);
    }

    @Operation(
            summary = "Редагування мотора",
            description = "Шукає мотор по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Engine update(@PathVariable
                           @Parameter(description = "ID мотора")
                                   String id,
                           @RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані зміненого мотора")
                                   Engine engine){
        engine.setCreated_at(service.getById(id).getCreated_at());
        return service.update(engine);
    }

}
