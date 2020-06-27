package com.alfa.battle;

import com.alfa.battle.controllers.AtmController;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

@SpringBootApplication
public class BattleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BattleApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] password = "password".toCharArray();
        InputStream jksInputStream = AtmController.class.getClassLoader().getResourceAsStream("alfabattle.jks");
        keyStore.load(jksInputStream, password);
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, password)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLContext(sslContext)
                .build();
        var requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        return new RestTemplate(requestFactory);
    }

}
