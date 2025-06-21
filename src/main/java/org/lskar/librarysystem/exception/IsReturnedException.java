package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class IsReturnedException extends BaseException{
    public IsReturnedException(String message) {
        super(HttpStatusEnum.BAD_REQUEST.getCode(),message);
    }
}
