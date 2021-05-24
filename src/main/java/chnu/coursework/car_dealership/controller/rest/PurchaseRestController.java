package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Purchase;
import chnu.coursework.car_dealership.service.purchase.impls.PurchaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.PurchaseRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version PurchaseRestController: 1.0
 */
@Tag(name = "Purchase",
        description = "Відповідає за керування даними колекції Purchase")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/purchases")
public class PurchaseRestController {
    @Autowired
    PurchaseServiceImpl service;


    @Operation(
            summary = "Вивід продаж",
            description = "Виводить всю інформацію про всі продажі"
    )
    @GetMapping
    public List<Purchase> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід продажі по id",
            description = "Виводить всю інформацію про шукану продажу"
    )
    @GetMapping("/get/{id}")
    public Purchase getById(@PathVariable("id")
                                 @Parameter(description = "ID продажі")
                                         String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення продажі по id",
            description = "Видаляє задану продажу"
    )
    @GetMapping("/delete/{id}")
    public Purchase delete(@PathVariable("id")
                                @Parameter(description = "ID продажі")
                                        String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нової продажі",
            description = "Створює нову продажу"
    )
    @PostMapping("/create")
    public Purchase create(@RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нової продажі")
                                        Purchase purchase){
        return service.create(purchase);
    }

    @Operation(
            summary = "Редагування продажі",
            description = "Шукає продажу по id та надає їй оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Purchase update(@PathVariable
                                @Parameter(description = "ID продажі")
                                        String id,
                                @RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованої продажі")
                                        Purchase purchase){
        purchase.setId(service.getById(id).getId());
        purchase.setCreated_at(service.getById(id).getCreated_at());
        return service.update(purchase);
    }
}
