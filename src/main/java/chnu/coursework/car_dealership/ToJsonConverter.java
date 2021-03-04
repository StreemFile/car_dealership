package chnu.coursework.car_dealership;

import com.google.gson.Gson;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ToJsonConverter
 *
 * @Autor: vovamv
 * @DateTime: 15.02.2021|16:11
 * @Version ToJsonConverter: 1.0
 */

public class ToJsonConverter {
    public String toJSON(Object obj) {
        Gson gson = new Gson();
        String JSON = gson.toJson(obj);

        return JSON;
    }
}
