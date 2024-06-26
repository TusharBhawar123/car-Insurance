package com.car_insurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @SequenceGenerator(
            name="Car_Sequence",
            sequenceName = "Car_Sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Car_Sequence"
    )
    private Long carId;
    private String carName;
    private String carType;
    private String carColor;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "Insurance_Id",
            referencedColumnName = "insuranceId"
    )
    private Insurance insurance;

}
