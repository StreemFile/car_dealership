package chnu.coursework.car_dealership.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.TotalSalary
 *
 * @Autor: vovamv
 * @DateTime: 28.05.2021|09:45
 * @Version TotalSalary: 1.0
 */

@Data
@AllArgsConstructor
public class TotalSalary {
    String city;
    Integer totalSalary;
}
