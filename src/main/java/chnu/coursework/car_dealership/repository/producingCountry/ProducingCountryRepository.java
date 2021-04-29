package chnu.coursework.car_dealership.repository.producingCountry;

import chnu.coursework.car_dealership.model.ProducingCountry;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducingCountryRepository extends Neo4jRepository<ProducingCountry,String> {
}
