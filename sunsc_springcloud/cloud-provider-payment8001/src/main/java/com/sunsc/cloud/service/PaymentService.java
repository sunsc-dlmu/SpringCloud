package com.sunsc.cloud.service;


import com.sunsc.cloud.dao.PaymentDao;
import com.sunsc.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        int result = paymentDao.create(payment);
        return result;
    }

    public Payment getPaymentById(Long id){
        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }
}
