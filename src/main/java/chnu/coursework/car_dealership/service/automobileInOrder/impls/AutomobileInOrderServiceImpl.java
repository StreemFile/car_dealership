package chnu.coursework.car_dealership.service.automobileInOrder.impls;

import chnu.coursework.car_dealership.data.FakeAutomobile;
import chnu.coursework.car_dealership.data.FakeAutomobileInOrder;
import chnu.coursework.car_dealership.model.AutomobileInOrder;
import chnu.coursework.car_dealership.repository.automobileInOrder.AutomobileInOrderRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.automobile.impls.AutomobileServiceImpl;
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
    FakeAutomobileInOrder fakeAutomobileInOrder;

    @Autowired
    AutomobileServiceImpl automobileService;

    @Autowired
    GenericService genericService;

    String className = "automobileInOrder";

    @PostConstruct
    void init(){
//        fakeAutomobileInOrder.getAutomobileInOrders()
//                             .get(0)
//                             .setAutomobile(automobileService.getAll().get(3));
//        fakeAutomobileInOrder.getAutomobileInOrders().forEach(this::create);
    }

    @Override
    public AutomobileInOrder create(AutomobileInOrder automobileInOrder) {
        return genericService.create(automobileInOrder, automobileInOrder.getId(), className);
    }

    @Override
    public AutomobileInOrder update(AutomobileInOrder automobileInOrder) {
        return genericService.update(automobileInOrder, automobileInOrder.getId(), className);
    }

    @Override
    public AutomobileInOrder delete(AutomobileInOrder automobileInOrder) {
        return genericService.delete(automobileInOrder, automobileInOrder.getId(), className);
    }

    @Override
    public AutomobileInOrder getById(String id) {
        return genericService.getById(id, className, AutomobileInOrder.class);
    }

    @Override
    public List<AutomobileInOrder> getAll() {
        return genericService.getAll(className, AutomobileInOrder.class);
    }
}
