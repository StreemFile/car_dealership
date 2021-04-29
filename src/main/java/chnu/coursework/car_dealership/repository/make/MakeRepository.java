package chnu.coursework.car_dealership.repository.make;

import chnu.coursework.car_dealership.model.Make;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends Neo4jRepository<Make, String> {

}
