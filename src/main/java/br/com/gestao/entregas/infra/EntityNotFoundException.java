package br.com.gestao.entregas.infra;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
