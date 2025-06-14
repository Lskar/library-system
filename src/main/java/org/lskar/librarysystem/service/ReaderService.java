package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.LoginInfo;
import org.lskar.librarysystem.entity.Reader;

import java.util.List;

public interface ReaderService {


    List<Reader> list();

    Reader getReaderById(String id);

    void insert(Reader reader);

    void update(Reader reader);

    void delete(String id);

    LoginInfo login(Reader reader);
}
