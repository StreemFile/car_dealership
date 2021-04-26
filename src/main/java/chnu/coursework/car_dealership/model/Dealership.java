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
 * car_dealership.Dealership
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:11
 * @Version Dealership: 1.0
 */
@Schema(description = "Об'єкт автосалону")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Dealership {
    @Schema(description = "ID автосалону", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Місто розташування", example = "Київ")
    private String city;
    @Schema(description = "Місто розташування англійською", example = "Kyiv")
    private String cityEnglish;
    @Schema(description = "Адрес розташування", example = "Головна 12")
    private String address;
    @Schema(description = "Номер телефону", example = "+380503748394")
    private String telephone;
    @Schema(description = "Компанія, яка володіє автосалоном")
    private Company company;
    @Schema(description = "description")
    private String description;
    @Schema(description = "Дата створення об'єтку", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;

}
