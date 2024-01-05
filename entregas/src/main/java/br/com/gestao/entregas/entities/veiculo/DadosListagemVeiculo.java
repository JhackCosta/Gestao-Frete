package br.com.gestao.entregas.entities.veiculo;


public record DadosListagemVeiculo(Long proprietario, String marca, Tipo tipo, int peso, String placa) {

    public DadosListagemVeiculo(Veiculo veiculo){
        this(veiculo.getProprietario().getId(), veiculo.getMarca(), veiculo.getTipo(), veiculo.getPeso(), veiculo.getPlaca());
    }


}
