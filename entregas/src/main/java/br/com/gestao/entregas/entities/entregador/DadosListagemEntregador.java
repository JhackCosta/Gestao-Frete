package br.com.gestao.entregas.entities.entregador;

public record DadosListagemEntregador(Long id, String nome, String email,
                                      String contato, String cnh, String categoria, boolean ativo) {

    public DadosListagemEntregador(Entregador entregador){

        this(entregador.getId(), entregador.getNome(), entregador.getEmail(),
                entregador.getContato(), entregador.getCnh(), entregador.getCategoria(), entregador.isAtivo());
    }
}
