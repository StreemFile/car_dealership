package chnu.coursework.car_dealership.repository.company;

import chnu.coursework.car_dealership.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {
}
