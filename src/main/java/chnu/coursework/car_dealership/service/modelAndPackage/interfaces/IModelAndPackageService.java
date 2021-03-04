package chnu.coursework.car_dealership.service.modelAndPackage.interfaces;

import chnu.coursework.car_dealership.model.ModelAndPackage;

import java.util.List;

public interface IModelAndPackageService {
    ModelAndPackage create(ModelAndPackage modelAndPackage);
    ModelAndPackage update(ModelAndPackage modelAndPackage);
    ModelAndPackage delete(ModelAndPackage modelAndPackage);
    ModelAndPackage getById(String id);
    List<ModelAndPackage> getAll();
}
