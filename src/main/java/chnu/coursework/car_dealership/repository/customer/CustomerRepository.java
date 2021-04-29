package chnu.coursework.car_dealership.repository.customer;

import chnu.coursework.car_dealership.model.Customer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends Neo4jRepository<Customer, String> {

}
