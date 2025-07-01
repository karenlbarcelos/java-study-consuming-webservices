package br.com.screenmatch.exception;

public class ErroDeConversaoDeAnoException extends RuntimeException {

    private String mensagem;

    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = this.mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
}
