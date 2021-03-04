package chnu.coursework.car_dealership.service.vehicleType.interfaces;

import chnu.coursework.car_dealership.model.VehicleType;

import java.util.List;

public interface IVehicleTypeService {
    VehicleType create(VehicleType vehicleType);
    VehicleType update(VehicleType vehicleType);
    VehicleType delete(VehicleType vehicleType);
    VehicleType getById(String id);
    List<VehicleType> getAll();
}
