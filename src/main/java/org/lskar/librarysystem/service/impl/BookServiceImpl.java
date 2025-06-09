package org.lskar.librarysystem.service.impl;

import org.lskar.librarysystem.mapper.BookMapper;
import org.lskar.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;




}
