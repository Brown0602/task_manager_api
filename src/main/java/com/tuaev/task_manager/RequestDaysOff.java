package com.tuaev.task_manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuaev.task_manager.json.DaysOffJson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RequestDaysOff{
    public static List<DaysOffJson> getDaysOff() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://date.nager.at/api/v3/PublicHolidays/2024/RU"))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        List<DaysOffJson> daysOff = objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
        });
        return daysOff;
    }
}
