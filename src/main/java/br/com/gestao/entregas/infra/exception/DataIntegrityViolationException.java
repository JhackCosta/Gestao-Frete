package br.com.gestao.entregas.infra.exception;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String mensagem) {
        super(mensagem);
    }
}
