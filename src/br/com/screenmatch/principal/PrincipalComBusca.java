package br.com.screenmatch.principal;

import br.com.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para pesquisa: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=11d8b8c7";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                //serializando de objeto json para classe java
                TituloOMDB meuTituloOmdb = gson.fromJson(json, TituloOMDB.class);
                System.out.println("Título não convertido:");
                System.out.println(meuTituloOmdb);
                System.out.println("----------------------");
                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Título já convertido:");
                System.out.println(meuTitulo);
                System.out.println("----------------------");

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Houve um erro!");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na pesquisa, verifique o endereco");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Finalizado com sucesso.");
    }
}
