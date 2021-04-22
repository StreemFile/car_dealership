package chnu.coursework.car_dealership.repository.vehicleType;


import chnu.coursework.car_dealership.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,String> {
}
