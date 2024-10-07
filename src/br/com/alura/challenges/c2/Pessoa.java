package br.com.alura.challenges.c2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public record Pessoa(String nome, int idade, String cidade) {
}