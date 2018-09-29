package com.example.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: Louis
 * @Date: 9/28/2018
 * @Description:
 */
@RestController
public class HttpClientController {
//    @Autowired
    private RestTemplate restTemplate;

    /**
     * 最简单的get操作
     */
    @GetMapping("/baidu1/{key}")
    public String get1(@PathVariable String key) throws UnsupportedEncodingException {
        String encodeKey = URLEncoder.encode(key, "UTF-8");

        String url = "http://www.baidu.com/s?bdorz_come=1&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=" + encodeKey;
        //返回百度主站html
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 需要自定义header头的get操作
     */
    @GetMapping("/baidu2/{key}")
    public String get2(@PathVariable String key) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();

        headers.set("MyHeaderKey", "MyHeaderValue");

        HttpEntity entity = new HttpEntity(headers);

        String encodeKey = URLEncoder.encode(key, "UTF-8");

        String url = "http://www.baidu.com/s?bdorz_come=1&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=" + encodeKey;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        //返回百度主站html
        return response.getBody();
    }

    @GetMapping("/postForm")
    public String testPostForm() {
        // 填写url
        String url = "";
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();

        // 填写表单
        form.add("name", "**");
        form.add("age", "**");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //headers.add("xx", "yy");//可以加入自定义的header头
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(form, headers);
        String json = restTemplate.postForObject(url, formEntity, String.class);
        return json;
    }

    @RequestMapping("/postBody")
    public String testPostBody() {
        // 填写url
        String url = "";

        // 填写json串
        String jsonBody = "{\n"
                + "    \"name\": \"XX\",\n"
                + "    \"age\": \"12\",\n"
                + "    \"sex\": \"man\"\n"
                + "}\n";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("xx", "yy");//可以加入自定义的header头
        HttpEntity<String> bodyEntity = new HttpEntity<>(jsonBody, headers);

        //1.直接拿原始json串
        String json = restTemplate.postForObject(url, bodyEntity, String.class);

        //2.将原始的json传转成java对象，rest template可以自动完成
        Object resultVo = restTemplate.postForObject(url, bodyEntity, Object.class);
        if (resultVo != null) {
        } else {
        }
        //返回的是分包api的json
        return json;
    }
}
