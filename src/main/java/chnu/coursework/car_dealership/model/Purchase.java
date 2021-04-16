package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Entity
public class Purchase {
    @Schema(description = "ID продажі", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Проданий автомобіль")
    @ManyToOne
    private Automobile automobile;
    @Schema(description = "Покупець")
    @ManyToOne
    private Customer customer;
    @Schema(description = "Працівник, що продав")
    @ManyToOne
    private Employee employee;
    @Schema(description = "Дата продажі", example = "2021-28-03")
    private LocalDate purchaseDate;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
