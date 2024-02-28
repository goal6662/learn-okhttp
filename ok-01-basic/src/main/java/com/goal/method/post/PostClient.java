package com.goal.method.post;

import com.alibaba.fastjson2.JSON;
import com.goal.method.server.domain.Person;
import com.goal.method.util.ClientUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;

@Slf4j
public class PostClient {

    public static final String url = "http://localhost:8080";

    @Test
    public void postWithBody() {

        Person person = new Person();
        person.setAge(180);
        person.setName("Tom");

        String data = JSON.toJSONString(person);

        // 构建请求体
        RequestBody requestBody = RequestBody.create(
                data,
                MediaType.parse("application/json")
        );

        // 构建请求信息
        Request request = new Request.Builder()
                .url(url + "/insert")
                .method("POST", requestBody)
                .build();

        ClientUtil.getResponse(request);

    }

}
