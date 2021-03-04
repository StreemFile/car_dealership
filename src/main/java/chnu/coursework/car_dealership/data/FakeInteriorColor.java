package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.InteriorColor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeInteriorColor
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakeInteriorColor: 1.0
 */
@Repository
public class FakeInteriorColor {
    private List<InteriorColor> interiorColors = new ArrayList<>(
            Arrays.asList(
                    new InteriorColor(UUID.randomUUID().toString(), "Білий",
                            "", LocalDateTime.now(), null),
                    new InteriorColor(UUID.randomUUID().toString(), "Чорний",
                            "", LocalDateTime.now(), null),
                    new InteriorColor(UUID.randomUUID().toString(), "Червоний",
                            "", LocalDateTime.now(), null),
                    new InteriorColor(UUID.randomUUID().toString(), "Коричневий",
                            "", LocalDateTime.now(), null),
                    new InteriorColor(UUID.randomUUID().toString(), "Золотистий",
                            "", LocalDateTime.now(), null),
                    new InteriorColor(UUID.randomUUID().toString(), "Сірий",
                            "", LocalDateTime.now(), null)
            )
    );

    public List<InteriorColor> getInteriorColors() {
        return interiorColors;
    }

    public void setInteriorColors(List<InteriorColor> interiorColors) {
        this.interiorColors = interiorColors;
    }
}
