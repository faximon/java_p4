package br.com.alura.challenges.c1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BookRequest book = new BookRequest();
        book.searchingByTitle();

        CoinGeckoRequest coin = new CoinGeckoRequest();
        coin.searchCoinByName();

        TheMealDBRequest meal = new TheMealDBRequest();
        meal.searchRecipeByName();
    }
}
