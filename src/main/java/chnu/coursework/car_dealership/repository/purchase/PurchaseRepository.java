package chnu.coursework.car_dealership.repository.purchase;

import chnu.coursework.car_dealership.model.Purchase;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends Neo4jRepository<Purchase, String> {
}
