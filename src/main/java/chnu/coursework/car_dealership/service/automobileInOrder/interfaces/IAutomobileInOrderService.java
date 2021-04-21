package chnu.coursework.car_dealership.service.automobileInOrder.interfaces;

import chnu.coursework.car_dealership.model.AutomobileInOrder;

import java.util.List;

public interface IAutomobileInOrderService {
    AutomobileInOrder create(AutomobileInOrder automobileInOrder);
    AutomobileInOrder update(AutomobileInOrder automobileInOrder);
    AutomobileInOrder delete(AutomobileInOrder automobileInOrder);
    AutomobileInOrder getById(String id);
    List<AutomobileInOrder> getAll();
}
