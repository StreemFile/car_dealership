package chnu.coursework.car_dealership;

import chnu.coursework.car_dealership.repository.customer.CustomerRepository;
import chnu.coursework.car_dealership.service.automobile.impls.AutomobileServiceImpl;
import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return  MongoClients.create();
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AutomobileServiceImpl automobileService;

    @Autowired
    private DealershipServiceImpl dealershipService;

    @Override
    public void run(String... args) throws Exception {
    }
}


