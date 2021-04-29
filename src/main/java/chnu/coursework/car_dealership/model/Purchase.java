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
 * car_dealership.Purchase
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|14:18
 * @Version Purchase: 1.0
 */

@Schema(description = "Об'єкт продажі")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Purchase {
    @Schema(description = "ID продажі", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Проданий автомобіль")
    @Relationship(type = "SOLED_CAR", direction = INCOMING)
    private Automobile automobile;
    @Schema(description = "Покупець")
    @Relationship(type = "BUYER", direction = INCOMING)
    private Customer customer;
    @Schema(description = "Працівник, що продав")
    @Relationship(type = "SELLER", direction = INCOMING)
    private Employee employee;
    @Schema(description = "Ціна продажі")
    private int soldPrice;
    @Schema(description = "Дата продажі", example = "2021-28-03")
    private LocalDate purchaseDate;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
