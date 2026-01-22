package com.exemplo.sistema.crud.exemplosistema;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByCategoria(Categoria categoria);

    // NOVO: Busca produtos contendo o texto (ignorando maiúsculas/minúsculas)
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}