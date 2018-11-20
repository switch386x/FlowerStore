package flowerstore;
import java.math.BigDecimal;
/*
 * Copyright (c) 2018. Schenker AG
 * All rights reserved.
 */

public enum Currencies {

    USD("USD",new BigDecimal(0.8912334)),
    EUR("EUR",new BigDecimal(1.0)),
    GBP("GBP",new BigDecimal(1.3229121));


    private final String currencyCode;
    private final BigDecimal exchangeRate;
    
    Currencies(String currencyCode, BigDecimal exchangeRate){
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
}

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
    
}
    



