package chnu.coursework.car_dealership.service.company.interfaces;

import chnu.coursework.car_dealership.model.Company;

import java.util.List;

public interface ICompanyService {
    Company create(Company company);
    Company update(Company company);
    Company delete(Company company);
    Company getById(String id);
    List<Company> getAll();
}
