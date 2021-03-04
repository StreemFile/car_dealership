package chnu.coursework.car_dealership.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.VehicleType
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|14:02
 * @Version VehicleType: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class VehicleType {
    @Id
    private String id;
    private String vehicleType;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
