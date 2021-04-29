package chnu.coursework.car_dealership.repository.engine;

import chnu.coursework.car_dealership.model.Engine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends Neo4jRepository<Engine,String> {
}
