package br.com.gestao.entregas.entities.empresa;

public record DadosListagemEmpresa(Long id, String nome, String email,
                                   String contato, String cnpj, boolean ativo) {
    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getNome(), empresa.getEmail(),
                empresa.getContato(), empresa.getCnpj(), empresa.isAtivo());
    };



}
