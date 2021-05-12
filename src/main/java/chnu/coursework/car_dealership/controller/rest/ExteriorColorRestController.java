package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.ExteriorColor;
import chnu.coursework.car_dealership.service.exteriorColor.impls.ExteriorColorServiceImpl;
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
 * car_dealership.ExteriorColorRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version ExteriorColorRestController: 1.0
 */
@Tag(name = "ExteriorColor",
        description = "Відповідає за керування даними колекції ExteriorColor")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/exteriorColors")
public class ExteriorColorRestController {
    @Autowired
    ExteriorColorServiceImpl service;


    @Operation(
            summary = "Вивід кольорів",
            description = "Виводить всю інформацію про всі існуючі кольори"
    )
    @GetMapping
    public List<ExteriorColor> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід кольору по id",
            description = "Виводить всю інформацію про шуканий колір"
    )
    @GetMapping("/get/{id}")
    public ExteriorColor getById(@PathVariable("id")
                                     @Parameter(description = "ID кольору")
                                             String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення кольору по id",
            description = "Видаляє заданий колір"
    )
    @GetMapping("/delete/{id}")
    public ExteriorColor delete(@PathVariable("id")
                                    @Parameter(description = "ID кольору")
                                            String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового кольору",
            description = "Створює новий колір"
    )
    @PostMapping("/create")
    public ExteriorColor create(@RequestBody
                             @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового кольору")
                                     ExteriorColor exteriorColor){
        exteriorColor.setId(UUID.randomUUID().toString());
        exteriorColor.setCreated_at(LocalDateTime.now());
        exteriorColor.setModified_at(LocalDateTime.now());
        return service.create(exteriorColor);
    }

    @Operation(
            summary = "Редагування кольору",
            description = "Шукає колір по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public ExteriorColor update(@PathVariable
                             @Parameter(description = "ID кольору")
                                     String id,
                             @RequestBody
                             @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованого кольору")
                                     ExteriorColor exteriorColor){
        exteriorColor.setId(service.getById(id).getId());
        exteriorColor.setCreated_at(service.getById(id).getCreated_at());
        return service.update(exteriorColor);
    }
}
