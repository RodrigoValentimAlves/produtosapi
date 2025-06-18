package io.github.cursobackend.produtosapi.controller;

import io.github.cursobackend.produtosapi.model.Produto;
import io.github.cursobackend.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Endpoint para receber um produto via POST.
     * @param produto o produto a ser salvo
     * @return o produto recebido
     */
    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    /**
     * Recupera um produto pelo seu identificador único.
     *
     * Este endpoint realiza uma busca no repositório de produtos com base no ID fornecido
     * na URL. Caso o produto seja encontrado, ele é retornado no corpo da resposta; caso
     * contrário, retorna {@code null}.
     *
     * @param id o identificador único do produto a ser recuperado
     * @return o objeto {@link Produto} correspondente ao ID informado, ou {@code null} se não encontrado
     */
    @GetMapping("/buscarPorId/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    /**
     * Remove um produto do repositório com base no seu identificador único.
     *
     * Este endpoint recebe um ID na URL e realiza a exclusão do respectivo produto
     * caso ele exista na base de dados. Não retorna conteúdo na resposta.
     *
     * @param id o identificador único do produto a ser excluído
     */
    @DeleteMapping("/apagarProdutoPorId/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }
}
