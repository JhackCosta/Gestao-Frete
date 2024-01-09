package br.com.gestao.entregas.infra.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
