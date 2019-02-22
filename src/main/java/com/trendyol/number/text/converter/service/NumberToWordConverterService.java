package com.trendyol.number.text.converter.service;

public interface NumberToWordConverterService {
    String numberToWords(Long requestNumber);

    Long wordsToNumber(String words);
}
