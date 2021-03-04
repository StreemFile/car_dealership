package chnu.coursework.car_dealership.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Automobile {
    @Id
    private String id;
    private VehicleType vehicleType;
    private ProducingCountry producingCountry;
    private Make make;
    private ModelAndPackage modelAndPackage;
    private String drive;
    private Engine engine;
    private ExteriorColor exteriorColor;
    @Singular private List<String> parkingSensors;
    @Singular private List<String> securities;
    private String headlightsType;
    @Singular private List<String> tyresAndWheels;
    private int numberOfDoors;
    private InteriorColor interiorColor;
    private String interiorMaterial;
    @Singular private List<String> interiorFeatures;
    private int numberOfSeats;
    @Singular private List<String> extras;
    private String vin;
    private String availability;
    private int price;
    private Dealership dealership;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
