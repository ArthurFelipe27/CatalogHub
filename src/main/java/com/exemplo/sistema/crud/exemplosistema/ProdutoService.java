package com.exemplo.sistema.crud.exemplosistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de Serviço: Responsável pelas regras de negócio.
 * O Controller fala com o Service, e o Service fala com o Repository.
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> findByCategoria(Categoria categoria) {
        return produtoRepository.findByCategoria(categoria);
    }

    public List<Produto> findByNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID do produto inválido: " + id));
    }

    public Produto save(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}