package com.trendyol.number.text.converter.enums;

public enum CurrencyEnum {
    DOLLAR("$", "dollar"),
    TURKISH_LIRA("TL", "turkish liras");

    private final String symbol;
    private final String description;

    public String getDescription() {
        return this.description;
    }

    public String getSymbol() {
        return this.symbol;
    }

    private CurrencyEnum(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }
}
