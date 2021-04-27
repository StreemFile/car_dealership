//package chnu.coursework.car_dealership.repository.customer;
//
//import chnu.coursework.car_dealership.model.Customer;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CustomerRepository extends MongoRepository<Customer, String> {
//    List<Customer> findByName(String name);
//    List<Customer> findAllByNameContains(String name);
//    List<Customer> findAllByPlaceOfResidenceEqualsOrPlaceOfResidenceEquals(String name, String name2);
//    List<Customer> findAllByPlaceOfResidenceEqualsAndNameContains(String place, String name);
//    List<Customer> findDistinctByPlaceOfResidenceIsNot(String name);
//
//
//}
