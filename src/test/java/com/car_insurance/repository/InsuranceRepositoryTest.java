package com.car_insurance.repository;

import com.car_insurance.entity.Insurance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InsuranceRepositoryTest {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Test
    public void findAll(){
        List<Insurance> insurances=insuranceRepository.findAll();
        for (Insurance insu:insurances){
            System.out.println("insu = " + insu);
        }
    }
}