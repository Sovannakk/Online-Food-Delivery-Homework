package com.kshrd.onlinefooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "delivery_persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNumber;
    private String vehicleType;

    @OneToMany(mappedBy = "deliveryPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;
}

