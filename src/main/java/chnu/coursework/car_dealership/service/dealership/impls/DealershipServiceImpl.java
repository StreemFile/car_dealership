package chnu.coursework.car_dealership.service.dealership.impls;

import chnu.coursework.car_dealership.data.FakeDealership;
import chnu.coursework.car_dealership.model.Dealership;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.company.impls.CompanyServiceImpl;
import chnu.coursework.car_dealership.service.dealership.interfaces.IDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.DealershipServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:34
 * @Version DealershipServiceImpl: 1.0
 */
@Service
public class DealershipServiceImpl implements IDealershipService {

    @Autowired
    CompanyServiceImpl companyService;

    @Autowired
    FakeDealership fakeDealership;

    @Autowired
    GenericService genericService;
    String className = "dealership";

    @PostConstruct
    void init() {
//        fakeDealership.getDealerships().get(0).setCompany(companyService.getAll().get(0));
//        fakeDealership.getDealerships().get(1).setCompany(companyService.getAll().get(0));
//        fakeDealership.getDealerships().get(2).setCompany(companyService.getAll().get(0));
//        fakeDealership.getDealerships().get(3).setCompany(companyService.getAll().get(0));
//        fakeDealership.getDealerships().get(4).setCompany(companyService.getAll().get(0));
//
//        fakeDealership.getDealerships().forEach(item -> create(item));
    }

    @Override
    public Dealership create(Dealership dealership) {
        return genericService.create(dealership, dealership.getId(), className);
    }

    @Override
    public Dealership update(Dealership dealership) {
        return genericService.update(dealership, dealership.getId(), className);
    }

    @Override
    public Dealership delete(Dealership dealership) {
        return genericService.delete(dealership, dealership.getId(), className);
    }

    @Override
    public Dealership getById(String id) {
        return genericService.getById(id, className, Dealership.class);
    }

    @Override
    public List<Dealership> getAll() {
        return genericService.getAll(className, Dealership.class);
    }
}
