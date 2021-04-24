package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.AutomobileInOrder
 *
 * @Autor: vovamv
 * @DateTime: 21.04.2021|20:11
 * @Version AutomobileInOrder: 1.0
 */

@Schema(description = "Об'єкт автомобіля, який замовлений")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class AutomobileInOrder {
    @Schema(description = "ID замовлення")
    @Id
    private String id;
    @Schema(description = "Замовлений автомобіль")
    private Automobile automobile;
    @Schema(description = "Очікувана дата прибуття")
    private LocalDate expectedArrivalDate;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку")
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку")
    private LocalDateTime modified_at;


}
