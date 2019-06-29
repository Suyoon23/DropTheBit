package com.example.app.spring.service;

//서비스 -> 비즈니스 로직 구현 되는 곳
public interface OrderService {
    void addOrder(String UserId, String productId, Double quantity);
}
