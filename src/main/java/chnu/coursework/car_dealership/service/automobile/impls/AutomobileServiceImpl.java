package chnu.coursework.car_dealership.service.automobile.impls;

import chnu.coursework.car_dealership.MongoCollectionGetter;
import chnu.coursework.car_dealership.ToObjectListConverter;
import chnu.coursework.car_dealership.data.FakeAutomobile;
import chnu.coursework.car_dealership.model.Automobile;
import chnu.coursework.car_dealership.repository.automobile.AutomobileRepository;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.repository.exteriorColor.ExteriorColorRepository;
import chnu.coursework.car_dealership.repository.interiorColor.InteriorColorRepository;
import chnu.coursework.car_dealership.repository.make.MakeRepository;
import chnu.coursework.car_dealership.repository.modelAndPackage.ModelAndPackageRepository;
import chnu.coursework.car_dealership.repository.producingCountry.ProducingCountryRepository;
import chnu.coursework.car_dealership.repository.vehicleType.VehicleTypeRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.automobile.interfaces.IAutomobileService;
import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
import chnu.coursework.car_dealership.service.exteriorColor.impls.ExteriorColorServiceImpl;
import chnu.coursework.car_dealership.service.interiorColor.impls.InteriorColorServiceImpl;
import chnu.coursework.car_dealership.service.make.impls.MakeServiceImpl;
import chnu.coursework.car_dealership.service.modelAndPackage.impls.ModelAndPackageServiceImpl;
import chnu.coursework.car_dealership.service.producingCountry.impls.ProducingCountryServiceImpl;
import chnu.coursework.car_dealership.service.vehicleType.impls.VehicleTypeServiceImpl;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.AutomobileServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:21
 * @Version AutomobileServiceImpl: 1.0
 */
@Service
public class AutomobileServiceImpl implements IAutomobileService {

    @Autowired
    FakeAutomobile fakeAutomobile;

    @Autowired
    VehicleTypeServiceImpl vehicleTypeService;

    @Autowired
    ProducingCountryServiceImpl producingCountryService;

    @Autowired
    MakeServiceImpl makeService;

    @Autowired
    ModelAndPackageServiceImpl modelAndPackageService;

    @Autowired
    ExteriorColorServiceImpl exteriorColorService;

    @Autowired
    InteriorColorServiceImpl interiorColorService;

    @Autowired
    DealershipServiceImpl dealershipService;

    @Autowired
    GenericService genericService;

    String className = "automobile";


    @PostConstruct
    void init() {
//
//        fakeAutomobile.getAutomobiles().get(0).setVehicleType(vehicleTypeService.getAll().get(6));
//        fakeAutomobile.getAutomobiles().get(0).setExportedFrom(producingCountryService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setMake(makeService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setModelAndPackage(modelAndPackageService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setExteriorColor(exteriorColorService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setInteriorColor(interiorColorService.getAll().get(5));
//        fakeAutomobile.getAutomobiles().get(0).setDealership(dealershipService.getAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(1).setVehicleType(vehicleTypeService.getAll().get(6));
//        fakeAutomobile.getAutomobiles().get(1).setExportedFrom(producingCountryService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(1).setMake(makeService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(1).setModelAndPackage(modelAndPackageService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(1).setExteriorColor(exteriorColorService.getAll().get(2));
//        fakeAutomobile.getAutomobiles().get(1).setInteriorColor(interiorColorService.getAll().get(5));
//        fakeAutomobile.getAutomobiles().get(1).setDealership(dealershipService.getAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(2).setVehicleType(vehicleTypeService.getAll().get(6));
//        fakeAutomobile.getAutomobiles().get(2).setExportedFrom(producingCountryService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(2).setMake(makeService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(2).setModelAndPackage(modelAndPackageService.getAll().get(0));
//        fakeAutomobile.getAutomobiles().get(2).setExteriorColor(exteriorColorService.getAll().get(3));
//        fakeAutomobile.getAutomobiles().get(2).setInteriorColor(interiorColorService.getAll().get(5));
//        fakeAutomobile.getAutomobiles().get(2).setDealership(dealershipService.getAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(3).setVehicleType(vehicleTypeService.getAll().get(2));
//        fakeAutomobile.getAutomobiles().get(3).setExportedFrom(producingCountryService.getAll().get(1));
//        fakeAutomobile.getAutomobiles().get(3).setMake(makeService.getAll().get(2));
//        fakeAutomobile.getAutomobiles().get(3).setModelAndPackage(modelAndPackageService.getAll().get(1));
//        fakeAutomobile.getAutomobiles().get(3).setExteriorColor(exteriorColorService.getAll().get(4));
//        fakeAutomobile.getAutomobiles().get(3).setInteriorColor(interiorColorService.getAll().get(5));
//        fakeAutomobile.getAutomobiles().get(3).setDealership(dealershipService.getAll().get(3));
//
//        fakeAutomobile.getAutomobiles().forEach(this::create);
    }

    @Override
    public Automobile create(Automobile automobile) {
        return genericService.create(automobile, automobile.getId(), className);
    }

    @Override
    public Automobile update(Automobile automobile) {
        return genericService.update(automobile, automobile.getId(), className);
    }

    @Override
    public Automobile delete(Automobile automobile) {
        return genericService.delete(automobile, automobile.getId(), className);
    }

    @Override
    public Automobile getById(String id) {
        return genericService.getById(id, className, Automobile.class);
    }

    @Override
    public List<Automobile> getAll() {
        return genericService.getAll(className, Automobile.class);
    }
}
