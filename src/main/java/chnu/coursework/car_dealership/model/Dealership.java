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
 * car_dealership.Dealership
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:11
 * @Version Dealership: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Dealership {
    @Id
    private String id;
    private String city;
    private String address;
    private String telephone;
    private Company company;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

}
