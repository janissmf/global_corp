package com.gc.controller;

import com.gc.model.OcrModel;
import com.gc.service.ApiService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping(
    value = {"/api"},
    produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiController {

  private final ApiService apiService;


  @PostMapping(
      value = "/migration/ocr",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OcrModel> apiPost(@RequestBody @Valid OcrModel ocr) {
    return new ResponseEntity<>(apiService.ocrCreate(ocr), HttpStatus.CREATED);
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OcrModel>> getAllFromDB() {
    return new ResponseEntity<>(apiService.getAllFromDB(), HttpStatus.OK);
  }

  @GetMapping(value = "/cached/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OcrModel>> getAllFromCached() {
    return new ResponseEntity<>(apiService.getAllFromCached(), HttpStatus.OK);
  }

  @GetMapping(value = "/cached/details/{foreign_id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OcrModel> getFromCachedByForeignId(
      @PathVariable("foreign_id") Integer foreignId) {
    return new ResponseEntity<>(apiService.getFromCachedByForeignId(foreignId), HttpStatus.OK);
  }

  @GetMapping(value = "/cached/flush")
  public ResponseEntity<String> getCachedFlush() {
    return new ResponseEntity<>(apiService.getCachedFlush(), HttpStatus.OK);
  }

  @GetMapping(value = "/cached/possibly-some")
  public ResponseEntity<Boolean> checkPossibleWord(@RequestParam(name = "word") String word) {
    return new ResponseEntity<>(apiService.checkPossibleWord(word), HttpStatus.OK);
  }

}
