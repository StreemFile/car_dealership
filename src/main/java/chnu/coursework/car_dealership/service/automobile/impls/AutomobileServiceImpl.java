package chnu.coursework.car_dealership.service.automobile.impls;

import chnu.coursework.car_dealership.MongoCollectionGetter;
import chnu.coursework.car_dealership.ToObjectListConverter;
import chnu.coursework.car_dealership.data.FakeAutomobile;
import chnu.coursework.car_dealership.model.Automobile;
import chnu.coursework.car_dealership.model.AutomobileAvailability;
import chnu.coursework.car_dealership.repository.automobile.AutomobileRepository;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.repository.exteriorColor.ExteriorColorRepository;
import chnu.coursework.car_dealership.repository.interiorColor.InteriorColorRepository;
import chnu.coursework.car_dealership.repository.make.MakeRepository;
import chnu.coursework.car_dealership.repository.modelAndPackage.ModelAndPackageRepository;
import chnu.coursework.car_dealership.repository.producingCountry.ProducingCountryRepository;
import chnu.coursework.car_dealership.repository.vehicleType.VehicleTypeRepository;
import chnu.coursework.car_dealership.service.automobile.interfaces.IAutomobileService;
import chnu.coursework.car_dealership.service.automobileInOrder.impls.AutomobileInOrderServiceImpl;
import chnu.coursework.car_dealership.service.purchase.impls.PurchaseServiceImpl;
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
import java.util.UUID;
import java.util.stream.Collectors;

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
    AutomobileRepository repository;

    @Autowired
    FakeAutomobile fakeAutomobile;

    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    MakeRepository makeRepository;

    @Autowired
    ModelAndPackageRepository modelAndPackageRepository;

    @Autowired
    ExteriorColorRepository exteriorColorRepository;

    @Autowired
    InteriorColorRepository interiorColorRepository;

    @Autowired
    ProducingCountryRepository producingCountryRepository;

    @Autowired
    AutomobileInOrderServiceImpl automobileInOrderService;

    @Autowired
    PurchaseServiceImpl purchaseService;

    @Autowired
    private MongoCollectionGetter mongoCollectionGetter;

    private ToObjectListConverter toObjectListConverter = new ToObjectListConverter();

    private final String collection = "automobile";

    @PostConstruct
    void init() {
//        fakeAutomobile.getAutomobiles().get(0).setVehicleType(vehicleTypeRepository.findAll().get(6));
//        fakeAutomobile.getAutomobiles().get(0).setExportedFrom(producingCountryRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setModelAndPackage(modelAndPackageRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setExteriorColor(exteriorColorRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(0).setInteriorColor(interiorColorRepository.findAll().get(5));
//        fakeAutomobile.getAutomobiles().get(0).setDealership(dealershipRepository.findAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(1).setVehicleType(vehicleTypeRepository.findAll().get(6));
//        fakeAutomobile.getAutomobiles().get(1).setExportedFrom(producingCountryRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(1).setModelAndPackage(modelAndPackageRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(1).setExteriorColor(exteriorColorRepository.findAll().get(2));
//        fakeAutomobile.getAutomobiles().get(1).setInteriorColor(interiorColorRepository.findAll().get(5));
//        fakeAutomobile.getAutomobiles().get(1).setDealership(dealershipRepository.findAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(2).setVehicleType(vehicleTypeRepository.findAll().get(6));
//        fakeAutomobile.getAutomobiles().get(2).setExportedFrom(producingCountryRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(2).setModelAndPackage(modelAndPackageRepository.findAll().get(0));
//        fakeAutomobile.getAutomobiles().get(2).setExteriorColor(exteriorColorRepository.findAll().get(3));
//        fakeAutomobile.getAutomobiles().get(2).setInteriorColor(interiorColorRepository.findAll().get(5));
//        fakeAutomobile.getAutomobiles().get(2).setDealership(dealershipRepository.findAll().get(1));
//
//        fakeAutomobile.getAutomobiles().get(3).setVehicleType(vehicleTypeRepository.findAll().get(2));
//        fakeAutomobile.getAutomobiles().get(3).setExportedFrom(producingCountryRepository.findAll().get(1));
//        fakeAutomobile.getAutomobiles().get(3).setModelAndPackage(modelAndPackageRepository.findAll().get(1));
//        fakeAutomobile.getAutomobiles().get(3).setExteriorColor(exteriorColorRepository.findAll().get(4));
//        fakeAutomobile.getAutomobiles().get(3).setInteriorColor(interiorColorRepository.findAll().get(5));
//        fakeAutomobile.getAutomobiles().get(3).setDealership(dealershipRepository.findAll().get(3));
//
//        repository.saveAll(fakeAutomobile.getAutomobiles());
    }

    @Override
    public Automobile create(Automobile automobile) {
        if(automobile.getId() == null) {
            automobile.setId(UUID.randomUUID().toString());
            automobile.setCreated_at(LocalDateTime.now());
            automobile.setModified_at(LocalDateTime.now());
        }
        return repository.save(automobile);
//        return dao.create(automobile);
    }

    @Override
    public Automobile update(Automobile automobile) {
        automobile.setModified_at(LocalDateTime.now());

        if (automobile.getAvailability().equals(AutomobileAvailability.ORDERED.toString())) {
            updateInOrderWhenAutomobileIsUpdated(automobile);
        }
        if (automobile.getAvailability().equals(AutomobileAvailability.SOLD.toString())) {
            updatePurchaseWhenSoldAutomobileIsUpdated(automobile);
        }
        return repository.save(automobile);
//        return dao.update(automobile);
    }

    @Override
    public Automobile delete(Automobile automobile) {
        repository.delete(automobile);
        return automobile;
//        return dao.delete(automobile);
    }

    @Override
    public Automobile getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Automobile> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }

    public Object getVolkswagenWithSevenSeatsMinMaxAvgPrice() {
        Bson project = Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("make", "price", "numberOfSeats")
                                                            ));

        Bson match = Aggregates.match(eq("numberOfSeats", 7));

        Bson group = Aggregates.group(
                "$make.name",
                Accumulators.min("minPrice", "$price"),
                Accumulators.max("maxPrice", "$price"),
                Accumulators.avg("avgPrice", "$price")
                                     );

        return toObjectListConverter.convert(
                mongoCollectionGetter.getCollection(collection).aggregate(
                        Arrays.asList(
                                project,
                                match,
                                group
                                     )
                                                                         )
                                            ).get(0);
    }

    public List<Object> getVolkswagenGearboxMin1600CubicCapacity() {
        Bson match = Aggregates.match(and(
                eq("make.name", "Volkswagen"),
                eq("engine.transmissionType", "Механіка"),
                gt("engine.cubicCapacity", 1600)
                                         ));

        return toObjectListConverter.convert(
                mongoCollectionGetter.getCollection(collection).aggregate(
                        Arrays.asList(match)
                                                                         ));
    }

    public List<Automobile> getAllByDealershipCity(String city) {
        return repository.findAllByDealershipCity(city);
    }


    private void updateInOrderWhenAutomobileIsUpdated(Automobile automobile) {
        automobileInOrderService.getAll()
                                .stream()
                                .filter(item -> item.getAutomobile().equals(automobile))
                                .collect(Collectors.toList())
                                .forEach(item -> {
                                    item.setAutomobile(automobile);
                                    automobileInOrderService.update(item);
                                });
    }

    private void updatePurchaseWhenSoldAutomobileIsUpdated(Automobile automobile){
        purchaseService.getAll()
                       .stream()
                       .filter(item -> item.getAutomobile().equals(automobile))
                       .collect(Collectors.toList())
                       .forEach(item -> {
                           item.setAutomobile(automobile);
                           purchaseService.update(item);
                       });
    }
}
