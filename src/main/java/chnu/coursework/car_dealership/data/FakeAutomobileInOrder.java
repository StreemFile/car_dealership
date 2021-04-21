package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.AutomobileInOrder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.FakeAutomobileInOrder
 *
 * @Autor: vovamv
 * @DateTime: 21.04.2021|20:30
 * @Version FakeAutomobileInOrder: 1.0
 */

@Repository
public class FakeAutomobileInOrder {
    private List<AutomobileInOrder> automobileInOrders = new ArrayList<>(
            Arrays.asList(
                    AutomobileInOrder.builder()
                                     .id(UUID.randomUUID().toString())
                                     .automobile(null)
                                     .expectedArrivalDate(LocalDate.of(2021, 5, 27))
                                     .description("")
                                     .created_at(LocalDateTime.now())
                                     .modified_at(LocalDateTime.now())
                                     .build()
                         )
    );
    public List<AutomobileInOrder> getAutomobileInOrders() {
        return automobileInOrders;
    }

    public void setAutomobileInOrders(List<AutomobileInOrder> automobileInOrders) {
        this.automobileInOrders = automobileInOrders;
    }
}
