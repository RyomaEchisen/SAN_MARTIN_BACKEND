package com.san.martin.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  // test
  @GetMapping("/test")
  public ResponseEntity<?> test() {
    Map<String, Object> response = new HashMap<>();
    response.put("testData", "respuesta de test");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
