package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Purchase;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakePurchase
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakePurchase: 1.0
 */
@Repository
public class FakePurchase {
    private List<Purchase> purchases = new ArrayList<>(
            Arrays.asList(
                    new Purchase(
                            UUID.randomUUID().toString(),
                            null, null, null,
                            19700, LocalDate.now(),
                            "", LocalDateTime.now(), LocalDateTime.now())
                         )
    );

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
