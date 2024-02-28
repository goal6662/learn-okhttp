package com.goal.method.delete;

import com.goal.method.util.ClientUtil;
import okhttp3.Request;
import org.junit.jupiter.api.Test;

/**
 * 学习如何使用路径参数
 */
public class DeleteClient {

    public static final String url = "http://localhost:8080";

    @Test
    public void delete() {

        Request request = new Request.Builder()
                .url(url + "/delete/111.txt")
                .delete()
                .build();

        ClientUtil.getResponse(request);

    }

}
