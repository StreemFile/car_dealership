package chnu.coursework.car_dealership.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.SoldMake
 *
 * @Autor: vovamv
 * @DateTime: 28.05.2021|10:35
 * @Version SoldMake: 1.0
 */

@Data
@AllArgsConstructor
public class SoldMake {
    String make;
    Long count;
}
