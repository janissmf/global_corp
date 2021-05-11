package com.gc.service.impl;

import com.gc.mapper.OcrEntityMapper;
import com.gc.model.OcrModel;
import com.gc.repo.OcrRepository;
import com.gc.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApiServiceImpl implements ApiService {

  private final OcrRepository repository;
  private final OcrEntityMapper ocrEntityMapper;

  @Override
  public OcrModel ocrCreate(OcrModel ocr) {
    var entity = ocrEntityMapper.convertTo(ocr);
    repository.save(entity);

    return ocr;
  }
}
