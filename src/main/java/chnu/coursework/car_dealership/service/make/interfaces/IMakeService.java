package chnu.coursework.car_dealership.service.make.interfaces;

import chnu.coursework.car_dealership.model.Make;

import java.util.List;

public interface IMakeService {
    Make create(Make make);
    Make update(Make make);
    Make delete(Make make);
    Make getById(String id);
    List<Make> getAll();
}
