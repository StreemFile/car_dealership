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
                    "+380992285544",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Мукан Олександра Вікторівна", "000521465",
                            "+380992827561",null, 13000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Кравчук Олег Святославович", "000648572",
                            "+380996723544",null, 9000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Кориш Артем Максимович", "000931465",
                            "+380992456804",null, 13200, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Прусняк Степан Степанович", "000609875",
                            "+380998359486",null, 11000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Григораш Ігор Васильович", "000642874",
                            "+380952283714",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Григорчук Віктор Іванович", "000644465",
                            "+380662209345",null, 14300, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Дороган Віталій Олегович", "000694856",
                            "+380673418034",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Порунь Софія Вікторівна", "000840413",
                            "+380953263321",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Мандрик Володимир Олегович", "000836165",
                            "+380671462452",null, 10000, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Марчук Валерій Степанович", "000644162",
                            "+380502326134",null, 12500, "", LocalDateTime.now(), null),
                    new Employee(UUID.randomUUID().toString(),
                            "Мирний Роман Олександрович", "000643142",
                            "+380992725824",null, 10000, "", LocalDateTime.now(), null)

            )
    );

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
