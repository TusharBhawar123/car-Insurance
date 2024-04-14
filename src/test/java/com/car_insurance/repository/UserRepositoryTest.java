package com.car_insurance.repository;

import com.car_insurance.entity.Car;
import com.car_insurance.entity.Insurance;
import com.car_insurance.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        Insurance insurance=Insurance.builder()
                . insuranceName("SBI General ")
                .insuranceType("Car-Insurance")
                .insuranceAmount("12000/Year")
                .insuranceDate("1/1/2024")
                .insuranceStatus("Active")
                .build();
        Car car= Car.builder()
                .carName("EEcho")
                .carType("Van")
                .carColor("Metallic Blue")
                .insurance(insurance)
                .build();
        User user = User.builder()
                .firstName("Vrushali")
                .lastName("Salunke")
                .phone("8087243865")
                .email("Vrushali@gmail.com")
                .address("Dehugaon")
                .car(List.of(car))
                .build();
        userRepository.save(user);
    }
}