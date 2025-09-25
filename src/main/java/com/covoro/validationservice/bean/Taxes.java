package com.covoro.validationservice.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Taxes {

    private final Map<String, BigDecimal> taxMap = new HashMap<>();

    public void put(String taxCategory, BigDecimal taxRate, BigDecimal taxableAmount) {
        String key = taxCategory;
        if(null != taxRate)
            key = key + "#" + taxRate;
        if(null == taxMap.get(key)) {
            taxMap.put(key, taxableAmount);
        } else {
            BigDecimal existing = taxMap.get(key);
            BigDecimal updated = existing.add(taxableAmount);
            taxMap.put(key, updated);
        }
    }

    public BigDecimal getAmount(String taxCategory, BigDecimal taxRate) {
        String key = taxCategory + "#"  + taxRate;
        return null != taxMap.get(key) ? taxMap.get(key) : BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "Taxes{" +
                "taxMap=" + taxMap +
                '}';
    }
}
