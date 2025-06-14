package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator selectById(String id);

    void update(Administrator administrator);

    void insert(Administrator administrator);

    void delete(List<String> ids);
}
