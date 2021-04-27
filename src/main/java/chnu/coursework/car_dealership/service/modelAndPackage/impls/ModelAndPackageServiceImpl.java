package chnu.coursework.car_dealership.service.modelAndPackage.impls;

import chnu.coursework.car_dealership.data.FakeModelAndPackage;
import chnu.coursework.car_dealership.model.ModelAndPackage;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.modelAndPackage.interfaces.IModelAndPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ModelAndPackageServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:50
 * @Version ModelAndPackageServiceImpl: 1.0
 */
@Service
public class ModelAndPackageServiceImpl implements IModelAndPackageService {
    @Autowired
    FakeModelAndPackage fakeModelAndPackage;

    @Autowired
    GenericService genericService;

    String className = "modelAndPackage";

    @PostConstruct
    void init(){
//        fakeModelAndPackage.getModelAndPackages().forEach(this::create);
    }

    @Override
    public ModelAndPackage create(ModelAndPackage modelAndPackage) {
        return genericService.create(modelAndPackage, modelAndPackage.getId(), className);
    }

    @Override
    public ModelAndPackage update(ModelAndPackage modelAndPackage) {
        return genericService.update(modelAndPackage, modelAndPackage.getId(), className);
    }

    @Override
    public ModelAndPackage delete(ModelAndPackage modelAndPackage) {
        return genericService.delete(modelAndPackage, modelAndPackage.getId(), className);
    }

    @Override
    public ModelAndPackage getById(String id) {
        return genericService.getById(id, className, ModelAndPackage.class);
    }

    @Override
    public List<ModelAndPackage> getAll() {
        return genericService.getAll(className, ModelAndPackage.class);
    }
}
