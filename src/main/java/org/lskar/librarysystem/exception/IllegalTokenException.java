package org.lskar.librarysystem.exception;

import org.lskar.librarysystem.enums.HttpStatusEnum;

public class IllegalTokenException extends BaseException {
  public IllegalTokenException(String message) {
    super(HttpStatusEnum.UNAUTHORIZED.getCode(),message);
  }
}
