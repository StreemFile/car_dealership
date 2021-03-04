package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.VehicleType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeVehicleType
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakeVehicleType: 1.0
 */
@Repository
public class FakeVehicleType {
    private List<VehicleType> vehicleTypes = new ArrayList<>(
            Arrays.asList(
                    new VehicleType(UUID.randomUUID().toString(), "Універсал",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Седан",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Хетчбек",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Позашляховик/Кросовер",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Купе",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Кабріолет",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Мінівен",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Пікап",
                            "", LocalDateTime.now(),null),
                    new VehicleType(UUID.randomUUID().toString(), "Лімузин",
                            "", LocalDateTime.now(),null)
            )
    );

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
