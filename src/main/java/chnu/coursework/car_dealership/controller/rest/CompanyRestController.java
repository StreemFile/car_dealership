package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Company;
import chnu.coursework.car_dealership.service.company.impls.CompanyServiceImpl;
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
 * car_dealership.CompanyRestController
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:30
 * @Version CompanyRestController: 1.0
 */

@Tag(name = "Company",
        description = "Відповідає за керування даними колекції Company")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/company")
public class CompanyRestController {

    @Autowired
    CompanyServiceImpl service;

    @Operation(
            summary = "Вивід компаній",
            description = "Виводить всю інформацію про всі існуючі компанії"
    )
    @GetMapping
    public List<Company> getAll() {
        return service.getAll();
    }

    @Operation(
            summary = "Вивід компанії по id",
            description = "Виводить всю інформацію про шукану компанію"
    )
    @GetMapping("/get/{id}")
    public Company getById(@PathVariable("id") @Parameter(description = "ID компанії") String id) {
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення компанії по id",
            description = "Видаляє задану компанію"
    )
    @GetMapping("/delete/{id}")
    public Company delete(@PathVariable("id") @Parameter(description = "ID компанії") String id) {
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нової компанії",
            description = "Створює нову компанію"
    )
    @PostMapping("/create")
    public Company create(@RequestBody
                              @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нової компанії")
                                      Company company) {
        company.setId(UUID.randomUUID().toString());
        company.setCreated_at(LocalDateTime.now());
        company.setModified_at(LocalDateTime.now());
        return service.create(company);
    }

    @Operation(
            summary = "Редагування компанії",
            description = "Шукає компанію по id та надає їй оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Company update(@PathVariable
                          @Parameter(description = "ID компанії")
                                      String id,
                          @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані зміненої компанії")
                          @RequestBody
                                  Company company) {
        company.setId(service.getById(id).getId());
        company.setCreated_at(service.getById(id).getCreated_at());
        return service.update(company);
    }
}


