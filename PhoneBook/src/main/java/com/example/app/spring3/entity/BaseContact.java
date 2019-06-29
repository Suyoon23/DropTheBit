package com.example.app.spring3.entity;

import java.util.List;

public interface BaseContact { //basecontact에 상속 받도록 하는 것이 첫번째,
    String getId();
    void setId(String id);

    String getLastName();
    void setLastName(String lastName);

    String getFirstName();
    void setFirstName(String firstName);

    String getEmail();
    void setEmail(String email);

    List<Phone> getPhones();
    void setPhones(List<Phone> phone);
}
