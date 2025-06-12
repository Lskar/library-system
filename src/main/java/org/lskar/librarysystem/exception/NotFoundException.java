package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(HttpStatusEnum.BAD_REQUEST.getCode(),message);
    }
}
