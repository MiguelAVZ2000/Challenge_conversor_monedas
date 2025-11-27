package com.conversor;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiHandler {

    private String apiKey;

    public ApiHandler() {
        try {
            Properties props = new Properties();
            props.load(new FileReader("config.properties"));
            this.apiKey = props.getProperty("API_KEY");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración o la clave de API.");
            e.printStackTrace();
        }
    }

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            System.out.println("La clave de API no está configurada.");
            return -1;
        }

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaOrigen + "/" + monedaDestino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
                if ("success".equals(apiResponse.result)) {
                    return apiResponse.conversion_rate;
                } else {
                    System.out.println("Error en la respuesta de la API: " + apiResponse.error_type);
                    return -1;
                }
            } else {
                System.out.println("Error en la solicitud a la API. Código de estado: " + response.statusCode());
                return -1;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la solicitud a la API.");
            e.printStackTrace();
            return -1;
        }
    }

    // Clase interna para mapear la respuesta JSON de la API
    private static class ApiResponse {
        String result;
        String documentation;
        String terms_of_use;
        long time_last_update_unix;
        String time_last_update_utc;
        long time_next_update_unix;
        String time_next_update_utc;
        String base_code;
        String target_code;
        double conversion_rate;
        String error_type;
    }
}
