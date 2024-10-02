package br.com.alura.challenges.c1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CoinGeckoRequest {
    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price?ids=";

    public void searchCoinByName() throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Search the coin by it's name: ");
        var search = input.nextLine();

        String address = API_URL + "/coins/markets?vs_currency=usd&ids=" + search + "&vs_currencies=usd";

        var formattedAddress = getValidURL(address);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(formattedAddress))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    static String getValidURL(String invalidURLString){
        try {
            // Convert the String and decode the URL into the URL class
            URL url = new URL(URLDecoder.decode(invalidURLString, StandardCharsets.UTF_8.toString()));

            // Use the methods of the URL class to achieve a generic solution
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            // return String or
            // uri.toURL() to return URL object
            return uri.toString();
        } catch (URISyntaxException | UnsupportedEncodingException | MalformedURLException ignored) {
            return null;
        }
    }
}
