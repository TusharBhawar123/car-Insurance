package com.car_insurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.ProtocolHandler;

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

//    @ManyToOne
//    @JsonManagedReference
//    @JoinColumn(
//            name = "User",
//            referencedColumnName = "userId"
//    )
//    private User user;

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
