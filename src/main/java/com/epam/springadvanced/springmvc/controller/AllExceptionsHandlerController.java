package com.epam.springadvanced.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllExceptionsHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(Exception e) {
    ModelAndView modelAndView = new ModelAndView("exception");
    modelAndView.addObject("name", e.getClass().getSimpleName());
    modelAndView.addObject("message", e.getMessage());

    return modelAndView;
  }
}