package com.goal.method.get;

import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class ClientGet {

    static OkHttpClient client = new OkHttpClient();

    public static final String url = "http://localhost:8080";

    public static void getPure() {
        Request request = new Request.Builder()
                .url(url)
                .get()  // 默认为get 可不写
                .build();
        getResponse(request);

    }

    public static Request withHeader() {
        return new Request.Builder()
                .url(url)
                .header("Env", "dev")
                .build();
    }

    public static Request withParam() {

        // http://localhost:8080/search
        HttpUrl httpUrl = HttpUrl.get(url + "/search").newBuilder()
                .addQueryParameter("kw", "Hello")
                .build();

        return new Request.Builder()
                .url(httpUrl)
                .build();

    }

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

    public static void main(String[] args) {
        getPure();

        getResponse(withHeader());

        getResponse(withParam());
    }

}
