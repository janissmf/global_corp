package com.gc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gc.validator.DateFrom;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcrModel implements Serializable {

  @JsonProperty("foreign_id")
  @Min(0)
  private Integer foreignId;

  @Size(min = 1, message = "required")
  private String word;

  @DateFrom(message = "Date must be later then 2015-01-01")
  private Date created;

}
