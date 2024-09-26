package com.rms.api.util;

import com.rms.api.config.datasource.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PasswordUtil {

    private static String encryptionKey = "MZygpewJsCpRrfOr";

    public static String generateBase64Hash(String userId, String password) {
        String originalInput = userId + ":" + password;
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }


    public static String decryptPassword() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        String cbsdbpass =  "";
        try {
            String password = context.getBean(DataSourceConfig.class).getDataSourcePassword();
            String server = context.getBean(DataSourceConfig.class).getServer();
            if (server != null && password != null && server.equals("production")) {
                Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
                byte[] plainBytes = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(password));
                cbsdbpass =  new String(plainBytes);
                System.setProperty("spring.datasource.password", cbsdbpass);
            }

        } catch (Exception e) {
            System.out.println("decryptPassword:Exception--->"+e);
        } finally {
            try {
                ((AbstractApplicationContext) context).close();
            } catch (Exception e2) {}
        }
        return cbsdbpass;
    }

    private static Cipher getCipher(int cipherMode) throws Exception {
        String encryptionAlgorithm = "AES";
        SecretKeySpec keySpecification = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(cipherMode, keySpecification);
        return cipher;
    }

}
