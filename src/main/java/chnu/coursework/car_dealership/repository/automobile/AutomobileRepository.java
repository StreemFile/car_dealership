package chnu.coursework.car_dealership.repository.automobile;

import chnu.coursework.car_dealership.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, String> {
}
