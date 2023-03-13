package com.wandonium.h2demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    @NotBlank(message = "Department name cannot be empty!")
    // other validations
    // no. of string characters
    /*@Length(max = 5, min = 1)
    @Size(max = 5, min = 1)
    // email
    @Email(regexp = ".*")
    // positive, negative or zero number values
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    // date values
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
