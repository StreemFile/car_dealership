package chnu.coursework.car_dealership;

import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;

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


