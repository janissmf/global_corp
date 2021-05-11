package com.gc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcrModel implements Serializable {

  @JsonProperty("foreign_id")
  @Min(0)
  private Integer foreignId;

  @Size(min = 1, message = "required")
  private String word;

  private Date created;

}
