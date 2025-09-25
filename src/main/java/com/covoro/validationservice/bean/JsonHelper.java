package com.covoro.validationservice.bean;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class JsonHelper {

    public List readList(DocumentContext context, String path){
        List result = context.read(path);
        return result;
    }

    public List readTaxList(DocumentContext context, String taxCategory, BigDecimal taxRate){
        String path = "";
        if("E".equals(taxCategory) || "O".equals(taxCategory))
            path = "$.taxTotal.taxSubtotal[?(@.taxCategory.id == '" + taxCategory + "')]";
        else
            path = "$.taxTotal.taxSubtotal[?(@.taxCategory.id == '" + taxCategory + "' && @.taxCategory.percent == " + taxRate + ")]";
        List result = context.read(path);
        return result;
    }

    public String read(DocumentContext context, String path){
        return context.read(path, String.class);
    }

    public BigDecimal readBigDecimal(DocumentContext context, String path){
        BigDecimal value = null;
        try {
            value = context.read(path, BigDecimal.class);
        } catch (Exception e) {

        }
        value = null != value ? value : BigDecimal.ZERO;
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCalculationRate(DocumentContext context, String path){
        BigDecimal value = null;
        try {
            value = context.read(path, BigDecimal.class);
        } catch (Exception e) {

        }
        value = null != value ? value : new BigDecimal(1);
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public DocumentContext parse(Object json){
        return JsonPath.parse(json);
    }

    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            return null;
        }
        if (BigDecimal.ZERO.compareTo(b) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.divide(b, 2, RoundingMode.HALF_UP);
    }

    public boolean equals(BigDecimal a, BigDecimal b) {
        BigDecimal tolerance = new BigDecimal("0.01");
        return a.subtract(b).abs().compareTo(tolerance) <= 0 ;
    }

    public boolean equals(BigDecimal a, BigDecimal b, BigDecimal tolerance) {
        return a.subtract(b).abs().compareTo(tolerance) <= 0 ;
    }

    public BigDecimal sum(List<Object> list) {
        return list.stream()
                .map(Object::toString)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean log(String msg){
        System.out.println(msg);
        return true;
    }
}
