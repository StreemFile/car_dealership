package chnu.coursework.car_dealership.repository.automobile;

import chnu.coursework.car_dealership.model.Automobile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends MongoRepository<Automobile, String> {
}
