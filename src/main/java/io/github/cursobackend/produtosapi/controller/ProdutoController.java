package io.github.cursobackend.produtosapi.controller;

import io.github.cursobackend.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    /**
     * Endpoint para receber um produto via POST.
     * @param produto o produto a ser salvo
     * @return o produto recebido
     */
    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        return produto;
    }
}
