package br.com.gestao.entregas.entities.frete;

public enum Status {

    ACEITO(1),
    REALIZANDO(2),
    FINALIZADO(3);

    private final int status;
    Status(int statusOpcao){
        status = statusOpcao;
    }

    public int getValor(){
        return status;
    }

}
