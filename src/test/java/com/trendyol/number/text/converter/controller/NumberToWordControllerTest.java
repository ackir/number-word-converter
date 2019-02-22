package com.trendyol.number.text.converter.controller;

import com.trendyol.number.text.converter.service.NumberToWordConverterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.trendyol.number.text.converter.constant.GenericConstants.ONE_HUNDRED_TWENTY_THREE;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NumberToWordControllerTest {

    @Mock
    private NumberToWordConverterService numberToWordConverterService;

    @InjectMocks
    private NumberToWordController numberToWordController;

    private MockMvc mockMvc;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        numberToWordController = new NumberToWordController(numberToWordConverterService);
        mockMvc = MockMvcBuilders.standaloneSetup(numberToWordController).build();
    }

    @Test
    public void getConvertedNumberWords() throws Exception {

        //given
        final Long requestNumber = 123L;
        final String requestParam = "requestNumber";

        //when
        doReturn(ONE_HUNDRED_TWENTY_THREE).when(numberToWordConverterService).numberToWords(requestNumber);

        //then
        mockMvc.perform(get("/convert/number").param(requestParam, requestNumber.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void getConvertedWordsNumber() throws Exception {

        //given
        final Long responseNumber = 123L;
        final String requestWord = ONE_HUNDRED_TWENTY_THREE;
        final String requestParam = "words";

        //when
        doReturn(responseNumber).when(numberToWordConverterService).wordsToNumber(requestWord);

        //then
        mockMvc.perform(get("/convert/word").param(requestParam, requestWord))
                .andExpect(status().isOk());
    }
}
