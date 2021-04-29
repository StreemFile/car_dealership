package chnu.coursework.car_dealership.service.engine.impls;

import chnu.coursework.car_dealership.data.FakeEngine;
import chnu.coursework.car_dealership.model.Engine;
import chnu.coursework.car_dealership.repository.engine.EngineRepository;
import chnu.coursework.car_dealership.service.engine.interfaces.IEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.EngineServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.04.2021|10:19
 * @Version EngineServiceImpl: 1.0
 */

@Service
public class EngineServiceImpl implements IEngineService {

    @Autowired
    EngineRepository repository;

    @Autowired
    FakeEngine fakeEngine;

    @PostConstruct
    void init() {
//        repository.saveAll(fakeEngine.getEngines());
    }

    @Override
    public Engine create(Engine engine) {
        return repository.save(engine);
    }

    @Override
    public Engine update(Engine engine) {
        return repository.save(engine);
    }

    @Override
    public Engine delete(Engine engine) {
        repository.delete(engine);
        return engine;
    }

    @Override
    public Engine getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Engine> getAll() {
        return repository.findAll();
    }
}
