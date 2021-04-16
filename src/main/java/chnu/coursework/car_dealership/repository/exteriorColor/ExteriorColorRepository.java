package chnu.coursework.car_dealership.repository.exteriorColor;

import chnu.coursework.car_dealership.model.ExteriorColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorColorRepository extends JpaRepository<ExteriorColor,String> {
}
