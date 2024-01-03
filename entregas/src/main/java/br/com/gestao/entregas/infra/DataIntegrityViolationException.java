package br.com.gestao.entregas.infra;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String mensagem) {
        super(mensagem);
    }
}
