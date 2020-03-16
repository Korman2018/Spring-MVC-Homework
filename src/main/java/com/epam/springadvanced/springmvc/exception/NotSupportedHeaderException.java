package com.epam.springadvanced.springmvc.exception;

public class NotSupportedHeaderException extends RuntimeException {

  public NotSupportedHeaderException(String message) {
    super(message);
  }
}
