package com.klinux.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAMAuthenticationService {

	@Value("${openam.url}")
    private String openamUrl;  // Recupera la URL de OpenAM desde application.properties

    private final RestTemplate restTemplate;

    public OpenAMAuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String authenticateUser(String username, String password) throws Exception {
        // Crear cliente RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Crear los encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept-API-Version", "resource=2.0, protocol=1.0");

        // Crear el cuerpo de la solicitud
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        json.addProperty("password", password);

        HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);

        // Realizar la solicitud y obtener la respuesta
        ResponseEntity<String> response = restTemplate.exchange(openamUrl, HttpMethod.POST, entity, String.class);
        
        // Verificar el contenido de la respuesta
        System.out.println("OpenAM Response: " + response.getBody());

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonObject responseBody = JsonParser.parseString(response.getBody()).getAsJsonObject();
            return responseBody.get("tokenId").getAsString(); // Obtener el token
        } else {
            System.out.println("Error de autenticación en OpenAM. Código de estado: " + response.getStatusCode());
        }
        return null;
    }
}

