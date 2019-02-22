package com.trendyol.number.text.converter.enums.word;

public enum NumbersEnum {
    HUNDRED(100, "hundred "),
    THOUSAND(1000, "thousand "),
    MILLION(1000000, "million "),
    BILLION(1000000000, "billion ");

    private final int number;
    private final String text;

    public int getNumber() {
        return this.number;
    }

    public String getText() {
        return this.text;
    }

    private NumbersEnum(int number, String text) {
        this.number = number;
        this.text = text;
    }
}
