package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.ProducingCountry;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeProducingCountry
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakeProducingCountry: 1.0
 */
@Repository
public class FakeProducingCountry {
    private List<ProducingCountry> producingCountries = new ArrayList<>(
            Arrays.asList(
                    new ProducingCountry(UUID.randomUUID().toString(),
                            "Німеччина","", LocalDateTime.now(),null),
                    new ProducingCountry(UUID.randomUUID().toString(),
                            "Сполучені Штати Америки","", LocalDateTime.now(),null),
                    new ProducingCountry(UUID.randomUUID().toString(),
                            "Чехія","", LocalDateTime.now(),null),
                    new ProducingCountry(UUID.randomUUID().toString(),
                            "Франція","", LocalDateTime.now(),null)
            )
    );

    public List<ProducingCountry> getProducingCountries() {
        return producingCountries;
    }

    public void setProducingCountries(List<ProducingCountry> producingCountries) {
        this.producingCountries = producingCountries;
    }
}
