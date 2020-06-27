package com.alfa.battle;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;

@SpringBootApplication
public class BattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		try {
			KeyStore trustStore;
			HttpComponentsClientHttpRequestFactory requestFactory = null;

			trustStore = KeyStore.getInstance("JKS");
			ClassPathResource classPathResource = new ClassPathResource("client_trustore.jks");
			InputStream inputStream = classPathResource.getInputStream();
			trustStore.load(inputStream, "123456".toCharArray());

			KeyStore keyStore = KeyStore.getInstance("JKS");
			ClassPathResource classPathResourceKeyStore = new ClassPathResource("client.jks");
			InputStream inputStreamKeyStore = classPathResourceKeyStore.getInputStream();
			keyStore.load(inputStreamKeyStore, "123456".toCharArray());

			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder()
					.loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
					.loadKeyMaterial(keyStore, "123456".toCharArray())
					.build());

			CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(socketFactory)
					.setMaxConnTotal(Integer.valueOf(5))
					.setMaxConnPerRoute(Integer.valueOf(5))
					.build();

			requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			requestFactory.setReadTimeout(Integer.valueOf(10000));
			requestFactory.setReadTimeout(Integer.valueOf(10000));

			restTemplate.setRequestFactory(requestFactory);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return restTemplate;
	}

}
