package chnu.coursework.car_dealership.service.make.impls;

import chnu.coursework.car_dealership.data.FakeMake;
import chnu.coursework.car_dealership.model.Make;
import chnu.coursework.car_dealership.repository.make.MakeRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.make.interfaces.IMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
    FakeMake fakeMake;

    @Autowired
    GenericService genericService;

    String className = "make";

    @PostConstruct
    void init(){
//        fakeMake.getMakes().forEach(this::create);
    }

    @Override
    public Make create(Make make) {
        return genericService.create(make, make.getId(), className);
    }

    @Override
    public Make update(Make make) {
        return genericService.update(make, make.getId(), className);
    }

    @Override
    public Make delete(Make make) {
        return genericService.delete(make, make.getId(), className);
    }

    @Override
    public Make getById(String id) {
        return genericService.getById(id, className, Make.class);
    }

    @Override
    public List<Make> getAll() {
        return genericService.getAll(className, Make.class);
    }
}
