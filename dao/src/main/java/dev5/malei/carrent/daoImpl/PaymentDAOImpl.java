package dev5.malei.carrent.daoImpl;

import dev5.malei.carrent.dao.PaymentDAO;
import dev5.malei.carrent.entities.Payment;

import java.util.List;

public class PaymentDAOImpl extends CrudDAOImpl<Payment> implements PaymentDAO {
    public PaymentDAOImpl() {
        super(Payment.class);
    }

    @Override
    public Payment getPaymentByRentInfo(int rentInfoId) {
        List<Payment> allPaymentsList = list();
        for (Payment payment : allPaymentsList){
            if (payment.getRentInfoId() == rentInfoId){
                return payment;
            }
        }
        return null;
    }
}
