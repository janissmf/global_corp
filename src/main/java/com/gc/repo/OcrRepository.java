package com.gc.repo;

import com.gc.model.OcrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrRepository extends JpaRepository<OcrEntity, Integer> {

}
