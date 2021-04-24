package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.InteriorColor;
import chnu.coursework.car_dealership.service.interiorColor.impls.InteriorColorServiceImpl;
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
 * car_dealership.InteriorColorRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version InteriorColorRestController: 1.0
 */
@Tag(name = "InteriorColor",
        description = "Відповідає за керування даними колекції InteriorColor")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/interiorColors")
public class InteriorColorRestController {
    @Autowired
    InteriorColorServiceImpl service;


    @Operation(
            summary = "Вивід кольорів",
            description = "Виводить всю інформацію про всі існуючі кольори"
    )
    @GetMapping
    public List<InteriorColor> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід кольору по id",
            description = "Виводить всю інформацію про шуканий колір"
    )
    @GetMapping("/get/{id}")
    public InteriorColor getById(@PathVariable("id") @Parameter(description = "ID кольору") String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення кольору по id",
            description = "Видаляє заданий колір"
    )
    @GetMapping("/delete/{id}")
    public InteriorColor delete(@PathVariable("id") @Parameter(description = "ID кольору") String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового кольору",
            description = "Створює новий колір"
    )
    @PostMapping("/create")
    public InteriorColor create(@RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового кольору")
                                        InteriorColor interiorColor){
        interiorColor.setId(UUID.randomUUID().toString());
        interiorColor.setCreated_at(LocalDateTime.now());
        return service.create(interiorColor);
    }

    @Operation(
            summary = "Редагування кольору",
            description = "Шукає колір по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public InteriorColor update(@PathVariable
                                @Parameter(description = "ID кольору")
                                        String id,
                                @RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого кольору")
                                        InteriorColor interiorColor){
        interiorColor.setCreated_at(service.getById(id).getCreated_at());
        interiorColor.setId(service.getById(id).getId());
        return service.update(interiorColor);
    }
}
