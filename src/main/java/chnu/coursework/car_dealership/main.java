package chnu.coursework.car_dealership;

import chnu.coursework.car_dealership.model.Company;
import chnu.coursework.car_dealership.model.Engine;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.main
 *
 * @Autor: vovamv
 * @DateTime: 15.02.2021|17:08
 * @Version main: 1.0
 */

public class main {
    public static void main(String[] args) {
        ToJsonConverter ToJsonConverter = new ToJsonConverter();
        Company company = new Company(UUID.randomUUID().toString(),
                "YourAutomobile","yourautomobile@gmail.com", "+380996088364",
                "Чернівці","Руська 132", "", LocalDateTime.now(),null);

//        Automobile automobile = Automobile.builder().interiorFeature(InteriorFeature.ELECTRIC_HEATED_FRONT_SEATS).build();
        Engine engine = new Engine();
        System.out.println(ToJsonConverter.toJSON(engine));
    }
}
