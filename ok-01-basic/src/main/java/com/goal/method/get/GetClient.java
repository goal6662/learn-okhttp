package com.goal.method.get;

import com.goal.method.util.ClientUtil;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.junit.jupiter.api.Test;

/**
 * 如何通过HttpUrl添加请求参数
 */
public class GetClient {

    public static final String url = "http://localhost:8080";

    @Test
    public void getPure() {
        Request request = new Request.Builder()
                .url(url)
                .get()  // 默认为get 可不写
                .build();
        ClientUtil.getResponse(request);
    }

    @Test
    public void withHeader() {
        Request request = new Request.Builder()
                .url(url)
                .header("Env", "dev")
                .build();

        ClientUtil.getResponse(request);
    }

    @Test
    public void withParam() {

        // http://localhost:8080/search
        HttpUrl httpUrl = HttpUrl.get(url + "/search").newBuilder()
                .addQueryParameter("kw", "Hello")
                .build();

        // 构造请求信息
        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        // 发送请求
        ClientUtil.getResponse(request);

    }

}
