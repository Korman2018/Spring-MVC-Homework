package com.epam.springadvanced.springmvc.controller;

import com.epam.springadvanced.springmvc.exception.NotSupportedHeaderException;
import com.epam.springadvanced.springmvc.service.UserDataService;
import java.io.ByteArrayInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PDFController {

  @Autowired
  private UserDataService userDataService;

  @GetMapping(value = "/getUsersPdf", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<InputStreamResource> getUsersPdf() {
    final ByteArrayInputStream inputStream = userDataService.getAllUsersPDF();
    final HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=users.pdf");

    return ResponseEntity
        .ok()
        .headers(headers)
        .contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(inputStream));
  }

  @GetMapping(value = "/getUsersPdf")
  public void getUsersPdfThrowError() {
    throw new NotSupportedHeaderException("Not supported header to get users PDF");
  }
}