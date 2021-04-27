package chnu.coursework.car_dealership.service.company.impls;

import chnu.coursework.car_dealership.data.FakeCompany;
import chnu.coursework.car_dealership.model.Company;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.company.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CompanyServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|21:42
 * @Version CompanyServiceImpl: 1.0
 */

@Service
public class CompanyServiceImpl implements ICompanyService {


    @Autowired
    FakeCompany fakeCompany;

    @Autowired
    GenericService genericService;

    String className = "company";

    @PostConstruct
    void init() {
//        fakeCompany.getCompany().forEach(this::create);
    }

    @Override
    public Company create(Company company) {
        return genericService.create(company,company.getId(), className);
    }

    @Override
    public Company update(Company company) {
        return genericService.update(company,company.getId(), className);
    }

    @Override
    public Company delete(Company company) {
        return genericService.delete(company,company.getId(), className);
    }

    @Override
    public Company getById(String id) {
        return genericService.getById(id,className, Company.class);
    }

    @Override
    public List<Company> getAll() {
        return genericService.getAll(className, Company.class);
    }
}
