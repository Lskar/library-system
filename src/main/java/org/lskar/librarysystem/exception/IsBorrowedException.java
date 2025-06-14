package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class IsBorrowedException extends BaseException {
    public IsBorrowedException(String message) {
        super(HttpStatusEnum.BAD_REQUEST.getCode(),message);
    }
}
