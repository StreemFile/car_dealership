package chnu.coursework.car_dealership.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Engine
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:20
 * @Version Engine: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Engine {
    private String fuelType;
    private String transmissionType;
    private int cubicCapacity;
    private int powerKW;
    private int powerPS;
    private String description;
}