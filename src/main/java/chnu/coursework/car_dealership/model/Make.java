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
 * car_dealership.Make
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:17
 * @Version Make: 1.0
 */
@Schema(description = "Об'єкт марки")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Make {
    @Schema(description = "ID марки", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Марка", example = "Volkswagen")
    private String name;
    @Schema(description = "description")
    private String description;
    @Schema(description = "Дата створення об'єтку", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
