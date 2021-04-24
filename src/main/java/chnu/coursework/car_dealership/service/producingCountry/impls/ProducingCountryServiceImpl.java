package chnu.coursework.car_dealership.service.producingCountry.impls;

import chnu.coursework.car_dealership.data.FakeProducingCountry;
import chnu.coursework.car_dealership.model.ProducingCountry;
import chnu.coursework.car_dealership.repository.producingCountry.ProducingCountryRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.producingCountry.interfaces.IProducingCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

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
    FakeProducingCountry fakeProducingCountry;

    @Autowired
    GenericService genericService;

    String className = "producingCountry";

    @PostConstruct
    void init(){
//        fakeProducingCountry.getProducingCountries().forEach(this::create);
    }

    @Override
    public ProducingCountry create(ProducingCountry producingCountry) {
        return genericService.create(producingCountry, producingCountry.getId(), className);
    }

    @Override
    public ProducingCountry update(ProducingCountry producingCountry) {
        return genericService.update(producingCountry, producingCountry.getId(), className);
    }

    @Override
    public ProducingCountry delete(ProducingCountry producingCountry) {
        return genericService.delete(producingCountry, producingCountry.getId(), className);
    }

    @Override
    public ProducingCountry getById(String id) {
        return genericService.getById(id, className, ProducingCountry.class);
    }

    @Override
    public List<ProducingCountry> getAll() {
        return genericService.getAll(className, ProducingCountry.class);
    }
}
