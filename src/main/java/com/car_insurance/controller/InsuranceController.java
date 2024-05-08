package com.car_insurance.controller;

import com.car_insurance.entity.Insurance;
import com.car_insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public List<Insurance> getAllInsurance(@RequestBody Insurance insurance){
        return this.insuranceService.getAllInsurance(insurance);
    }
}
