package chnu.coursework.car_dealership.service.automobile.interfaces;

import chnu.coursework.car_dealership.model.Automobile;

import java.util.List;

public interface IAutomobileService {
    Automobile create(Automobile automobile);
    Automobile update(Automobile automobile);
    Automobile delete(Automobile automobile);
    Automobile getById(String id);
    List<Automobile> getAll();
}
