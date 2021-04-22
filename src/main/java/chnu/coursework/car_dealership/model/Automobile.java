package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

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
@Entity
public class Automobile {
    @Schema(description = "ID автомобіля", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "Тип кузова")
    @ManyToOne
    private VehicleType vehicleType;
    @Schema(description = "Країна виробник")
    @ManyToOne
    private ProducingCountry producingCountry;
    @Schema(description = "Марка")
    @ManyToOne
    private Make make;
    @Schema(description = "Модель")
    @ManyToOne
    private ModelAndPackage modelAndPackage;
    @Schema(description = "Привід")
    private String drive;
    @Schema(description = "Характеристики мотору")
    @ManyToOne
    private Engine engine;
    @Schema(description = "Зовнішній колір")
    @ManyToOne
    private ExteriorColor exteriorColor;
    @Schema(description = "Парковочні сенсори")
    @ElementCollection
    @Singular private List<String> parkingSensors;
    @Schema(description = "Засоби безпеки")
    @ElementCollection
    @Singular private List<String> securities;
    @Schema(description = "Тип фар")
    private String headlightsType;
    @Schema(description = "Тип коліс")
    @ElementCollection
    @Singular private List<String> tyresAndWheels;
    @Schema(description = "Кількість дверей", example = "5")
    private int numberOfDoors;
    @Schema(description = "Внутрішній колір")
    @ManyToOne
    private InteriorColor interiorColor;
    @Schema(description = "Матеріал салон")
    private String interiorMaterial;
    @Schema(description = "Засоби комфорту в салоні ")
    @ElementCollection
    @Singular private List<String> interiorFeatures;
    @Schema(description = "Кількість місць", example = "5")
    private int numberOfSeats;
    @Schema(description = "Особливості автомобіля (люк, панорама і тд)", example = "5")
    @ElementCollection
    @Singular private List<String> extras;
    @Schema(description = "VIN-код", example = "5")
    private String vin;
    @Schema(description = "Наявність", example = "5")
    private String availability;
    @Schema(description = "Ціна", example = "5")
    private int price;
    @Schema(description = "Автосалон, в якому налічується даний автомобіль", example = "5")
    @ManyToOne
    private Dealership dealership;
    @Schema(description = "Опис")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;
}
