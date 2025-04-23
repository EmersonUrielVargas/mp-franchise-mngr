package com.mp.marketplace_franchise.Utilities;

public class Util {

    public static String isNullOrEmpty(String firstValue, String defaultValue){
        return firstValue == null || firstValue.isEmpty() ? defaultValue : firstValue;
    }

    public static<T> T isNull(T firstValue, T defaultValue){
        return firstValue == null? defaultValue : firstValue;
    }
}
