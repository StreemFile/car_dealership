package chnu.coursework.car_dealership.service.exteriorColor.interfaces;

import chnu.coursework.car_dealership.model.ExteriorColor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.IExteriorColorService
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:41
 * @Version IExteriorColorService: 1.0
 */

public interface IExteriorColorService {
    ExteriorColor create(ExteriorColor exteriorColor);
    ExteriorColor update(ExteriorColor exteriorColor);
    ExteriorColor delete(ExteriorColor exteriorColor);
    ExteriorColor getById(String id);
    List<ExteriorColor> getAll();
}
