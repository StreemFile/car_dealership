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
 * car_dealership.Employee
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:15
 * @Version Employee: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private String passport;
    private String telephone;
    private Dealership dealership;
    private int salary;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}

