package com.test.platform.utils;

import com.alibaba.fastjson.JSONObject;
import com.test.platform.dto.RestResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.thymeleaf.util.StringUtils;
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

    public static RestResult getRes(String url, String method, String reqBody) {
        RestResult restResult = new RestResult();
        ResponseEntity<String> responseEntity = null;
        try {
            JSONObject jsonObject = null;
            if (!StringUtils.isEmpty(reqBody)) {
                jsonObject = JSONObject.parseObject(reqBody);
            }
            if (method.equalsIgnoreCase("GET")&&jsonObject!=null) {
                UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
                for (String s : jsonObject.keySet()) {
                    Object v = jsonObject.get(s);
                    uriComponentsBuilder.queryParam(s, v);
                }
                url = uriComponentsBuilder.toUriString();
            }
            log.info("url={},method={},reqBody={}", url, method, reqBody);
            responseEntity = REST_TEMPLATE.exchange(url, HttpMethod.resolve(method), new HttpEntity<>(jsonObject), new ParameterizedTypeReference<String>() {
            });
        } catch (Exception e) {
            log.error("rest fail ", e);
            restResult.setResult(e.getMessage());
            restResult.setResultMsg("失败");
            return restResult;
        }
        restResult.setResult(responseEntity.getBody());
        restResult.setResultMsg("成功");
        return restResult;
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
