package com.gc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcrModel {

  @JsonProperty("foreign_id")
  @Min(0)
  @Max(255)
  private Integer foreignId;

  @Size(min = 1, message = "required")
  private String word;

  private Date created;

}
