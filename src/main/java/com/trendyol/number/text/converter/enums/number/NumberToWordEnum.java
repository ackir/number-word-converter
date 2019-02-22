package com.trendyol.number.text.converter.enums.number;

public enum NumberToWordEnum {
    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    FIFTEEN(15, "fifteen"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen"),
    TWENTY(20, "twenty"),
    THIRTY(30, "thirty"),
    FORTY(40, "forty"),
    FIFTY(50, "fifty"),
    SIXTY(60, "sixty"),
    SEVENTY(70, "seventy"),
    EIGHTY(80, "eighty"),
    NINETY(90, "ninety"),
    HUNDRED(100, "hundred"),
    THOUSAND(1000, "thousand"),
    MILLION(1000000, "million"),
    BILLION(1000000000, "billion");

    private final int number;
    private final String text;

    public int getNumber() {
        return this.number;
    }

    public String getText() {
        return this.text;
    }

    private NumberToWordEnum(int number, String text) {
        this.number = number;
        this.text = text;
    }
}
