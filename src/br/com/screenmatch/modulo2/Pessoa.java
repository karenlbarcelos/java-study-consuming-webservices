package br.com.screenmatch.modulo2;

public class Pessoa {

    private String nome;
    private int idade;
    private String cidade;
    private int cpf;
    private String nomeMae;
    private String nomePai;
    private double limiteCartao;

    public Pessoa(String nome, int idade, String cidade, int cpf, String nomeMae) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public Pessoa(PessoaRecord pessoaRecord) {
        this.nome = pessoaRecord.nome();
        this.idade = pessoaRecord.idade();
        this.cidade = pessoaRecord.cidade();
        this.cpf = pessoaRecord.cpf();
        this.nomeMae = pessoaRecord.nomeMae();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\n" +
                "Idade: " + idade + ",\n" +
                "Cidade: " + cidade + "\n" +
                "CPF: " + cpf + "\n" +
                "Nome da mae: " + nomeMae;
    }
}
