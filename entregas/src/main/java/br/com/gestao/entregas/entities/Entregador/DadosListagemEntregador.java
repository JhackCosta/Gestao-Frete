package br.com.gestao.entregas.entities.Entregador;

public record DadosListagemEntregador(String nome, String email,
                                      String contato, String cnh, String categoria, boolean ativo) {

    public DadosListagemEntregador(Entregador entregador){

        this(entregador.getNome(), entregador.getEmail(),
                entregador.getContato(), entregador.getCnh(), entregador.getCategoria(), entregador.isAtivo());
    }
}
