package chnu.coursework.car_dealership.repository.automobile;

import chnu.coursework.car_dealership.model.Automobile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobileRepository extends MongoRepository<Automobile, String> {
    List<Automobile> findAllByDealershipCity(String city);
}
