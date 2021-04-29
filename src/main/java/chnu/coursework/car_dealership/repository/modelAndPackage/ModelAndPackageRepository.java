package chnu.coursework.car_dealership.repository.modelAndPackage;

import chnu.coursework.car_dealership.model.ModelAndPackage;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelAndPackageRepository extends Neo4jRepository<ModelAndPackage, String> {
}
