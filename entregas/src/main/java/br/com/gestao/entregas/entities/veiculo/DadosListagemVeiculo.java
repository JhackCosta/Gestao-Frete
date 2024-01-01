package br.com.gestao.entregas.entities.veiculo;


public record DadosListagemVeiculo(Long proprietario, String marca, Tipo tipo, Double peso) {

    public DadosListagemVeiculo(Veiculo veiculo){
        this(veiculo.getProprietario().getId(), veiculo.getMarca(), veiculo.getTipo(), veiculo.getPeso());
    }


}
