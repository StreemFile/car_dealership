package chnu.coursework.car_dealership.service.producingCountry.interfaces;

import chnu.coursework.car_dealership.model.ProducingCountry;

import java.util.List;

public interface IProducingCountryService {
    ProducingCountry create(ProducingCountry producingCountry);
    ProducingCountry update(ProducingCountry producingCountry);
    ProducingCountry delete(ProducingCountry producingCountry);
    ProducingCountry getById(String id);
    List<ProducingCountry> getAll();
}
