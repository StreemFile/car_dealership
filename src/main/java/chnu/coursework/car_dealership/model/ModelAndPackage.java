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
 * car_dealership.ModelAndPackage
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|13:59
 * @Version ModelAndPackage: 1.0
 */
@Schema(description = "Об'єкт моделі автомобіля")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ModelAndPackage {
    @Schema(description = "ID моделі", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Модель", example = "Touran")
    private String model;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
