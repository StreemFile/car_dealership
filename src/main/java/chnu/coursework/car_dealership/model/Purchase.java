package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Purchase {
    @Schema(description = "ID продажі", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @EqualsAndHashCode.Include()
    private String id;
    @Schema(description = "Проданий автомобіль")
    @DBRef
    private Automobile automobile;
    @Schema(description = "Покупець")
    private Customer customer;
    @Schema(description = "Працівник, що продав")
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
