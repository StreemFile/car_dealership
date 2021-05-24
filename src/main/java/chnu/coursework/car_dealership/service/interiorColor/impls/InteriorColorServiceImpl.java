package chnu.coursework.car_dealership.service.interiorColor.impls;

import chnu.coursework.car_dealership.data.FakeInteriorColor;
import chnu.coursework.car_dealership.model.InteriorColor;
import chnu.coursework.car_dealership.repository.interiorColor.InteriorColorRepository;
import chnu.coursework.car_dealership.service.interiorColor.interfaces.IInteriorColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.InteriorColorServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:46
 * @Version InteriorColorServiceImpl: 1.0
 */
@Service
public class InteriorColorServiceImpl implements IInteriorColorService {

    @Autowired
    InteriorColorRepository repository;

    @Autowired
    FakeInteriorColor fakeInteriorColor;

    @PostConstruct
    void init() {
//        repository.saveAll(fakeInteriorColor.getInteriorColors());
    }

    @Override
    public InteriorColor create(InteriorColor interiorColor) {
        if (interiorColor.getId() == null) {
            interiorColor.setId(UUID.randomUUID().toString());
            interiorColor.setCreated_at(LocalDateTime.now());
            interiorColor.setModified_at(LocalDateTime.now());
        }
        return repository.save(interiorColor);
//        return dao.create(interiorColor);
    }

    @Override
    public InteriorColor update(InteriorColor interiorColor) {
        interiorColor.setModified_at(LocalDateTime.now());
        return repository.save(interiorColor);
//        return dao.update(interiorColor);
    }

    @Override
    public InteriorColor delete(InteriorColor interiorColor) {
        repository.delete(interiorColor);
        return interiorColor;
//        return dao.delete(interiorColor);
    }

    @Override
    public InteriorColor getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<InteriorColor> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
