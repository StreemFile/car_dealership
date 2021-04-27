package chnu.coursework.car_dealership.service.interiorColor.impls;

import chnu.coursework.car_dealership.data.FakeInteriorColor;
import chnu.coursework.car_dealership.model.InteriorColor;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.interiorColor.interfaces.IInteriorColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

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
    FakeInteriorColor fakeInteriorColor;

    @Autowired
    GenericService genericService;

    String className = "interiorColor";

    @PostConstruct
    void init(){
//       fakeInteriorColor.getInteriorColors().forEach(this::create);
    }

    @Override
    public InteriorColor create(InteriorColor interiorColor) {
       return genericService.create(interiorColor, interiorColor.getId(), className);
    }

    @Override
    public InteriorColor update(InteriorColor interiorColor) {
        interiorColor.setModified_at(LocalDateTime.now());
       return genericService.update(interiorColor, interiorColor.getId(), className);
    }

    @Override
    public InteriorColor delete(InteriorColor interiorColor) {
       return genericService.delete(interiorColor, interiorColor.getId(), className);
    }

    @Override
    public InteriorColor getById(String id) {
       return genericService.getById(id, className, InteriorColor.class);
    }

    @Override
    public List<InteriorColor> getAll() {
        return genericService.getAll(className, InteriorColor.class);
    }
}
