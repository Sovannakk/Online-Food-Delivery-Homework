package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import com.kshrd.onlinefooddelivery.model.request.DeliveryPersonRequest;

import java.util.List;

public interface DeliveryPersonService {
    List<DeliveryPerson> getAllDeliveryPersons();

    DeliveryPerson getDeliveryPerson(Long id);

    DeliveryPerson createDeliveryPerson(DeliveryPersonRequest deliveryPersonRequest);

    DeliveryPerson updateDeliveryPerson(Long id, DeliveryPersonRequest deliveryPersonRequest);

    void deleteDeliveryPerson(Long id);
}
