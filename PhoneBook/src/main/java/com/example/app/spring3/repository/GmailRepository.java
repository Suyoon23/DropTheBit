package com.example.app.spring3.repository;

import com.example.app.spring3.entity.GmailContact;

import java.util.List;

public class GmailRepository implements  BaseRepository<GmailContact> {
    @Override
    public List<GmailContact> getContacts() {
        return null;
    }

    @Override
    public GmailContact getContactById(String id) {
        return null;
    }

    @Override
    public void addContact(GmailContact contact) {

    }

    @Override
    public GmailContact deleteById(String id) {
        return null;
    }
}
