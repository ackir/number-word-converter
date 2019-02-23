package com.trendyol.number.text.converter.service;

import com.trendyol.number.text.converter.enums.CurrencyEnum;

public interface NumberToWordConverterService {
    String numberToWords(Long requestNumber, CurrencyEnum currencyEnum);

    Long wordsToNumber(String words);
}
