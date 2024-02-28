package com.goal.method.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class ClientUtil {

    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 发送请求
     * @param request
     */
    public static void getResponse(Request request) {
        try {
            Response response = client.newCall(request).execute();

            // 获取所有响应头
            log.info("\n[Headers] : {}", response.headers());

            // 获取状态码
            log.info("\n[status code] : {}", response.code());

            // 获取请求体
            if (response.body() != null) {
                log.info("\n[body] : {}", response.body().string());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
