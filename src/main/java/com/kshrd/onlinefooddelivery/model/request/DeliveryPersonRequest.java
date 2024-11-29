package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPersonRequest {
    private String name;
    private String contactNumber;
    private String vehicleType;

    public DeliveryPerson toEntity() {
        return new DeliveryPerson(null, name, contactNumber, vehicleType, List.of());
    }

    public DeliveryPerson toEntity(Long id) {
        return new DeliveryPerson(id, name, contactNumber, vehicleType, List.of());
    }
}

