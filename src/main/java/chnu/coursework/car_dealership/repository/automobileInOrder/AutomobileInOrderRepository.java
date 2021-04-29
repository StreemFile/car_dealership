package chnu.coursework.car_dealership.repository.automobileInOrder;

import chnu.coursework.car_dealership.model.AutomobileInOrder;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileInOrderRepository extends Neo4jRepository<AutomobileInOrder,String> {
}
