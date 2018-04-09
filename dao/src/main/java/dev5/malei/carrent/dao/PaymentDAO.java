package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.Payment;

public interface PaymentDAO extends CrudDAO<Payment> {
    Payment getPaymentByRentInfo(int rentInfoId);
}
