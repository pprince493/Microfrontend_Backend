package com.nagarro.watermarkservice.service.impl;

import com.nagarro.watermarkservice.service.GeocodingService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    @Override
    public String getLocationFromCoordinates(double latitude, double longitude) {
        try {
            String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitude + "&lon=" + longitude;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String responseString = stringBuilder.toString();
            JSONObject json = new JSONObject(responseString);

            return json.getString("display_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
