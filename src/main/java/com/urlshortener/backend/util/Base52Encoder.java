package com.urlshortener.backend.util;

public class Base52Encoder {

    private static final String BASE52 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long value) {
        if (value == 0) return "a";
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int remainder = (int) (value % 52); // only letters
            sb.append(BASE52.charAt(remainder));
            value /= 52;
        }
        return sb.reverse().toString();
    }
}