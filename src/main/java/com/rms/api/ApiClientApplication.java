package com.rms.api;

import org.springframework.beans.factory.annotation.Value;
/*
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.rms.api.config.datasource.DataSourceConfig;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


@SpringBootApplication
public class ApiClientApplication {

	
	private static String encryptionKey = "MZygpewJsCpRrfOr";
	
	@Value("${spring.datasource.password}")
	private String dataSourcePassword;
	
	public static void main(String[] args) {
		decryptPassword();
		SpringApplication.run(ApiClientApplication.class, args);
	
	}

	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	
	
	
	private static void decryptPassword() {
		ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		try {
			String password = context.getBean(DataSourceConfig.class).getDataSourcePassword();
			String server = context.getBean(DataSourceConfig.class).getServer();
			if (server != null && password != null && server.equals("production")) {
				Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
				byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(password));
				String cbsdbpass =  new String(plainBytes);
				System.setProperty("spring.datasource.password", cbsdbpass);
			}
			
		} catch (Exception e) {
			System.out.println("decryptPassword:Exception--->"+e);
		} finally {
			try {
				((AbstractApplicationContext) context).close();
			} catch (Exception e2) {}
		}		
	}
	
	private static Cipher getCipher(int cipherMode) throws Exception {
		String encryptionAlgorithm = "AES";
		SecretKeySpec keySpecification = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), encryptionAlgorithm);
		Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
		cipher.init(cipherMode, keySpecification);
		return cipher;
	}
	

	/*
	@Bean
	public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
				.build();

		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}*/

}
