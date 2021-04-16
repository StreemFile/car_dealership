package chnu.coursework.car_dealership.service.make.impls;

import chnu.coursework.car_dealership.data.FakeMake;
import chnu.coursework.car_dealership.model.Make;
import chnu.coursework.car_dealership.repository.make.MakeRepository;
import chnu.coursework.car_dealership.service.make.interfaces.IMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.MakeServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:48
 * @Version MakeServiceImpl: 1.0
 */
@Service
public class MakeServiceImpl implements IMakeService {

    @Autowired
    MakeRepository repository;

    @Autowired
    FakeMake fakeMake;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeMake.getMakes());
    }

    @Override
    public Make create(Make make) {
        return repository.save(make);
//        return dao.create(make);
    }

    @Override
    public Make update(Make make) {
        return repository.save(make);
//        return dao.update(make);
    }

    @Override
    public Make delete(Make make) {
        repository.delete(make);
        return make;
//        return dao.delete(make);
    }

    @Override
    public Make getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Make> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
