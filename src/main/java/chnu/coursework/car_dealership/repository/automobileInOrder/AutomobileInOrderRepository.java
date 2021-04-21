package chnu.coursework.car_dealership.repository.automobileInOrder;

import chnu.coursework.car_dealership.model.AutomobileInOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileInOrderRepository extends MongoRepository<AutomobileInOrder,String> {
}
