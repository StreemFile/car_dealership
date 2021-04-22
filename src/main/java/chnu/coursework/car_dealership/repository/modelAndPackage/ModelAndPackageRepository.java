package chnu.coursework.car_dealership.repository.modelAndPackage;


import chnu.coursework.car_dealership.model.ModelAndPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelAndPackageRepository extends JpaRepository<ModelAndPackage, String> {
}
