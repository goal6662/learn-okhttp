package com.goal.method.put;

import com.goal.method.util.ClientUtil;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PutClient {

    public static final String url = "http://localhost:8080";

    @Test
    public void putWithFile() {

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "file.txt",
                        RequestBody.create(new File("src/main/resources/file.txt"), MediaType.parse("application/octet-stream")))
                .build();

        Request request = new Request.Builder()
                .put(requestBody)
                .url(url + "/upload")
                .build();

        ClientUtil.getResponse(request);

    }

}
