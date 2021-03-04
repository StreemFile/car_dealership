package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.ExteriorColor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeExteriorColor
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:03
 * @Version FakeExteriorColor: 1.0
 */
@Repository
public class FakeExteriorColor {
    private List<ExteriorColor> exteriorColors = new ArrayList<>(
            Arrays.asList(
                    new ExteriorColor(UUID.randomUUID().toString(), "Срібний",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Чорний",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Сірий",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Білий",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Синій",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Золотистий",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Червоний",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Зелений",
                            "", LocalDateTime.now(),null),
                    new ExteriorColor(UUID.randomUUID().toString(), "Салатовий",
                            "", LocalDateTime.now(),null)
            )
    );

    public List<ExteriorColor> getExteriorColors() {
        return exteriorColors;
    }

    public void setExteriorColors(List<ExteriorColor> exteriorColors) {
        this.exteriorColors = exteriorColors;
    }
}
