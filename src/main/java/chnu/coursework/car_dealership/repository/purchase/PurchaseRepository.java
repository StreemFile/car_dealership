package chnu.coursework.car_dealership.repository.purchase;

import chnu.coursework.car_dealership.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
