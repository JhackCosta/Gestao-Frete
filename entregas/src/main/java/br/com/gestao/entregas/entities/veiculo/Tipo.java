package br.com.gestao.entregas.entities.veiculo;

public enum Tipo {

        CAMINHONETE(1),
        FURGAO(2),
        CAMINHAO(3);

        private final int valor;
        Tipo(int valorOpcao){
                valor = valorOpcao;
        }

        public int getValor(){
                return valor;
        }

}
