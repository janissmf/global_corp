package com.gc.service.impl;

import com.gc.mapper.OcrEntityMapper;
import com.gc.mapper.OcrModelMapper;
import com.gc.model.OcrModel;
import com.gc.repo.OcrRepository;
import com.gc.service.ApiService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApiServiceImpl implements ApiService {

  private final OcrRepository repository;
  private final OcrEntityMapper ocrEntityMapper;
  private final OcrModelMapper ocrModelMapper;

  @Override
  @Caching(evict = {@CacheEvict(value = "ocrList", allEntries = true),}, put = {
      @CachePut(value = "ocr", key = "#ocr.foreignId")})
  public OcrModel ocrCreate(OcrModel ocr) {
    var entity = ocrEntityMapper.convertTo(ocr);
    repository.save(entity);

    return ocr;
  }

  @Override
  public List<OcrModel> getAllFromDB() {
    List<OcrModel> ocrModelList = new ArrayList<>();
    repository.findAll()
        .forEach(ocrEntity -> ocrModelList.add(ocrModelMapper.convertTo(ocrEntity)));

    return ocrModelList;
  }

  @Override
  @Cacheable(value = "ocrList")
  public List<OcrModel> getAllFromCached() {
    return getAllFromDB();
  }

  @Override
  @Cacheable(value = "ocrList", key = "#foreignId")
  public OcrModel getFromCachedByForeignId(Integer foreignId) {
    return ocrModelMapper
        .convertTo(repository.findAllById(Collections.singleton(foreignId)).stream()
            .findFirst()
            .orElse(null));
  }

  @Override
  @CacheEvict(allEntries = true, value = "ocrList")
  public String getCachedFlush() {
    return "Removed";
  }

  @Override
  @Cacheable(value = "ocrList", key = "#word")
  public Boolean checkPossibleWord(String word) {
    return true;
  }
}
