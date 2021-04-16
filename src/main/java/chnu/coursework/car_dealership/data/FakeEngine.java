package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.model.Engine;
import chnu.coursework.car_dealership.model.engine.FuelType;
import chnu.coursework.car_dealership.model.engine.TransmissionType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.FakeEngine
 *
 * @Autor: vovamv
 * @DateTime: 16.04.2021|16:05
 * @Version FakeEngine: 1.0
 */

@Repository
public class FakeEngine {
    private List<Engine> engines = new ArrayList<>(
            Arrays.asList(
                    new Engine(UUID.randomUUID().toString(),
                               FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               1968, 110, 150, ""),
                    new Engine(UUID.randomUUID().toString(),
                               FuelType.DIESEL.toString(),
                               TransmissionType.AUTOMATIC.toString(),
                               1968, 140, 190, ""),
                    new Engine(UUID.randomUUID().toString(),
                               FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               1598, 81, 110, ""),
                    new Engine(UUID.randomUUID().toString(),
                               FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               998, 92, 125, "")
                         ));

    public List<Engine> getEngines() {
        return engines;
    }
}
