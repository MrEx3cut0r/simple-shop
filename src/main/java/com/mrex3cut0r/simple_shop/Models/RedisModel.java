package com.mrex3cut0r.simple_shop.Models;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(timeToLive=5L)
public class RedisModel {
    public String key;
    public Object obj;
}
