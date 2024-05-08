package com.car_insurance.service;

import com.car_insurance.entity.Car;
import com.car_insurance.entity.User;
import com.car_insurance.repository.CarRepository;
import com.car_insurance.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars(Car car) {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return this.carRepository.findById(id).get();
    }

}
