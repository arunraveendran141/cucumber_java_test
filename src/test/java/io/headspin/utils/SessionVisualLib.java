package io.headspin.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import static io.headspin.global_variables.GlobalVariable.*;
import io.headspin.utils.HsApi.*;

public class SessionVisualLib {
        static String url_root = "https://api-dev.headspin.io/v0/";
//
//        static String session_id = "a0a328d4-2d43-11ed-be31-00e04c693a0e";
//        static String access_token = "459e866ed5fb43798b5f9e98460e91bc";
//        static String TestName = "Demo";
        public static void update_session_name_and_description() throws URISyntaxException, IOException, InterruptedException {
            System.out.println(access_token);
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://api-dev.headspin.io/v0/sessions/"+session_id+"/description"))
                    .header("Authorization", "Bearer "+access_token)
                    .POST(BodyPublishers.ofString("{\"name\": \""+ test_name +"\", \"description\": \"This is Api call generated description.\"}"))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
//            System.out.println("response description"+postResponse.body());
        }

        public static void add_session_data() throws URISyntaxException, IOException, InterruptedException {
//            # Sample
//        # {"session_id": "<session_id>", "test_name": "<test_name>", "data":[{"key":"bundle_id","value":"com.example.android"}] }


            JSONArray ja = new JSONArray();
            JSONObject data = new JSONObject();
            data.put("key","bundle_id");
            data.put("value","test");
            ja.add(data);
            JSONObject session_data = new JSONObject();
            session_data.put("session_id", session_id.toString());
            session_data.put("test_name", test_name);
            session_data.put("status", "Passed");
            session_data.put("data",ja);
            String temp = session_data.toString();
            System.out.println("t:" + temp);
//            System.out.println("{\"data\":[{\"value\":\"test\",\"key\":\"bundle_id\"}],\"session_id\":1aa13022-2d44-11ed-be31-00e04c693a0e,\"test_name\":\"testname\",\"status\":\"Passed\"}");
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI(url_root + "perftests/upload"))
                    .header("Authorization", "Bearer "+access_token)
                    .POST(BodyPublishers.ofString(temp))
//                    .POST(BodyPublishers.ofString("{\"data\":[{\"value\":\"test\",\"key\":\"bundle_id\"}],\"session_id\":1aa13022-2d44-11ed-be31-00e04c693a0e,\"test_name\":\"testname\",\"status\":\"Passed\"}"))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("response data upload"+postResponse.body());
        }
        public static void run_add_session_data() throws URISyntaxException, IOException, InterruptedException {
            update_session_name_and_description();
            add_session_data();
        }
        public static void run_record_session_info() throws IOException, URISyntaxException, InterruptedException {
            System.out.println("https://ui-dev.headspin.io/sessions/"+session_id+"/waterfall");
            run_add_session_data();

        }

//    This is Working >>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    public static void run_record_session_info() throws IOException {
//        System.out.println("In visual lib");
//        URL url3 = new URL("https://api-dev.headspin.io/v0/sessions/"+session_id+"/description");
//        HttpURLConnection http2 = (HttpURLConnection)url3.openConnection();
//        http2.setRequestProperty("Authorization", "Bearer "+access_token);
//        http2.setRequestMethod("POST");
//        http2.setDoOutput(true);
//
//        OutputStreamWriter writer = new OutputStreamWriter(http2.getOutputStream());
//        writer.write("{\"name\": \""+ TestName +"\", \"description\": \"This is Api call generated description.\"}");
//        writer.flush();
//        writer.close();
//        http2.getOutputStream().close();
//        System.out.println(http2.getResponseCode());
//        InputStream responseStream1 = http2.getResponseCode() / 100 == 2
//                ? http2.getInputStream()
//                : http2.getErrorStream();
//        Scanner s1 = new Scanner(responseStream1).useDelimiter("\\A");
//        String response2 = s1.hasNext() ? s1.next() : "";
//        System.out.println("last"+response2);
//    }


}
