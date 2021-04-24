package chnu.coursework.car_dealership;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CarDealershipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}


