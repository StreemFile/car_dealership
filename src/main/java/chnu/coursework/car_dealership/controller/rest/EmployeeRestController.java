package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.service.employee.impls.EmployeeServiceImpl;
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
 * car_dealership.EmployeeRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:06
 * @Version EmployeeRestController: 1.0
 */
@Tag(name = "Employee",
        description = "Відповідає за керування даними колекції Employee")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    EmployeeServiceImpl service;

    @Operation(
            summary = "Вивід працівників",
            description = "Виводить всю інформацію про всіх працівників"
    )
    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }


    @Operation(
            summary = "Вивід працівника по id",
            description = "Виводить всю інформацію про шуканого працівника"
    )
    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable("id")
                                @Parameter(description = "ID працівника")
                                        String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення працівника по id",
            description = "Видаляє заданого працівника"
    )
    @GetMapping("/delete/{id}")
    public Employee delete(@PathVariable("id")
                               @Parameter(description = "ID працівника")
                                       String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нового працівника",
            description = "Створює нового працівника"
    )
    @PostMapping("/create")
    public Employee create(@RequestBody
                               @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нового працівника")
                                       Employee employee){
        employee.setId(UUID.randomUUID().toString());
        employee.setCreated_at(LocalDateTime.now());
        return service.create(employee);
    }

    @Operation(
            summary = "Редагування працівника",
            description = "Шукає працівника по id та надає йому оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public Employee update(@PathVariable
                               @Parameter(description = "ID працівника")
                                       String id,
                           @RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані зміненого працівника")
                                   Employee employee){
        employee.setId(service.getById(id).getId());
        employee.setCreated_at(service.getById(id).getCreated_at());
        return service.update(employee);
    }
}
