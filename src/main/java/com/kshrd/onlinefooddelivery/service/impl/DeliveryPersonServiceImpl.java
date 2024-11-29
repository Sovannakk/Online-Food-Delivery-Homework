package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import com.kshrd.onlinefooddelivery.model.request.DeliveryPersonRequest;
import com.kshrd.onlinefooddelivery.repository.DeliveryPersonRepository;
import com.kshrd.onlinefooddelivery.service.DeliveryPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;

    @Override
    public List<DeliveryPerson> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    @Override
    public DeliveryPerson getDeliveryPerson(Long id) {
        return deliveryPersonRepository.findById(id).orElse(null);
    }

    @Override
    public DeliveryPerson createDeliveryPerson(DeliveryPersonRequest deliveryPersonRequest) {
        return deliveryPersonRepository.save(deliveryPersonRequest.toEntity());
    }

    @Override
    public DeliveryPerson updateDeliveryPerson(Long id, DeliveryPersonRequest deliveryPersonRequest) {
        return deliveryPersonRepository.save(deliveryPersonRequest.toEntity(id));
    }

    @Override
    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
