package chnu.coursework.car_dealership.repository.make;

import chnu.coursework.car_dealership.model.Make;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends MongoRepository<Make, String> {
    public List<Make> findDistinctByNameIsNot(String name);
}
