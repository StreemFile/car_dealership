package chnu.coursework.car_dealership.data;

import chnu.coursework.car_dealership.model.ModelAndPackage;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.FakeModelAndPackage
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:04
 * @Version FakeModelAndPackage: 1.0
 */
@Repository
public class FakeModelAndPackage {
    private List<ModelAndPackage> modelAndPackages = new ArrayList<>(
            Arrays.asList(
                    new ModelAndPackage(UUID.randomUUID().toString(), null,
                                        "Touran", "Highline", "VW",
                                        LocalDateTime.now(), LocalDateTime.now()),
                    new ModelAndPackage(UUID.randomUUID().toString(), null,
                                        "Mondeo", "Sport", "Ford",
                                        LocalDateTime.now(), LocalDateTime.now()),
                    new ModelAndPackage(UUID.randomUUID().toString(), null,
                                        "Fabia", "Active", "Skoda",
                                        LocalDateTime.now(), LocalDateTime.now())
                         )
    );

    public List<ModelAndPackage> getModelAndPackages() {
        return modelAndPackages;
    }

    public void setModelAndPackages(List<ModelAndPackage> modelAndPackages) {
        this.modelAndPackages = modelAndPackages;
    }
}
