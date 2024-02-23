package com.markus.rpc.raw.base;

import java.io.Serializable;

/**
 * @author: markus
 * @date: 2024/2/23 10:29 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HelloResponse implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
