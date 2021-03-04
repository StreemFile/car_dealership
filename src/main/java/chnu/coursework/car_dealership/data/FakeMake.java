package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.Make;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeMake
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakeMake: 1.0
 */
@Repository
public class FakeMake {
    private List<Make> makes = new ArrayList<>(
            Arrays.asList(
                    new Make(UUID.randomUUID().toString(), "Volkswagen",
                            "", LocalDateTime.now(),null),
                    new Make(UUID.randomUUID().toString(), "Skoda",
                            "", LocalDateTime.now(),null),
                    new Make(UUID.randomUUID().toString(), "Ford",
                            "", LocalDateTime.now(),null),
                    new Make(UUID.randomUUID().toString(), "Peugeot",
                            "", LocalDateTime.now(),null),
                    new Make(UUID.randomUUID().toString(), "Audi",
                            "", LocalDateTime.now(),null)
            )
    );

    public List<Make> getMakes() {
        return makes;
    }

    public void setMakes(List<Make> makes) {
        this.makes = makes;
    }
}
