package br.com.screenmatch.modulo2;

import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {

        String jsonPessoa = """
          {
            "nome" : "Karen",
            "idade" : 30,
            "cidade" : "Santo André"
          }
        """;

        Gson gson = new Gson();
        PessoaRecord pessoaRecord = gson.fromJson(jsonPessoa, PessoaRecord.class);
        System.out.println(pessoaRecord);

        Pessoa pessoa = new Pessoa(pessoaRecord);
        System.out.println(pessoa);
    }
}
