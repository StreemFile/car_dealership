package chnu.coursework.car_dealership;

import com.mongodb.client.AggregateIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.ToObjectListConverter
 *
 * @Autor: vovamv
 * @DateTime: 27.03.2021|23:38
 * @Version ToObjectListConverter: 1.0
 */

public class ToObjectListConverter {
    public List<Object> convert(AggregateIterable toConvert) {
        List<Object> convertedObjects = new ArrayList<>();

        Iterator iterator = toConvert.iterator();
        while (iterator.hasNext()) {
            convertedObjects.add(iterator.next());
        }

        return convertedObjects;
    }
}
