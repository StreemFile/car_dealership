package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Automobile
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|14:03
 * @Version Automobile: 1.0
 */
@Schema(description = "Об'єкт автомобіля")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Automobile {
    @Schema(description = "ID автомобіля", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Тип кузова")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private VehicleType vehicleType;
    @Schema(description = "Країна виробник")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private ProducingCountry exportedFrom;
    @Schema(description = "Марка")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private Make make;
    @Schema(description = "Модель")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private ModelAndPackage modelAndPackage;
    @Schema(description = "Привід")
    private String drive;
    @Schema(description = "Характеристики мотору")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private Engine engine;
    @Schema(description = "Зовнішній колір")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private ExteriorColor exteriorColor;
    @Schema(description = "Парковочні сенсори")
    @Singular private List<String> parkingSensors;
    @Schema(description = "Засоби безпеки")
    @Singular private List<String> securities;
    @Schema(description = "Тип фар")
    private String headlightsType;
    @Schema(description = "Тип коліс")
    @Singular private List<String> tyresAndWheels;
    @Schema(description = "Кількість дверей", example = "5")
    private int numberOfDoors;
    @Schema(description = "Внутрішній колір")
    @Relationship(type = "CAR_COMPONENT", direction = INCOMING)
    private InteriorColor interiorColor;
    @Schema(description = "Матеріал салон")
    private String interiorMaterial;
    @Schema(description = "Засоби комфорту в салоні ")
    @Singular private List<String> interiorFeatures;
    @Schema(description = "Кількість місць", example = "5")
    private int numberOfSeats;
    @Schema(description = "Особливості автомобіля (люк, панорама і тд)", example = "5")
    @Singular private List<String> extras;
    @Schema(description = "Пробіг", example = "237200")
    private int mileage;
    @Schema(description = "Рік випуску", example = "2015")
    private int manufactureYear;
    @Schema(description = "VIN-код", example = "5")
    private String vin;
    @Schema(description = "Наявність", example = "sold")
    private String availability;
    @Schema(description = "Закупна ціна", example = "15000")
    private int actualPrice;
    @Schema(description = "Очікувана ціна продажі", example = "20000")
    private int expectedSellingPrice;
    @Schema(description = "Автосалон, в якому налічується даний автомобіль", example = "5")
    @Relationship(type = "CAR_DEALERSHIP", direction = INCOMING)
    private Dealership dealership;
    @Schema(description = "Короткий опис")
    private String title;
    @Schema(description = "Детальний опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
