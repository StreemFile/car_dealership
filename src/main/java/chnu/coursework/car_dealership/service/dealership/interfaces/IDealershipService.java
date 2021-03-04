package chnu.coursework.car_dealership.service.dealership.interfaces;

import chnu.coursework.car_dealership.model.Dealership;

import java.util.List;

public interface IDealershipService {
    Dealership create(Dealership dealership);
    Dealership update(Dealership dealership);
    Dealership delete(Dealership dealership);
    Dealership getById(String id);
    List<Dealership> getAll();
}
