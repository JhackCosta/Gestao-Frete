package br.com.gestao.entregas.entities.frete;

public enum Status {

    PENDENTE(1),
    ACEITO(2),
    REALIZANDO(3),
    FINALIZADO(4);

    private final int status;
    Status(int statusOpcao){
        status = statusOpcao;
    }

    public int getValor(){
        return status;
    }

}
