package com.example.app.spring3.repository;

import com.example.app.spring3.entity.BaseContact;

import java.util.List;

public interface BaseRepository<T extends BaseContact> {

    List<T> getContacts();
    T getContactById(String id);
    void addContact(T contact);

    T deleteById(String id);

}
