package com.test.platform.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Slf4j
public class RpcUtils {
    private static RestTemplate REST_TEMPLATE = restTemplateBuild();

    public static ResponseEntity<String> getRes(String url, String method, String reqBody) {
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        if (method.equalsIgnoreCase("GET")) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
            for (String s : jsonObject.keySet()) {
                Object v = jsonObject.get(s);
                uriComponentsBuilder.queryParam(s, v);
            }
            url = uriComponentsBuilder.toUriString();
        }
        log.info("url={},method={},reqBody={}", url, method, reqBody);
        ResponseEntity<String> responseEntity = REST_TEMPLATE.exchange(url, HttpMethod.resolve(method), new HttpEntity<>(jsonObject), new ParameterizedTypeReference<String>() {
        });
        return responseEntity;
    }


    /**
     * Apache HttpClient
     *
     * @return
     * @see [类、类#方法、类#成员]
     */
    @SneakyThrows
    private static RestTemplate restTemplateBuild() {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

}
