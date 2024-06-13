package com.car_insurance.repository;

import com.car_insurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from User where first_name=?" , nativeQuery = true)
    Optional<User> findByUserFirstName(String userFirstName);

    @Query(value = "Select * from User where Last_Name=?", nativeQuery = true)
    Optional<User> findByLastName(String userLastName);
    //void delete(Optional<User> user);
}
