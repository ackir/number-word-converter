package com.trendyol.number.text.converter.util;

import com.trendyol.number.text.converter.enums.number.NumberToWordEnum;
import com.trendyol.number.text.converter.enums.word.NumbersEnum;
import com.trendyol.number.text.converter.enums.word.TenEnum;
import com.trendyol.number.text.converter.enums.word.UnitEnum;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
public class GenericConverter {

    public String convert(Long requestNumber) {
        String numberText = "";

        if ((requestNumber / NumbersEnum.BILLION.getNumber()) > BigDecimal.ZERO.longValue()) {
            numberText += convert(requestNumber / NumbersEnum.BILLION.getNumber()) + NumbersEnum.BILLION.getText();
            requestNumber %= NumbersEnum.BILLION.getNumber();
        }
        if ((requestNumber / NumbersEnum.MILLION.getNumber()) > BigDecimal.ZERO.longValue()) {
            numberText += convert(requestNumber / NumbersEnum.MILLION.getNumber()) + NumbersEnum.MILLION.getText();
            requestNumber %= NumbersEnum.MILLION.getNumber();
        }
        if ((requestNumber / NumbersEnum.THOUSAND.getNumber()) > BigDecimal.ZERO.longValue()) {
            numberText += convert(requestNumber / NumbersEnum.THOUSAND.getNumber()) + NumbersEnum.THOUSAND.getText();
            requestNumber %= NumbersEnum.THOUSAND.getNumber();
        }
        if ((requestNumber / NumbersEnum.HUNDRED.getNumber()) > BigDecimal.ZERO.longValue()) {
            numberText += convert(requestNumber / NumbersEnum.HUNDRED.getNumber()) + NumbersEnum.HUNDRED.getText();
            requestNumber %= NumbersEnum.HUNDRED.getNumber();
        }
        if (requestNumber > BigDecimal.ZERO.longValue()) {
            if (requestNumber < 20) {
                numberText += UnitEnum.values()[requestNumber.intValue()].getText();
            } else {
                numberText += TenEnum.values()[(int) (requestNumber / BigDecimal.TEN.longValue())].getText();
                if ((requestNumber % BigDecimal.TEN.longValue()) > BigDecimal.ZERO.longValue()) {
                    numberText += UnitEnum.values()[(int) (requestNumber % BigDecimal.TEN.longValue())].getText();
                }
            }
        }
        return numberText;
    }

    public Long convert(String requestWord) {
        AtomicLong result = new AtomicLong();
        AtomicLong finalResult = new AtomicLong();

        if (Objects.nonNull(requestWord)) {
            List<String> splittedWords = Arrays.asList(requestWord.trim().split("\\s+"));

            splittedWords.forEach(str -> {
                if (str.equals(NumberToWordEnum.valueOf(str.toUpperCase()).getText())
                        && NumberToWordEnum.valueOf(str.toUpperCase()).getNumber() < NumberToWordEnum.HUNDRED.getNumber()) {
                    result.addAndGet(NumberToWordEnum.valueOf(str.toUpperCase()).getNumber());
                } else if (str.equals(NumberToWordEnum.HUNDRED.getText())) {
                    result.updateAndGet(number -> number * NumberToWordEnum.HUNDRED.getNumber());
                } else if (str.equals(NumberToWordEnum.valueOf(str.toUpperCase()).getText())) {
                    result.updateAndGet(number -> number * NumberToWordEnum.valueOf(str.toUpperCase()).getNumber());
                    finalResult.addAndGet(result.get());
                    result.set(0);
                }
            });
        }
        finalResult.addAndGet(result.get());
        return finalResult.get();
    }
}
