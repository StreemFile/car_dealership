package chnu.coursework.car_dealership.repository.dealership;

import chnu.coursework.car_dealership.model.Dealership;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepository extends Neo4jRepository<Dealership,String> {
}
