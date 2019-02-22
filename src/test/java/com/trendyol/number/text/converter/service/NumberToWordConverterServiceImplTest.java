package com.trendyol.number.text.converter.service;


import com.trendyol.number.text.converter.service.impl.NumberToWordConverterServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static com.trendyol.number.text.converter.constant.GenericConstants.*;
import static org.junit.Assert.assertEquals;


public class NumberToWordConverterServiceImplTest {

    private NumberToWordConverterServiceImpl numberToTextConverterService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        numberToTextConverterService = new NumberToWordConverterServiceImpl();
    }

    @Test
    public void it_should_convert_hundred_number_to_text() {
        // when
        String text = numberToTextConverterService.numberToWords(123L);

        //then
        assertEquals(ONE_HUNDRED_TWENTY_THREE, text);
    }

    @Test
    public void it_should_convert_thousand_number_to_text() {
        // when
        String text = numberToTextConverterService.numberToWords(100850543457L);

        //then
        assertEquals(ONE_HUNDRED_BILLION_EIGHT_HUNDRED_FIFTY_MILLION_FIVE_HUNDRED_FORTY_THREE_THOUSAND_FOUR_HUNDRED_FIFTY_SEVEN, text);
    }

    @Test
    public void it_should_convert_text_included_to_thousand_number() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(ONE_THOUSAND_THREE_HUNDRED_FORTY_FIVE);

        //then
        assertEquals(1345L, convertedNumber);
    }

    @Test
    public void it_should_convert_text_included_to_hundred_number() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(ONE_HUNDRED_TWENTY_EIGHT);

        //then
        assertEquals(128L, convertedNumber);
    }

    @Test
    public void it_should_convert_text_to_hundred_number() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(NINETY_NINE);

        //then
        assertEquals(99L, convertedNumber);
    }
}
