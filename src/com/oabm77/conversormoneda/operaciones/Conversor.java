package com.oabm77.conversormoneda.operaciones;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.oabm77.conversormoneda.api.Api;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class Conversor {
    public static String ejecutar(Api api) {
        Gson gson = new Gson();
        String salida = "No ha sido posible realizar la consulta";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api.getUrlApi()))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JsonObject object = JsonParser.parseString(json).getAsJsonObject();

            String base = api.getBase();
            String objetivo = api.getObjetivo();
            double monto = api.getMonto();
            double tasa = gson.fromJson(object.get("conversion_rate"), Double.class);
            double resultado = gson.fromJson(object.get("conversion_result"), Double.class);

            salida = String.format("\nTasa de conversión: 1 %s = %.5f %s\n%.1f %s = %.2f %s", base, tasa, objetivo, monto, base, resultado, objetivo);
        } catch (NullPointerException e) {
            System.out.println("Error, verifique ApiKey o parámetros de conversión: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error de entrada y salida de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        escribeHistorial(salida);
        return salida;
    }

    public static void escribeHistorial(String resultado) {
        String archivo = "historial.txt";
        try {
            LocalDateTime ahora = LocalDateTime.now();
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(ahora + resultado + "\n--------------------------------------------------------\n");
            escritura.close();
            System.out.println("Se ha registrado la consulta correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error intentando guardardar la información.\n" + e.getMessage());
        }
    }

    public static void leerHistorial() {
        String archivo = "historial.txt";
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String linea;
            System.out.println("-- Historial de conversiones --");
            while ((linea = lectura.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error leyendo el historial. " + e.getMessage());
        }
    }
}
