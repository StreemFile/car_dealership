package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeCustomer
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:34
 * @Version FakeCustomer: 1.0
 */

@Repository
public class FakeCustomer {

    private List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer(UUID.randomUUID().toString(),
                            "Тащук Володимир Володимирович", "+380996088454",
                            "Мамаївці","провулок Заводський 15", "000680943",
                            "", LocalDateTime.now(),LocalDateTime.now()),
                    new Customer(UUID.randomUUID().toString(),
                            "Іващук Валентин Ігорович", "+380503085364",
                            "Чернівці","Головна 12", "000643920",
                            "", LocalDateTime.now(),LocalDateTime.now()),
                    new Customer(UUID.randomUUID().toString(),
                            "Григорчук Олег Іванович", "+380503054123",
                            "Чернівці","Руська 27", "002345924",
                            "", LocalDateTime.now(),LocalDateTime.now()),
                    new Customer(UUID.randomUUID().toString(),
                            "Яцик Іван Сергійович", "+380994037562",
                             "Івано-Франківськ", "Франка 12", "000480123",
                             "", LocalDateTime.now(),LocalDateTime.now()),
                    new Customer(UUID.randomUUID().toString(),
                            "Чегерин Аліна Василівна", "+380665847364",
                            "Чернівці", "Головна 42", "000665412",
                            "", LocalDateTime.now(),LocalDateTime.now())
            )
    );

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
