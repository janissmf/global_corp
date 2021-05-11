package com.gc.configuration;

import com.gc.mapper.OcrEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.gc.service"})
public class SpringConfiguration implements WebMvcConfigurer {

  @Bean
  public OcrEntityMapper ocrEntityMapper() {
    return Mappers.getMapper(OcrEntityMapper.class);
  }

}
