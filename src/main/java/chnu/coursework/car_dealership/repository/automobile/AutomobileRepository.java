package chnu.coursework.car_dealership.repository.automobile;

import chnu.coursework.car_dealership.model.Automobile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends Neo4jRepository<Automobile, String> {
}
