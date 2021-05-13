package com.gc.service;

import com.gc.model.OcrModel;
import java.util.List;

public interface ApiService {

  OcrModel ocrCreate(OcrModel ocr);

  List<OcrModel> getAllFromDB();

  List<OcrModel> getAllFromCached();

  OcrModel getFromCachedByForeignId(Integer foreignId);

  String getCachedFlush();

  Boolean checkPossibleWord(String word);
}
