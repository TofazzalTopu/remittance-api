package com.rms.api.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.rms.api.service.impl.instantCash.ICNotifyPaymentStatusRemittanceServiceImpl.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class TestUtility {

    public static void main(String[] args) throws IOException {
        String str = "504  NORTH SHAHJAHANPUR DHAKA 1217 DGM PRINCIPAL OFFICE  NARAYANGANJ ";
        System.out.println(str.substring(0, 35));
        System.out.println(str.substring(0, 36));
        System.out.println(str.subSequence(0, 69));
        System.out.println("abcd".substring(0, 3));
        switchExample(STATUS_COMPLETED);
        apiCall();
        System.out.println(generateBase64Hash("AE90009999", "Qwe_123!"));
//        System.out.println(UUID.randomUUID());
        IntSummaryStatistics intSummaryStatistics = IntStream.range(301, 400).summaryStatistics();
        Spliterator.OfInt spliterator = IntStream.range(301, 400).spliterator();

        List<Long> collect = LongStream.rangeClosed(300, 399).flatMap(d -> Arrays.stream(String.valueOf(d).split(""))
                .mapToLong(Long::new)).boxed().filter(d -> d == 3).collect(Collectors.toList());
        System.out.println(collect.stream().count());
        System.out.println();
        getThree();

//        LongStream generate = LongStream.generate(() -> {
//            System.out.println("hg\n");
//            return (long) (Math.random() * 10000);
//        });
//        System.out.println(generate.max());
//        generate.limit(4).forEach(System.out::println);
    }

    static void getThree() {
        int count = 0;
        for (int i = 300; i <= 399; i++) {
            String[] nums = String.valueOf(i).split("");
            for (int j = 0; j < nums.length; j++) {
                if (Integer.parseInt(nums[j]) == 3) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static String generateBase64Hash(String userId, String password) {
        String originalInput = userId + ":" + password;
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }

    public static void switchExample(String status) {
        int number = 20;

        switch (number) {
            //Case statements
            case 10:
                System.out.println("10");
                break;
            case 20:
                System.out.println("20");
                break;
            case 30:
                System.out.println("30");
                break;
            //Default case statement
            default:
                System.out.println("Not in 10, 20 or 30");
        }
        String newStatus = NEW_STATUS_D;
        switch (status) {
            case STATUS_COMPLETED:
                newStatus = NEW_STATUS_Y;
                break;
            case STATUS_REJECTED:
                newStatus = NEW_STATUS_X;
                break;
            default:
                newStatus = NEW_STATUS_D;
        }
        System.out.println(newStatus);
    }


    public static void apiCall() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.instantcashworldwide.ae/sandbox/api/v1/transactions/receive-payment")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("x-fapi-financial-id", "AE01BH")
                .addHeader("Authorization", "Basic QUU5MDAwNTU1NTpRd2VfMTIzIQ==")
                .addHeader("Ocp-Apim-Subscription-Key", "769f2166defa44789a3a7e42edf110d4")
                .addHeader("x-correlation-id", UUID.randomUUID().toString())
                .addHeader("x-idempotency-key", UUID.randomUUID().toString())
                .build();

//        Response response = client.newCall(request).execute();
//        System.out.println(response);
    }

    static void encoder(String password) {
        String encode = Base64.getEncoder().encodeToString(password.getBytes());
        String decode = Arrays.toString(Base64.getDecoder().decode(encode));
        System.out.println(String.format("%02x", encode));
    }

    public static void encid() {
        String pText = "Hello MD5";
        byte[] md5InBytes = digest(pText.getBytes(UTF_8));
        String hash = bytesToHex(md5InBytes);
        System.out.println(hash);
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes)));
    }

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    private static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        try {
            String s = "";
        } finally {

        }
        return sb.toString();
    }

    public static void test() {
        final int i;
        i = 0; int j = i + 20;
        System.out.println(i + " " + j);
    }

    public static void collection(){
        TreeSet<String> ts = new TreeSet<>();
        Set<Integer> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    }
}




