package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Company;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeCompany
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|21:35
 * @Version FakeCompany: 1.0
 */

@Repository
public class FakeCompany {
    private List<Company> company = new ArrayList<>(
            Arrays.asList(
                    new Company(UUID.randomUUID().toString(),
                            "YourCar", "yourcar@gmail.com", "+380996088364", "Мамаївці",
                            "провулок Заводський 11", "", LocalDateTime.now(),null)
            )
    );

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}
