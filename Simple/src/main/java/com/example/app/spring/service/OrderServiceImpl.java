package com.example.app.spring.service;

import com.example.app.spring.util.BaseSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    private BaseSequenceGenerator sequenceGenerator;
//
//    public OrderServiceImpl(){
//
//    }
//
//    public BaseOrderServiceImpl (SequenceGenerator sequenceGenerator){
//        this.sequenceGenerator = sequenceGenerator;
//    }
//
//    public void setSequenceGenerator(SequenceGenerator sequenceGenerator){
//        this.sequenceGenerator=sequenceGenerator;
   // }
    @Override
    public void addOrder(String UserId, String productId, Double quantity) {
        System.out.println("Added a new order");
    }
}
