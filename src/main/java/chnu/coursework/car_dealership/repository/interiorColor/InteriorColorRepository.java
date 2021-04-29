package chnu.coursework.car_dealership.repository.interiorColor;


import chnu.coursework.car_dealership.model.InteriorColor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorColorRepository extends Neo4jRepository<InteriorColor,String> {
}
