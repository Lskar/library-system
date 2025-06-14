package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class TimeEarlyException extends BaseException {
    public TimeEarlyException(String message) {
        super(HttpStatusEnum.BAD_REQUEST.getCode(),message);
    }
}
