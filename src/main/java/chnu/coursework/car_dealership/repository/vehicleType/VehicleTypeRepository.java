package chnu.coursework.car_dealership.repository.vehicleType;

import chnu.coursework.car_dealership.model.VehicleType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends Neo4jRepository<VehicleType,String> {
}
