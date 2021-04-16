package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ProducingCountry
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:26
 * @Version ProducingCountry: 1.0
 */
@Schema(description = "Об'єкт країни-виробника")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProducingCountry {
    @Schema(description = "ID країни", accessMode = Schema.AccessMode.READ_ONLY)

    @Id
    private String id;
    @Schema(description = "Країна", example = "Німеччина")
    private String country;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
