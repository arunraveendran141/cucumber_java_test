package io.headspin.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static io.headspin.global_variables.GlobalVariable.*;

public class HsApi {
    /** API for getting all devices and its details present in  an org */
    static String url_root = "https://api-dev.headspin.io/v0/";
    static String device_list_url = "https://api-dev.headspin.io/v0/devices";
    static String get_auto_config = "https://api-dev.headspin.io/v0/devices/automation-config";

    public static void update_session_name_and_description() throws URISyntaxException, IOException, InterruptedException {
        System.out.println(access_token);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api-dev.headspin.io/v0/sessions/"+session_id+"/description"))
                .header("Authorization", "Bearer "+access_token)
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \""+ test_name +"\", \"description\": \"This is Api call generated description.\"}"))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
    }

    public static void run_adb_command() {
//        String api_endpoint = String.format("https://api-dev.headspin.io/v0/adb/%s/pull?remote=%s",UDID);
    }

    /*r = requests.get(request_url, headers=self.headers)
    data = r.json()
    print(data)
        return data*/
}
