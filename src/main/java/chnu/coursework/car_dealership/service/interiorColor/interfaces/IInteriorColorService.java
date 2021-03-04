package chnu.coursework.car_dealership.service.interiorColor.interfaces;

import chnu.coursework.car_dealership.model.InteriorColor;

import java.util.List;

public interface IInteriorColorService {
    InteriorColor create(InteriorColor interiorColor);
    InteriorColor update(InteriorColor interiorColor);
    InteriorColor delete(InteriorColor interiorColor);
    InteriorColor getById(String id);
    List<InteriorColor> getAll();
}
