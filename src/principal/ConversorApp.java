package principal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String apiKey = "4b018f02a15064569dd48521";
        String base = "COP";
        String target = "USD";
        double amount = 4100000;
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + target + "/" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        JsonObject object = JsonParser.parseString(json).getAsJsonObject();

        double conversionRate = gson.fromJson(object.get("conversion_rate"), Double.class);
        double conversionResult = gson.fromJson(object.get("conversion_result"), Double.class);

        System.out.printf("%.5f - %.2f", conversionRate, conversionResult);
    }
}
