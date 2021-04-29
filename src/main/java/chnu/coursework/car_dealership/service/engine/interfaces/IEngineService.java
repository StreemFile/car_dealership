package chnu.coursework.car_dealership.service.engine.interfaces;

import chnu.coursework.car_dealership.model.Engine;

import java.util.List;

public interface IEngineService {
    Engine create(Engine engine);
    Engine update(Engine engine);
    Engine delete(Engine engine);
    Engine getById(String id);
    List<Engine> getAll();
}
