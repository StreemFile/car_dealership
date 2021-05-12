package chnu.coursework.car_dealership.controller.rest;

import chnu.coursework.car_dealership.model.ModelAndPackage;
import chnu.coursework.car_dealership.service.make.impls.MakeServiceImpl;
import chnu.coursework.car_dealership.service.modelAndPackage.impls.ModelAndPackageServiceImpl;
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
 * car_dealership.ModelAndPackageRestController
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:34
 * @Version ModelAndPackageRestController: 1.0
 */
@Tag(name = "ModelAndPackage",
        description = "Відповідає за керування даними колекції ModelAndPackage")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/modelAndPackages")
public class ModelAndPackageRestController {
    @Autowired
    ModelAndPackageServiceImpl service;

    @Autowired
    MakeServiceImpl makeService;


    @Operation(
            summary = "Вивід моделей",
            description = "Виводить всю інформацію про всі існуючі моделі"
    )
    @GetMapping
    public List<ModelAndPackage> getAll(){
        return service.getAll();
    }

    @Operation(
            summary = "Вивід моделі по id",
            description = "Виводить всю інформацію про шукану модель"
    )
    @GetMapping("/get/{id}")
    public ModelAndPackage getById(@PathVariable("id")
                                       @Parameter(description = "ID моделі")
                                               String id){
        return service.getById(id);
    }

    @Operation(
            summary = "Видалення моделі по id",
            description = "Видаляє задану модель"
    )
    @GetMapping("/delete/{id}")
    public ModelAndPackage delete(@PathVariable("id")
                                      @Parameter(description = "ID моделі")
                                              String id){
        return service.delete(service.getById(id));
    }

    @Operation(
            summary = "Створення нової моделі",
            description = "Створює нову модель"
    )
    @PostMapping("/create")
    public ModelAndPackage create(@RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані нової моделі")
                                        ModelAndPackage modelAndPackage){
        modelAndPackage.setId(UUID.randomUUID().toString());
        modelAndPackage.setCreated_at(LocalDateTime.now());
        modelAndPackage.setModified_at(LocalDateTime.now());
        return service.create(modelAndPackage);
    }

    @Operation(
            summary = "Редагування моделі",
            description = "Шукає модель по id та надає їй оновлену інформацію"
    )
    @PostMapping("/edit/{id}")
    public ModelAndPackage update(@PathVariable
                                @Parameter(description = "ID моделі")
                                        String id,
                                @RequestBody
                                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Дані відредагованої моделі")
                                        ModelAndPackage modelAndPackage){
        modelAndPackage.setId(service.getById(id).getId());
        modelAndPackage.setCreated_at(service.getById(id).getCreated_at());
        return service.update(modelAndPackage);
    }
}
