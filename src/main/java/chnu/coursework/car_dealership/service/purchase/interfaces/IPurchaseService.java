package chnu.coursework.car_dealership.service.purchase.interfaces;

import chnu.coursework.car_dealership.model.Purchase;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.IPurchaseService
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:57
 * @Version IPurchaseService: 1.0
 */

public interface IPurchaseService {
    Purchase create(Purchase purchase);
    Purchase update(Purchase purchase);
    Purchase delete(Purchase purchase);
    Purchase getById(String id);
    List<Purchase> getAll();
}
