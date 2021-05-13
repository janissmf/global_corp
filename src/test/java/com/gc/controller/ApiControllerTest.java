package com.gc.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gc.GlobalCorpApplication;
import com.gc.model.OcrModel;
import com.gc.service.ApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = GlobalCorpApplication.class)
@AutoConfigureMockMvc
class ApiControllerTest {

  private static final String REQ_JSON = "{\"foreign_id\" : \"128\",\"word\" : \"Something\",\"created\" : \"2016-01-01T00:00:00\"}";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ApiService service;


  @Test
  void testPost() throws Exception {
    mockMvc.perform(
        post("/api/migration/ocr").contentType(MediaType.APPLICATION_JSON)
            .content(REQ_JSON.getBytes()))
        .andDo(print())
        .andExpect(status().isCreated());
    verify(service, times(1)).ocrCreate(any(OcrModel.class));
  }

  @Test
  void testAllFromDB() throws Exception {
    mockMvc.perform(
        get("/api/all"))
        .andDo(print())
        .andExpect(status().isOk());
    verify(service, times(1)).getAllFromDB();
  }

  @Test
  void testAllFromCached() throws Exception {
    mockMvc.perform(
        get("/api/cached/all"))
        .andDo(print())
        .andExpect(status().isOk());
    verify(service, times(1)).getAllFromCached();
  }

  @Test
  void testFromCachedByForeignId() throws Exception {
    String foreign_id = "123";
    when(service.getFromCachedByForeignId(Integer.parseInt(foreign_id)))
        .thenReturn(new OcrModel());
    mockMvc.perform(
        get(String.format("/api/cached/details/%s", foreign_id)))
        .andDo(print())
        .andExpect(status().isOk());
    verify(service, times(1)).getFromCachedByForeignId(Integer.parseInt(foreign_id));
  }

  @Test
  void testCachedFlush() throws Exception {
    when(service.getCachedFlush()).thenReturn("Done");
    mockMvc.perform(
        get("/api/cached/flush"))
        .andDo(print())
        .andExpect(status().isOk());
    verify(service, times(1)).getCachedFlush();
  }

  @Test
  void testCheckPossibleWord() throws Exception {
    String word = "wordTest";
    when(service.checkPossibleWord(word)).thenReturn(true);
    mockMvc.perform(
        get(String.format("/api/cached/possibly-some?word=%s", word)))
        .andDo(print())
        .andExpect(status().isOk());
    verify(service, times(1)).checkPossibleWord(word);
  }
}