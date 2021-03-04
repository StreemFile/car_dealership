package chnu.coursework.car_dealership.dao;


import java.util.List;

public interface IGenericDAO<E> {
    E create(E item);
    E update(E item);
    E delete(E item);
    E getById(String id);
    List<E> getAll();
}
