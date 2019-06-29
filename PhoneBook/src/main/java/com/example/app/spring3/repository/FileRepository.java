package com.example.app.spring3.repository;

import com.example.app.spring3.entity.FileContact;
import org.springframework.stereotype.Component;

import java.util.List;


public class FileRepository implements BaseRepository <FileContact>{
    public FileRepository(String filePath) {
        this.filePath = filePath;
    }

    private final String filePath;//final이니까 초기화 그리고 생성자

    @Override
    public List<FileContact> getContacts() {
        return null;
    }

    @Override
    public FileContact getContactById(String id) {
        return null;
    }

    @Override
    public void addContact(FileContact contact) {

    }

    @Override
    public FileContact deleteById(String id) {
        return null;
    }
}
