package br.com.screenmatch.modulo2;

public class Pessoa {

    private String nome;
    private int idade;
    private String cidade;

    public Pessoa(String nome, int idade, String cidade){
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public Pessoa(PessoaRecord pessoaRecord) {
        this.nome = pessoaRecord.nome();
        this.idade = pessoaRecord.idade();
        this.cidade = pessoaRecord.cidade();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\n" +
                "Idade: " + idade + ",\n" +
                "Cidade: " + cidade + "\n";
    }
}
