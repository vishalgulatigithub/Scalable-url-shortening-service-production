package com.urlshortener.backend.util;

public class ShardResolver {

    public static int getShard(long id){

        return (int) (id % 4);
    }
}