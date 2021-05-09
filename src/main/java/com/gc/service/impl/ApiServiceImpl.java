package com.gc.service.impl;

import com.gc.model.OcrModel;
import com.gc.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApiServiceImpl implements ApiService {

  @Override
  public OcrModel ocrCreate(OcrModel ocr) {
    return ocr;
  }
}
