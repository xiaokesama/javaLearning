package com.xiaoke.springboothttpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class HttpClientTest {
    @Test
    public void testGet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8011");

        CloseableHttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();

        System.out.println(entity.getContent());
        System.out.println(execute.getStatusLine());
        System.out.println(EntityUtils.toString(entity));

        execute.close();
        httpClient.close();
    }

    @Test
    public void testPost() throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8011/api/register");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "test");
        jsonObject.put("password", "123456");
        jsonObject.put("mobilephone", "123456fds");
        jsonObject.put("pwd", "123sdf456");

        StringEntity entity = new StringEntity(jsonObject.toString(), "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        CloseableHttpResponse execute = httpClient.execute(httpPost);

        System.out.println(entity.getContent());
        System.out.println(execute.getStatusLine());
        System.out.println(EntityUtils.toString(entity));

        execute.close();
        httpClient.close();
    }
}
