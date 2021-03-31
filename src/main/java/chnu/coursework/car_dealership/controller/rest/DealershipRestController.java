package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Dealership;
import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
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
 * car_dealership.DealershipRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version DealershipRestController: 1.0
 */

@Tag(name = "Dealership",
        description = "Відповідає за керування даними колекції Dealership")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/dealerships")
public class DealershipRestController {

    @Autowired
    DealershipServiceImpl service;

    @Operation(
            summary = "Вивід автосалонів",
            description = "Виводить всю інформацію про всі існуючі автосалони"
    )
    @GetMapping
    public List<Dealership> getAll() {
        return service.getAll();
    }

    @Operation(
            summary = "Вивід автосалону по id",
            description = "Виводить всю інформацію про шуканий автосалон"
    )
    @GetMapping("/get/{id}")
    public Dealership getById(@PathVariable("id")
                                  @Parameter(description = "ID автосалону")
                                          String id) {
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення автосалону по id",
            description = "Видаляє заданий автосалон"
    )
    @GetMapping("/delete/{id}")
    public Dealership delete(@PathVariable("id")
                                 @Parameter(description = "ID автосалону")
                                         String id) {
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового автосалону",
            description = "Створює нову компанію"
    )
    @PostMapping("/create")
    public Dealership create(@RequestBody
                          @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового автосалону")
                                  Dealership dealership) {
        dealership.setId(UUID.randomUUID().toString());
        dealership.setCreated_at(LocalDateTime.now());
        return service.create(dealership);
    }

    @Operation(
            summary = "Редагування автосалону",
            description = "Шукає автосалон по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Dealership update(@PathVariable
                          @Parameter(description = "ID автосалону")
                                  String id,
                          @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані зміненого автосалону")
                          @RequestBody
                                  Dealership dealership) {
        dealership.setCreated_at(service.getById(id).getCreated_at());
        return service.update(dealership);
    }
}


