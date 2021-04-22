package chnu.coursework.car_dealership.repository.interiorColor;



import chnu.coursework.car_dealership.model.InteriorColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorColorRepository extends JpaRepository<InteriorColor,String> {
}
