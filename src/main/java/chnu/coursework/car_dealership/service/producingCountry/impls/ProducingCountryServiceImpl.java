package chnu.coursework.car_dealership.service.producingCountry.impls;

import chnu.coursework.car_dealership.data.FakeProducingCountry;
import chnu.coursework.car_dealership.model.ProducingCountry;
import chnu.coursework.car_dealership.repository.producingCountry.ProducingCountryRepository;
import chnu.coursework.car_dealership.service.producingCountry.interfaces.IProducingCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ProducingCountryServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:54
 * @Version ProducingCountryServiceImpl: 1.0
 */
@Service
public class ProducingCountryServiceImpl implements IProducingCountryService {

    @Autowired
    ProducingCountryRepository repository;

    @Autowired
    FakeProducingCountry fakeProducingCountry;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeProducingCountry.getProducingCountries());
    }

    @Override
    public ProducingCountry create(ProducingCountry producingCountry) {
        if(producingCountry.getId() == null) {
            producingCountry.setId(UUID.randomUUID().toString());
            producingCountry.setCreated_at(LocalDateTime.now());
            producingCountry.setModified_at(LocalDateTime.now());
        }
        return repository.save(producingCountry);
//        return dao.create(producingCountry);
    }

    @Override
    public ProducingCountry update(ProducingCountry producingCountry) {
        producingCountry.setModified_at(LocalDateTime.now());
        return repository.save(producingCountry);
//        return dao.update(producingCountry);
    }

    @Override
    public ProducingCountry delete(ProducingCountry producingCountry) {
        repository.delete(producingCountry);
        return producingCountry;
//        return dao.delete(producingCountry);
    }

    @Override
    public ProducingCountry getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<ProducingCountry> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
