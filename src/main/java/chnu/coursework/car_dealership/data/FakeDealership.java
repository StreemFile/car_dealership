package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Dealership;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeDealership
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:03
 * @Version FakeDealership: 1.0
 */
@Repository
public class FakeDealership {



    private List<Dealership> dealerships = new ArrayList<>(
            Arrays.asList(new Dealership(UUID.randomUUID().toString(),
                   "Мамаївці", "mamaivtsi","провулок Заводський 11", "+380503741198",
                    null, "", LocalDateTime.now(), null ),
                     new Dealership(UUID.randomUUID().toString(),
                    "Чернівці","chernivtsi", "Руська 120", "+380503748184",
                    null, "", LocalDateTime.now(), null),
                    new Dealership(UUID.randomUUID().toString(),
                    "Львів","lviv", "Березова 17", "+380505737937",
                    null, "", LocalDateTime.now(), null),
                    new Dealership(UUID.randomUUID().toString(),
                    "Одеса","odessa", "Авіаційна 24", "+380502123764",
                    null, "", LocalDateTime.now(), null),
                    new Dealership(UUID.randomUUID().toString(),
                    "Київ", "kyiv","Макаренка 7", "+380992285544",
                    null, "", LocalDateTime.now(), null)
            )
    );

    public List<Dealership> getDealerships() {
        return dealerships;
    }

    public void setDealerships(List<Dealership> dealerships) {
        this.dealerships = dealerships;
    }
}
