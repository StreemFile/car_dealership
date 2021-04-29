package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Engine;
import chnu.coursework.car_dealership.model.engine.FuelType;
import chnu.coursework.car_dealership.model.engine.TransmissionType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.FakeEngine
 *
 * @Autor: vovamv
 * @DateTime: 28.04.2021|10:16
 * @Version FakeEngine: 1.0
 */

@Repository
public class FakeEngine {
    private List<Engine> engines = new ArrayList<>(
            Arrays.asList(
                    new Engine(UUID.randomUUID().toString(), FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               1968, 110, 150, "",
                               LocalDateTime.now(), LocalDateTime.now()),
                    new Engine(UUID.randomUUID().toString(), FuelType.DIESEL.toString(),
                               TransmissionType.AUTOMATIC.toString(),
                               1968, 140, 190, "",
                               LocalDateTime.now(), LocalDateTime.now()),
                    new Engine(UUID.randomUUID().toString(), FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               1598, 81, 110, "",
                               LocalDateTime.now(), LocalDateTime.now()),
                    new Engine(UUID.randomUUID().toString(), FuelType.DIESEL.toString(),
                               TransmissionType.MANUAL_GEARBOX.toString(),
                               998, 92, 125, "",
                               LocalDateTime.now(), LocalDateTime.now())
                         )
    );

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }
}
