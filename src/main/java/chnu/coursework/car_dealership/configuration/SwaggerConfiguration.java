package chnu.coursework.car_dealership.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.SwaggerConfiguration
 *
 * @Autor: vovamv
 * @DateTime: 24.03.2021|12:03
 * @Version SwaggerConfiguration: 1.0
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customerOpenAPI(){
        return new OpenAPI().info(
                new Info()
                .title("Курсова")
                .version("1.0")
                .contact(new Contact()
                        .email("volodymyr.moisei@gmail.com")
                        .name("Volodymyr Moisei")
                ));
    }
}
