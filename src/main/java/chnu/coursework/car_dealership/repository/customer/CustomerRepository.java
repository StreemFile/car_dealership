package chnu.coursework.car_dealership.repository.customer;


import chnu.coursework.car_dealership.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
