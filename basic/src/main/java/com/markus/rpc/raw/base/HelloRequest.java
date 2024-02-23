package com.markus.rpc.raw.base;

import java.io.Serializable;

/**
 * @author: markus
 * @date: 2024/2/23 10:29 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HelloRequest implements Serializable {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
