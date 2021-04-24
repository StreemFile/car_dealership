package chnu.coursework.car_dealership.service;

import chnu.coursework.car_dealership.model.Company;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * automobile_dealership.GenericService
 *
 * @Autor: vovamv
 * @DateTime: 24.04.2021|23:53
 * @Version GenericService: 1.0
 */

@Component
public class GenericService {

    static Jedis jedis = new Jedis("localhost", 6379);
    Gson gson = new Gson();

    public <T> T create(T t, String id, String className) {
        String ids = jedis.get(className);
        ids += " " + id;
        ids = ids.replace("null", "");
        jedis.set(className + "." + id, gson.toJson(t));
        jedis.set(className, ids);

        return t;
    }

    public <T> T update(T t, String id, String className) {
        jedis.set(className + "." + id, gson.toJson(t));
        return t;
    }

    public <T> T delete(T t, String id, String className) {
        jedis.del(className+"." + id);
        String ids = jedis.get(className);
        ids = ids.replace(id, "");
        jedis.set(className, ids);
        return t;
    }

    public <T> T getById(String id, String className, Class<T> classType) {
        return gson.fromJson(jedis.get(className + "." + id), (Type) classType);
    }

    public <T> List<T> getAll(String className, Class<T> classType) {
        List<String> items = Arrays.stream(jedis.get(className)
                                                    .trim()
                                                    .split(" "))
                                       .collect(Collectors.toList());
        List<T> result = items.stream()
                                        .map(id -> getById(id, className, classType))
                                        .collect(Collectors.toList());
        result.remove(null);
        return result;
    }
}
