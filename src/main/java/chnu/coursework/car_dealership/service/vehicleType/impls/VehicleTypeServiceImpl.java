package chnu.coursework.car_dealership.service.vehicleType.impls;

import chnu.coursework.car_dealership.data.FakeVehicleType;
import chnu.coursework.car_dealership.model.VehicleType;
import chnu.coursework.car_dealership.repository.vehicleType.VehicleTypeRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.vehicleType.interfaces.IVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.VehicleTypeServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|23:00
 * @Version VehicleTypeServiceImpl: 1.0
 */

@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {

    @Autowired
    FakeVehicleType fakeVehicleType;

    @Autowired
    GenericService genericService;

    String className = "vehicleType";

    @PostConstruct
    void init(){
//        fakeVehicleType.getVehicleTypes().forEach(this::create);
    }

    @Override
    public VehicleType create(VehicleType vehicleType) {
        return genericService.create(vehicleType, vehicleType.getId(), className);
    }

    @Override
    public VehicleType update(VehicleType vehicleType) {
        return genericService.update(vehicleType, vehicleType.getId(), className);
    }

    @Override
    public VehicleType delete(VehicleType vehicleType) {
        return genericService.delete(vehicleType, vehicleType.getId(), className);
    }

    @Override
    public VehicleType getById(String id) {
        return genericService.getById(id, className, VehicleType.class);
    }

    @Override
    public List<VehicleType> getAll() {
        return genericService.getAll(className, VehicleType.class);
    }
}
