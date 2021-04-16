package chnu.coursework.car_dealership.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * Created by IntelliJ IDEA.
 * car_dealership.Customer
 *
 * @Autor: vovamv
 * @DateTime: 10.02.2021|14:04
 * @Version Customer: 1.0
 */
@Schema(description = "Об'єкт покупця")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Schema(description = "ID компанії", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    private String id;
    @Schema(description = "ПІП покупця", example = "Тащук Василь Васильович")
    private String name;
    @Schema(description = "Номер телефону", example = "+380996035846")
    private String telephone;
    @Schema(description = "Місто проживання", example = "Одеса")
    private String placeOfResidence;
    @Schema(description = "Адреса проживання", example = "Приморська 17")
    private String address;
    @Schema(description = "Номер паспорту", example = "000690321")
    private String passport;
    @Schema(description = "description")
    private String description;
    @Schema(description = "Дата створення об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime created_at;
    @Schema(description = "Дата останньої модифікації об'єтку",accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime modified_at;

    public Customer(String name, String telephone, String placeOfResidence, String address, String passport, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.telephone = telephone;
        this.placeOfResidence = placeOfResidence;
        this.address = address;
        this.passport = passport;
        this.description = description;
        this.created_at = LocalDateTime.now();
        this.modified_at = null;
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "\n\tid='" + id + '\'' +
                ",\n\tname='" + name + '\'' +
                ",\n\ttelephone='" + telephone + '\'' +
                ",\n\tplaceOfResidence='" + placeOfResidence + '\'' +
                ",\n\taddress='" + address + '\'' +
                ",\n\tpassport='" + passport + '\'' +
                ",\n\tdescription='" + description + '\'' +
                ",\n\tcreated_at=" + created_at +
                ",\n\tmodified_at=" + modified_at +
                "\n}";
    }
}
