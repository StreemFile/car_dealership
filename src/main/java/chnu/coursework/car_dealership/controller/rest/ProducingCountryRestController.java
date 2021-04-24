package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.ProducingCountry;
import chnu.coursework.car_dealership.service.producingCountry.impls.ProducingCountryServiceImpl;
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
 * car_dealership.ProducingCountryRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version ProducingCountryRestController: 1.0
 */
@Tag(name = "ProducingCountry",
        description = "Відповідає за керування даними колекції ProducingCountry")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/producingCountries")
public class ProducingCountryRestController {
    @Autowired
    ProducingCountryServiceImpl service;


    @Operation(
            summary = "Вивід країн-виробників",
            description = "Виводить всю інформацію про всі існуючі країни-виробники"
    )
    @GetMapping
    public List<ProducingCountry> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід країни по id",
            description = "Виводить всю інформацію про шукану країну"
    )
    @GetMapping("/get/{id}")
    public ProducingCountry getById(@PathVariable("id")
                                 @Parameter(description = "ID країни")
                                         String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення країни по id",
            description = "Видаляє задану країну"
    )
    @GetMapping("/delete/{id}")
    public ProducingCountry delete(@PathVariable("id")
                                @Parameter(description = "ID країни")
                                        String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нової країни",
            description = "Створює нову країну"
    )
    @PostMapping("/create")
    public ProducingCountry create(@RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нової країни")
                                        ProducingCountry producingCountry){
        producingCountry.setId(UUID.randomUUID().toString());
        producingCountry.setCreated_at(LocalDateTime.now());
        return service.create(producingCountry);
    }

    @Operation(
            summary = "Редагування країни",
            description = "Шукає країну по id та надає їй оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public ProducingCountry update(@PathVariable
                                @Parameter(description = "ID країни")
                                        String id,
                                @RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованої країни")
                                        ProducingCountry producingCountry){
        producingCountry.setCreated_at(service.getById(id).getCreated_at());
        producingCountry.setId(service.getById(id).getId());
        return service.update(producingCountry);
    }
}
