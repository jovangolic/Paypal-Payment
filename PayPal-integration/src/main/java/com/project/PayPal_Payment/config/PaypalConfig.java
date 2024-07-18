package com.project.PayPal_Payment.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;

@Configuration
public class PaypalConfig {
	
	@Value("${paypal.client-id}")
	private String clientId;
	
	@Value("${paypal.client-secret}")
	private String clientSecret;
	
	@Value("${paypal.mode}")
	private String mode;

	
	@Bean
	public APIContext apiContext() {
		return new APIContext(clientId, clientSecret, mode);
	}
	
	/*@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	 @Bean
	 public String getPayPalAccessToken() {
	        RestTemplate restTemplate = restTemplate();

	        String authUrl = "https://api." + mode + ".paypal.com/v1/oauth2/token";

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        headers.setBasicAuth(clientId, clientSecret);

	        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
	        body.add("grant_type", "client_credentials");

	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

	        ResponseEntity<Map> response = restTemplate.exchange(authUrl, HttpMethod.POST, request, Map.class);
	        return response.getBody().get("access_token").toString();
	    }*/
}
