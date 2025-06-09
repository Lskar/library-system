package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    List<Administrator> list();

    void update(Administrator administrator);

    void insert(Administrator administrator);

    void delete(String id);
}
