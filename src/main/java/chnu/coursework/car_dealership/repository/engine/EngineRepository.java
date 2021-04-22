package chnu.coursework.car_dealership.repository.engine;


import chnu.coursework.car_dealership.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, String> {
}
