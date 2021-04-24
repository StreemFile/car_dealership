package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Employee
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:15
 * @Version Employee: 1.0
 */
@Schema(description = "Об'єкт працівника")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Employee {
    @Schema(description = "ID працівника")
    @Id
    private String id;
    @Schema(description = "ПІП працівника", example = "Мойсей Володимир Володимирович")
    private String name;
    @Schema(description = "Номер паспорту", example = "000690321")
    private String passport;
    @Schema(description = "Номер телефону", example = "+380996035846")
    private String telephone;
    @Schema(description = "Автосалон, у якому працює")
    private Dealership dealership;
    @Schema(description = "Зарплата", example = "13000")
    private int salary;
    @Schema(description = "description")
    private String description;
    @Schema(description = "Дата створення об'єтку")
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку")
    private LocalDateTime modified_at;
}

