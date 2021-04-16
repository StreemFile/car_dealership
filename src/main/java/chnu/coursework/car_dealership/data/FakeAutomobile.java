package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.*;
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
 * car_dealership.FakeAutomobile
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|21:26
 * @Version FakeAutomobile: 1.0
 */
@Repository
public class FakeAutomobile {
    private List<Automobile> automobiles = new ArrayList<>(
            Arrays.asList(
                    Automobile.builder()
                              .id(UUID.randomUUID().toString())
                              .vehicleType(null)
                              .producingCountry(null)
                              .make(null)
                              .modelAndPackage(null)
                              .drive(Drive.FRONT_WHEEL_DRIVE.toString())
                              .engine(null)
                              .exteriorColor(null)
                              .parkingSensors(
                                      Arrays.asList(
                                              ParkingSensor.FRONT.toString(),
                                              ParkingSensor.REAR.toString()))
                              .securities(
                                      Arrays.asList(
                                              Security.ABS.toString(),
                                              Security.ISOFIX.toString(),
                                              Security.ESP.toString(),
                                              Security.DISTANCE_WARNING_SYSTEM.toString(),
                                              Security.TYRE_PRESSURE_MONITORING.toString(),
                                              Security.SPEED_LIMIT_CONTROL_SYSTEM.toString(),
                                              Security.TRACTION_CONTROL.toString(),
                                              Security.SPARE_TYRE.toString(),
                                              Security.ADAPTIVE_CRUISE_CONTROL.toString()
                                                   ))
                              .headlightsType(HeadlightsType.XENON.toString())
                              .tyresAndWheel(TyresAndWheels.ALLOY_SUMMER.toString())
                              .numberOfDoors(5)
                              .numberOfSeats(5)
                              .interiorColor(null)
                              .interiorMaterial(InteriorMaterial.CLOTH.toString())
                              .interiorFeatures(
                                      Arrays.asList(
                                              InteriorFeature.BLUETOOTH.toString(),
                                              InteriorFeature.AMBIENT_LIGHTING.toString(),
                                              InteriorFeature.ARM_REST.toString(),
                                              InteriorFeature.CD_PLAYER.toString(),
                                              InteriorFeature.ELECTRIC_FRONT_WINDOWS.toString(),
                                              InteriorFeature.ELECTRIC_REAR_WINDOWS.toString(),
                                              InteriorFeature.ELECTRIC_HEATED_FRONT_SEATS.toString(),
                                              InteriorFeature.ELECTRIC_SIDE_MIRROR.toString(),
                                              InteriorFeature.HEATED_SIDE_MIRROR.toString(),
                                              InteriorFeature.LEATHER_STEERING_WHEEL.toString(),
                                              InteriorFeature.MULTIFUNCTION_STEERING_WHEEL.toString(),
                                              InteriorFeature.NAVIGATION_SYSTEM.toString(),
                                              InteriorFeature.PADDLE_SHIFTERS.toString(),
                                              InteriorFeature.START_STOP_SYSTEM.toString(),
                                              InteriorFeature.RAIN_SENSOR.toString(),
                                              InteriorFeature.TOUCHSCREEN.toString()
                                                   ))
                              .numberOfSeats(5)
                              .extra(Extra.PANORAMIC_ROOF.toString())
                              .vin("VIN-CODE")
                              .availability(AutomobileAvailability.IN_STOCK.toString())
                              .price(25000)
                              .dealership(null)
                              .description("")
                              .created_at(LocalDateTime.now())
                              .modified_at(null)
                              .build(),

                    Automobile.builder()
                              .id(UUID.randomUUID().toString())
                              .vehicleType(null)
                              .producingCountry(null)
                              .make(null)
                              .modelAndPackage(null)
                              .drive(Drive.FRONT_WHEEL_DRIVE.toString())
                              .engine(null)
                              .exteriorColor(null)
                              .parkingSensors(
                                      Arrays.asList(ParkingSensor.FRONT.toString(),
                                                    ParkingSensor.REAR.toString()))
                              .securities(
                                      Arrays.asList(Security.ABS.toString(),
                                                    Security.ISOFIX.toString(),
                                                    Security.ESP.toString(),
                                                    Security.DISTANCE_WARNING_SYSTEM.toString(),
                                                    Security.TYRE_PRESSURE_MONITORING.toString(),
                                                    Security.SPEED_LIMIT_CONTROL_SYSTEM.toString(),
                                                    Security.TRACTION_CONTROL.toString(),
                                                    Security.SPARE_TYRE.toString(),
                                                    Security.ADAPTIVE_CRUISE_CONTROL.toString()
                                                   ))
                              .headlightsType(HeadlightsType.BIXENON.toString())
                              .tyresAndWheel(TyresAndWheels.ALLOY_SUMMER.toString())
                              .tyresAndWheel(TyresAndWheels.ALLOY_WINTER.toString())
                              .numberOfDoors(5)
                              .numberOfSeats(5)
                              .interiorColor(null)
                              .interiorMaterial(InteriorMaterial.ALCANTARA.toString())
                              .interiorFeatures(
                                      Arrays.asList(
                                              InteriorFeature.BLUETOOTH.toString(),
                                              InteriorFeature.AMBIENT_LIGHTING.toString(),
                                              InteriorFeature.ARM_REST.toString(),
                                              InteriorFeature.CD_PLAYER.toString(),
                                              InteriorFeature.ELECTRIC_FRONT_WINDOWS.toString(),
                                              InteriorFeature.ELECTRIC_REAR_WINDOWS.toString(),
                                              InteriorFeature.ELECTRIC_HEATED_FRONT_SEATS.toString(),
                                              InteriorFeature.ELECTRIC_SIDE_MIRROR.toString(),
                                              InteriorFeature.HEATED_SIDE_MIRROR.toString(),
                                              InteriorFeature.LEATHER_STEERING_WHEEL.toString(),
                                              InteriorFeature.MULTIFUNCTION_STEERING_WHEEL.toString(),
                                              InteriorFeature.NAVIGATION_SYSTEM.toString(),
                                              InteriorFeature.START_STOP_SYSTEM.toString(),
                                              InteriorFeature.RAIN_SENSOR.toString(),
                                              InteriorFeature.TOUCHSCREEN.toString()
                                                   ))
                              .numberOfSeats(5)
                              .extra(Extra.PANORAMIC_ROOF.toString())
                              .vin("VIN-CODE")
                              .availability(AutomobileAvailability.IN_STOCK.toString())
                              .price(33400)
                              .dealership(null)
                              .description("")
                              .created_at(LocalDateTime.now())
                              .modified_at(null)
                              .build(),

                    Automobile.builder()
                              .id(UUID.randomUUID().toString())
                              .vehicleType(null)
                              .producingCountry(null)
                              .make(null)
                              .modelAndPackage(null)
                              .drive(Drive.FRONT_WHEEL_DRIVE.toString())
                              .engine(null)
                              .exteriorColor(null)
                              .parkingSensors(Arrays.asList(ParkingSensor.REAR.toString()))
                              .securities(
                                      Arrays.asList(
                                              Security.ABS.toString(),
                                              Security.ISOFIX.toString(),
                                              Security.ESP.toString(),
                                              Security.TYRE_PRESSURE_MONITORING.toString(),
                                              Security.TRACTION_CONTROL.toString(),
                                              Security.SPARE_TYRE.toString()
                                                   ))
                              .headlightsType(HeadlightsType.USUAL.toString())
                              .tyresAndWheel(TyresAndWheels.STEEL_SUMMER.toString())
                              .numberOfDoors(5)
                              .numberOfSeats(5)
                              .interiorColor(null)
                              .interiorMaterial(InteriorMaterial.CLOTH.toString())
                              .interiorFeatures(
                                      Arrays.asList(
                                              InteriorFeature.BLUETOOTH.toString(),
                                              InteriorFeature.AMBIENT_LIGHTING.toString(),
                                              InteriorFeature.ARM_REST.toString(),
                                              InteriorFeature.CD_PLAYER.toString(),
                                              InteriorFeature.ELECTRIC_FRONT_WINDOWS.toString(),
                                              InteriorFeature.ELECTRIC_REAR_WINDOWS.toString(),
                                              InteriorFeature.NAVIGATION_SYSTEM.toString(),
                                              InteriorFeature.START_STOP_SYSTEM.toString(),
                                              InteriorFeature.RAIN_SENSOR.toString(),
                                              InteriorFeature.TOUCHSCREEN.toString()
                                                   ))
                              .numberOfSeats(5)
                              .vin("VIN-CODE")
                              .availability(AutomobileAvailability.SOLD.toString())
                              .price(20000)
                              .dealership(null)
                              .description("")
                              .created_at(LocalDateTime.now())
                              .modified_at(null)
                              .build(),

                    Automobile.builder()
                              .id(UUID.randomUUID().toString())
                              .vehicleType(null)
                              .producingCountry(null)
                              .make(null)
                              .modelAndPackage(null)
                              .drive(Drive.FRONT_WHEEL_DRIVE.toString())
                              .engine(null)
                              .exteriorColor(null)
                              .securities(
                                      Arrays.asList(
                                              Security.ABS.toString(),
                                              Security.ISOFIX.toString(),
                                              Security.ESP.toString(),
                                              Security.TYRE_PRESSURE_MONITORING.toString(),
                                              Security.TRACTION_CONTROL.toString()
                                                   ))
                              .headlightsType(HeadlightsType.USUAL.toString())
                              .tyresAndWheel(TyresAndWheels.STEEL_WINTER.toString())
                              .numberOfDoors(5)
                              .numberOfSeats(5)
                              .interiorColor(null)
                              .interiorMaterial(InteriorMaterial.CLOTH.toString())
                              .interiorFeatures(
                                      Arrays.asList(
                                              InteriorFeature.AMBIENT_LIGHTING.toString(),
                                              InteriorFeature.ARM_REST.toString(),
                                              InteriorFeature.CD_PLAYER.toString(),
                                              InteriorFeature.ELECTRIC_FRONT_WINDOWS.toString(),
                                              InteriorFeature.START_STOP_SYSTEM.toString(),
                                              InteriorFeature.RAIN_SENSOR.toString()
                                                   ))
                              .numberOfSeats(5)
                              .vin("VIN-CODE")
                              .availability(AutomobileAvailability.ORDERED.toString())
                              .price(14000)
                              .dealership(null)
                              .description("")
                              .created_at(LocalDateTime.now())
                              .modified_at(null)
                              .build()
                         )
    );

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }
}
