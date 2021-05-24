package chnu.coursework.car_dealership.service.company.impls;

import chnu.coursework.car_dealership.data.FakeCompany;
import chnu.coursework.car_dealership.model.Company;
import chnu.coursework.car_dealership.model.Dealership;
import chnu.coursework.car_dealership.repository.company.CompanyRepository;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.service.company.interfaces.ICompanyService;
import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    CompanyRepository repository;

    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    DealershipServiceImpl dealershipService;

    @Autowired
    FakeCompany fakeCompany;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeCompany.getCompany());
    }

    @Override
    public Company create(Company company) {
        if(company.getId() == null) {
            company.setId(UUID.randomUUID().toString());
            company.setCreated_at(LocalDateTime.now());
            company.setModified_at(LocalDateTime.now());
        }
        return repository.save(company);
//        return dao.create(company);
    }

    @Override
    public Company update(Company company) {
        company.setModified_at(LocalDateTime.now());
       List<Dealership> dealershipToUpdate = dealershipRepository.findAll()
                                                                 .stream()
                                                                 .filter(item -> item.getCompany().equals(company))
                                                                 .collect(Collectors.toList());
       dealershipToUpdate.forEach(item -> {
           item.setCompany(company);
           dealershipService.update(item);
       });
        return repository.save(company);
//        return dao.update(company);
    }

    @Override
    public Company delete(Company company) {
        repository.delete(company);
        return company;
//        return dao.delete(company);
    }

    @Override
    public Company getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
