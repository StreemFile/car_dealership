package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

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
@Node
public class AutomobileInOrder {
    @Schema(description = "ID замовлення", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Замовлений автомобіль")
    @Relationship(type = "ORDERED_CAR", direction = INCOMING)
    private Automobile automobile;
    @Schema(description = "Очікувана дата прибуття")
    private LocalDate expectedArrivalDate;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;


}
