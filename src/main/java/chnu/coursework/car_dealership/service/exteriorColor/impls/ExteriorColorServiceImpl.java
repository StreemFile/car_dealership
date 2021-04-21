package chnu.coursework.car_dealership.service.exteriorColor.impls;

import chnu.coursework.car_dealership.data.FakeExteriorColor;
import chnu.coursework.car_dealership.model.ExteriorColor;
import chnu.coursework.car_dealership.repository.exteriorColor.ExteriorColorRepository;
import chnu.coursework.car_dealership.service.exteriorColor.interfaces.IExteriorColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ExteriorColorServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:42
 * @Version ExteriorColorServiceImpl: 1.0
 */

@Service
public class ExteriorColorServiceImpl implements IExteriorColorService {

    @Autowired
    ExteriorColorRepository repository;

    @Autowired
    FakeExteriorColor fakeExteriorColor;

    @PostConstruct
    void init(){
        repository.saveAll(fakeExteriorColor.getExteriorColors());
    }

    @Override
    public ExteriorColor create(ExteriorColor exteriorColor) {
        return repository.save(exteriorColor);
//        return dao.create(exteriorColor);
    }

    @Override
    public ExteriorColor update(ExteriorColor exteriorColor) {
        exteriorColor.setModified_at(LocalDateTime.now());
        return repository.save(exteriorColor);
//        return dao.update(exteriorColor);
    }

    @Override
    public ExteriorColor delete(ExteriorColor exteriorColor) {
        repository.delete(exteriorColor);
        return exteriorColor;
//        return dao.delete(exteriorColor);
    }

    @Override
    public ExteriorColor getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<ExteriorColor> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
