package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Company
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:09
 * @Version Company: 1.0
 */
@Schema(description = "Об'єкт компанії")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Company {
    @Schema(description = "ID компанії", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Назва компанії", example = "SomeName")
    private String name;
    @Schema(description = "Електронна пошта", example = "my.email@gmail.com")
    private String email;
    @Schema(description = "Номер телефону головного офісу", example = "+380996088364")
    private String telephoneOfTheMainOffice;
    @Schema(description = "Місто головного офісу", example = "Чернівці")
    private String cityOfTheMainOffice;
    @Schema(description = "Адрес головного офісу", example = "Головна 12")
    private String addressOfTheMainOffice;
    @Schema(description = "description")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
