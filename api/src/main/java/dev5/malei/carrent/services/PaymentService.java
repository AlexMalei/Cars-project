package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.Payment;

public interface PaymentService extends CrudService<Payment> {
    Payment getPaymentByRentInfo(int rentInfoId);
}
