package com.trendyol.number.text.converter.service.impl;

import com.trendyol.number.text.converter.enums.CurrencyEnum;
import com.trendyol.number.text.converter.service.NumberToWordConverterService;
import com.trendyol.number.text.converter.util.GenericConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NumberToWordConverterServiceImpl implements NumberToWordConverterService {

    private final GenericConverter genericConverter;

    @Override
    public String numberToWords(Long requestNumber, CurrencyEnum currencyEnum) {
        String convertedString = genericConverter.convert(requestNumber);

        return convertedString + currencyEnum.getDescription();
    }

    public Long wordsToNumber(String requestWord) {

        return genericConverter.convert(requestWord);
    }
}
