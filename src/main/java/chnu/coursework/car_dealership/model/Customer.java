package chnu.coursework.car_dealership.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


/**
 * Created by IntelliJ IDEA.
 * car_dealership.Customer
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:04
 * @Version Customer: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Customer {
    @Id
    private String id;
    private String name;
    private String telephone;
    private String placeOfResidence;
    private String address;
    private String passport;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

}
