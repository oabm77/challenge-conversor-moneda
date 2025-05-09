package principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = "4b018f02a15064569dd48521";
        String base = "COP";
        String target = "USD";
        double amount = 3800000;
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + target + "/" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
    }
}
