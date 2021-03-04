package chnu.coursework.car_dealership.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.Purchase
 *
 * @Autor: vovamv
 * @DateTime: 11.02.2021|14:18
 * @Version Purchase: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Purchase {
    @Id
    private String id;
    private Automobile automobile;
    private Customer customer;
    private Employee employee;
    private LocalDate purchaseDate;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
