package chnu.coursework.car_dealership.service.exteriorColor.impls;

import chnu.coursework.car_dealership.data.FakeExteriorColor;
import chnu.coursework.car_dealership.model.ExteriorColor;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.exteriorColor.interfaces.IExteriorColorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    FakeExteriorColor fakeExteriorColor;

    @Autowired
    GenericService genericService;

    String className = "exteriorColor";

    @PostConstruct
    void init(){
//        fakeExteriorColor.getExteriorColors().forEach(this::create);
    }

    @Override
    public ExteriorColor create(ExteriorColor exteriorColor) {
        return genericService.create(exteriorColor, exteriorColor.getId(), className);
    }

    @Override
    public ExteriorColor update(ExteriorColor exteriorColor) {
        return genericService.update(exteriorColor, exteriorColor.getId(), className);
    }

    @Override
    public ExteriorColor delete(ExteriorColor exteriorColor) {
        return genericService.delete(exteriorColor, exteriorColor.getId(), className);
    }

    @Override
    public ExteriorColor getById(String id) {
        return genericService.getById(id, className, ExteriorColor.class);
    }

    @Override
    public List<ExteriorColor> getAll() {
        return genericService.getAll(className, ExteriorColor.class);
    }
}
