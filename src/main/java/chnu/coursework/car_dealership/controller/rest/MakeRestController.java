package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Make;
import chnu.coursework.car_dealership.service.make.impls.MakeServiceImpl;
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
 * car_dealership.MakeRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version MakeRestController: 1.0
 */

@Tag(name = "Make",
        description = "Відповідає за керування даними колекції Make")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/makes")
public class MakeRestController {

    @Autowired
    MakeServiceImpl service;
    @Operation(
            summary = "Вивід марок",
            description = "Виводить всю інформацію про всі коли-небудь" +
                    " продаваємі марки"
    )
    @GetMapping
    public List<Make> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід маррку по id",
            description = "Виводить всю інформацію про шукану марку"
    )
    @GetMapping("/get/{id}")
    public Make getById(@PathVariable("id")
                            @Parameter(description = "ID марки")
                                    String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення марки по id",
            description = "Видаляє задану марку"
    )
    @GetMapping("/delete/{id}")
    public Make delete(@PathVariable("id")
                           @Parameter(description = "ID марки")
                                   String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нової марки",
            description = "Створює нову марку"
    )
    @PostMapping("/create")
    public Make create(@RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нової марки")

                                   Make make){
        make.setId(UUID.randomUUID().toString());
        make.setCreated_at(LocalDateTime.now());
        return service.create(make);
    }

    @Operation(
            summary = "Редагування марки",
            description = "Шукає марку по id та надає їй оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Make update(@PathVariable
                           @Parameter(description = "ID марки")
                                   String id,
                       @RequestBody
                       @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованої марки")

                               Make make){
        make.setCreated_at(service.getById(id).getCreated_at());
        make.setId(service.getById(id).getId());
        return service.update(make);
    }

}


