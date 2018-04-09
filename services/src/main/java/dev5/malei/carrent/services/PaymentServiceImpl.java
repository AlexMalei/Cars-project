package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.PaymentDAO;
import dev5.malei.carrent.daoImpl.PaymentDAOImpl;
import dev5.malei.carrent.entities.Payment;

public class PaymentServiceImpl extends CrudServiceImpl<Payment> implements PaymentService {
    private PaymentDAO paymentDAO = (PaymentDAOImpl) DaoFactory.getDao(PaymentServiceImpl.class);

    public Payment getPaymentByRentInfo(int rentInfoId) {
        return paymentDAO.getPaymentByRentInfo(rentInfoId);
    }
}
