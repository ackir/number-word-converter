package com.trendyol.number.text.converter.enums.word;

public enum TenEnum {
    ZERO(0, "zero"),
    TEN(1, "ten"),
    TWENTY(2, "twenty "),
    THIRTY(3, "thirty "),
    FORTY(4, "forty "),
    FIFTY(5, "fifty "),
    SIXTY(6, "sixty "),
    SEVENTY(7, "seventy "),
    EIGHTY(8, "eighty "),
    NINETY(9, "ninety ");

    private final int number;
    private final String text;

    public int getNumber() {
        return this.number;
    }

    public String getText() {
        return this.text;
    }

    private TenEnum(int number, String text) {
        this.number = number;
        this.text = text;
    }
}
