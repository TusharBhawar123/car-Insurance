package com.car_insurance.repository;

import com.car_insurance.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void findAllCar(){
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            System.out.println("cars = " + car);
        }
    }

    @Test
    public void findById(){
        Optional<Car> car = carRepository.findById(Long.valueOf(12));
        car.stream().map(s->s.getCarId().compareTo(s.getCarId())).forEach(System.out::println);
        System.out.println("car = " + car);
    }
}