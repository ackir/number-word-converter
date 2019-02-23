package com.trendyol.number.text.converter.controller;

import com.trendyol.number.text.converter.enums.CurrencyEnum;
import com.trendyol.number.text.converter.service.NumberToWordConverterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/convert")
public class NumberToWordController {

    private final NumberToWordConverterService numberToWordConverterService;

    @GetMapping(path = "/number")
    public String getConvertedNumberWords(@RequestParam Long requestNumber,
                                          @RequestParam(value = "currency", defaultValue = "DOLLAR") CurrencyEnum currency) {
        return numberToWordConverterService.numberToWords(requestNumber, currency);
    }

    @GetMapping(path = "/word")
    public Long getConvertedWordsNumber(@RequestParam String words) {
        return numberToWordConverterService.wordsToNumber(words);
    }
}
