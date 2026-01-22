package com.exemplo.sistema.crud.exemplosistema;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class ProdutoController {

    // Agora injetamos o Service, não o Repository diretamente
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/cadastro")
    public String formulario(Model model) {
        if (!model.containsAttribute("produtoDTO")) {
            model.addAttribute("produtoDTO", new ProdutoDTO());
        }
        model.addAttribute("categorias", Categoria.values());
        return "index";
    }

    @PostMapping("/cadastro")
    public String salvarProduto(@ModelAttribute("produtoDTO") @Valid ProdutoDTO produtoDTO,
                                BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.produtoDTO", result);
            redirectAttributes.addFlashAttribute("produtoDTO", produtoDTO);
            return "redirect:/cadastro";
        }

        produtoService.save(produtoDTO);
        redirectAttributes.addFlashAttribute("successMessage", "Produto cadastrado com sucesso!");
        return "redirect:/cadastro";
    }
    
    @GetMapping("/listar")
    public String listarProdutos(@RequestParam(name = "categoria", required = false) Categoria categoria, 
                                 @RequestParam(name = "busca", required = false) String busca,
                                 Model model) {
        List<Produto> produtos;

        // Lógica de filtro melhorada
        if (categoria != null) {
            produtos = produtoService.findByCategoria(categoria);
        } else if (busca != null && !busca.isEmpty()) {
            produtos = produtoService.findByNome(busca);
        } else {
            produtos = produtoService.findAll();
        }

        List<ProdutoDTO> produtosDTO = produtos.stream()
            .map(ProdutoMapper::toDTO)
            .collect(Collectors.toList());

        model.addAttribute("produtos", produtosDTO);
        model.addAttribute("categorias", Categoria.values());
        model.addAttribute("categoriaSelecionada", categoria);
        model.addAttribute("buscaAtual", busca); // Para manter o texto na barra de busca
        return "listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        produtoService.deleteById(id);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoService.findById(id);
        model.addAttribute("produtoDTO", ProdutoMapper.toDTO(produto));
        model.addAttribute("categorias", Categoria.values());
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String editarProduto(@PathVariable("id") Long id, 
                                @ModelAttribute("produtoDTO") @Valid ProdutoDTO produtoDTO, 
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            produtoDTO.setId(id);
            model.addAttribute("categorias", Categoria.values());
            return "editar";
        }
        produtoService.save(produtoDTO);
        return "redirect:/listar";
    }
}