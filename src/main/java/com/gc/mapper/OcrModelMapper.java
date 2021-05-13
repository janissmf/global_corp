package com.gc.mapper;

import com.gc.model.OcrEntity;
import com.gc.model.OcrModel;
import javax.validation.Valid;
import org.mapstruct.Mapper;

@Mapper
public interface OcrModelMapper {

  OcrModel convertTo(@Valid OcrEntity ocrEntity);

}
