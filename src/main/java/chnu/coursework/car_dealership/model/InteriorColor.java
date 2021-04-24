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
 * car_dealership.InteriorColor
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|13:57
 * @Version InteriorColor: 1.0
 */

@Schema(description = "Об'єкт внутрішнього кольору")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class InteriorColor {
    @Schema(description = "ID кольору")
    @Id
    private String id;
    @Schema(description = "Колір", example = "Червоний")
    private String interiorColor;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку")
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку")
    private LocalDateTime modified_at;
}
