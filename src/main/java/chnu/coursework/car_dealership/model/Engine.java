package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Engine
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:20
 * @Version Engine: 1.0
 */

@Schema(description = "Об'єкт мотору")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Engine {
    @Id
    private String id;
    @Schema(description = "Тип топлива", example = "Дизель")
    private String fuelType;
    @Schema(description = "Коробка передач", example = "Автомат")
    private String transmissionType;
    @Schema(description = "Об'єм двигуна", example = "1968")
    private int cubicCapacity;
    @Schema(description = "Кількість кіловат", example = "140")
    private int powerKW;
    @Schema(description = "Кількість кінських сил", example = "190")
    private int powerPS;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private String description;
    @Schema(description = "Дата створення об'єтку", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;


}