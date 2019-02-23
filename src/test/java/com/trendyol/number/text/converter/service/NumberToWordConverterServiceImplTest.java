package com.trendyol.number.text.converter.service;


import com.trendyol.number.text.converter.enums.CurrencyEnum;
import com.trendyol.number.text.converter.enums.number.NumberToWordEnum;
import com.trendyol.number.text.converter.service.impl.NumberToWordConverterServiceImpl;
import com.trendyol.number.text.converter.util.GenericConverter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.trendyol.number.text.converter.constant.GenericConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class NumberToWordConverterServiceImplTest {

    @Mock
    private GenericConverter genericConverter;

    private NumberToWordConverterServiceImpl numberToTextConverterService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        genericConverter = new GenericConverter();
        numberToTextConverterService = new NumberToWordConverterServiceImpl(genericConverter);
    }

    @Test
    public void itShouldConvertHundredNumberToWord() {
        // when
        String text = numberToTextConverterService.numberToWords(123L, CurrencyEnum.DOLLAR);

        //then
        assertEquals(RESPONSE_ONE_HUNDRED_TWENTY_THREE, text);
    }

    @Test
    public void itShouldConvertBillionNumberToWord() {
        // when
        String text = numberToTextConverterService.numberToWords(100850543457L, CurrencyEnum.DOLLAR);

        //then
        assertEquals(RESPONSE_ONE_HUNDRED_BILLION_EIGHT_HUNDRED_FIFTY_MILLION_FIVE_HUNDRED_FORTY_THREE_THOUSAND_FOUR_HUNDRED_FIFTY_SEVEN, text);
    }

    @Test
    public void itShouldConvertAnySmallToMillionNumberToWord() {
        //given
        String responseWord = null;

        //when
        for (long i = 0; i < NumberToWordEnum.MILLION.getNumber(); i++) {
            responseWord = numberToTextConverterService.numberToWords(i, CurrencyEnum.DOLLAR);
        }
        assertNotNull(responseWord);
    }

    @Test
    public void itShouldConvertWordToThousandNumber() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(ONE_THOUSAND_THREE_HUNDRED_FORTY_FIVE);

        //then
        assertEquals(1345L, convertedNumber);
    }

    @Test
    public void itShouldConvertWordToHundredNumber() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(ONE_HUNDRED_TWENTY_EIGHT);

        //then
        assertEquals(128L, convertedNumber);
    }

    @Test
    public void itShouldConvertWordToLessThanHundredNumber() {
        //when
        long convertedNumber = numberToTextConverterService.wordsToNumber(NINETY_NINE);

        //then
        assertEquals(99L, convertedNumber);
    }
}
