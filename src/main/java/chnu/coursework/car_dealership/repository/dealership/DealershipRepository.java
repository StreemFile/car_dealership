package chnu.coursework.car_dealership.repository.dealership;

import chnu.coursework.car_dealership.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership,String> {
}
