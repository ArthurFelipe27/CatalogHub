package com.exemplo.sistema.crud.exemplosistema;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade()); // Mapeia quantidade
        produto.setCategoria(dto.getCategoria());
        return produto;
    }

    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade()); // Mapeia quantidade
        dto.setCategoria(produto.getCategoria());
        return dto;
    }
}