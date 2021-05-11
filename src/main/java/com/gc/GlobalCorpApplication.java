package com.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GlobalCorpApplication {

  public static void main(String[] args) {
    SpringApplication.run(GlobalCorpApplication.class, args);
  }

}
