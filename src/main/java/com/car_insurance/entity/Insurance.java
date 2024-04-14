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
public class Insurance {
    @Id
    @SequenceGenerator(
            name = "Insurance_Sequence",
            sequenceName = "Insurance_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Insurance_Sequence"
    )
    private Long insuranceId;
    private String insuranceName;
    private String insuranceType;
    private String insuranceAmount;
    private String insuranceDate;
    private String insuranceStatus;

}
