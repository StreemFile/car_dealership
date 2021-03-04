package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Employee;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeEmployee
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:03
 * @Version FakeEmployee: 1.0
 */

@Repository
public class FakeEmployee {
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID().toString(),
                            "Мойсей Володимир Володимирович", "000680925",
                    "+380996088364",null, 15000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Мойсей Володимир Танасійович", "000680341",
                    "+380503741198",null, 11000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Мойсей Мирослав Володимирович", "000680837",
                    "+380505737937",null, 14000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Бучковський Вадим Сергійович", "000343925",
                    "+380502123764",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Гронь Ніна Мирославівна", "000642465",
                    "+380992285544",null, 10000, "", LocalDateTime.now(), null)
            )
    );

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
