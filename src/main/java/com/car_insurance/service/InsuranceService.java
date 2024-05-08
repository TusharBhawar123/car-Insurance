package com.car_insurance.service;

import com.car_insurance.entity.Insurance;
import com.car_insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository InsuranceRepository;

    public List<Insurance> getAllInsurance(Insurance insurance){
        return this.InsuranceRepository.findAll();
     }
}
