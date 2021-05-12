package chnu.coursework.car_dealership.service.automobileInOrder.impls;

import chnu.coursework.car_dealership.data.FakeAutomobileInOrder;
import chnu.coursework.car_dealership.model.AutomobileInOrder;
import chnu.coursework.car_dealership.repository.automobile.AutomobileRepository;
import chnu.coursework.car_dealership.repository.automobileInOrder.AutomobileInOrderRepository;
import chnu.coursework.car_dealership.service.automobileInOrder.interfaces.IAutomobileInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.AutomobileInOrderServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 21.04.2021|20:18
 * @Version AutomobileInOrderServiceImpl: 1.0
 */

@Service
public class AutomobileInOrderServiceImpl implements IAutomobileInOrderService {
    @Autowired
    AutomobileInOrderRepository repository;

    @Autowired
    FakeAutomobileInOrder fakeAutomobileInOrder;

    @Autowired
    AutomobileRepository automobileRepository;

    @PostConstruct
    void init(){
//        fakeAutomobileInOrder.getAutomobileInOrders()
//                             .get(0)
//                             .setAutomobile(automobileRepository.findAll().get(3));
//        repository.saveAll(fakeAutomobileInOrder.getAutomobileInOrders());
    }

    @Override
    public AutomobileInOrder create(AutomobileInOrder automobileInOrder) {
        return repository.save(automobileInOrder);
    }

    @Override
    public AutomobileInOrder update(AutomobileInOrder automobileInOrder) {
        automobileInOrder.setModified_at(LocalDateTime.now());
        return repository.save(automobileInOrder);
    }

    @Override
    public AutomobileInOrder delete(AutomobileInOrder automobileInOrder) {
        repository.delete(automobileInOrder);
        return automobileInOrder;
    }

    @Override
    public AutomobileInOrder getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AutomobileInOrder> getAll() {
        return repository.findAll();
    }
}
