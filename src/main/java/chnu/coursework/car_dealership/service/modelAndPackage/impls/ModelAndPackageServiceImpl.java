package chnu.coursework.car_dealership.service.modelAndPackage.impls;

import chnu.coursework.car_dealership.data.FakeModelAndPackage;
import chnu.coursework.car_dealership.model.ModelAndPackage;
import chnu.coursework.car_dealership.repository.modelAndPackage.ModelAndPackageRepository;
import chnu.coursework.car_dealership.service.modelAndPackage.interfaces.IModelAndPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
    ModelAndPackageRepository repository;

    @Autowired
    FakeModelAndPackage fakeModelAndPackage;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeModelAndPackage.getModelAndPackages());
    }

    @Override
    public ModelAndPackage create(ModelAndPackage modelAndPackage) {
        return repository.save(modelAndPackage);
//        return dao.create(modelAndPackage);
    }

    @Override
    public ModelAndPackage update(ModelAndPackage modelAndPackage) {
        modelAndPackage.setModified_at(LocalDateTime.now());
        return repository.save(modelAndPackage);
//        return dao.update(modelAndPackage);
    }

    @Override
    public ModelAndPackage delete(ModelAndPackage modelAndPackage) {
        repository.delete(modelAndPackage);
        return modelAndPackage;
//        return dao.delete(modelAndPackage);
    }

    @Override
    public ModelAndPackage getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<ModelAndPackage> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
