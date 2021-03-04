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
 * car_dealership.ProducingCountry
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:26
 * @Version ProducingCountry: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ProducingCountry {
    @Id
    private String id;
    private String country;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
