package chnu.coursework.car_dealership.service.vehicleType.impls;

import chnu.coursework.car_dealership.data.FakeVehicleType;
import chnu.coursework.car_dealership.model.VehicleType;
import chnu.coursework.car_dealership.repository.vehicleType.VehicleTypeRepository;
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
    VehicleTypeRepository repository;

    @Autowired
    FakeVehicleType fakeVehicleType;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeVehicleType.getVehicleTypes());
    }

    @Override
    public VehicleType create(VehicleType vehicleType) {
        return repository.save(vehicleType);
//        return dao.create(vehicleType);
    }

    @Override
    public VehicleType update(VehicleType vehicleType) {
        vehicleType.setModified_at(LocalDateTime.now());
        return repository.save(vehicleType);
//        return dao.update(vehicleType);
    }

    @Override
    public VehicleType delete(VehicleType vehicleType) {
        repository.delete(vehicleType);
        return vehicleType;
//        return dao.delete(vehicleType);
    }

    @Override
    public VehicleType getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<VehicleType> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
