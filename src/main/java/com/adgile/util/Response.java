package com.adgile.util;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response<T> {

    private Integer code;
    private String message;
    private T data;

    public static final Response<String> OK = new Response<>(200, "OK", null);

//    public static <T> Response<T> test() {
//        return new Response<>(200, null, )
//    }

    public static <T> Response<T> success(T data) {
        return new Response<>(200, null, data);
    }

    public static Response<Object> error (Integer code, String message) {
        return new Response<>(code, message, null);
    }
}
