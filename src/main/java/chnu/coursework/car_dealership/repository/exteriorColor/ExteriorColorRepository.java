package chnu.coursework.car_dealership.repository.exteriorColor;

import chnu.coursework.car_dealership.model.ExteriorColor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorColorRepository extends Neo4jRepository<ExteriorColor,String> {
}
