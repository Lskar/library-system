package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class BorrowLimitException extends BaseException {
  public BorrowLimitException(String message) {
    super(HttpStatusEnum.BAD_REQUEST.getCode(),message);
  }
}
