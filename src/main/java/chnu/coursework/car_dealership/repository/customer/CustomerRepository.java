package chnu.coursework.car_dealership.repository.customer;

import chnu.coursework.car_dealership.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
