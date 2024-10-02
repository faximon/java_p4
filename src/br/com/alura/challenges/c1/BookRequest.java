package br.com.alura.challenges.c1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BookRequest {

    public void searchingByTitle () throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Searching book by its name: ");
        var search = input.nextLine();

        var formattedSearch = search.replaceAll(" ", "%20");

        String apiKey = "AIzaSyBpnEoKJmkCi9dnctKRuyopC1m9feyPNn8";
        String address = "https://www.googleapis.com/books/v1/volumes?q=" + formattedSearch + "&key=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
