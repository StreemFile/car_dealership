package chnu.coursework.car_dealership.repository.producingCountry;

import chnu.coursework.car_dealership.model.ProducingCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducingCountryRepository extends JpaRepository<ProducingCountry,String> {
}
